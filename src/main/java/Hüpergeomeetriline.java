import java.util.Arrays;

public class Hüpergeomeetriline {

    //Kombinatsioonide valem:
    static long kombinatsioonid(int k, int n) {
        long lugeja = 1L;
        long nimetaja = 1L;
        if (k > n - k) {
            for (int i = k + 1; i < n + 1; i++) {
                lugeja *= i;
            }
            for (int i = 1; i < n - k + 1; i++) {
                nimetaja *= i;
            }
        } else {
            for (int i = n - k + 1; i < n + 1; i++) {
                lugeja *= i;
            }
            for (int i = 1; i < k + 1; i++) {
                nimetaja *= i;
            }
        }
        return lugeja / nimetaja;
    }

    //Küsime kasutajalt vajalikud andmed ja väljastame soovitud tulemuse:
    public static String arvuta(int m, int N, int K) {

        int suurN = 0;
        int väikeN = 0;
        int[] klassid = new int[m];
        int[] k = new int[m];
        int kSumma = 0;
        int nSumma = 0;
        long lugeja = 1;
        for (int i = 0; i < m; i++) {
            klassid[i] = N;
            k[i] = K;
            kSumma += k[i];
            nSumma += klassid[i];
            lugeja *= kombinatsioonid(k[i], klassid[i]);
        }
        suurN = nSumma;
        väikeN = kSumma;

        long nimetaja = kombinatsioonid(väikeN, suurN);
        double tõenäosus = (double) lugeja / (double) nimetaja;

        return "Tõenäosus, et " + suurN + "-st objektist, mis on jaotatud " + m + " klassi järgmiselt:\n"
                + Arrays.toString(klassid) + "\n" +
                väikeN + " objekti valimisel saadakse klassidest vastavalt\n" + Arrays.toString(k) + "\nobjekti, on: "
                + Math.round(tõenäosus * 1000.0) / 1000.0 + "." + "\n";
    }
}