package com.example.backautodoc;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;

public class HelloController {
    @FXML
    private ComboBox<String> marqueComboBox;


    @FXML
    private CheckBox freinsCheckBox, huileCheckBox, filtresCheckBox;

    @FXML
    private Button freinsPlusButton, freinsMinusButton, huilePlusButton, huileMinusButton, filtresPlusButton, filtresMinusButton, commanderButton;

    @FXML
    private Label freinsQtyLabel, huileQtyLabel, filtresQtyLabel;

    @FXML
    private Label prixFinalLabel;

    private final MarqueSelection marqueSelection = new MarqueSelection();
    private final PieceSelection pieceSelection = new PieceSelection();
    private final GestionQuantites gestionQuantites = new GestionQuantites();
    private final PrixArticles prixArticles = new PrixArticles();
    private final Facture facture = new Facture(gestionQuantites, prixArticles);

    @FXML
    public void initialize(){
        marqueComboBox.setItems(FXCollections.observableArrayList(marqueSelection.getMarques()));
        marqueComboBox.setOnAction(e -> marqueSelection.setMarque(marqueComboBox.getValue()));

        //System.out.println("Marques disponibles : " + marqueSelection.getMarques());

        freinsCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> pieceSelection.setFreins(newVal));
        huileCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> pieceSelection.setHuile(newVal));
        filtresCheckBox.selectedProperty().addListener((obs, oldVal, newVal) -> pieceSelection.setFiltres(newVal));

        freinsPlusButton.setOnAction(e -> updateQuantity("freins", 1));
        freinsMinusButton.setOnAction(e -> updateQuantity("freins", -1));

        huilePlusButton.setOnAction(e -> updateQuantity("huile", 1));
        huileMinusButton.setOnAction(e -> updateQuantity("huile", -1));

        filtresPlusButton.setOnAction(e -> updateQuantity("filtres", 1));
        filtresMinusButton.setOnAction(e -> updateQuantity("filtres", -1));

        commanderButton.setOnAction(e -> handleCommander());

    }

    private void updateQuantity(String category, int delta) {

            boolean isSelected = false;

            // Vérification manuelle de la sélection
            if (category == "freins" && freinsCheckBox.isSelected()) {
                isSelected = true;
                gestionQuantites.updateFreinsQty(delta);
                freinsQtyLabel.setText("Quantité: " + gestionQuantites.getFreinsQty());
            }
            if (category == "huile" && huileCheckBox.isSelected()) {
                isSelected = true;
                gestionQuantites.updateHuileQty(delta);
                huileQtyLabel.setText("Quantité: " + gestionQuantites.getHuileQty());
            }
            if (category == "filtres" && filtresCheckBox.isSelected()) {
                isSelected = true;
                gestionQuantites.updateFiltresQty(delta);
                filtresQtyLabel.setText("Quantité: " + gestionQuantites.getFiltresQty());
            }


            // Afficher une erreur si aucune case n'est sélectionnée
            if (!isSelected) {
                System.out.println("Erreur : Vous devez sélectionner une pièce avant d'ajouter ou retirer des quantités.");
            } else {
                prixFinalLabel.setText("Total: " + facture.calculerPrixTotal() + " €");
            }
        }

        private void handleCommander() {
        if (marqueSelection.getMarque() == null) {
            showError("Erreur", "Aucune marque sélectionnée idiot .", "Veuillez sélectionner une marque avant de passer commande.");
            return;
        }

        if (!pieceSelection.isFreins() && !pieceSelection.isHuile() && !pieceSelection.isFiltres()) {
            showError("Erreur", "Aucune pièce sélectionnée.", "Veuillez sélectionner au moins une pièce avant de passer commande.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Commande");
        alert.setHeaderText("Résumé de la Commande");
        alert.setContentText(facture.genererFacture(marqueSelection.getMarque()));
        alert.showAndWait();
    }

    private void showError(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    }

