package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presentor;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import java.util.UUID;

import ro.ovidiuconeac.androidasynchronousmvp.common.Util;
import ro.ovidiuconeac.androidasynchronousmvp.features.Presenter;
import ro.ovidiuconeac.androidasynchronousmvp.features.Screen;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model.SecondModel;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.view.SecondScreen;

/**
 * Created by ovidiu on 12/29/16.
 */

public final class SecondPresenter implements Presenter {

    private UUID uuid;
    private SecondScreen screen;
    private SecondModel model;

    public SecondPresenter(SecondScreen screen) {
        this.uuid = UUID.randomUUID();
        this.screen = screen;
        this.model = new SecondModel();
    }

    public void requestName() {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                Util.simulateNetworkLatency(2000);
                return model.requestName();
            }

            @Override
            protected void onPostExecute(String name) {
                super.onPostExecute(name);
                screen.postName(name);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void requestAge() {
        new AsyncTask<Void, Void, Integer>() {

            @Override
            protected Integer doInBackground(Void... params) {
                Util.simulateNetworkLatency(3000);
                return model.requestAge();
            }

            @Override
            protected void onPostExecute(Integer age) {
                super.onPostExecute(age);
                screen.postAge(age);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void requestImage() {
        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected Bitmap doInBackground(Void... params) {
                Util.simulateNetworkLatency(4000);
                return model.requestImage(screen.getContext());
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                screen.postImage(bitmap);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);;
    }

    @Override
    public void setScreen(Screen screen) {
        this.screen = (SecondScreen) screen;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }
}
