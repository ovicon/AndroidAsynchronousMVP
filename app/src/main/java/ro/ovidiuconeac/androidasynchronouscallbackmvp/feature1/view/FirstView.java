package ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.view;

/**
 * Created by ovidiu on 12/29/16.
 */

public interface FirstView {
    void requestLogin();
    void doLogin();
    void showLoginError();
    void requestMessage();
    void postMessage(String message);
}
