package ro.ovidiuconeac.androidasynchronousmvp.feature1.presenter;

import ro.ovidiuconeac.androidasynchronousmvp.feature1.model.FirstModel;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.model.User;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.view.FirstView;

/**
 * Created by ovidiu on 12/29/16.
 */

public class FirstPresenterImpl implements FirstPresenter {

    private FirstView view;
    private FirstModel model;

    public FirstPresenterImpl(FirstView firstView) {
        this.view = firstView;
        this.model = new FirstModel();
    }

    @Override
    public void requestLogin(User user) {
        if(model.isValid(user)) {
            view.doLogin();
        } else {
            view.showLoginError();
        }
    }

    @Override
    public void requestMessage() {
        view.postMessage(model.requestMessage());
    }
}
