package KIT_Einheiten.JavaFX.Klassen;

import java.time.LocalDate;

/**
 * since: 29.03.2023
 * author: ML Dozent Armenti
 */
public class Person {
    private int persnr;
    private String vorname;
    private String nachname;
    private LocalDate gebdatum;

    public int getPersnr() {
        return persnr;
    }

    public void setPersnr(int persnr) {
        this.persnr = persnr;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public LocalDate getGebdatum() {
        return gebdatum;
    }

    public void setGebdatum(LocalDate gebdatum) {
        this.gebdatum = gebdatum;
    }

    public Person() {
        this(0, "", "", LocalDate.now());
    }

    public Person(int persnr, String vorname, String nachname, LocalDate gebdatum) {
        setPersnr(persnr);
        setVorname(vorname);
        setNachname(nachname);
        setGebdatum(gebdatum);
    }
}
