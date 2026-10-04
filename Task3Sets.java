import java.util.*;

/** Задание № 3. Множества и сравнение объектов. */
public class Task3Sets {

    public static void main(String[] args) {
        // 1. Список объектов Human (есть полный дубликат, однофамильцы и ровесники)
        List<Human> humans = new ArrayList<>(List.of(
                new Human("Ivan", "Ivanov", 20),
                new Human("Alexey", "Ivanov", 25),
                new Human("Anna", "Petrova", 22),
                new Human("Petr", "Sidorov", 25),
                new Human("Ivan", "Ivanov", 20)   // полный дубликат первого
        ));
        System.out.println("Исходный список: " + humans + "\n");

        // 2. HashSet
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet:       " + hashSet);

        // 3. LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // 4. TreeSet (естественный порядок, Comparable)
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet:       " + treeSet);

        // 5. TreeSet с компаратором по фамилии
        Set<Human> byLastName = new TreeSet<>(new HumanComparatorByLastName());
        byLastName.addAll(humans);
        System.out.println("TreeSet (по фамилии): " + byLastName);

        // 6. TreeSet с анонимным компаратором по возрасту
        Set<Human> byAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human a, Human b) {
                return Integer.compare(a.getAge(), b.getAge());
            }
        });
        byAge.addAll(humans);
        System.out.println("TreeSet (по возрасту): " + byAge);
    }

    /*
     * 7. Объяснение различий в выводах:
     *
     * HashSet — порядок элементов не гарантируется: он зависит от hashCode()
     * и размера внутренней таблицы. Дубликаты определяются через hashCode()
     * и equals(), поэтому полный дубликат "Ivanov Ivan, 20" добавлен один раз.
     *
     * LinkedHashSet — тоже убирает дубликаты по equals()/hashCode(), но
     * сохраняет порядок добавления (первое вхождение остаётся на своём месте).
     *
     * TreeSet (Comparable) — элементы отсортированы по compareTo():
     * фамилия, затем имя, затем возраст. Дубликатом считается элемент,
     * для которого compareTo() вернул 0, то есть совпали все три поля.
     *
     * TreeSet с HumanComparatorByLastName — порядок по фамилии, а два
     * человека с одинаковой фамилией считаются "равными". Поэтому из двух
     * Ivanov в множестве остаётся только первый добавленный, второй теряется,
     * хотя имена и возраст у них разные.
     *
     * TreeSet с компаратором по возрасту — порядок по возрасту, а люди
     * одного возраста считаются "равными": из двух 25-летних остаётся
     * только первый добавленный.
     *
     * Вывод: в TreeSet понятие "одинаковый элемент" задаёт компаратор
     * (compare == 0), а в HashSet/LinkedHashSet — equals() и hashCode().
     */
}
