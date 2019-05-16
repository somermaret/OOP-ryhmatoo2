import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;


public class Peaklass extends Application {

    @Override
    public void start(Stage pealava) {

        //////////////////////////////////////////////////////////////////////////////////////

        StackPane juur = new StackPane();

        Scene stseen = new Scene(juur, 1460, 580);

        //////////////////////////////////////////////////////////////////////////////////////

        //CSS + fondid
        File f = new File("styles.css");
        stseen.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        stseen.getStylesheets().add("http://fonts.googleapis.com/css?family=Overpass:400,700");
        stseen.getStylesheets().add("http://fonts.googleapis.com/css?family=Karla:400,700");

        //////////////////////////////////////////////////////////////////////////////////////

        // #1 - Tekstiväli

        Text tekst = new Text("Tõenäosusteooria valemite kalkulaator");

        StackPane.setAlignment(tekst, Pos.TOP_CENTER);
        StackPane.setMargin(tekst, new Insets(30, 0, 0, 0));
        tekst.setId("tiitel");

        //Animatsioon (fade in) tiitlile
        FadeTransition ft = new FadeTransition(Duration.millis(3000), tekst);
        ft.setFromValue(0.0); ft.setToValue(1.0); ft.setCycleCount(1); ft.setAutoReverse(true); ft.play();

        juur.getChildren().add(tekst);

        //////////////////////////////////////////////////////////////////////////////////////

        // #2 Sissejuhatav lause

        Text valik = new Text("Valige valem:");

        StackPane.setAlignment(valik, Pos.TOP_LEFT);
        StackPane.setMargin(valik, new Insets(130, 0, 0, 64));
        valik.setId("valik");

        juur.getChildren().add(valik);

        //////////////////////////////////////////////////////////////////////////////////////

        // #3 Nupud valemite nimedega

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.TOP_LEFT); grid.setMinSize(400, 200);
        grid.setPadding(new Insets(180, 10, 10, 62));
        grid.setVgap(5);  grid.setHgap(20);

        Button bernoulli = new Button("Bernoulli valem");
        bernoulli.setPrefWidth(170);
        grid.add(bernoulli, 0, 0);

        Button multinoom = new Button("Multinoom");
        multinoom.setPrefWidth(170);
        grid.add(multinoom, 1, 0);

        Button hyper = new Button("Hüpergeomeetriline");
        hyper.setPrefWidth(170);
        grid.add(hyper, 2, 0);

        Button bernoulliJaotus = new Button("Bernoulli jaotus");
        bernoulliJaotus.setPrefWidth(170);
        grid.add(bernoulliJaotus, 3, 0);

        Button binoom = new Button("Binoomjaotus");
        binoom.setPrefWidth(170);
        grid.add(binoom, 4, 0);

        Button geo = new Button("Geomeetriline jaotus");
        geo.setPrefWidth(170);
        grid.add(geo, 5, 0);

        Button poisson = new Button("Poissoni jaotus");
        poisson.setPrefWidth(170);
        grid.add(poisson, 6, 0);

        juur.getChildren().add(grid);

        //////////////////////////////////////////////////////////////////////////////////////

        // #4 Väljad kasutajaga suhtlemiseks

        ///////////////////////////////////
            // Bernoulli valem //

        //p (vaadeldava sündmuse toimumise tõenäosus, mis on igal katsel sama)
        final TextField pBernValem = new TextField();
        pBernValem.setPromptText("Sisestage p");
        pBernValem.setPrefWidth(10);
        GridPane.setConstraints(pBernValem, 0, 1);

        //n (kõikide katsete koguarv)
        final TextField nBernValem = new TextField();
        nBernValem.setPromptText("Sisestage n");
        nBernValem.setPrefWidth(10);
        GridPane.setConstraints(nBernValem, 0, 1);

        //k (mitmel korral sündmus toimub)
        final TextField kBernValem = new TextField();
        kBernValem.setPromptText("Sisestage k");
        kBernValem.setPrefWidth(10);
        GridPane.setConstraints(kBernValem, 0, 1);

        ///////////////////////////////////
            // Multinoom //

