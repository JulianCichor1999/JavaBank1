package com.company;

public class KartaPlatniczaVisa extends KartaPlatnicza{

    public KartaPlatniczaVisa(String imie, String nazwisko, String numerKarty, String PIN, double srodki, String producentKarty) {
        super(imie,nazwisko,numerKarty,PIN,srodki, producentKarty);
        setProducentKarty("Visa");
    }
    /*@Override
    public String toString() {
        return getImie()+"\t"+getNazwisko()+"\t"+getNumerKarty()+"\t"+getPIN()+"\t"+getSrodki();
    }*/
}
