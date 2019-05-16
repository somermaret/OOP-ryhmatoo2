public class BernoulliValem {

    public static String arvuta(double p, int n, int k) {

        double tõenäosus = Hüpergeomeetriline.kombinatsioonid(k, n) * Math.pow(p, k) * Math.pow((1 - p), (n - k));
        return "Igal katsel tõenäosusega " + p + " toimuva sündmuse puhul tõenäosus, et " + n + "-st katsest" +
                " toimub sündmus " + k + " katsel, on: " + Math.round(tõenäosus * 1000.0) / 1000.0 + "." + "\n";
    }

}