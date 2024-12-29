package com.example.backautodoc;

public class GestionQuantites {
    private int freinsQty = 0;
    private int huileQty = 0;
    private int filtresQty = 0;

    public int getFreinsQty() {
        return freinsQty;
    }

    public void updateFreinsQty(int delta) {
        freinsQty = Math.max(0, freinsQty + delta);
    }

    public int getHuileQty() {
        return huileQty;
    }

    public void updateHuileQty(int delta) {
        huileQty = Math.max(0, huileQty + delta);
    }

    public int getFiltresQty() {
        return filtresQty;
    }

    public void updateFiltresQty(int delta) {
        filtresQty = Math.max(0, filtresQty + delta);
    }
}
