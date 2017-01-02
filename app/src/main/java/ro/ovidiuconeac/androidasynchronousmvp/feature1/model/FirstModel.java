package ro.ovidiuconeac.androidasynchronousmvp.feature1.model;

import android.annotation.SuppressLint;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ro.ovidiuconeac.androidasynchronousmvp.common.Util;

/**
 * Created by ovidiu on 12/29/16.
 */

public class FirstModel {

    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    private Map<Integer, String> messages;
    private Random random;

    @SuppressLint("UseSparseArrays")
    public FirstModel() {
        messages = new HashMap<>();
        messages.put(0, "In teaching others we teach ourselves.");
        messages.put(1, "Don’t regret the past, just learn from it.");
        messages.put(2, "It does not matter how slowly you go as long as you do not stop.");
        messages.put(3, "I hear and I forget, I see and I remember. I do and I understand.”");
        messages.put(4, "Wherever you go, go with all your heart.");
        messages.put(5, "Don’t wait. The time will never be just right.");
        messages.put(6, "Do what you can, with what you have, where you are.");
        messages.put(7, "Action is the foundational key to all success.");
        messages.put(8, "The best way out is always through.");
        messages.put(9, "If not us, who? If not now, when?");
        messages.put(10, "I can, therefore I am.");
        random = new Random();
    }

    public boolean isValid(User user) {
        boolean valid = false;
        if(USER.equals(user.getUser()) && PASSWORD.equals(user.getPassword())) {
            valid = true;
        }
        return valid;
    }

    public String requestMessage() {
        return messages.get(random.nextInt(11));
    }
}
