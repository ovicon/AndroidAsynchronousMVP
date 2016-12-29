package ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.presenter;

import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.model.FirstModel;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.model.User;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.view.FirstView;

/**
 * Created by ovidiu on 12/29/16.
 */

public class FirstPresenterImpl implements FirstPresenter {

    private FirstView view;
    private FirstModel model;

    public FirstPresenterImpl(FirstView firstView) {
        this.view = firstView;
        this.model = new FirstModel(this);
    }

    @Override
    public void requestLogin(User user) {
        model.requestLogin(user);
    }

    @Override
    public void doLogin() {
        view.doLogin();
    }

    @Override
    public void showLoginError() {
        view.showLoginError();
    }

    @Override
    public void requestMessage() {
        model.requestMessage();
    }

    @Override
    public void postMessage(String message) {
        view.postMessage(message);
    }
}
