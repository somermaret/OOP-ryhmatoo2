public class GeomeetrilineJaotus {

    public static String arvuta(double p) {

        double keskväärtus = 1 / p;
        double dispersioon = (1 - p) / (p * p);
        double standardhälve = Math.sqrt(dispersioon);

        return "Geomeetrilise jaotuse kohaselt on keskväärtus " + Math.round(keskväärtus * 100.0) / 100.0 + ", dispersioon " +
                Math.round(dispersioon * 100.0) / 100.0 + " ja standardhälve " + Math.round(standardhälve * 100.0) / 100.0 + ".\n";
    }
}