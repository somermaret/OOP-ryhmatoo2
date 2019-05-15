import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class Multinoom implements Arvutatav {

    private int n;
    private int m;

    //Setterid:
    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }

    //Parameetriteta konstruktorid:
    public Multinoom() {
        this.n = 0;
        this.m = 0;
    }

    //Väljastame kasutajale näite tema sisestuse põhjal:
    @Override
    public String näide() {
        setM((int) Math.round(2 + Math.random() * 3));
        double[] tõenäosused = new double[m];
        int[] k = new int[m];
        int kSumma = 0;
        double pSumma = 0;
        for (int i = 0; i < m; i++) {
            k[i] = (int) Math.round(Math.random() * 7);
            kSumma += k[i];
            if (i != m - 1) {
                tõenäosused[i] = Math.random() * (1 - pSumma);
                pSumma += tõenäosused[i];
            }
        }
        tõenäosused[m - 1] = 1.0 - pSumma;
        setN(kSumma);
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
        StringBuilder väljund = new StringBuilder("Näide:\nTõenäosus, et ");
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
        väljund.append(", mille tõenäosused on vastavalt [");
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

    //Küsime kasutajalt vajalikud andmed ja väljastame soovitud tulemuse:
    @Override
    public String arvuta() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Sisesta m (katsel toimuvate võimalike sündmuste koguarv)");
        setM(scan.nextInt());
        double[] tõenäosused = new double[m];
        int[] k = new int[m];
        int kSumma = 0;
        double pSumma = 0;
        for (int i = 0; i < m; i++) {
            System.out.println("Sisesta k(" + (i + 1) + ") ehk mitu korda vastav sündmus toimuma peab");
            k[i] = scan.nextInt();
            kSumma += k[i];
            if (i != m - 1) {
                System.out.println("Sisesta p(" + (i + 1) + ") ehk vastava sündmuse toimumise tõenäosus");
                tõenäosused[i] = scan.nextDouble();
                pSumma += tõenäosused[i];
            }
        }
        tõenäosused[m - 1] = 1.0 - pSumma;
        setN(kSumma);
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
        väljund.append(", mille tõenäosused on vastavalt [");
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
