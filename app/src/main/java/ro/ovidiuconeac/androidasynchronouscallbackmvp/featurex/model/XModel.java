package ro.ovidiuconeac.androidasynchronouscallbackmvp.featurex.model;

import ro.ovidiuconeac.androidasynchronouscallbackmvp.featurex.presenter.XPresenter;

/**
 * Created by ovidiu on 12/29/16.
 */

public class XModel {

    private XPresenter presenter;

    public XModel(XPresenter presenter) {
        this.presenter = presenter;
    }

    public void requestAction1() {
        // Compute some data here
        presenter.postResult1("Response 1");
    }

    public void requestAction2() {
        // Compute some data here
        presenter.postResult2("Response 2");
    }

    public void requestAction3() {
        // Compute some data here
        presenter.postResult2("Response 3");
    }
}
