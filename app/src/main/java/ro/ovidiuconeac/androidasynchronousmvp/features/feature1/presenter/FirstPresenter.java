package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.presenter;

import android.os.AsyncTask;

import java.util.UUID;

import ro.ovidiuconeac.androidasynchronousmvp.common.Util;
import ro.ovidiuconeac.androidasynchronousmvp.features.Presenter;
import ro.ovidiuconeac.androidasynchronousmvp.features.Screen;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.FirstModel;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model.User;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature1.view.FirstScreen;

/**
 * Created by ovidiu on 12/29/16.
 *
 */
public final class FirstPresenter implements Presenter {

    private UUID uuid;
    private FirstScreen screen;
    private FirstModel model;

    public FirstPresenter(FirstScreen screen) {
        this.uuid = UUID.randomUUID();
        this.screen = screen;
        this.model = new FirstModel();
    }

    public void requestLogin(final User user) {
        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... params) {
                Util.simulateNetworkLatency(3000);
                return model.isValid(user);
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                if (aBoolean) {
                    screen.doLogin();
                } else {
                    screen.showLoginError();
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void requestMessage(final FirstScreen screen) {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                return model.requestMessage();
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                screen.postMessage(message);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void setScreen(Screen screen) {
        this.screen = (FirstScreen) screen;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }
}
