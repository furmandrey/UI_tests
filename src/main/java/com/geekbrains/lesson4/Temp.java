package com.geekbrains.lesson4;

import static com.geekbrains.lesson4.AreaTriangle.squareMeters;

public class Temp {
    public static void main(String[] args) throws SideMustHaveSizeException, NotExistingException {
        System.out.println(squareMeters(4.0, 4.0, 5.0));
        System.out.println(squareMeters(1.0, 2.0, 5.0));
        //System.out.println(squareMeters(0.0, 4.0, 5.0));
    }
}
