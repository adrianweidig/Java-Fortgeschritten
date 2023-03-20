package KIT_Einheiten.applikationen;

import KIT_Einheiten.bank.ausgabe.KonsolenAusgabe;
import KIT_Einheiten.bank.eingabe.DateiEingabe;
import KIT_Einheiten.bank.klassen.KontoStamm;
import KIT_Einheiten.bank.schnittstellen.IAusgabe;
import KIT_Einheiten.bank.schnittstellen.IEingabe;

import java.util.HashMap;
import java.util.Map;

public class AppBankDatei {
    public static void main(String[] args) {
        IEingabe eingabeTest = new DateiEingabe();
        IAusgabe ausgabeTest = new KonsolenAusgabe();

        HashMap<Integer, KontoStamm> konten = eingabeTest.konten();

        ausgabeTest.konten(konten);
    }
}
