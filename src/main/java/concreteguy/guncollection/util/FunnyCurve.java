package concreteguy.guncollection.util;

public class FunnyCurve {

    public static double evaluate(double t) {
        double t2 = t * t;
        double t3 = t2 * t;
        return (1 - t) * (1 - t) * (1 - t) * 0 +
                3 * (1 - t) * (1 - t) * t * 0.6 -
                3 * (1 - t) * t2 * 0.33 +
                t3 * 1.49;
    }

}
