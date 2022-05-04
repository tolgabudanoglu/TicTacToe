package com.game.gametictactoe;

import com.game.enums.Durum;
import com.game.enums.Sembol;
import com.game.views.Board;

import java.util.Scanner;

public class GameMain {

    private Board board;
    private Durum mevcutDurum;
    private Sembol mevcutOyuncu;

    private Scanner scanner = new Scanner(System.in);

    public GameMain(){
        board = new Board();
        board.hucreTemizle();
        mevcutOyuncu = Sembol.CARPI;
        mevcutDurum = Durum.OYNANIYOR;

        do{
            oyunOyna(mevcutOyuncu);
            board.ciz();
            oyunGuncelle(mevcutOyuncu);

            if (mevcutDurum == Durum.X_KAZANDI)
                System.out.println("x kazandı");
            else if (mevcutDurum == Durum.O_KAZANDI)
                System.out.println("o kazandı");
            else if(mevcutDurum == Durum.BERABERE)
                System.out.println("berabere");

            mevcutOyuncu = (mevcutOyuncu == Sembol.CARPI) ? Sembol.DAİRE : Sembol.CARPI;


        }while (mevcutDurum == Durum.OYNANIYOR);



    }
    public void oyunOyna(Sembol sembol){

        boolean bilgiGirisi = false;

        do {
            if (sembol==Sembol.CARPI)
                System.out.print("x oyuncusu icin satir [1-3] sutun [1-3] bilgisi:");
            else
                System.out.print("o oyuncusu icin satir [1-3] sutun [1-3] bilgisi:");
            int satir = scanner.nextInt() -1;
            int sutun = scanner.nextInt() -1;

            if (satir>=0 && satir <Board.SATIRSAYISI && sutun >= 0 &&
            sutun <Board.SUTUNSAYISI &&
            board.getHucreler()[satir][sutun].getIcerik() == Sembol.BOS){
                board.getHucreler()[satir][sutun].setIcerik(sembol);
                board.setAktifSutun(sutun);
                board.setAktifSatir(satir);
                bilgiGirisi =true;
            }
            else
                System.out.println("hatalı satir sutun girliişi");

        }while (!bilgiGirisi);

    }
    public void oyunGuncelle(Sembol sembol){
        if (board.kazananıBul(sembol))
            mevcutDurum = (sembol == Sembol.CARPI) ? Durum.X_KAZANDI: Durum.O_KAZANDI;
        else if (board.berabere())
            mevcutDurum = Durum.BERABERE;

    }
}
