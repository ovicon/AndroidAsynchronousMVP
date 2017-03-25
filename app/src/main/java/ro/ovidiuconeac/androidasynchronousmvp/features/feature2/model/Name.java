package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model;

/**
 * Created by www.ovidiuconeac.ro on 3/24/17.
 */

public class Name {

    public String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name1 = (Name) o;

        return value != null ? value.equals(name1.value) : name1.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Name{" +
                "value='" + value + '\'' +
                '}';
    }
}
