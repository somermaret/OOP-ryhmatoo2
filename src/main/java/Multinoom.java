import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Multinoom {

    //Küsime kasutajalt vajalikud andmed ja väljastame soovitud tulemuse:
    public static String arvuta(int m, int K, double p) {

        int n = 0;
        double[] tõenäosused = new double[m];
        int[] k = new int[m];
        int kSumma = 0;
        double pSumma = 0;

        for (int i = 0; i < m; i++) {
            k[i] = K;
            kSumma += k[i];

            if (i != m - 1) {
                tõenäosused[i] = p;
                pSumma += tõenäosused[i];
            }
        }

        tõenäosused[m - 1] = 1.0 - pSumma;
        n = kSumma;

        BigDecimal faktoriaalLugeja = new BigDecimal("1");
        for (int i = 2; i < n + 1; i++) {
            faktoriaalLugeja = faktoriaalLugeja.multiply(BigDecimal.valueOf(i));
        }
        BigDecimal faktoriaalNimetaja = new BigDecimal("1");
        for (int i = 0; i < m; i++) { //käib läbi kõik k-d
            for (int j = 2; j < k[i] + 1; j++) { //korrutab nimetajaga k faktoriaali
                faktoriaalNimetaja = faktoriaalNimetaja.multiply(BigDecimal.valueOf(j));
            }
        }
        double tõenäosus = faktoriaalLugeja.divide(faktoriaalNimetaja, 3, RoundingMode.HALF_UP).doubleValue();
        for (int i = 0; i < m; i++) {
            tõenäosus *= Math.pow(tõenäosused[i], k[i]);
        }

        StringBuilder väljund = new StringBuilder("Tõenäosus, et ");
        väljund.append(n);
        väljund.append(" sõltumatus katses sündmused C(1), C(2)");
        if (m == 3){
            väljund.append(", C(3)");
        }
        if (m > 3){
            väljund.append(", ..., C(");
            väljund.append(m);
            väljund.append(")");
        }
        väljund.append(", mille tõenäosused on vastavalt \n [");
        väljund.append(Math.round(tõenäosused[0] * 1000.0) / 1000.0);
        for (int i = 1; i < m; i++) {
            väljund.append(", ");
            väljund.append(Math.round(tõenäosused[i] * 1000.0) / 1000.0);
        }
        väljund.append("]\ntoimuvad vastavalt ");
        väljund.append(Arrays.toString(k));
        väljund.append(" korda, on: ");
        väljund.append(Math.round(tõenäosus * 100000.0) / 100000.0);

        return väljund.toString();
    }
}