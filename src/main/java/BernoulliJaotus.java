import java.util.Scanner;

public class BernoulliJaotus {

    public static String arvuta(double p) {

        double keskväärtus = p;
        double dispersioon = p * (1 - p);
        double standardhälve = Math.sqrt(dispersioon);

        return "Bernoulli jaotuse kohaselt on keskväärtus " + Math.round(keskväärtus * 100.0) / 100.0
                + ", dispersioon " + Math.round(dispersioon * 100.0) / 100.0 + " ja standardhälve "
                + Math.round(standardhälve * 100.0) / 100.0 + ".\n";
    }
}