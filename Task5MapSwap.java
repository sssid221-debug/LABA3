import java.util.HashMap;
import java.util.Map;

/** Задание № 5. Обмен ключей и значений. */
public class Task5MapSwap {

    /**
     * Возвращает новую Map, в которой ключи и значения поменяны местами.
     * Исходная Map не изменяется.
     *
     * @throws IllegalArgumentException если в исходной Map есть повторяющиеся
     *         значения: они стали бы одинаковыми ключами, и часть данных потерялась бы.
     */
    public static <K, V> Map<V, K> swap(Map<K, V> map) {
        Map<V, K> result = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (result.containsKey(entry.getValue())) {
                throw new IllegalArgumentException(
                        "Повторяющееся значение: " + entry.getValue());
            }
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        Map<Integer, String> original = new HashMap<>();
        original.put(1, "one");
        original.put(2, "two");
        original.put(3, "three");

        System.out.println("Исходная Map: " + original);
        System.out.println("Результат:    " + swap(original));

        Map<String, String> bad = new HashMap<>();
        bad.put("a", "x");
        bad.put("b", "x");
        try {
            swap(bad);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка для повторяющихся значений: " + e.getMessage());
        }
    }
}
