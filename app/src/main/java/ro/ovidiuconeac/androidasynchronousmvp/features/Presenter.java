package ro.ovidiuconeac.androidasynchronousmvp.features;

import java.util.UUID;

/**
 * Created by ovidiu on 2/2/17.
 */

public interface Presenter {
    void setScreen(Screen screen);
    UUID getUuid();
}
