package ro.ovidiuconeac.androidasynchronousmvp.features.feature1.model;

/**
 * Created by www.ovidiuconeac.ro on 3/26/17.
 */

public class Valid {

    private boolean value;

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Valid valid = (Valid) o;

        return value == valid.value;

    }

    @Override
    public int hashCode() {
        return (value ? 1 : 0);
    }

    @Override
    public String toString() {
        return "Valid{" +
                "value=" + value +
                '}';
    }
}
