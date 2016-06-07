package ru.kpfu.itis;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by TECH on 04.03.2016.
 */
@Service
@Scope("singleton")
public class TestService {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void printService(){
        System.out.println("TestService: " + message);
    }
    public TestService(){

    }
    public TestService(String message){
        this.message = message;
    }

    String message;

}
