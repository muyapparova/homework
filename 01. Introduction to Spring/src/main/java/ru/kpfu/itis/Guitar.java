package ru.kpfu.itis;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by root on 05.10.15.
 */
@Qualifier("strunnaya")
public class Guitar implements Instrument {
    public void play() {
        System.out.println("GUI!!TAR!");
    }
}
