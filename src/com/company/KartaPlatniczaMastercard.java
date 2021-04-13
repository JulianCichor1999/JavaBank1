package com.company;

public class KartaPlatniczaMastercard extends KartaPlatnicza{
    public KartaPlatniczaMastercard(String imie, String nazwisko, String numerKarty, String PIN, double srodki, String producentKarty) {
        super(imie, nazwisko, numerKarty, PIN, srodki, producentKarty);
        setProducentKarty("MasterCard");
    }
}
