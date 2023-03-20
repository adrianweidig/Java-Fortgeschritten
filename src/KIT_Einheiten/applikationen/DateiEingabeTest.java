package KIT_Einheiten.applikationen;

import KIT_Einheiten.bank.eingabe.DateiEingabe;
import KIT_Einheiten.bank.klassen.KontoStamm;

import java.util.HashMap;
import java.util.Map;

public class DateiEingabeTest {
    public static void main(String[] args) {
        DateiEingabe eingabeTest = new DateiEingabe();

        HashMap<Integer, KontoStamm> konten = eingabeTest.konten();

        for (Map.Entry<Integer, KontoStamm> konto : konten.entrySet()) {
            System.out.println(konto.getValue().getInfo());
        }
    }
}
