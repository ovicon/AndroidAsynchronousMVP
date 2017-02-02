package ro.ovidiuconeac.androidasynchronousmvp.feature1.presenter;

import android.os.AsyncTask;

import ro.ovidiuconeac.androidasynchronousmvp.common.Util;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.model.FirstModel;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.model.User;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.view.FirstScreen;

/**
 * Created by ovidiu on 12/29/16.
 */

public class FirstPresenter {

    private FirstModel model = new FirstModel();

    private static FirstPresenter presenter = new FirstPresenter();

    private static FirstScreen screen;

    public static FirstPresenter getInstance(FirstScreen screen) {
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
        }.execute();
    }

    public void requestMessage(FirstScreen screen) {
        screen.postMessage(model.requestMessage());
    }
}
