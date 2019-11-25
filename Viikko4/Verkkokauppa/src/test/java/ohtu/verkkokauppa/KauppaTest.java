package test.java.ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Kirjanpito;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Viitegeneraattori;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Tuote;


public class KauppaTest {

    private Varasto varasto;
    private Pankki pankki;
    private Viitegeneraattori viite;
    private Kauppa kauppa;

    @Before
    public void setup() {
        this.varasto = mock(Varasto.class);
        this.pankki = mock(Pankki.class);
        this.viite = mock(Viitegeneraattori.class);
        this.kauppa = new Kauppa(this.varasto, this.pankki, this.viite);
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
       when(this.varasto.saldo(1)).thenReturn(10);

        // tehdään ostokset
        //k.aloitaAsiointi();
        //k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        //k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        //verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
}