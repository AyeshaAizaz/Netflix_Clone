package com.example.netflixclone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationChecks {

    private static final String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String phonePattern = "^\\+\\d{10,}$\n";
    private static final String passPattern =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)[a-zA-Z\\\\d!@#$%^&*()-_+=<>?.,;:'\\\"`~\\\\[\\\\]{}\\\\/\\\\\\\\]{8,}$\n";
    private static final Pattern passpattern = Pattern.compile(passPattern);
    private static final Pattern emailpattern = Pattern.compile(emailPattern);
    private static final Pattern phonepattern = Pattern.compile(phonePattern);

    private String email, pass;

    public ValidationChecks(){

    }

    public static boolean isEmailOrPhoneValid(String email) {
        Matcher emailMatcher = emailpattern.matcher(email);
        Matcher phoneMatcher = phonepattern.matcher(email);
        return emailMatcher.matches() || phoneMatcher.matches();
    }

    public static boolean isPasswordValid(String password) {
        Matcher passMatcher = passpattern.matcher(password);
        return passMatcher.matches() && password.length() >= 8 && password.length() <= 16;
    }

}
