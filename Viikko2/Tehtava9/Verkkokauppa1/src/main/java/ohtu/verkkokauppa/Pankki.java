package ohtu.verkkokauppa;

import main.java.ohtu.verkkokauppa.IPankki;

public class Pankki implements IPankki{

    private static Pankki instanssi;

    public static Pankki getInstance() {
        if (instanssi == null) {
            instanssi = new Pankki();
        }

        return instanssi;
    }
    private IKirjanpito kirjanpito;

    public Pankki() {
        kirjanpito = Kirjanpito.getInstance();
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
