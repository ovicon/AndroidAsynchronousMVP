package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model;

/**
 * Created by ovidiu on 12/29/16.
 *
 */

public class User {
    private String user;
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}