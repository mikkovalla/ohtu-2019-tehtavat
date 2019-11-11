
package ohtu.verkkokauppa;

import java.util.ArrayList;

import main.java.ohtu.verkkokauppa.IKirjanpito;

public class Kirjanpito implements IKirjanpito {
    private static Kirjanpito instance;
    
    public static Kirjanpito getInstance() {
        if ( instance==null) {
            instance = new Kirjanpito();
        }
        
        return instance;
    }
    
    private ArrayList<String> tapahtumat;

    private Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }
    
    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
