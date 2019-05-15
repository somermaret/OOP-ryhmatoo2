import java.util.Scanner;

public class GeomeetrilineJaotus implements Arvutatav {

    private double p;

    //Setter:
    public void setP(double p) {
        this.p = p;
    }

    //Parameetriteta konstruktor:
    public GeomeetrilineJaotus() {

        this.p = 0.0;
    }

    //Väljastame kasutajale näite tema sisestuse põhjal:
    @Override
    public String näide() {
        setP(Math.random());
        double keskväärtus = 1 / p;
        double dispersioon = (1 - p) / (p * p);
        double standardhälve = Math.sqrt(dispersioon);

        return "Näide:\nKui juhuslik suurus X on geomeetrilise jaotusega parameetriga p=" +
                Math.round(p * 100.0) / 100.0 + ", siis on keskväärtus " +
                Math.round(keskväärtus * 100.0) / 100.0 + ", dispersioon " + Math.round(dispersioon * 100.0) / 100.0 +
                " ja standardhälve " + Math.round(standardhälve * 100.0) / 100.0 + ".\n";
    }

    //Küsime kasutajalt vajalikud andmed ja väljastame soovitud tulemuse:
    @Override
    public String arvuta() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Sisesta p (vaadeldava sündmuse toimumise tõenäosus, mis on igal katsel sama)");
        setP(scan.nextDouble());

        double keskväärtus = 1 / p;
        double dispersioon = (1 - p) / (p * p);
        double standardhälve = Math.sqrt(dispersioon);

        return "Geomeetrilise jaotuse kohaselt on keskväärtus " + Math.round(keskväärtus * 100.0) / 100.0 + ", dispersioon " +
                Math.round(dispersioon * 100.0) / 100.0 + " ja standardhälve " + Math.round(standardhälve * 100.0) / 100.0 + ".\n";
    }
}