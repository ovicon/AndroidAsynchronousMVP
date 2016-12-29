package ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.model;

import ro.ovidiuconeac.androidasynchronouscallbackmvp.common.Util;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature1.presenter.FirstPresenter;

/**
 * Created by ovidiu on 12/29/16.
 */

public class FirstModel {

    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    private FirstPresenter presenter;

    public FirstModel(FirstPresenter presenter) {
        this.presenter = presenter;
    }

    public void requestLogin(User user) {
        Util.simulateNetworkLatency(6000);
        if(authenticate(user)) {
            presenter.doLogin();
        } else {
            presenter.showLoginError();
        }
    }

    private boolean authenticate(User user) {
        boolean authenticated = false;
        if (USER.equals(user.getUser()) && PASSWORD.equals(user.getPassword())) {
            authenticated = true;
        }
        return authenticated;
    }
}
