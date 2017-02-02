package ro.ovidiuconeac.androidasynchronousmvp.cache;

import android.preference.Preference;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import ro.ovidiuconeac.androidasynchronousmvp.features.Presenter;

/**
 * Created by ovidiu on 2/2/17.
 *
 * The purpose of this class is to provide a caching
 * mechanism to persist presenters during activity
 * orientation change.
 *
 */
public class Cache implements Serializable {

    private static Cache ourInstance;
    private Map<UUID, Presenter> cache;

    public static Cache getInstance() {
        if (ourInstance == null) {
            ourInstance = new Cache();
        }
        return ourInstance;
    }

    private Cache() {
        cache = new HashMap<>();
    }

    public Map<UUID, Presenter> getCache() {
        return cache;
    }
}