        //m (katsel toimuvate võimalike sündmuste koguarv)
        final TextField mMultinoom = new TextField();
        mMultinoom.setPromptText("Sisestage m");
        mMultinoom.setPrefWidth(10);
        GridPane.setConstraints(mMultinoom, 1, 1);

        //k ehk mitu korda vastav sündmus toimuma peab
        final TextField kMultinoom = new TextField();
        kMultinoom.setPromptText("Sisestage k");
        kMultinoom.setPrefWidth(10);
        GridPane.setConstraints(kMultinoom, 1, 1);

        //p ehk vastava sündmuse toimumise tõenäosus
        final TextField pMultinoom = new TextField();
        pMultinoom.setPromptText("Sisestage p");
        pMultinoom.setPrefWidth(10);
        GridPane.setConstraints(pMultinoom, 1, 1);

        ///////////////////////////////////
            // Hüpergeomeetriline //

        //m (klasside koguarv)
        final TextField mHyper = new TextField();
        mHyper.setPromptText("Sisestage m");
        mHyper.setPrefWidth(10);
        GridPane.setConstraints(mHyper, 2, 1);

        //N ehk mitu objekti vastavasse klassi kuulub
        final TextField nHyper = new TextField();
        nHyper.setPromptText("Sisestage N");
        nHyper.setPrefWidth(10);
        GridPane.setConstraints(nHyper, 2, 1);

        //k ehk mitu objekti sellest klassist valitakse
        final TextField kHyper = new TextField();
        kHyper.setPromptText("Sisestage k");
        kHyper.setPrefWidth(10);
        GridPane.setConstraints(kHyper, 2, 1);

        ///////////////////////////////////
            // Bernoulli jaotus //

        //p (vaadeldava sündmuse toimumise tõenäosus, mis on igal katsel sama)
        final TextField pBernJ = new TextField();
        pBernJ.setPromptText("Sisestage p");
        pBernJ.setPrefWidth(10);
        GridPane.setConstraints(pBernJ, 3, 1);

        ///////////////////////////////////
            // Binoomjaotus //

        //p (vaadeldava sündmuse toimumise tõenäosus, mis on igal katsel sama)
        final TextField pBin = new TextField();
        pBin.setPromptText("Sisestage p");
        pBin.setPrefWidth(10);
        GridPane.setConstraints(pBin, 4, 1);

        //n (kõikide katsete koguarv)
        final TextField nBin = new TextField();
        nBin.setPromptText("Sisestage n");
        nBin.setPrefWidth(10);
        GridPane.setConstraints(nBin, 4, 1);

        ///////////////////////////////////
            // Geomeetriline jaotus //

        //p (vaadeldava sündmuse toimumise tõenäosus, mis on igal katsel sama)
        final TextField pGeo = new TextField();
        pGeo.setPromptText("Sisestage p");
        pGeo.setPrefWidth(10);
        GridPane.setConstraints(pGeo, 5, 1);

        ///////////////////////////////////
            // Poissoni jaotus //

        //lambda (Poissoni jaotuse parameeter)
        final TextField L = new TextField();
        L.setPromptText("Sisestage lambda");
        L.setPrefWidth(10);
        GridPane.setConstraints(L, 6, 1);

        //Nupud
        String next = "Edasi";
        String compute = "Arvuta!";

        Button edasi = new Button(next);
        edasi.setId("edasi");
        GridPane.setConstraints(edasi, 0, 2);

        Button edasi0 = new Button(next);
        edasi0.setId("edasi");
        GridPane.setConstraints(edasi0, 0, 2);

        Button edasi2 = new Button(next);
        edasi2.setId("edasi");
        GridPane.setConstraints(edasi2, 1, 2);

        Button edasi00 = new Button(next);
        edasi00.setId("edasi");
        GridPane.setConstraints(edasi00, 1, 2);

        Button edasi3 = new Button(next);
        edasi3.setId("edasi");
        GridPane.setConstraints(edasi3, 2, 2);

        Button edasi000 = new Button(next);
        edasi000.setId("edasi");
        GridPane.setConstraints(edasi000, 2, 2);

