package interfaces;

import java.util.Random;

public interface RandomNumberGeneratorDouble {

    static double randomBetween(double start, double end) {

        double random = new Random().nextDouble();
        return start + (random * (end - start));
    }
}
