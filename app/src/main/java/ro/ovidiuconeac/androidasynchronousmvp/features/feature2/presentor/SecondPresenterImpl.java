package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presentor;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import java.util.UUID;

import ro.ovidiuconeac.androidasynchronousmvp.common.Util;
import ro.ovidiuconeac.androidasynchronousmvp.features.Screen;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model.Age;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model.Image;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model.Name;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model.SecondModel;
import ro.ovidiuconeac.androidasynchronousmvp.features.feature2.view.SecondView;

/**
 * Created by ovidiu on 12/29/16.
 *
 */
public class SecondPresenterImpl implements SecondPresenter {

    private UUID uuid;
    private SecondView screen;
    private SecondModel model;

    public SecondPresenterImpl(SecondView view) {
        this.uuid = UUID.randomUUID();
        this.screen = view;
        this.model = new SecondModel();
    }

    @Override
    public void requestName() {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                Util.simulateNetworkLatency(2000);
                Name name = model.requestName();
                return name.getName();
            }

            @Override
            protected void onPostExecute(String name) {
                super.onPostExecute(name);
                screen.postName(name);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void requestAge() {
        new AsyncTask<Void, Void, Integer>() {

            @Override
            protected Integer doInBackground(Void... params) {
                Util.simulateNetworkLatency(3000);
                Age age = model.requestAge();
                return age.getAge();
            }

            @Override
            protected void onPostExecute(Integer age) {
                super.onPostExecute(age);
                screen.postAge(age);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void requestImage() {
        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected Bitmap doInBackground(Void... params) {
                Util.simulateNetworkLatency(4000);
                Image image = model.requestImage(screen.getContext());
                return image.getBitmap();
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                screen.postImage(bitmap);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);;
    }

    @Override
    public void setView(Screen view) {
        this.screen = (SecondView) view;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }
}
