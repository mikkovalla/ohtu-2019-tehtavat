
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5; // aloitustalukon koko
    public final static int OLETUSKASVATUS = 5;  // luotava uusi taulukko on näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(IntJoukko.KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(IntJoukko.OLETUSKASVATUS, IntJoukko.KAPASITEETTI);
    }
        
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kasvatuskoko väärin");
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if(this.kuuluu(luku)) return false;
        if(this.alkioidenLkm == this.ljono.length) {
            this.kasvataTaulukkoa();
        }

        this.ljono[this.alkioidenLkm++] = luku;

        return true;
    }

    private void kasvataTaulukkoa() {
        int[] uusitaulukko = new int[this.ljono.length + this.kasvatuskoko];
        System.arraycopy(this.ljono, 0, uusitaulukko, 0, this.ljono.length);
        this.ljono = uusitaulukko;
    }

    public boolean kuuluu(int luku) {
        return this.luvunIndeksi(luku) >= 0;
    }

    public int luvunIndeksi(int luku) {
        for(int i = 0; i < this.alkioidenLkm; i++) {
            if(this.ljono[i] == luku) return i;
        }
        return -1;
    }

    public boolean poista(int luku) {
        int indeksi = this.luvunIndeksi(luku);
        if (indeksi == -1) return false;
        this.korjaaTaulukko(indeksi);
        return true;
    }

    private void korjaaTaulukko(int indeksi) {
        System.arraycopy(this.ljono, indeksi + 1, this.ljono, indeksi, this.ljono.length - indeksi - 1);
        this.alkioidenLkm--;
    }

    public int mahtavuus() {
        return this.alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) return "{}";
        else {
            StringBuilder joukko = new StringBuilder("{");
            for(int i = 0; i < this.alkioidenLkm; i++) {
                if(i > 0) joukko.append(", ");
                joukko.append(this.ljono[i]);
            }
            joukko.append("}");
            return joukko.toString();
        }
    }

    public int[] toIntArray() {
        return Arrays.copyOf(this.ljono, this.alkioidenLkm);
    }
   
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko joukko = IntJoukko.kopioi(a);
        for(int i = 0; i < b.alkioidenLkm; i++) joukko.lisaa(b.ljono[i]);
        return joukko;
    }

    public static IntJoukko kopioi(IntJoukko a) {
        //Kopioi suoraan taulukko a b:hen
        IntJoukko b = new IntJoukko(a.alkioidenLkm);
        System.arraycopy(a.ljono, 0, b.ljono, 0, a.alkioidenLkm);
        b.alkioidenLkm = a.alkioidenLkm;
        return b;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for(int i = 0; i < a.alkioidenLkm; i++){
            int indeksi = a.ljono[i];
            if(b.kuuluu(indeksi)) y.lisaa(indeksi);
        }
        return y;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = IntJoukko.kopioi(a);
        for(int i = 0; i < b.alkioidenLkm; i++) z.poista(b.ljono[i]);
        return z;
    }
        
}
