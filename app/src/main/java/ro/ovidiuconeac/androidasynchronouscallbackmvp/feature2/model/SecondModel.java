package ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.model;

import ro.ovidiuconeac.androidasynchronouscallbackmvp.common.Util;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.presentor.SecondPresenter;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.feature2.presentor.SecondPresenterImpl;

/**
 * Created by ovidiu on 12/29/16.
 */

public class SecondModel {

    private SecondPresenter presenter;

    public SecondModel(SecondPresenter presenter) {
        this.presenter = presenter;
    }

    public void requestName() {
        Util.simulateNetworkLatency(2000);
        presenter.postName("ovidiu");
    }

    public void requestAge() {
        Util.simulateNetworkLatency(3000);
        presenter.postAge(31);
    }

    public void requestImage() {
        presenter.postImage(null);
    }
}
