package com.geekbrains.lesson4;


public class AreaTriangle {
    public static double squareMeters (double a, double b, double c) throws SideMustHaveSizeException, NotExistingException {
        if (a == 0.0 || b == 0.0 || c == 0.0){
            throw new SideMustHaveSizeException("Сторона не может быть нулевой!");
        }
        double max = a;
        if (b >= max) max = b;
        if (c >= max) max = c;
        double sum = a + b + c;
        if (max > sum - max) {
            throw new NotExistingException("Такого треугольника не существует!");
        }

        double p = (a + b + c)/2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        double scale = Math.pow(10, 2);
        s = Math.ceil(s * scale)/scale;
        return s;
    }
}
