package ro.ovidiuconeac.androidasynchronousmvp.featurex.presenter;

import ro.ovidiuconeac.androidasynchronousmvp.featurex.model.XModel;
import ro.ovidiuconeac.androidasynchronousmvp.featurex.view.XView;

/**
 * Created by ovidiu on 12/29/16.
 */

public class XPresenterImpl implements XPresenter {

    private XView view;
    private XModel model;

    public XPresenterImpl(XView view) {
        this.view = view;
        this.model = new XModel();
    }

    @Override
    public void requestAction1() {
        view.postResult1(model.requestAction1());
    }

    @Override
    public void requestAction2() {
        view.postResult2(model.requestAction2());
    }

    @Override
    public void requestAction3() {
        view.postResult2(model.requestAction3());
        model.requestAction3();
    }
}
