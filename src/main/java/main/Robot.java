package main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

    @Value("${name}")
    private String string;

    public void setString(String string) {
        this.string = string;
    }

    public void make() {
        System.out.println(string);
    }
}
