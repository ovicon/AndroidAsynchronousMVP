package ro.ovidiuconeac.androidasynchronousmvp.features.feature2.model;

/**
 * Created by www.ovidiuconeac.ro on 3/24/17.
 */

public class Age {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Age age1 = (Age) o;

        return age == age1.age;

    }

    @Override
    public int hashCode() {
        return age;
    }

    @Override
    public String toString() {
        return "Age{" +
                "age=" + age +
                '}';
    }
}
