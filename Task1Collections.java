import java.util.*;

/** Задание № 1. Методы Collections. */
public class Task1Collections {

    public static void main(String[] args) {
        int n = 20;
        Random random = new Random();

        // 1. Массив из N случайных чисел от 0 до 100
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(101);
        }
        System.out.println("1. Массив: " + Arrays.toString(array));

        // 2. Список на основе массива
        List<Integer> list = new ArrayList<>();
        for (int value : array) {
            list.add(value);
        }
        System.out.println("2. Список: " + list);

        // 3. Сортировка по возрастанию
        Collections.sort(list);
        System.out.println("3. По возрастанию: " + list);

        // 4. Сортировка в обратном порядке
        list.sort(Collections.reverseOrder());
        System.out.println("4. В обратном порядке: " + list);

        // 5. Перемешивание
        Collections.shuffle(list);
        System.out.println("5. Перемешанный: " + list);

        // 6. Циклический сдвиг на 1 элемент
        Collections.rotate(list, 1);
        System.out.println("6. После сдвига на 1: " + list);

        // 7. Только уникальные элементы (убираем повторы, порядок сохраняем).
        // Шаги 7 и 8 выполняются над копиями текущего списка, иначе после
        // шага 7 дубликатов в списке уже не осталось бы.
        List<Integer> unique = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println("7. Уникальные элементы: " + unique);

        // 8. Только дублирующиеся элементы (значения, встречающиеся более 1 раза)
        Set<Integer> duplicatesSet = new LinkedHashSet<>();
        for (Integer value : list) {
            if (Collections.frequency(list, value) > 1) {
                duplicatesSet.add(value);
            }
        }
        List<Integer> duplicates = new ArrayList<>(duplicatesSet);
        System.out.println("8. Дублирующиеся элементы: " + duplicates);

        // 9. Из списка получаем массив
        Integer[] resultArray = list.toArray(new Integer[0]);
        System.out.println("9. Массив из списка: " + Arrays.toString(resultArray));

        // 10. Количество вхождений каждого числа
        System.out.println("10. Количество вхождений:");
        for (Integer value : new TreeSet<>(list)) {
            System.out.println("   " + value + " -> " + Collections.frequency(list, value));
        }
    }
}
