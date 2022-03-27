package ru.learnUp.lesson21.springboottest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Utils {

    public static boolean isNumeric(String string) {

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) < 48 || string.charAt(i) > 57) {
                return false;
            }
        }
        if (string.length() == 0) {
            return false;
        }
        return true;
    }

    public static Locale setLocale() {
        while (true) {
            System.out.println("Выберите локализацию: [1] - default, [2] - english");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String answer = null;
            try {
                answer = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert answer != null;

            if (answer.equals("1")) {
                return Locale.getDefault();
            } else if (answer.equals("2")) {
                return Locale.US;
            } else {
                System.out.println("Введите число 1 или 2");
            }
        }
    }
}
