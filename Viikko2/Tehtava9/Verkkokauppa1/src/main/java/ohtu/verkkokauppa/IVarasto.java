package ohtu.verkkokauppa;

import ohtu.verkkokauppa.Tuote;

public interface IVarasto {
    Tuote haeTuote(int id);
    int saldo(int id);
    void otaVarastosta(Tuote tuote);
    void palautaVarastoon(Tuote tuote);
}