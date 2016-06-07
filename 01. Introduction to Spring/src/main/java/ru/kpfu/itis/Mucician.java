package ru.kpfu.itis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by root on 05.10.15.
 */
public class Mucician {

    String name;

    int age;
    @Autowired
    @Qualifier("testService2")
    TestService printService;
    @Autowired
    @Qualifier("piano")
    Instrument instrument;

    List<String> songs;

    public Mucician(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Mucician() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }



    public void print(){
        printService.printService();
    }
}
