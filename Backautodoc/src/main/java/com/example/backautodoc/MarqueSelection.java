package com.example.backautodoc;
import java.util.ArrayList;
import java.util.List;

public class MarqueSelection {
    public String marque;
    public final List<String> marques;

    public MarqueSelection() {
        this.marque = null; // Pas de marque par défaut
        this.marques = new ArrayList<>();
        initialiserMarques();
    }

    public MarqueSelection(List<String> marques) { // constructeur  marque
        this.marques = marques;
        this.marque = null; // pas de marque par défaut
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public List<String> getMarques(){
        return marques;
    }

    private void initialiserMarques() {
        marques.add("Toyota");
        marques.add("Ford");
        marques.add("BMW");
    }
}