        Button edasi4 = new Button(next);
        edasi4.setId("edasi");
        GridPane.setConstraints(edasi4, 4, 2);

        Button arvuta = new Button(compute);
        arvuta.setId("arvuta");
        GridPane.setConstraints(arvuta, 0, 2);

        Button arvuta2 = new Button(compute);
        arvuta2.setId("arvuta");
        GridPane.setConstraints(arvuta2, 1, 2);

        Button arvuta3 = new Button(compute);
        arvuta3.setId("arvuta");
        GridPane.setConstraints(arvuta3, 2, 2);

        Button arvuta4 = new Button(compute);
        arvuta4.setId("arvuta");
        GridPane.setConstraints(arvuta4, 3, 2);

        Button arvuta5 = new Button(compute);
        arvuta5.setId("arvuta");
        GridPane.setConstraints(arvuta5, 4, 2);

        Button arvuta6 = new Button(compute);
        arvuta6.setId("arvuta");
        GridPane.setConstraints(arvuta6, 5, 2);

        Button arvuta7 = new Button(compute);
        arvuta7.setId("arvuta");
        GridPane.setConstraints(arvuta7, 6, 2);

        //////////////////////////////////////////////////////////////////////////////////////

        // #5 Dünaamilised nupud ja väljad hakkavad sisestatud infot töötlema

        //////////////////////////////////////////////////////////////////////////////////////

        Button tühjenda = new Button("Tühjenda");
        StackPane.setAlignment(tühjenda, Pos.BOTTOM_CENTER);
        StackPane.setMargin(tühjenda, new Insets(0, 0, 40, 0));
        tühjenda.setId("tühjenda");

        //Bernoulli valem
        EventHandler<javafx.scene.input.MouseEvent> bernoulliValHandler1 =
                (MouseEvent e) -> {
                    grid.getChildren().remove(mMultinoom);
                    grid.getChildren().remove(edasi2);
                    grid.getChildren().remove(kMultinoom);
                    grid.getChildren().remove(edasi00);
                    grid.getChildren().remove(edasi000);
                    grid.getChildren().remove(edasi3);
                    grid.getChildren().remove(edasi4);
                    grid.getChildren().remove(pMultinoom);
                    grid.getChildren().remove(arvuta2);
                    grid.getChildren().remove(pBernJ);
                    grid.getChildren().remove(mHyper);
                    grid.getChildren().remove(nHyper);
                    grid.getChildren().remove(kHyper);
                    grid.getChildren().remove(pBin);
                    grid.getChildren().remove(nBin);
                    grid.getChildren().remove(pGeo);
                    grid.getChildren().remove(L);
                    grid.getChildren().remove(arvuta3);
                    grid.getChildren().remove(arvuta4);
                    grid.getChildren().remove(arvuta5);
                    grid.getChildren().remove(arvuta6);
                    grid.getChildren().remove(arvuta7);

                    grid.getChildren().add(pBernValem);
                    grid.getChildren().add(edasi);
                };
        EventHandler<javafx.scene.input.MouseEvent> bernoulliValHandler2 =
                (MouseEvent e) -> {
                    grid.getChildren().add(nBernValem);
                    grid.getChildren().add(edasi0);
                };
        EventHandler<javafx.scene.input.MouseEvent> bernoulliValHandler3 =
                (MouseEvent e) -> {
                    grid.getChildren().add(kBernValem);
                    grid.getChildren().add(arvuta);
                };

