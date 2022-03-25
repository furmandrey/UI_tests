package com.geekbrains.lesson4;

public class NotExistingException extends Exception {
    public NotExistingException(String s) {
        System.out.println(s);
    }
}
