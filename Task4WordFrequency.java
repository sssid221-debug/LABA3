import java.util.HashMap;
import java.util.Map;

/** Задание № 4. Частота слов (без учёта регистра). */
public class Task4WordFrequency {

    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog. "
                + "The dog was not that lazy, and the Fox was quick!";

        Map<String, Integer> frequency = countWords(text);

        System.out.println("Различных слов: " + frequency.size());
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> frequency = new HashMap<>();
        // Приводим к нижнему регистру и делим по всему, что не является буквой или апострофом
        String[] words = text.toLowerCase().split("[^a-z']+");
        for (String word : words) {
            if (!word.isEmpty()) {
                frequency.merge(word, 1, Integer::sum);
            }
        }
        return frequency;
    }
}
