package com.company;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<KartaPlatnicza> klienci = Reader.getKlienci();

        for(KartaPlatnicza kl: klienci) {
            System.out.println(kl.toString());
        }
    }
}