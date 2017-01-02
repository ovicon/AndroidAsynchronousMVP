package ro.ovidiuconeac.androidasynchronousmvp.feature1.presenter;

import ro.ovidiuconeac.androidasynchronousmvp.feature1.model.FirstModel;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.model.User;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.view.FirstScreen;

/**
 * Created by ovidiu on 12/29/16.
 */

public class FirstPresenter {

    private FirstModel model = new FirstModel();

    public void requestLogin(FirstScreen screen, User user) {
        if(model.isValid(user)) {
            screen.doLogin();
        } else {
            screen.showLoginError();
        }
    }

    public void requestMessage(FirstScreen screen) {
        screen.postMessage(model.requestMessage());
    }
}
