package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model;

/**
 * Created by www.ovidiuconeac.ro on 3/24/17.
 */

public class Age {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Age age1 = (Age) o;

        return value == age1.value;

    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "Age{" +
                "value=" + value +
                '}';
    }
}
