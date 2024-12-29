package com.example.backautodoc;

public class Facture {
    private final GestionQuantites gestionQuantites;
    private final PrixArticles prixArticles;

    public Facture(GestionQuantites gestionQuantites, PrixArticles prixArticles) {
        this.gestionQuantites = gestionQuantites;
        this.prixArticles = prixArticles;
    }

    public int calculerPrixTotal() {
        return (gestionQuantites.getFreinsQty() * prixArticles.getPrixFrein()) +
                (gestionQuantites.getHuileQty() * prixArticles.getPrixHuile()) +
                (gestionQuantites.getFiltresQty() * prixArticles.getPrixFiltre());
    }

    public String genererFacture(String marque) {
        StringBuilder facture = new StringBuilder();
        facture.append("Facture pour la marque ").append(marque).append(":\n");

        int totalFreins = gestionQuantites.getFreinsQty() * prixArticles.getPrixFrein();
        int totalHuile = gestionQuantites.getHuileQty() * prixArticles.getPrixHuile();
        int totalFiltres = gestionQuantites.getFiltresQty() * prixArticles.getPrixFiltre();

        if (gestionQuantites.getFreinsQty() > 0) {
            facture.append("- Freins: ").append(gestionQuantites.getFreinsQty())
                    .append(" x ").append(prixArticles.getPrixFrein()).append("€\n");
        }
        if (gestionQuantites.getHuileQty() > 0) {
            facture.append("- Huile: ").append(gestionQuantites.getHuileQty())
                    .append(" x ").append(prixArticles.getPrixHuile()).append("€\n");
        }
        if (gestionQuantites.getFiltresQty() > 0) {
            facture.append("- Filtres: ").append(gestionQuantites.getFiltresQty())
                    .append(" x ").append(prixArticles.getPrixFiltre()).append("€\n");
        }

        facture.append("Prix total: ").append(calculerPrixTotal()).append(" €");
        return facture.toString();
    }
}

