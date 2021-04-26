package com.company;

public class KartaPlatniczaMastercard extends KartaPlatnicza{

    public KartaPlatniczaMastercard(String imie, String nazwisko, long numerKarty, short PIN, double srodki) {
        super(imie,nazwisko,numerKarty,PIN,srodki);
        setProducentKarty(Producenci.MASTERCARD);
    }
}
