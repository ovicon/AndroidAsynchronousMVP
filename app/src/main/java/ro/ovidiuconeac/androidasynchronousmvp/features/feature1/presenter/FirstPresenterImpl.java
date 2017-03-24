package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.presenter;

import android.os.AsyncTask;

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
        this.model = new FirstModel();
    }

    @Override
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
                    view.doLogin();
                } else {
                    view.showLoginError();
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void requestMessage(final FirstView screen) {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                Message result = model.requestMessage();
                return result.getMessage();
            }

            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                screen.postMessage(message);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void setView(Screen view) {
        this.view = (FirstView) view;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }
}
