package com.company;

import java.util.Scanner;

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

    public KartaPlatnicza() {
        super(null, null);
        this.numerKarty = -1;
        this.PIN = -1;
        this.srodki = -1;
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

    public void wyswietlBalans() {
        System.out.printf("Masz %.2f pieniędzy na koncie!\n", srodki);
    }

    public void wyplacPieniadze() {
        Scanner scanner = new Scanner(System.in);
        wyswietlBalans();
        int wyplacanaKwota = -1;
        System.out.print("Ile chcesz wypłacić pieniędzy: ");
        wyplacanaKwota = Integer.parseInt(scanner.nextLine());
        if (wyplacanaKwota > srodki) {
            System.out.println("Przekroczyłeś stan konta!");
        } else if (wyplacanaKwota == 0) {
            System.out.println("Nie możesz wypłacić 0zł!");
        } else {
            System.out.printf("Wypłacono %.2f pieniędzy z konta!\n", srodki);
            srodki -= wyplacanaKwota;
        }
        scanner.close();
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, %d, %.2f, %s",
                getImie(), getNazwisko(), getNumerKarty(), getPIN(), getSrodki(), getProducentKarty());
    }
}
