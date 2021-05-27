package interfaces;

import java.util.Random;

public interface RandomNumberGeneratorInt {

    static int randomBetween(int start, int end) {
        Random random = new Random();

        int a1 = random.nextInt(end - start + 1);
        return a1 + start;
    }
}
