package ro.ovidiuconeac.androidasynchronousmvp.feature1.view;

/**
 * Created by ovidiu on 12/29/16.
 */

public interface FirstScreen {
    void requestLogin();
    void doLogin();
    void showLoginError();
    void requestMessage();
    void postMessage(String message);
}
