package com.company;

public class KartaPlatniczaVisa extends KartaPlatnicza{

    public KartaPlatniczaVisa(String imie, String nazwisko, long numerKarty, short PIN, double srodki) {
        super(imie,nazwisko,numerKarty,PIN,srodki);
        setProducentKarty(Producenci.VISA);
    }

    public KartaPlatniczaVisa(String imie, String nazwisko, String numerKarty, short PIN, double srodki) {
        super(imie,nazwisko,numerKarty,PIN,srodki);
        setProducentKarty(Producenci.VISA);
    }

    public void doliczSrodki(double noweSrodki) {
        noweSrodki *= 1.05;
        srodki += noweSrodki;
        System.out.printf("Wpłacono %.2f (doliczono 5%s premii dla posiadaczy karty VISA) pieniędzy do konta\n", noweSrodki, "%");
    }

}
