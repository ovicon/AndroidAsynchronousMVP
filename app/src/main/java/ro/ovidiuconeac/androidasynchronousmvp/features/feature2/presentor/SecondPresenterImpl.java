package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.presentor;

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
    private SecondView view;
    private SecondModel model;

    public SecondPresenterImpl(SecondView view) {
        this.uuid = UUID.randomUUID();
        this.view = view;
        this.model = new SecondModel(this);
    }

    @Override
    public void requestName() {
        Util.simulateNetworkLatency(2000);
        model.requestName();
    }

    @Override
    public void postName(Name name) {
        view.postName(name.toString());
    }

    @Override
    public void requestAge() {
        Util.simulateNetworkLatency(2000);
        model.requestAge();
    }

    @Override
    public void postAge(Age age) {
        view.postAge(age.getValue());
    }

    @Override
    public void requestImage() {
        Util.simulateNetworkLatency(2000);
        model.requestImage(view.getContext());
    }

    @Override
    public void postImage(Image image) {
        view.postImage(image.getBitmap());
    }

    @Override
    public void setView(Screen view) {
        this.view = (SecondView) view;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }
}