        bernoulli.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, bernoulliValHandler1);
        edasi.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, bernoulliValHandler2);
        edasi0.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, bernoulliValHandler3);

        arvuta.setOnAction(event -> {

            Text berniVastus = new Text(BernoulliValem.arvuta(Double.parseDouble(pBernValem.getText()),
                    Integer.parseInt(nBernValem.getText()), Integer.parseInt(kBernValem.getText())));

            StackPane.setAlignment(berniVastus, Pos.BOTTOM_CENTER);
            StackPane.setMargin(berniVastus, new Insets(0, 0, 140, 0));
            berniVastus.setId("vastus");
            juur.getChildren().add(berniVastus);
            juur.getChildren().add(tühjenda);

            tühjenda.setOnAction(event2 -> {
                juur.getChildren().remove(tühjenda);
                juur.getChildren().remove(berniVastus);
                grid.getChildren().remove(kBernValem);
                grid.getChildren().remove(arvuta);
                grid.getChildren().remove(nBernValem);
                grid.getChildren().remove(edasi0);
                grid.getChildren().remove(pBernValem);
                grid.getChildren().remove(edasi);
            });
        });

        //////////////////////////////////////////////////////////////////////////////////////

        //Multinoom
        EventHandler<javafx.scene.input.MouseEvent> multinoomHandler =
                (MouseEvent e) -> {
                    grid.getChildren().remove(pBernValem);
                    grid.getChildren().remove(edasi);
                    grid.getChildren().remove(nBernValem);
                    grid.getChildren().remove(edasi0);
                    grid.getChildren().remove(edasi000);
                    grid.getChildren().remove(edasi3);
                    grid.getChildren().remove(edasi4);
                    grid.getChildren().remove(kBernValem);
                    grid.getChildren().remove(arvuta);
                    grid.getChildren().remove(pBernJ);
                    grid.getChildren().remove(mHyper);
                    grid.getChildren().remove(nHyper);
                    grid.getChildren().remove(kHyper);
                    grid.getChildren().remove(pBin);
                    grid.getChildren().remove(nBin);
                    grid.getChildren().remove(pGeo);
                    grid.getChildren().remove(L);
                    grid.getChildren().remove(arvuta3);
                    grid.getChildren().remove(arvuta4);
                    grid.getChildren().remove(arvuta5);
                    grid.getChildren().remove(arvuta6);
                    grid.getChildren().remove(arvuta7);

                    grid.getChildren().add(mMultinoom);
                    grid.getChildren().add(edasi2);
                };
        EventHandler<javafx.scene.input.MouseEvent> multinoomHandler2 =
                (MouseEvent e) -> {
                    grid.getChildren().add(kMultinoom);
                    grid.getChildren().add(edasi00);
                };
        EventHandler<javafx.scene.input.MouseEvent> multinoomHandler3 =
                (MouseEvent e) -> {
                    grid.getChildren().add(pMultinoom);
                    grid.getChildren().add(arvuta2);
                };

        multinoom.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, multinoomHandler);
        edasi2.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, multinoomHandler2);
        edasi00.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, multinoomHandler3);

        arvuta2.setOnAction(event -> {

            Text multinoomVastus = new Text(Multinoom.arvuta(Integer.parseInt(mMultinoom.getText()),
                    Integer.parseInt(kMultinoom.getText()), Double.parseDouble(pMultinoom.getText())));

            StackPane.setAlignment(multinoomVastus, Pos.BOTTOM_CENTER);
            StackPane.setMargin(multinoomVastus, new Insets(0, 0, 140, 0));
            multinoomVastus.setId("vastus");
            juur.getChildren().add(multinoomVastus);
            juur.getChildren().add(tühjenda);

            tühjenda.setOnAction(event2 -> {
                juur.getChildren().remove(tühjenda);
                juur.getChildren().remove(multinoomVastus);
                grid.getChildren().remove(pMultinoom);
                grid.getChildren().remove(arvuta2);
                grid.getChildren().remove(kMultinoom);
                grid.getChildren().remove(edasi00);
                grid.getChildren().remove(mMultinoom);
                grid.getChildren().remove(edasi2);
            });
        });

        //////////////////////////////////////////////////////////////////////////////////////


        //Hüpergeomeetriline
        EventHandler<javafx.scene.input.MouseEvent> hyperHandler =
                e -> {
                    grid.getChildren().remove(pBernValem);
                    grid.getChildren().remove(edasi);
                    grid.getChildren().remove(nBernValem);
                    grid.getChildren().remove(edasi0);
                    grid.getChildren().remove(kBernValem);
                    grid.getChildren().remove(arvuta);
                    grid.getChildren().remove(mMultinoom);
                    grid.getChildren().remove(edasi2);
                    grid.getChildren().remove(edasi4);
                    grid.getChildren().remove(kMultinoom);
                    grid.getChildren().remove(edasi00);
                    grid.getChildren().remove(pMultinoom);
                    grid.getChildren().remove(arvuta2);
                    grid.getChildren().remove(pBernJ);
                    grid.getChildren().remove(pBin);
                    grid.getChildren().remove(nBin);
                    grid.getChildren().remove(pGeo);
                    grid.getChildren().remove(L);
                    grid.getChildren().remove(arvuta4);
                    grid.getChildren().remove(arvuta5);
                    grid.getChildren().remove(arvuta6);
                    grid.getChildren().remove(arvuta7);

                    grid.getChildren().add(mHyper);
                    grid.getChildren().add(edasi3);
                };
        EventHandler<javafx.scene.input.MouseEvent> hyperHandler2 =
                (MouseEvent e) -> {
                    grid.getChildren().add(nHyper);
                    grid.getChildren().add(edasi000);
                };
        EventHandler<javafx.scene.input.MouseEvent> hyperHandler3 =
                (MouseEvent e) -> {
                    grid.getChildren().add(kHyper);
                    grid.getChildren().add(arvuta3);
                };

        hyper.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, hyperHandler);
        edasi3.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, hyperHandler2);
        edasi000.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, hyperHandler3);

        arvuta3.setOnAction(event -> {

            Text hyperVastus = new Text(Hüpergeomeetriline.arvuta(Integer.parseInt(mHyper.getText()),
                    Integer.parseInt(nHyper.getText()), Integer.parseInt(kHyper.getText())));

            StackPane.setAlignment(hyperVastus, Pos.BOTTOM_CENTER);
            StackPane.setMargin(hyperVastus, new Insets(0, 0, 90, 0));
            hyperVastus.setId("vastus");
            juur.getChildren().add(hyperVastus);
            juur.getChildren().add(tühjenda);

            tühjenda.setOnAction(event2 -> {
                juur.getChildren().remove(tühjenda);
                juur.getChildren().remove(hyperVastus);
                grid.getChildren().remove(kHyper);
                grid.getChildren().remove(arvuta3);
                grid.getChildren().remove(nHyper);
                grid.getChildren().remove(edasi000);
                grid.getChildren().remove(mHyper);
                grid.getChildren().remove(edasi3);
            });
        });

        //////////////////////////////////////////////////////////////////////////////////////

        //Bernoulli jaotus
        EventHandler<javafx.scene.input.MouseEvent> bernoulliHandler =
                e -> {
                    grid.getChildren().remove(pBernValem);
                    grid.getChildren().remove(edasi);
                    grid.getChildren().remove(nBernValem);
                    grid.getChildren().remove(edasi0);
                    grid.getChildren().remove(kBernValem);
                    grid.getChildren().remove(arvuta);
                    grid.getChildren().remove(mMultinoom);
                    grid.getChildren().remove(edasi2);
                    grid.getChildren().remove(edasi3);
                    grid.getChildren().remove(edasi4);
                    grid.getChildren().remove(kMultinoom);
                    grid.getChildren().remove(edasi00);
                    grid.getChildren().remove(edasi000);
                    grid.getChildren().remove(pMultinoom);
                    grid.getChildren().remove(arvuta2);
                    grid.getChildren().remove(mHyper);
                    grid.getChildren().remove(nHyper);
                    grid.getChildren().remove(kHyper);
                    grid.getChildren().remove(pBin);
                    grid.getChildren().remove(nBin);
                    grid.getChildren().remove(pGeo);
                    grid.getChildren().remove(L);
                    grid.getChildren().remove(arvuta3);
                    grid.getChildren().remove(arvuta5);
                    grid.getChildren().remove(arvuta6);
                    grid.getChildren().remove(arvuta7);

                    grid.getChildren().add(pBernJ);
                    grid.getChildren().add(arvuta4);
                };

        bernoulliJaotus.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, bernoulliHandler);

        arvuta4.setOnAction(event -> {

            Text bernJVastus = new Text(BernoulliJaotus.arvuta(Double.parseDouble(pBernJ.getText())));

            StackPane.setAlignment(bernJVastus, Pos.TOP_RIGHT);
            StackPane.setMargin(bernJVastus, new Insets(360, 180, 0, 0));
            bernJVastus.setId("vastus");
            juur.getChildren().add(bernJVastus);
            juur.getChildren().add(tühjenda);

            tühjenda.setOnAction(event2 -> {
                juur.getChildren().remove(tühjenda);
                juur.getChildren().remove(bernJVastus);
                grid.getChildren().remove(pBernJ);
                grid.getChildren().remove(arvuta4);
            });
        });

        //////////////////////////////////////////////////////////////////////////////////////

        //Binoomjaotus
        EventHandler<javafx.scene.input.MouseEvent> binoomHandler =
                e -> {
                    grid.getChildren().remove(pBernValem);
                    grid.getChildren().remove(edasi);
                    grid.getChildren().remove(nBernValem);
                    grid.getChildren().remove(edasi0);
                    grid.getChildren().remove(kBernValem);
                    grid.getChildren().remove(arvuta);
                    grid.getChildren().remove(mMultinoom);
                    grid.getChildren().remove(edasi2);
                    grid.getChildren().remove(edasi3);
                    grid.getChildren().remove(kMultinoom);
                    grid.getChildren().remove(edasi00);
                    grid.getChildren().remove(edasi000);
                    grid.getChildren().remove(pMultinoom);
                    grid.getChildren().remove(arvuta2);
                    grid.getChildren().remove(pBernJ);
                    grid.getChildren().remove(mHyper);
                    grid.getChildren().remove(nHyper);
                    grid.getChildren().remove(kHyper);
                    grid.getChildren().remove(pGeo);
                    grid.getChildren().remove(L);
                    grid.getChildren().remove(arvuta2);
                    grid.getChildren().remove(arvuta3);
                    grid.getChildren().remove(arvuta4);
                    grid.getChildren().remove(arvuta6);
                    grid.getChildren().remove(arvuta7);

                    grid.getChildren().add(pBin);
                    grid.getChildren().add(edasi4);
                };
        EventHandler<javafx.scene.input.MouseEvent> binoomHandler2 =
                (MouseEvent e) -> {
                    grid.getChildren().add(nBin);
                    grid.getChildren().add(arvuta5);
                };

        binoom.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, binoomHandler);
        edasi4.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, binoomHandler2);

        arvuta5.setOnAction(event -> {

            Text binVastus = new Text(BinoomJaotus.arvuta(Double.parseDouble(pBin.getText()),
                    Integer.parseInt(nBin.getText())));

            StackPane.setAlignment(binVastus, Pos.TOP_RIGHT);
            StackPane.setMargin(binVastus, new Insets(360, 180, 0, 0));
            binVastus.setId("vastus");
            juur.getChildren().add(binVastus);
            juur.getChildren().add(tühjenda);

            tühjenda.setOnAction(event2 -> {
                juur.getChildren().remove(tühjenda);
                juur.getChildren().remove(binVastus);
                grid.getChildren().remove(nBin);
                grid.getChildren().remove(arvuta5);
                grid.getChildren().remove(pBin);
                grid.getChildren().remove(edasi4);
            });
        });

        //////////////////////////////////////////////////////////////////////////////////////

        //Geomeetriline jaotus
        EventHandler<javafx.scene.input.MouseEvent> geoHandler =
                e -> {
                    grid.getChildren().remove(pBernValem);
                    grid.getChildren().remove(edasi);
                    grid.getChildren().remove(nBernValem);
                    grid.getChildren().remove(edasi0);
                    grid.getChildren().remove(kBernValem);
                    grid.getChildren().remove(arvuta);
                    grid.getChildren().remove(mMultinoom);
                    grid.getChildren().remove(edasi2);
                    grid.getChildren().remove(edasi3);
                    grid.getChildren().remove(edasi4);
                    grid.getChildren().remove(kMultinoom);
                    grid.getChildren().remove(edasi00);
                    grid.getChildren().remove(edasi000);
                    grid.getChildren().remove(pMultinoom);
                    grid.getChildren().remove(arvuta2);
                    grid.getChildren().remove(pBernJ);
                    grid.getChildren().remove(mHyper);
                    grid.getChildren().remove(nHyper);
                    grid.getChildren().remove(kHyper);
                    grid.getChildren().remove(pBin);
                    grid.getChildren().remove(nBin);
                    grid.getChildren().remove(L);
                    grid.getChildren().remove(arvuta3);
                    grid.getChildren().remove(arvuta4);
                    grid.getChildren().remove(arvuta5);
                    grid.getChildren().remove(arvuta6);
                    grid.getChildren().remove(arvuta7);

                    grid.getChildren().add(pGeo);
                    grid.getChildren().add(arvuta6);
                };

        geo.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, geoHandler);

        arvuta6.setOnAction(event -> {

            Text geoVastus = new Text(GeomeetrilineJaotus.arvuta(Double.parseDouble(pGeo.getText())));

            StackPane.setAlignment(geoVastus, Pos.TOP_RIGHT);
            StackPane.setMargin(geoVastus, new Insets(360, 180, 0, 0));
            geoVastus.setId("vastus");
            juur.getChildren().add(geoVastus);
            juur.getChildren().add(tühjenda);

            tühjenda.setOnAction(event2 -> {
                juur.getChildren().remove(tühjenda);
                juur.getChildren().remove(geoVastus);
                grid.getChildren().remove(pGeo);
                grid.getChildren().remove(arvuta6);
            });
        });

        //////////////////////////////////////////////////////////////////////////////////////

        //Poissoni jaotus
        EventHandler<javafx.scene.input.MouseEvent> poisHandler;
        poisHandler = e -> {
            grid.getChildren().remove(pBernValem);
            grid.getChildren().remove(edasi);
            grid.getChildren().remove(nBernValem);
            grid.getChildren().remove(edasi0);
            grid.getChildren().remove(kBernValem);
            grid.getChildren().remove(arvuta);
            grid.getChildren().remove(mMultinoom);
            grid.getChildren().remove(edasi2);
            grid.getChildren().remove(edasi3);
            grid.getChildren().remove(edasi4);
            grid.getChildren().remove(kMultinoom);
            grid.getChildren().remove(edasi00);
            grid.getChildren().remove(edasi000);
            grid.getChildren().remove(pMultinoom);
            grid.getChildren().remove(arvuta2);
            grid.getChildren().remove(pBernJ);
            grid.getChildren().remove(mHyper);
            grid.getChildren().remove(nHyper);
            grid.getChildren().remove(kHyper);
            grid.getChildren().remove(pBin);
            grid.getChildren().remove(nBin);
            grid.getChildren().remove(pGeo);
            grid.getChildren().remove(arvuta3);
            grid.getChildren().remove(arvuta4);
            grid.getChildren().remove(arvuta5);
            grid.getChildren().remove(arvuta6);

            grid.getChildren().add(L);
            grid.getChildren().add(arvuta7);
        };

        poisson.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, poisHandler);

        arvuta7.setOnAction(event -> {

            Text poissoniVastus = new Text(PoissoniJaotus.arvuta(Double.parseDouble(L.getText())));

            StackPane.setAlignment(poissoniVastus, Pos.TOP_RIGHT);
            StackPane.setMargin(poissoniVastus, new Insets(360, 180, 0, 0));
            poissoniVastus.setId("vastus");
            juur.getChildren().add(poissoniVastus);
            juur.getChildren().add(tühjenda);

            tühjenda.setOnAction(event2 -> {
                juur.getChildren().remove(tühjenda);
                juur.getChildren().remove(poissoniVastus);
                grid.getChildren().remove(L);
                grid.getChildren().remove(arvuta7);
            });
        });

        //////////////////////////////////////////////////////////////////////////////////////

        pealava.setTitle("Tõenäosusteooria kalkulaator");
        pealava.setScene(stseen);
        pealava.show();
    }

    /*
    public boolean onDouble(TextField input) {
        try {
            Double.parseDouble(input.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean onInt(TextField input) {
        try {
            Integer.parseInt(input.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
     */

    public static void main(String[] args) {
        launch(args);
    }
}