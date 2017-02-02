package ro.ovidiuconeac.androidasynchronousmvp.feature1.presenter;

import android.os.AsyncTask;

import ro.ovidiuconeac.androidasynchronousmvp.common.Util;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.model.FirstModel;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.model.User;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.view.FirstScreen;

/**
 * Created by ovidiu on 12/29/16.
 */

public final class FirstPresenter {

    private static FirstPresenter presenter;
    private static FirstScreen screen;

    private FirstModel model = new FirstModel();

    public static FirstPresenter getInstance(FirstScreen screen) {
        if (presenter == null) {
            presenter = new FirstPresenter();
        }
        FirstPresenter.screen = screen;
        return presenter;
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
}
