package fr.clicandpick.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by Marc on 13/08/2015.
 */
public final class PasswordService {
    public static String hashPassword(String plaintext) {
        return BCrypt.hashpw(plaintext, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plaintext , String hashed) {
        return BCrypt.checkpw(plaintext, hashed);
    }
}