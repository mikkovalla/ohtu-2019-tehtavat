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
        when(this.viite.uusi()).thenReturn(42);
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        when(this.varasto.saldo(1)).thenReturn(10);
        when(this.varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        // tehdään ostokset
        this.kauppa.aloitaAsiointi();
        this.kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        this.kauppa.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        //verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
        verify(this.pankki).tilisiirto(eq("pekka"), eq(42),eq("12345"), anyString(), eq(5));  
    }

    /*aloitetaan asiointi, koriin lisätään kaksi eri tuotetta, 
    joita varastossa on ja suoritetaan ostos, varmista että kutsutaan pankin metodia 
    tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla*/
    @Test
    public void ostetaanKaksiEriTuotetta() {
        when(this.varasto.saldo(1)).thenReturn(5);
        when(this.varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(this.varasto.saldo(2)).thenReturn(5);
        when(this.varasto.haeTuote(2)).thenReturn(new Tuote(2, "leipä", 2));

        this.kauppa.aloitaAsiointi();
        this.kauppa.lisaaKoriin(1);
        this.kauppa.lisaaKoriin(2);
        this.kauppa.tilimaksu("pekka", "12345");
        verify(this.pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), anyString(), eq(7));
    }
    /*aloitetaan asiointi, koriin lisätään kaksi samaa tuotetta, jota on varastossa tarpeeksi ja suoritetaan ostos, 
    varmista että kutsutaan pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla*/
    @Test
    public void ostetaanKaksiSamaaTuotetta() {
        when(this.varasto.saldo(1)).thenReturn(10);
        when(this.varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    
        this.kauppa.aloitaAsiointi();
        this.kauppa.lisaaKoriin(1);
        this.kauppa.lisaaKoriin(1);
        this.kauppa.tilimaksu("pekka", "12345");
        verify(this.pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), anyString(), eq(10));
    }

}