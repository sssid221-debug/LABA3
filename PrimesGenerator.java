import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/** Задание № 2. Генератор первых N простых чисел. */
public class PrimesGenerator implements Iterable<Integer> {

    private final List<Integer> primes = new ArrayList<>();

    public PrimesGenerator(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N должно быть неотрицательным");
        }
        int candidate = 2;
        while (primes.size() < n) {
            if (isPrime(candidate)) {
                primes.add(candidate);
            }
            candidate++;
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int d = 2; (long) d * d <= number; d++) {
            if (number % d == 0) {
                return false;
            }
        }
        return true;
    }

    /** Перебор в прямом порядке. */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < primes.size();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return primes.get(index++);
            }
        };
    }

    /** Перебор в обратном порядке. */
    public Iterator<Integer> reverseIterator() {
        return new Iterator<>() {
            private int index = primes.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return primes.get(index--);
            }
        };
    }
}
