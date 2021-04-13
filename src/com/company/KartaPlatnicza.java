package com.company;

public class KartaPlatnicza extends Osoba{
    private String numerKarty;
    private String PIN;
    private double srodki;
    private String producentKarty;
    public KartaPlatnicza(String imie, String nazwisko, String numerKarty, String PIN, double srodki, String producentKarty) {
        super(imie, nazwisko);
        this.numerKarty = numerKarty;
        this.PIN = PIN;
        this.srodki = srodki;
        this.producentKarty = producentKarty;
    }

    public String getNumerKarty() {
        return numerKarty;
    }

    public String getPIN() {
        return PIN;
    }

    public double getSrodki() {
        return srodki;
    }

    public String getProducentKarty() {
        return producentKarty;
    }

    protected void setProducentKarty(String producentKarty) {
        this.producentKarty = producentKarty;
    }

    @Override
    public String toString() {
        return getImie()+"\t"+getNazwisko()+"\t"+getNumerKarty()+"\t"+getPIN()+"\t"+getSrodki()+"\t"+getProducentKarty();
    }
}
