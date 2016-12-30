package ro.ovidiuconeac.androidasynchronousmvp.common;

/**
 * Created by ovidiu on 12/29/16.
 */

public final class Util {

    public static void simulateNetworkLatency(int millis) {
        // Pause current thread
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
