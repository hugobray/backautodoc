package com.example.backautodoc;

public class PieceSelection {
    private boolean freins;
    private boolean huile;
    private boolean filtres;

    public boolean isFreins() {
        return freins;
    }
    public void setFreins(boolean freins) {
        this.freins = freins;
    }
    public boolean isHuile() {
        return huile;
    }

    public void setHuile(boolean huile) {
        this.huile = huile;
    }

    public boolean isFiltres() {
        return filtres;
    }

    public void setFiltres(boolean filtres) {
        this.filtres = filtres;
    }
}
