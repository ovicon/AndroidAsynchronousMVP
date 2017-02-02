package ro.ovidiuconeac.androidasynchronousmvp.cache;

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
 * A disadvantage of the caching class is that it
 * never deletes the unused presenters.
 *
 * A solution, e.g. a daemon, must be implemented
 * to remove the unused presenters.
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
