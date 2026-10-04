import java.util.Iterator;

/** Проверка генератора: первые N простых чисел в прямом и обратном порядке. */
public class PrimesGeneratorTest {

    public static void main(String[] args) {
        int n = 15;
        PrimesGenerator generator = new PrimesGenerator(n);

        System.out.println("Первые " + n + " простых чисел (прямой порядок):");
        Iterator<Integer> forward = generator.iterator();
        while (forward.hasNext()) {
            System.out.print(forward.next() + " ");
        }
        System.out.println();

        System.out.println("Обратный порядок:");
        Iterator<Integer> backward = generator.reverseIterator();
        while (backward.hasNext()) {
            System.out.print(backward.next() + " ");
        }
        System.out.println();
    }
}
