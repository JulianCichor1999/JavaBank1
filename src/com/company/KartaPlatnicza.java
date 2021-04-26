package com.company;

public class KartaPlatnicza extends Osoba{
    private long numerKarty;
    private short PIN;
    protected double srodki;
    private Producenci producentKarty;
    public KartaPlatnicza(String imie, String nazwisko, long numerKarty, short PIN, double srodki, Producenci producentKarty) {
        super(imie, nazwisko);
        this.numerKarty = numerKarty;
        this.PIN = PIN;
        this.srodki = srodki;
        this.producentKarty = producentKarty;
    }

    public KartaPlatnicza(String imie, String nazwisko, long numerKarty, short PIN, double srodki) {
        super(imie, nazwisko);
        this.numerKarty = numerKarty;
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

    public static KartaPlatnicza parseData(String data) {
        String[] clients = data.split(",");
        String imie = clients[0];
        String nazwisko = clients[1];
        long numerKonta = Long.parseLong(clients[2].replaceAll("\\s+", ""));
        short numerPIN = Short.parseShort(clients[3]);
        double srodki = Double.parseDouble(clients[4]);
        Producenci producentKarty = Producenci.valueOf(clients[5].toUpperCase());
        return new KartaPlatnicza(imie,nazwisko,numerKonta,numerPIN,srodki,producentKarty);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, %d, %.2f, %s",
                getImie(), getNazwisko(), getNumerKarty(), getPIN(), getSrodki(), getProducentKarty());
    }
}
