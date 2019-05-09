import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Peaklass extends Application {

    @Override
    public void start(Stage pealava) {
        BorderPane juur = new BorderPane();

        // tekstivälja loomine ja lisamine piiripaanile (üles)
        TextField tekst = new TextField();
        tekst.setText("Tere! Mina olen tõenäosusteooria valemite kalkulaator.");
        juur.setTop(tekst);


        Scene stseen = new Scene(juur, 500, 500);
        pealava.setTitle("Ülesanne 6");
        pealava.setScene(stseen);
        pealava.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
