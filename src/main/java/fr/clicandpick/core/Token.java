package fr.clicandpick.core;

/**
 * Created by Marc on 13/08/2015.
 */
import com.fasterxml.jackson.annotation.JsonProperty;

public class Token {
    String token;

    public Token(@JsonProperty("token") String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}