package ru.kpfu.itis;

public class Singleton {

    private static Singleton INSTANCE;


    private Singleton() {

    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    public Mucician oleg() {
        Mucician m = new Mucician();
        m.setAge(12);
        return m;
    }

}
