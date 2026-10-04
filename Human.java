import java.util.Objects;

/** Задание № 3. Человек. Естественный порядок: фамилия, имя, возраст. */
public class Human implements Comparable<Human> {

    private final String firstName;
    private final String lastName;
    private final int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human other) {
        int result = lastName.compareTo(other.lastName);
        if (result != 0) {
            return result;
        }
        result = firstName.compareTo(other.firstName);
        if (result != 0) {
            return result;
        }
        return Integer.compare(age, other.age);
    }

    // equals и hashCode согласованы с compareTo (учитывают все три поля).
    // Они нужны HashSet и LinkedHashSet, чтобы определять дубликаты.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Human)) {
            return false;
        }
        Human human = (Human) o;
        return age == human.age
                && firstName.equals(human.firstName)
                && lastName.equals(human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + ", " + age;
    }
}
