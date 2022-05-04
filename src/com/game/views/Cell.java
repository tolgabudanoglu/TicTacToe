package com.game.views;

import com.game.enums.Sembol;

public class Cell {
    private Sembol icerik;
    private  int satir;
    private int sutun;

    public Cell(int satir, int sutun) {
        this.satir = satir;
        this.sutun = sutun;
    }

    public void clear(){
        icerik = Sembol.BOS;
    }

    public Sembol getIcerik() {
        return icerik;
    }

    public void setIcerik(Sembol icerik) {
        this.icerik = icerik;
    }

    public void ciz(){
        if (icerik == Sembol.CARPI)
            System.out.print(" X ");
        else if (icerik == Sembol.DAİRE)
            System.out.print(" O ");
        else if (icerik == Sembol.BOS)
            System.out.print("   ");
    }
}
