package com.company;

public class KartaPlatniczaVisa extends KartaPlatnicza{

    public KartaPlatniczaVisa(String imie, String nazwisko, long numerKarty, short PIN, double srodki) {
        super(imie,nazwisko,numerKarty,PIN,srodki);
        setProducentKarty(Producenci.VISA);
    }
}
