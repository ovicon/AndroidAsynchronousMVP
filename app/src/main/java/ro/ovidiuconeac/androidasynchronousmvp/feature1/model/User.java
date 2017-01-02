package ro.ovidiuconeac.androidasynchronousmvp.feature1.model;

/**
 * Created by ovidiu on 12/29/16.
 */

public class User {
    public String user;
    public String password;

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