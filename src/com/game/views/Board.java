package com.game.views;

import com.game.enums.Sembol;

public class Board {
    public static final int SATIRSAYISI = 3;
    public static final int SUTUNSAYISI = 3;

    private Cell[][] hucreler;
    private int aktifSatir;
    private int aktifSutun;

    public Board() {
        hucreler = new Cell[SATIRSAYISI][SUTUNSAYISI];
        for (int i = 0; i < SATIRSAYISI; i++)
            for (int j = 0; j < SUTUNSAYISI; j++)
                hucreler[i][j] = new Cell(i, j);
    }

    public void hucreTemizle() {
        for (int i = 0; i < SATIRSAYISI; i++)
            for (int j = 0; j < SUTUNSAYISI; j++)
                hucreler[i][j].clear();
    }

    public int getAktifSatir() {
        return aktifSatir;
    }

    public void setAktifSatir(int aktifSatir) {
        this.aktifSatir = aktifSatir;
    }

    public int getAktifSutun() {
        return aktifSutun;
    }

    public void setAktifSutun(int aktifSutun) {
        this.aktifSutun = aktifSutun;
    }

    public Cell[][] getHucreler() {
        return hucreler;
    }

    public void setHucreler(Cell[][] hucreler) {
        this.hucreler = hucreler;
    }

    public boolean kazananıBul(Sembol sembol) {
        return (hucreler[aktifSatir][0].getIcerik() == sembol
                && hucreler[aktifSatir][1].getIcerik() == sembol
                && hucreler[aktifSatir][2].getIcerik() == sembol
                || hucreler[aktifSutun][0].getIcerik() == sembol
                && hucreler[aktifSutun][1].getIcerik() == sembol
                && hucreler[aktifSutun][2].getIcerik() == sembol
                || aktifSutun == aktifSatir
                && hucreler[0][0].getIcerik() == sembol
                && hucreler[1][1].getIcerik() == sembol
                && hucreler[2][2].getIcerik() == sembol
                || aktifSatir + aktifSutun == 2
                && hucreler[0][2].getIcerik() == sembol
                && hucreler[1][1].getIcerik() == sembol
                && hucreler[2][0].getIcerik() == sembol);

    }

    public void ciz() {
        for (int i = 0; i < SATIRSAYISI; i++) {
            for (int j = 0; j < SUTUNSAYISI; j++) {
                hucreler[i][j].ciz();
                if (j < SUTUNSAYISI - 1)
                    System.out.print("|");
            }
            System.out.println();
            if (i < SATIRSAYISI - 1)
                System.out.println("------------");
        }
    }

    public boolean berabere() {
        for (int i = 0; i < SATIRSAYISI; i++)
            for (int j = 0; j < SUTUNSAYISI; j++)
                if (hucreler[i][j].getIcerik() == Sembol.BOS)
                    return false;

        return true;


    }
}

