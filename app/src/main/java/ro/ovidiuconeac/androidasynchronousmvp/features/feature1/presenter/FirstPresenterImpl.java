package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.presenter;

import java.util.UUID;

import ro.ovidiuconeac.androidasynchronousmvp.common.Util;
import ro.ovidiuconeac.androidasynchronousmvp.features.Screen;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.FirstModel;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.Message;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.User;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.view.FirstView;

/**
 * Created by ovidiu on 12/29/16.
 *
 */
public class FirstPresenterImpl implements FirstPresenter {

    private UUID uuid;
    private FirstView view;
    private FirstModel model;

    public FirstPresenterImpl(FirstView view) {
        this.uuid = UUID.randomUUID();
        this.view = view;
        this.model = new FirstModel(this);
    }

    @Override
    public void requestLogin(User user) {
        Util.simulateNetworkLatency(3000);
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
    public void postMessage(Message message) {
        view.postMessage(message.getMessage());
    }

    @Override
    public void setView(Screen view) {
        this.view = (FirstView) view;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }
}
