package ro.ovidiuconeac.androidasynchronouscallbackmvp.featurex.view;

/**
 * Created by ovidiu on 12/29/16.
 */

public interface XView {
    void requestAction1();
    void postResult1(String result);
    void requestAction2();
    void postResult2(String result);
    void requestAction3();
    void postResult3(String result);
}
