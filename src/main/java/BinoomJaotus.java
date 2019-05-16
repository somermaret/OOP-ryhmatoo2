public class BinoomJaotus {

    public static String arvuta(double p, int n) {

        double keskväärtus = n * p;
        double dispersioon = (n * p) * (1 - p);
        double standardhälve = Math.sqrt(dispersioon);

        return "Binoomjaotuse kohaselt on keskväärtus " + Math.round(keskväärtus * 100.0) / 100.0
                + ", dispersioon " + Math.round(dispersioon * 100.0) / 100.0 + " ja standardhälve " +
                Math.round(standardhälve * 100.0) / 100.0 + ".\n";

    }
}