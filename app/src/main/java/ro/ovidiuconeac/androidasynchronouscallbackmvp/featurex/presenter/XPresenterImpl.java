package ro.ovidiuconeac.androidasynchronouscallbackmvp.featurex.presenter;

import ro.ovidiuconeac.androidasynchronouscallbackmvp.featurex.model.XModel;
import ro.ovidiuconeac.androidasynchronouscallbackmvp.featurex.view.XView;

/**
 * Created by ovidiu on 12/29/16.
 */

public class XPresenterImpl implements XPresenter {

    private XView view;
    private XModel model;

    public XPresenterImpl(XView view) {
        this.view = view;
        this.model = new XModel(this);
    }

    @Override
    public void requestAction1() {
        model.requestAction1();
    }

    @Override
    public void postResult1(String result) {
        view.postResult1(result);
    }

    @Override
    public void requestAction2() {
        model.requestAction2();
    }

    @Override
    public void postResult2(String result) {
        view.postResult2(result);
    }

    @Override
    public void requestAction3() {
        model.requestAction3();
    }

    @Override
    public void postResult3(String result) {
        view.postResult3(result);
    }
}
