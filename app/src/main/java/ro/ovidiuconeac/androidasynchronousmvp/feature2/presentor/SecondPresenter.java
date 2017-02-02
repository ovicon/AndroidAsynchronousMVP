package ro.ovidiuconeac.androidasynchronousmvp.feature2.presentor;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import ro.ovidiuconeac.androidasynchronousmvp.feature1.presenter.FirstPresenter;
import ro.ovidiuconeac.androidasynchronousmvp.feature1.view.FirstScreen;
import ro.ovidiuconeac.androidasynchronousmvp.feature2.model.SecondModel;
import ro.ovidiuconeac.androidasynchronousmvp.feature2.view.SecondScreen;

/**
 * Created by ovidiu on 12/29/16.
 */

public final class SecondPresenter {

    private static SecondPresenter presenter;
    private static SecondScreen screen;

    private SecondModel model = new SecondModel();

    public static SecondPresenter getInstance(SecondScreen screen) {
        if (presenter == null) {
            presenter = new SecondPresenter();
        }
        SecondPresenter.screen = screen;
        return presenter;
    }

    public void requestName() {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
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
                return model.requestImage(screen.getContext());
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                screen.postImage(bitmap);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);;
    }
}
