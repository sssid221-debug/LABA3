import java.util.Comparator;

/** Сравнивает людей только по фамилии. */
public class HumanComparatorByLastName implements Comparator<Human> {

    @Override
    public int compare(Human a, Human b) {
        return a.getLastName().compareTo(b.getLastName());
    }
}
