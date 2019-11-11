package ohtu.verkkokauppa;

import ohtu.verkkokauppa.IViitegeneraattori;

public class Viitegeneraattori implements IViitegeneraattori{
    private int seuraava;
    
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
