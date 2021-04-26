package com.company;

public class KartaPlatnicza extends Osoba{
    private long numerKarty;
    private short PIN;
    protected double srodki;
    private Producenci producentKarty;

    public KartaPlatnicza(String imie, String nazwisko, long numerKarty, short PIN, double srodki) {
        super(imie, nazwisko);
        this.numerKarty = numerKarty;
        this.PIN = PIN;
        this.srodki = srodki;
    }

    public KartaPlatnicza(String imie, String nazwisko, String numerKarty, short PIN, double srodki) {
        super(imie, nazwisko);
        this.numerKarty = Long.parseLong(numerKarty);
        this.PIN = PIN;
        this.srodki = srodki;
    }

    public String getNumerKarty() {
        return String.format("%16d", numerKarty).replaceAll("\\s", "0");
    }

    public short getPIN() {
        return PIN;
    }

    public double getSrodki() {
        return srodki;
    }

    public Producenci getProducentKarty() {
        return producentKarty;
    }

    protected void setProducentKarty(Producenci producentKarty) {
        this.producentKarty = producentKarty;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, %d, %.2f, %s",
                getImie(), getNazwisko(), getNumerKarty(), getPIN(), getSrodki(), getProducentKarty());
    }
}
