package application;

//import org.mindrot.jbcrypt.BCrypt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Login {
    private static final String FILENAME = "user_data.txt";

    public static void main(String[] args) {
        String username = "admin";
        String password = "password";

        String hashedPassword = hashPassword(password);

        writeUserData(username, hashedPassword);
    }

    private static String hashPassword(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    private static void writeUserData(String username, String hashedPassword) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            bw.write(username + "," + hashedPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

