import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int Iterable() {
        int diff = max - min;
        int result;
        random = new Random();
        if (diff > 0) {
            result = random.nextInt(diff + 1) + min;
        } else {
            throw new IllegalStateException("Максимальное число меньше минимального");
        }
        return result;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return Iterable();
            }
        };
    }

    //...
}