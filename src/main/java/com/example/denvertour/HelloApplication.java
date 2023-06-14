package com.example.denvertour;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class HelloApplication extends Application {

    private int currentBoxIndex = 0;
    private final StackPane trends = new StackPane();
    private Rectangle createRectangle(){
        Rectangle clip = new Rectangle();
        clip.setWidth(220);
        clip.setHeight(170);
        clip.setArcWidth(20);
        clip.setArcHeight(20);
        return clip;
    };

//    public static  HBox createHBox(int spacing){
//        return  new HBox(spacing);
//    }
//
    public static Node createBoxNode(int spacing, String name){
        if(Objects.equals(name, "box")){
            return new HBox(spacing);
        }
        return new VBox(spacing);
    }

    public static HBox createSite(String s1,String s2,String s3,double d,int i){
        HomeUI maletsunnyane = new HomeUI(s1,s2,s3,d,i);
        StackPane maletsunyanePane = maletsunnyane.createPlace();

        HomeUI thabaBosiu = new HomeUI("/images/thababosiu.jpg","Thaba-Bosiu","Phuthiatsana Valley, Maseru",3.4,189);
        StackPane thababosiPane = thabaBosiu.createPlace();

        HomeUI malotiDrakensberg = new HomeUI("/images/mdp.jpg","Maloti Drakensberg Park","Sehlabathebe National Park",3.7,173);
        StackPane malotiDrakrnsbergPane = malotiDrakensberg.createPlace();

        HomeUI thabanaNtlenyane = new HomeUI("/images/thabanaNtlenyana.jpg","Thabana Ntlenyane","Drakensberg mountain range",2.9,191);
        StackPane thabanaNtlenyanepane = thabanaNtlenyane.createPlace();

        HomeUI avaniHotel = new HomeUI("/images/casino.jpg","Avani Hotel & Casino","Main South 1 RD, Hilton, Maseru",4.0,224);
        StackPane avaniPane = avaniHotel.createPlace();

        HBox newHBox = new HBox();
        newHBox.getChildren().addAll(maletsunyanePane,thababosiPane,malotiDrakrnsbergPane,thabanaNtlenyanepane,avaniPane);

        return newHBox;
    }

    public static String videoURL(String name){
        return  HelloApplication.class.getResource(name).toExternalForm();
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        String style = getClass().getResource("/styles.css").toExternalForm();

        //Foundation containers
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1200, 700);

        StackPane appBackground = new StackPane();
        appBackground.prefWidthProperty().bind(primaryStage.widthProperty().multiply(1.0));
        appBackground.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.30));
        root.setTop(appBackground);

        VBox appFeatures = new VBox(15);
        appFeatures.prefWidthProperty().bind(primaryStage.widthProperty().multiply(1.0));
        appFeatures.prefHeightProperty().bind(primaryStage.heightProperty().multiply(0.70));
        root.setBottom(appFeatures);

        root.setId("root");
        appBackground.setId("appBackground");
        appFeatures.setId("appFeatures");

        //appBackground elements
        //Image
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResource("/images/background.jpg")).toString());
        ImageView backgroundIV = new ImageView(backgroundImage);
        backgroundIV.setFitHeight(300);
        backgroundIV.setFitWidth(1280);

        //Description
        Label appName = new Label("DenvarTour");
        Label appDesc = new Label("Trust DenvarTour to plug you with the most appealing sites in the Mountain kingdom");
        appDesc.setMaxWidth(500);
        appDesc.setAlignment(Pos.CENTER);
        appDesc.setWrapText(true);

        VBox appDescription = new VBox(5, appName, appDesc);
        appBackground.getChildren().addAll(backgroundIV,appDescription);

        backgroundIV.setId("backgroundIV");
        appName.setId("appName");
        appDesc.setId("appDesc");
        appDescription.setId("appDescription");

        //appFeatures elements
        //Header
        Label header = new Label("Discover Places");
        header.setId("header");

        //Categories
        //All
        Image allIcon = new Image(Objects.requireNonNull(getClass().getResource("/images/all.png")).toString());
        ImageView allIV = new ImageView(allIcon);
        allIV.setFitHeight(13);
        allIV.setFitWidth(13);

        Label allLabel = new Label("ALL");

        HBox all = new HBox(5,allIV, allLabel);
        all.setId("all");

        //HOTELS
        Image hotelIcon = new Image(Objects.requireNonNull(getClass().getResource("/images/hotel.png")).toString());
        ImageView hotelIV = new ImageView(hotelIcon);
        hotelIV.setFitHeight(20);
        hotelIV.setFitWidth(25);

        Label hotelLabel = new Label("HOTEL");

        HBox hotel = new HBox(5, hotelIV, hotelLabel);
        hotel.setId("hotel");

        //PARKS
        Image parksIcon = new Image(Objects.requireNonNull(getClass().getResource("/images/parks.png")).toString());
        ImageView parksIV = new ImageView(parksIcon);
        parksIV.setFitHeight(13);
        parksIV.setFitWidth(13);

        Label parksLabel = new Label("PARKS");

        HBox parks = new HBox(5, parksIV, parksLabel);
        parks.setId("parks");

        //WATERFALLS
        Image waterfallIcon = new Image(Objects.requireNonNull(getClass().getResource("/images/waterfall.png")).toString());
        ImageView waterfallIV = new ImageView(waterfallIcon);
        waterfallIV.setFitHeight(13);
        waterfallIV.setFitWidth(13);

        Label waterfallLabel = new Label("WATERFALLS");

        HBox waterfalls = new HBox(5, waterfallIV, waterfallLabel);
        waterfalls.setId("waterfalls");

        //MOUNTAIN PASSES
        Image mpIcon = new Image(Objects.requireNonNull(getClass().getResource("/images/pass.png")).toString());
        ImageView mpIV = new ImageView(mpIcon);
        mpIV.setFitHeight(23);
        mpIV.setFitWidth(20);

        Label mpLabel = new Label("MOUNTAIN PASSES");

        HBox mountainP = new HBox(5, mpIV, mpLabel);
        mountainP.setId("mountainP");

        //MOUNTAIN PEAKS
        Image mpeaksIcon = new Image(Objects.requireNonNull(getClass().getResource("/images/peak.png")).toString());
        ImageView mpeaksIV = new ImageView(mpeaksIcon);
        mpeaksIV.setFitHeight(20);
        mpeaksIV.setFitWidth(20);

        Label mpeaksLabel = new Label("MOUNTAIN PEAKS");

        HBox mountainPeaks = new HBox(5, mpeaksIV, mpeaksLabel);
        mountainPeaks.setId("mountainPeaks");

        //BOTANICAL GARDENS
        Image bgIcon = new Image(Objects.requireNonNull(getClass().getResource("/images/gardens.png")).toString());
        ImageView bgIV = new ImageView(bgIcon);
        bgIV.setFitHeight(20);
        bgIV.setFitWidth(20);

        Label bgLabel = new Label("BOTANICAL GARDENS");

        HBox botanicalGarden = new HBox(5,bgIV, bgLabel);
        botanicalGarden.setId("botanicalGarden");

        HBox categories = new HBox(60, all, hotel, parks, waterfalls, mountainP, mountainPeaks, botanicalGarden);
        categories.setCursor(Cursor.HAND);
        //Sites Desc
        HBox sites = new HBox(32);
        sites.setCursor(Cursor.HAND);
        //Categories Functionalities
        all.setOnMouseClicked(event -> {

            HomeUI maletsunnyane = new HomeUI("/images/Maletsunyane.jpg","Maletsunyane Falls","Semonkong, Maseru, Lesotho",3.9,226);
            StackPane maletsunyanePane = maletsunnyane.createPlace();

            HomeUI thabaBosiu = new HomeUI("/images/thababosiu.jpg","Thaba-Bosiu","Phuthiatsana Valley, Maseru",3.4,189);
            StackPane thababosiPane = thabaBosiu.createPlace();

            HomeUI malotiDrakensberg = new HomeUI("/images/mdp.jpg","Maloti Drakensberg Park","Sehlabathebe National Park",3.7,173);
            StackPane malotiDrakrnsbergPane = malotiDrakensberg.createPlace();

            HomeUI thabanaNtlenyane = new HomeUI("/images/thabanaNtlenyana.jpg","Thabana Ntlenyane","Drakensberg mountain range",2.9,191);
            StackPane thabanaNtlenyanepane = thabanaNtlenyane.createPlace();

            HomeUI avaniHotel = new HomeUI("/images/casino.jpg","Avani Hotel & Casino","Main South 1 RD, Hilton, Maseru",4.0,224);
            StackPane avaniPane = avaniHotel.createPlace();

                   if(sites.getChildren().size() > 0){
                       sites.getChildren().clear();
                       sites.getChildren().addAll(avaniPane,maletsunyanePane,thababosiPane,thabanaNtlenyanepane,malotiDrakrnsbergPane);
                   }else {
                       sites.getChildren().addAll(avaniPane,maletsunyanePane,thababosiPane,thabanaNtlenyanepane,malotiDrakrnsbergPane);
                   }
                }
        );

        VBox s1ViewMore = new VBox();
        Image site1ViewMore = new Image(Objects.requireNonNull(getClass().getResource("/images/site1ViewMore.png")).toString());
        ImageView site1ViewMoreIV = new ImageView(site1ViewMore);




        s1ViewMore.setOnMouseClicked(event->{
            Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
            String[] hotelImagesURLs = {"/images/casino.jpg","/images/Hotels/avani2.jpg","/images/Hotels/avani3.jpg","/images/Hotels/avani4.jpg"};

            SiteDetails siteDetailsObject = new SiteDetails("Avani","Set in an elegant sandstone-constructed building, Avani Lesotho Hotel" +
                    " & Casino offers guests panoramic views of the Maseru city centre. It also features a spa, outdoor swimming pool and casino, " +
                    "as well as several restaurants and bars. The modern, air-conditioned rooms and suites all come with a seating area and satellite TV." +
                    " They are also equipped with tea-and-coffee making facilities and a safety deposit box."
                    ,hotelImagesURLs,videoURL("/avani.mp4"));
            ImageView back = siteDetailsObject.CreateHeader();


            TextField comment = new TextField();
            Stage newWindow = new Stage();
            VBox scene2RootVbox = new VBox(10);
            scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
            StackPane section1 = new StackPane();
            section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
            StackPane.setAlignment(back,Pos.TOP_LEFT);
            StackPane.setMargin(back,new Insets(5,0,0,5));
            HBox section2 = (HBox) createBoxNode(270,"box");
            section2.setStyle("-fx-padding: 0px 15px");
            VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

            Label title = new Label(siteDetailsObject.getName());
            title.setStyle("-fx-font-fill: #495057;\n" +
                    "-fx-font-size: 18px;\n" +
                    "-fx-font-weight: bold;");

            Label siteDescription = new Label(siteDetailsObject.getDescription());
            siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                    "-fx-text-fill:  #EEEEEE;\n" +
                    "-fx-font-size: 13px;");

            siteDescription.setMaxWidth(850);
            siteDescription.setAlignment(Pos.CENTER);
            siteDescription.setWrapText(true);

            siteDescriptionBox.getChildren().addAll(title,siteDescription);
            try {
                section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            VBox ratingsVbox = (VBox) createBoxNode(0,"");
            ratingsVbox = siteDetailsObject.createDivThree();
            ratingsVbox.setStyle("-fx-padding: 0px 15px");
            scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
            ImageView sendImageView = new ImageView(send);
            sendImageView.setFitWidth(25);
            sendImageView.setFitHeight(25);
            VBox section3 = new VBox();

            sendImageView.setOnMouseClicked(sendComment->{
                HBox section3element = new HBox(5);
                Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                ImageView profileImageView = new ImageView(profileImage);
                profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                profileImageView.setPreserveRatio(true);
                Rectangle rec = siteDetailsObject.profilePicRec();
                profileImageView.setClip(rec);
                Label userName = new Label("Maryjane Tahaji");
                userName.setTranslateY(5);
                userName.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 13px;\n" +
                        "-fx-font-weight: bold;");
                siteDetailsObject.setComment(comment.getText());
                comment.clear();
                Label userComment = new Label(siteDetailsObject.getComment());
                userComment.setAlignment(Pos.TOP_LEFT);
                userComment.setWrapText(true);

                section3element.getChildren().addAll(profileImageView,userName);
                section3.getChildren().addAll(section3element,userComment);
            });

            section3.setStyle("-fx-padding: 0px 15px");
            section3.setPrefHeight(100); section3.setPrefWidth(100);
            scene2RootVbox.getChildren().add(section3);

            comment.setPrefHeight(50); comment.setPrefWidth(1000);
            comment.setStyle("-fx-border-width: 1;\n" +
                    "  -fx-border-color: #BDBDBD;\n" +
                    "  -fx-padding: 2px 50px;\n" +
                    "  -fx-background-radius: 50px;\n" +
                    "    -fx-border-radius: 50px;");

            HBox stars = siteDetailsObject.createDivFour();
            stars.setTranslateY(13);

            HBox div4plus = new HBox(40,stars,comment,sendImageView);
            div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                    "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
            div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
            div4plus.setAlignment(Pos.CENTER);
            scene2RootVbox.getChildren().addAll(div4plus);
            Scene newScene = new Scene(scene2RootVbox,1200,700);
            newWindow.setTitle("Details");
            primaryStage.setScene(newScene);
            primaryStage.show();
            //Go back to main
            back.setOnMouseClicked(eve->{
                (siteDetailsObject.sv).stop();
                primaryStage.setScene(scene);
                primaryStage.show();
                scene2RootVbox.getChildren().clear();
            });
        });


        hotel.setOnMouseClicked(event -> {

        //<------------BEGINNING OF HOTEL1 OBJECT------------------------------------------------------------------------------------------------------------------------------->//
            HomeUI hotel1 = new HomeUI("/images/casino.jpg", "Avani Hotel & Casino", "Main South 1 RD, Hilton, Maseru", 4.0, 224);
            StackPane hotelPane = hotel1.createPlace();
            Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());

            //handle site click
            hotelPane.setOnMouseClicked(hotelClick->{

                String[] hotelImagesURLs = {"/images/casino.jpg","/images/Hotels/avani2.jpg","/images/Hotels/avani3.jpg","/images/Hotels/avani4.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Avani","Set in an elegant sandstone-constructed building, Avani Lesotho Hotel" +
                        " & Casino offers guests panoramic views of the Maseru city centre. It also features a spa, outdoor swimming pool and casino, " +
                        "as well as several restaurants and bars. The modern, air-conditioned rooms and suites all come with a seating area and satellite TV." +
                        " They are also equipped with tea-and-coffee making facilities and a safety deposit box."
                        ,hotelImagesURLs,videoURL("/avani.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();

                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });
                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
            //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });
            //<------END OF HOTEL1----->


                    //<------------BEGINNING OF HOTEL2 OBJECT------------------------------------------------------------------------------------------------------------------------------->//
            HomeUI hotel2 = new HomeUI("/images/Hotels/maluti.jpg","Hotel Mount Maluti","VF2J+358, Mohale's Hoek",3.6,67);
            StackPane hotel2Pane = hotel2.createPlace();

            hotel2Pane.setOnMouseClicked(hotelClick->{

                String[] hotelImagesURLs = {"/images/Hotels/maluti.jpg","/images/Hotels/maluti2.jpg","/images/Hotels/maluti3.jpg","/images/Hotels/maluti4.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Hotel Mount Maluti","Offering an outdoor pool, Hotel Mount Maluti - Lesotho is located in peaceful surroundings in " +
                        "Mohales Hoek and provides accommodation with free WiFi access." +
                        " A garden and a bar can be found on site, and each room has a balcony with a view of the garden.Rooms here come with a flat-screen TV, electric blankets and an electric kettle." +
                        " The private bathrooms are fitted with a bath or a shower, and free toiletries."
                        ,hotelImagesURLs,videoURL("/mtMaluti.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();

                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });



                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });





            HomeUI hotel3 = new HomeUI("/images/Hotels/mahlakapese1.jpg","Mahlakapese Guest House","A1 opposite Masjid Mosque, Hlotse",4.3,95);
            StackPane hotel3pane = hotel3.createPlace();
            hotel3pane.setOnMouseClicked(hotelClick->{

                String[] hotelImagesURLs = {"/images/Hotels/mahlakapese.jpg","/images/Hotels/mahlakapese2.jpg","/images/Hotels/mahlakapese3.jpg","/images/Hotels/mahlakapese.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Mahlakapese Guest House","Located in Leribe, Mahlakapese Guest Lodge provides accommodation with free WiFi and " +
                        "free private parking, as well as access to a fitness room.All units include a private bathroom and have air conditioning, a flat-screen TV and a fridge. Some units have a seating area and/or a balcony. Breakfast is available daily, and includes buffet, à la carte and continental options." +
                        " At the lodge you will find a restaurant serving African, Vegan, American and Seafood cuisine."
                        ,hotelImagesURLs,videoURL("/mahlakapese.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });



            HomeUI hotel4 = new HomeUI("/images/Hotels/blue1.jpg","Blue Mounatain Inn","Box7 Teyateyaneng 200",3.9,139);
            StackPane hotel4Pane = hotel4.createPlace();
            hotel4Pane.setOnMouseClicked(hotelClick->{

                String[] hotelImagesURLs = {"/images/Hotels/blue.jpg","/images/Hotels/blue1.jpg","/images/Hotels/blue2.jpg","/images/Hotels/blue3.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Blue Mountain Inn","The hotel is fully furnished and rooms are equipped with DSTV." +
                        " It has 3 conference halls and a boardroom. It is fully equipped to meet all your conferencing needs. Blue mountain inn makes one of the best wood fired pizzas in the country. It has a well manicured gardens and a swimming pool." +
                        " It is a family holiday hotel as well as a business hotel. So come stay with us."
                        ,hotelImagesURLs,videoURL("/blueM.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });

            });



                    String[] hotelImagesURLs = {"/images/Hotels/mpilo.jpg","/images/Hotels/mpilo1.jpg","/images/Hotels/mpilo2.jpg","/images/Hotels/mpilo3.jpg"};

                    SiteDetails siteDetailsObject = new SiteDetails("Mpilo Boutique Hotel","Mpilo Boutique Hotel is conveniently located at" +
                            " Corner Kingsway and Maluti Road," +
                            " Maseru West in Maseru just in 616 m from the centre.There is a golf field several kilometers from here. During a walking tour, you can explore numerous interesting places nearby. Rooms for non-smokers are offered. On guest's demand, there is a comfortable" +
                            " conference hall provided for holding business meetings, and also a banquet hall for lunches."
                            ,hotelImagesURLs,videoURL("/mpilo.mp4"));
                    ImageView back = siteDetailsObject.CreateHeader();


                    //<-----------------handle rating-------------->//
                    Polygon rateSite = siteDetailsObject.star1;
                    Polygon rateSite2 = siteDetailsObject.star2;
                    Polygon rateSite3 = siteDetailsObject.star3;
                    Polygon rateSite4 = siteDetailsObject.star4;
                    Polygon rateSite5 = siteDetailsObject.star5;

                    rateSite.setOnMouseClicked(rate->{
                        String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                        int increased = Integer.parseInt(numToIncrease);
                        increased++;
                        siteDetailsObject.updateFinalRatingNumber(increased);
                        rateSite.setFill(Color.YELLOW);

                        Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                        for(Polygon stars: ratingStars){
                            stars.setFill(Color.TRANSPARENT);
                        }

                    });


                    rateSite2.setOnMouseClicked(rate->{
                        String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                        int increased = Integer.parseInt(numToIncrease);
                        increased++;
                        siteDetailsObject.updateFinalRatingNumber(increased);
                        rateSite.setFill(Color.YELLOW);
                        rateSite2.setFill(Color.YELLOW);

                        rateSite5.setFill(Color.TRANSPARENT);
                        rateSite4.setFill(Color.TRANSPARENT);
                        rateSite3.setFill(Color.TRANSPARENT);

                    });

                    rateSite3.setOnMouseClicked(rate->{
                        String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                        int increased = Integer.parseInt(numToIncrease);
                        increased++;
                        siteDetailsObject.updateFinalRatingNumber(increased);
                        rateSite.setFill(Color.YELLOW);
                        rateSite2.setFill(Color.YELLOW);
                        rateSite3.setFill(Color.YELLOW);

                        rateSite5.setFill(Color.TRANSPARENT);
                        rateSite4.setFill(Color.TRANSPARENT);
                    });

                    rateSite4.setOnMouseClicked(rate->{
                        String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                        int increased = Integer.parseInt(numToIncrease);
                        increased++;
                        siteDetailsObject.updateFinalRatingNumber(increased);
                        rateSite.setFill(Color.YELLOW);
                        rateSite2.setFill(Color.YELLOW);
                        rateSite3.setFill(Color.YELLOW);
                        rateSite4.setFill(Color.YELLOW);

                        rateSite5.setFill(Color.TRANSPARENT);
                    });

                    Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                    rateSite5.setOnMouseClicked(rate->{
                        String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                        int increased = Integer.parseInt(numToIncrease);
                        increased++;
                        siteDetailsObject.updateFinalRatingNumber(increased);

                        for(Polygon stars : ratingStars){
                            stars.setFill(Color.YELLOW);
                        }

                    });



                    HomeUI hotel5 = new HomeUI("/images/Hotels/mpilo.jpg","Mpilo Boutique Hotel","MFVF+33F, Maluti Rd, Maseru",4.3,169);
                    StackPane hotel5Pane = hotel5.createPlace();
                    hotel5Pane.setOnMouseClicked(hotelClick->{

                        TextField comment = new TextField();
                    Stage newWindow = new Stage();
                    VBox scene2RootVbox = new VBox(10);
                    scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                    StackPane section1 = new StackPane();
                    section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                    StackPane.setAlignment(back,Pos.TOP_LEFT);
                    StackPane.setMargin(back,new Insets(5,0,0,5));
                    HBox section2 = (HBox) createBoxNode(270,"box");
                    section2.setStyle("-fx-padding: 0px 15px");
                    VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                    Label title = new Label(siteDetailsObject.getName());
                    title.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 18px;\n" +
                            "-fx-font-weight: bold;");

                    Label siteDescription = new Label(siteDetailsObject.getDescription());
                    siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                            "-fx-text-fill:  #EEEEEE;\n" +
                            "-fx-font-size: 13px;");

                    siteDescription.setMaxWidth(850);
                    siteDescription.setAlignment(Pos.CENTER);
                    siteDescription.setWrapText(true);

                    siteDescriptionBox.getChildren().addAll(title,siteDescription);
                    try {
                        section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                    VBox ratingsVbox = (VBox) createBoxNode(0,"");
                    ratingsVbox = siteDetailsObject.createDivThree();
                    ratingsVbox.setStyle("-fx-padding: 0px 15px");
                    scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                    ImageView sendImageView = new ImageView(send);
                    sendImageView.setFitWidth(25);
                    sendImageView.setFitHeight(25);
                    VBox section3 = new VBox();

                    sendImageView.setOnMouseClicked(sendComment->{
                        HBox section3element = new HBox(5);
                        Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                        ImageView profileImageView = new ImageView(profileImage);
                        profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                        profileImageView.setPreserveRatio(true);
                        Rectangle rec = siteDetailsObject.profilePicRec();
                        profileImageView.setClip(rec);
                        Label userName = new Label("Maryjane Tahaji");
                        userName.setTranslateY(5);
                        userName.setStyle("-fx-font-fill: #495057;\n" +
                                "-fx-font-size: 13px;\n" +
                                "-fx-font-weight: bold;");
                        siteDetailsObject.setComment(comment.getText());
                        comment.clear();
                        Label userComment = new Label(siteDetailsObject.getComment());
                        userComment.setAlignment(Pos.TOP_LEFT);
                        userComment.setWrapText(true);

                        section3element.getChildren().addAll(profileImageView,userName);
                        section3.getChildren().addAll(section3element,userComment);
                    });

                    section3.setStyle("-fx-padding: 0px 15px");
                    section3.setPrefHeight(100); section3.setPrefWidth(100);
                    scene2RootVbox.getChildren().add(section3);

                    comment.setPrefHeight(50); comment.setPrefWidth(1000);
                    comment.setStyle("-fx-border-width: 1;\n" +
                            "  -fx-border-color: #BDBDBD;\n" +
                            "  -fx-padding: 2px 50px;\n" +
                            "  -fx-background-radius: 50px;\n" +
                            "    -fx-border-radius: 50px;");

                    HBox stars = siteDetailsObject.createDivFour();
                    stars.setTranslateY(13);

                    HBox div4plus = new HBox(40,stars,comment,sendImageView);
                    div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                            "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                    div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                    div4plus.setAlignment(Pos.CENTER);
                    scene2RootVbox.getChildren().addAll(div4plus);
                    Scene newScene = new Scene(scene2RootVbox,1200,700);
                    newWindow.setTitle("Details");
                    primaryStage.setScene(newScene);
                    primaryStage.show();
                    //Go back to main
                    back.setOnMouseClicked(eve->{
                        (siteDetailsObject.sv).stop();
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        scene2RootVbox.getChildren().clear();
                });
            });

                    if (sites.getChildren().size() > 0) {
                        sites.getChildren().clear();
                        sites.getChildren().addAll(hotelPane,hotel2Pane,hotel3pane,hotel4Pane,hotel5Pane);

                    } else {
                        sites.getChildren().addAll(hotelPane,hotel2Pane,hotel3pane,hotel4Pane,hotel5Pane);

                    }
                }
        );



        waterfalls.setOnMouseClicked(event -> {

         String url = "/images/Waterfalls/";
         HomeUI waterfall1 = new HomeUI(url+"ketane.jpg","Ketane Falls","Mohale's Hoek",5.0,3);
         StackPane waterfall1Pane = waterfall1.createPlace();
         waterfall1Pane.setOnMouseClicked(hotelClick->{

             Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
             String[] hotelImagesURLs = {"/images/Waterfalls/ketane.jpg","/images/Waterfalls/ketane1.jpg","/images/Waterfalls/ketane3.jpg","/images/Waterfalls/ketane4.jpg"};

             SiteDetails siteDetailsObject = new SiteDetails("Ketane Falls","Ketane Falls is located in one of the most remote areas of Lesotho; " +
                     "the Ketane falls are only accessible by foot or on horseback. The falls have an impressive drop of 122 m, falling down into the narrow geological formation leading up the valley." +
                     " Ketane Falls (Ketane Falls) is a waterfall(s) (class H - Hydrographic) in Lesotho (general), Lesotho (Africa) "
                     ,hotelImagesURLs,videoURL("/ketane.mp4"));
             ImageView back = siteDetailsObject.CreateHeader();
             //<-----------------handle rating-------------->//
             Polygon rateSite = siteDetailsObject.star1;
             Polygon rateSite2 = siteDetailsObject.star2;
             Polygon rateSite3 = siteDetailsObject.star3;
             Polygon rateSite4 = siteDetailsObject.star4;
             Polygon rateSite5 = siteDetailsObject.star5;

             rateSite.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);

                 Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                 for(Polygon stars: ratingStars){
                     stars.setFill(Color.TRANSPARENT);
                 }

             });


             rateSite2.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
                 rateSite4.setFill(Color.TRANSPARENT);
                 rateSite3.setFill(Color.TRANSPARENT);

             });

             rateSite3.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);
                 rateSite3.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
                 rateSite4.setFill(Color.TRANSPARENT);
             });

             rateSite4.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);
                 rateSite3.setFill(Color.YELLOW);
                 rateSite4.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
             });

             Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
             rateSite5.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);

                 for(Polygon stars : ratingStars){
                     stars.setFill(Color.YELLOW);
                 }

             });
             TextField comment = new TextField();
             Stage newWindow = new Stage();
             VBox scene2RootVbox = new VBox(10);
             scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
             StackPane section1 = new StackPane();
             section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
             StackPane.setAlignment(back,Pos.TOP_LEFT);
             StackPane.setMargin(back,new Insets(5,0,0,5));
             HBox section2 = (HBox) createBoxNode(270,"box");
             section2.setStyle("-fx-padding: 0px 15px");
             VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

             Label title = new Label(siteDetailsObject.getName());
             title.setStyle("-fx-font-fill: #495057;\n" +
                     "-fx-font-size: 18px;\n" +
                     "-fx-font-weight: bold;");

             Label siteDescription = new Label(siteDetailsObject.getDescription());
             siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                     "-fx-text-fill:  #EEEEEE;\n" +
                     "-fx-font-size: 13px;");

             siteDescription.setMaxWidth(850);
             siteDescription.setAlignment(Pos.CENTER);
             siteDescription.setWrapText(true);

             siteDescriptionBox.getChildren().addAll(title,siteDescription);
             try {
                 section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
             } catch (URISyntaxException e) {
                 throw new RuntimeException(e);
             }
             VBox ratingsVbox = (VBox) createBoxNode(0,"");
             ratingsVbox = siteDetailsObject.createDivThree();
             ratingsVbox.setStyle("-fx-padding: 0px 15px");
             scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
             ImageView sendImageView = new ImageView(send);
             sendImageView.setFitWidth(25);
             sendImageView.setFitHeight(25);
             VBox section3 = new VBox();

             sendImageView.setOnMouseClicked(sendComment->{
                 HBox section3element = new HBox(5);
                 Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                 ImageView profileImageView = new ImageView(profileImage);
                 profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                 profileImageView.setPreserveRatio(true);
                 Rectangle rec = siteDetailsObject.profilePicRec();
                 profileImageView.setClip(rec);
                 Label userName = new Label("Maryjane Tahaji");
                 userName.setTranslateY(5);
                 userName.setStyle("-fx-font-fill: #495057;\n" +
                         "-fx-font-size: 13px;\n" +
                         "-fx-font-weight: bold;");
                 siteDetailsObject.setComment(comment.getText());
                 comment.clear();
                 Label userComment = new Label(siteDetailsObject.getComment());
                 userComment.setAlignment(Pos.TOP_LEFT);
                 userComment.setWrapText(true);

                 section3element.getChildren().addAll(profileImageView,userName);
                 section3.getChildren().addAll(section3element,userComment);
             });

             section3.setStyle("-fx-padding: 0px 15px");
             section3.setPrefHeight(100); section3.setPrefWidth(100);
             scene2RootVbox.getChildren().add(section3);

             comment.setPrefHeight(50); comment.setPrefWidth(1000);
             comment.setStyle("-fx-border-width: 1;\n" +
                     "  -fx-border-color: #BDBDBD;\n" +
                     "  -fx-padding: 2px 50px;\n" +
                     "  -fx-background-radius: 50px;\n" +
                     "    -fx-border-radius: 50px;");

             HBox stars = siteDetailsObject.createDivFour();
             stars.setTranslateY(13);

             HBox div4plus = new HBox(40,stars,comment,sendImageView);
             div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                     "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
             div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
             div4plus.setAlignment(Pos.CENTER);
             scene2RootVbox.getChildren().addAll(div4plus);
             Scene newScene = new Scene(scene2RootVbox,1200,700);
             newWindow.setTitle("Details");
             primaryStage.setScene(newScene);
             primaryStage.show();
             //Go back to main
             back.setOnMouseClicked(eve->{
                 (siteDetailsObject.sv).stop();
                 primaryStage.setScene(scene);
                 primaryStage.show();
                 scene2RootVbox.getChildren().clear();
             });
         });


         HomeUI waterfall2 = new HomeUI(url+"maletsunyanefalls1.jpg","Maletsunyane Falls","Semonkong, Maseru, Lesotho",3.9,229);
         StackPane waterfall2Pane = waterfall2.createPlace();
         waterfall2Pane.setOnMouseClicked(hotelClick->{

             Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
             String[] hotelImagesURLs = {"/images/Waterfalls/maletsunyanefalls1.jpg","/images/Waterfalls/maletsunyane2.jpg","/images/Waterfalls/maletsunyane3.jpg","/images/Waterfalls/maletsunyane4.jpg"};

             SiteDetails siteDetailsObject = new SiteDetails("Maletsunyane Falls","Maletsunyane Falls, also known in some sources as Semonkong Falls," +
                     " is a single drop waterfall that is located on the Maletsunyane River, close to the town of Semonkong, in the Southern African Kingdom of Lesotho. The name Semonkong translate to the Site of smoke which is unique because from one of the tallest falls in Africa," +
                     " there is a haze of smoke as the water plummets down and continues towards the ocean."
                     ,hotelImagesURLs,videoURL("/maletsunyane.mp4"));
             ImageView back = siteDetailsObject.CreateHeader();
             //<-----------------handle rating-------------->//
             Polygon rateSite = siteDetailsObject.star1;
             Polygon rateSite2 = siteDetailsObject.star2;
             Polygon rateSite3 = siteDetailsObject.star3;
             Polygon rateSite4 = siteDetailsObject.star4;
             Polygon rateSite5 = siteDetailsObject.star5;

             rateSite.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);

                 Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                 for(Polygon stars: ratingStars){
                     stars.setFill(Color.TRANSPARENT);
                 }

             });


             rateSite2.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
                 rateSite4.setFill(Color.TRANSPARENT);
                 rateSite3.setFill(Color.TRANSPARENT);

             });

             rateSite3.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);
                 rateSite3.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
                 rateSite4.setFill(Color.TRANSPARENT);
             });

             rateSite4.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);
                 rateSite3.setFill(Color.YELLOW);
                 rateSite4.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
             });

             Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
             rateSite5.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);

                 for(Polygon stars : ratingStars){
                     stars.setFill(Color.YELLOW);
                 }

             });


             TextField comment = new TextField();
             Stage newWindow = new Stage();
             VBox scene2RootVbox = new VBox(10);
             scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
             StackPane section1 = new StackPane();
             section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
             StackPane.setAlignment(back,Pos.TOP_LEFT);
             StackPane.setMargin(back,new Insets(5,0,0,5));
             HBox section2 = (HBox) createBoxNode(270,"box");
             section2.setStyle("-fx-padding: 0px 15px");
             VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

             Label title = new Label(siteDetailsObject.getName());
             title.setStyle("-fx-font-fill: #495057;\n" +
                     "-fx-font-size: 18px;\n" +
                     "-fx-font-weight: bold;");

             Label siteDescription = new Label(siteDetailsObject.getDescription());
             siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                     "-fx-text-fill:  #EEEEEE;\n" +
                     "-fx-font-size: 13px;");

             siteDescription.setMaxWidth(850);
             siteDescription.setAlignment(Pos.CENTER);
             siteDescription.setWrapText(true);

             siteDescriptionBox.getChildren().addAll(title,siteDescription);
             try {
                 section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
             } catch (URISyntaxException e) {
                 throw new RuntimeException(e);
             }
             VBox ratingsVbox = (VBox) createBoxNode(0,"");
             ratingsVbox = siteDetailsObject.createDivThree();
             ratingsVbox.setStyle("-fx-padding: 0px 15px");
             scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
             ImageView sendImageView = new ImageView(send);
             sendImageView.setFitWidth(25);
             sendImageView.setFitHeight(25);
             VBox section3 = new VBox();

             sendImageView.setOnMouseClicked(sendComment->{
                 HBox section3element = new HBox(5);
                 Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                 ImageView profileImageView = new ImageView(profileImage);
                 profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                 profileImageView.setPreserveRatio(true);
                 Rectangle rec = siteDetailsObject.profilePicRec();
                 profileImageView.setClip(rec);
                 Label userName = new Label("Maryjane Tahaji");
                 userName.setTranslateY(5);
                 userName.setStyle("-fx-font-fill: #495057;\n" +
                         "-fx-font-size: 13px;\n" +
                         "-fx-font-weight: bold;");
                 siteDetailsObject.setComment(comment.getText());
                 comment.clear();
                 Label userComment = new Label(siteDetailsObject.getComment());
                 userComment.setAlignment(Pos.TOP_LEFT);
                 userComment.setWrapText(true);

                 section3element.getChildren().addAll(profileImageView,userName);
                 section3.getChildren().addAll(section3element,userComment);
             });

             section3.setStyle("-fx-padding: 0px 15px");
             section3.setPrefHeight(100); section3.setPrefWidth(100);
             scene2RootVbox.getChildren().add(section3);

             comment.setPrefHeight(50); comment.setPrefWidth(1000);
             comment.setStyle("-fx-border-width: 1;\n" +
                     "  -fx-border-color: #BDBDBD;\n" +
                     "  -fx-padding: 2px 50px;\n" +
                     "  -fx-background-radius: 50px;\n" +
                     "    -fx-border-radius: 50px;");

             HBox stars = siteDetailsObject.createDivFour();
             stars.setTranslateY(13);

             HBox div4plus = new HBox(40,stars,comment,sendImageView);
             div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                     "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
             div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
             div4plus.setAlignment(Pos.CENTER);
             scene2RootVbox.getChildren().addAll(div4plus);
             Scene newScene = new Scene(scene2RootVbox,1200,700);
             newWindow.setTitle("Details");
             primaryStage.setScene(newScene);
             primaryStage.show();
             //Go back to main
             back.setOnMouseClicked(eve->{
                 (siteDetailsObject.sv).stop();
                 primaryStage.setScene(scene);
                 primaryStage.show();
                 scene2RootVbox.getChildren().clear();
             });
         });




         HomeUI waterfall3 = new HomeUI(url+"mj.jpg","Majoana Mabeli Falls","Quthing",3.9,2);
         StackPane waterfall3Pane = waterfall3.createPlace();
         waterfall3Pane.setOnMouseClicked(hotelClick->{

             Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
             String[] hotelImagesURLs = {"/images/Waterfalls/mj1.jpg","/images/Waterfalls/mj.jpg","/images/Waterfalls/mj3.jpg","/images/Waterfalls/maletsunayne4.jpg"};

             SiteDetails siteDetailsObject = new SiteDetails("Majoana Mabeli Falls","Majoana Mabeli water fall is in the valley of Quthing River from Lets’eng-la-Letsie." +
                     "Lets’eng-la-Letsie is Lesotho’s only Ramsar wetland, located in the south-eastern part of the mountain kingdom. It is not easy to reach this piece of paradise high-up in the mountains, " +
                     "as the only two ‘roads’ leading there are rough, tough, " +
                     "adventurous 4x4, and not for the faint hearted."
                     ,hotelImagesURLs,videoURL("/majoana.mp4"));
             ImageView back = siteDetailsObject.CreateHeader();
             //<-----------------handle rating-------------->//
             Polygon rateSite = siteDetailsObject.star1;
             Polygon rateSite2 = siteDetailsObject.star2;
             Polygon rateSite3 = siteDetailsObject.star3;
             Polygon rateSite4 = siteDetailsObject.star4;
             Polygon rateSite5 = siteDetailsObject.star5;

             rateSite.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);

                 Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                 for(Polygon stars: ratingStars){
                     stars.setFill(Color.TRANSPARENT);
                 }

             });


             rateSite2.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
                 rateSite4.setFill(Color.TRANSPARENT);
                 rateSite3.setFill(Color.TRANSPARENT);

             });

             rateSite3.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);
                 rateSite3.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
                 rateSite4.setFill(Color.TRANSPARENT);
             });

             rateSite4.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);
                 rateSite3.setFill(Color.YELLOW);
                 rateSite4.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
             });

             Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
             rateSite5.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);

                 for(Polygon stars : ratingStars){
                     stars.setFill(Color.YELLOW);
                 }

             });



             TextField comment = new TextField();
             Stage newWindow = new Stage();
             VBox scene2RootVbox = new VBox(10);
             scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
             StackPane section1 = new StackPane();
             section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
             StackPane.setAlignment(back,Pos.TOP_LEFT);
             StackPane.setMargin(back,new Insets(5,0,0,5));
             HBox section2 = (HBox) createBoxNode(270,"box");
             section2.setStyle("-fx-padding: 0px 15px");
             VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

             Label title = new Label(siteDetailsObject.getName());
             title.setStyle("-fx-font-fill: #495057;\n" +
                     "-fx-font-size: 18px;\n" +
                     "-fx-font-weight: bold;");

             Label siteDescription = new Label(siteDetailsObject.getDescription());
             siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                     "-fx-text-fill:  #EEEEEE;\n" +
                     "-fx-font-size: 13px;");

             siteDescription.setMaxWidth(850);
             siteDescription.setAlignment(Pos.CENTER);
             siteDescription.setWrapText(true);

             siteDescriptionBox.getChildren().addAll(title,siteDescription);
             try {
                 section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
             } catch (URISyntaxException e) {
                 throw new RuntimeException(e);
             }
             VBox ratingsVbox = (VBox) createBoxNode(0,"");
             ratingsVbox = siteDetailsObject.createDivThree();
             ratingsVbox.setStyle("-fx-padding: 0px 15px");
             scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
             ImageView sendImageView = new ImageView(send);
             sendImageView.setFitWidth(25);
             sendImageView.setFitHeight(25);
             VBox section3 = new VBox();

             sendImageView.setOnMouseClicked(sendComment->{
                 HBox section3element = new HBox(5);
                 Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                 ImageView profileImageView = new ImageView(profileImage);
                 profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                 profileImageView.setPreserveRatio(true);
                 Rectangle rec = siteDetailsObject.profilePicRec();
                 profileImageView.setClip(rec);
                 Label userName = new Label("Maryjane Tahaji");
                 userName.setTranslateY(5);
                 userName.setStyle("-fx-font-fill: #495057;\n" +
                         "-fx-font-size: 13px;\n" +
                         "-fx-font-weight: bold;");
                 siteDetailsObject.setComment(comment.getText());
                 comment.clear();
                 Label userComment = new Label(siteDetailsObject.getComment());
                 userComment.setAlignment(Pos.TOP_LEFT);
                 userComment.setWrapText(true);

                 section3element.getChildren().addAll(profileImageView,userName);
                 section3.getChildren().addAll(section3element,userComment);
             });

             section3.setStyle("-fx-padding: 0px 15px");
             section3.setPrefHeight(100); section3.setPrefWidth(100);
             scene2RootVbox.getChildren().add(section3);

             comment.setPrefHeight(50); comment.setPrefWidth(1000);
             comment.setStyle("-fx-border-width: 1;\n" +
                     "  -fx-border-color: #BDBDBD;\n" +
                     "  -fx-padding: 2px 50px;\n" +
                     "  -fx-background-radius: 50px;\n" +
                     "    -fx-border-radius: 50px;");

             HBox stars = siteDetailsObject.createDivFour();
             stars.setTranslateY(13);

             HBox div4plus = new HBox(40,stars,comment,sendImageView);
             div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                     "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
             div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
             div4plus.setAlignment(Pos.CENTER);
             scene2RootVbox.getChildren().addAll(div4plus);
             Scene newScene = new Scene(scene2RootVbox,1200,700);
             newWindow.setTitle("Details");
             primaryStage.setScene(newScene);
             primaryStage.show();
             //Go back to main
             back.setOnMouseClicked(eve->{
                 (siteDetailsObject.sv).stop();
                 primaryStage.setScene(scene);
                 primaryStage.show();
                 scene2RootVbox.getChildren().clear();
             });
         });

         HomeUI waterfall4 = new HomeUI(url+"qiloane2.jpg","Qiloane Falls","JW36+6X6, Maseru",4.3,6);
         StackPane waterfall4Pane = waterfall4.createPlace();
         waterfall4Pane.setOnMouseClicked(hotelClick->{

             Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
             String[] hotelImagesURLs = {"/images/Waterfalls/qiloane1.jpg","/images/Waterfalls/qiloane2.jpg","/images/Waterfalls/qiloane4.jpg","/images/Waterfalls/qiloane3.jpg"};

             SiteDetails siteDetailsObject = new SiteDetails("Qiloane Falls","Qiloane Falls is located along the Makhaleng River in Setibing area, " +
                     "which is close to the popular Molimo Nthuse Pass, which means “God Help Me Pass” in English (due to the scary nature of the precipice before the road was tarred). " +
                     "It takes about 2 hours to walk from the Basotho Pony Trekking base to Qiloane Falls." +
                     " Recently, 16 lady hikers participated in a pilgrimage to Qiloane Falls. "
                     ,hotelImagesURLs,videoURL("/qiloane.mp4"));
             ImageView back = siteDetailsObject.CreateHeader();
             //<-----------------handle rating-------------->//
             Polygon rateSite = siteDetailsObject.star1;
             Polygon rateSite2 = siteDetailsObject.star2;
             Polygon rateSite3 = siteDetailsObject.star3;
             Polygon rateSite4 = siteDetailsObject.star4;
             Polygon rateSite5 = siteDetailsObject.star5;

             rateSite.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);

                 Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                 for(Polygon stars: ratingStars){
                     stars.setFill(Color.TRANSPARENT);
                 }

             });


             rateSite2.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
                 rateSite4.setFill(Color.TRANSPARENT);
                 rateSite3.setFill(Color.TRANSPARENT);

             });

             rateSite3.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);
                 rateSite3.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
                 rateSite4.setFill(Color.TRANSPARENT);
             });

             rateSite4.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);
                 rateSite3.setFill(Color.YELLOW);
                 rateSite4.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
             });

             Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
             rateSite5.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);

                 for(Polygon stars : ratingStars){
                     stars.setFill(Color.YELLOW);
                 }

             });


             TextField comment = new TextField();
             Stage newWindow = new Stage();
             VBox scene2RootVbox = new VBox(10);
             scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
             StackPane section1 = new StackPane();
             section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
             StackPane.setAlignment(back,Pos.TOP_LEFT);
             StackPane.setMargin(back,new Insets(5,0,0,5));
             HBox section2 = (HBox) createBoxNode(270,"box");
             section2.setStyle("-fx-padding: 0px 15px");
             VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

             Label title = new Label(siteDetailsObject.getName());
             title.setStyle("-fx-font-fill: #495057;\n" +
                     "-fx-font-size: 18px;\n" +
                     "-fx-font-weight: bold;");

             Label siteDescription = new Label(siteDetailsObject.getDescription());
             siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                     "-fx-text-fill:  #EEEEEE;\n" +
                     "-fx-font-size: 13px;");

             siteDescription.setMaxWidth(850);
             siteDescription.setAlignment(Pos.CENTER);
             siteDescription.setWrapText(true);

             siteDescriptionBox.getChildren().addAll(title,siteDescription);
             try {
                 section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
             } catch (URISyntaxException e) {
                 throw new RuntimeException(e);
             }
             VBox ratingsVbox = (VBox) createBoxNode(0,"");
             ratingsVbox = siteDetailsObject.createDivThree();
             ratingsVbox.setStyle("-fx-padding: 0px 15px");
             scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
             ImageView sendImageView = new ImageView(send);
             sendImageView.setFitWidth(25);
             sendImageView.setFitHeight(25);
             VBox section3 = new VBox();

             sendImageView.setOnMouseClicked(sendComment->{
                 HBox section3element = new HBox(5);
                 Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                 ImageView profileImageView = new ImageView(profileImage);
                 profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                 profileImageView.setPreserveRatio(true);
                 Rectangle rec = siteDetailsObject.profilePicRec();
                 profileImageView.setClip(rec);
                 Label userName = new Label("Maryjane Tahaji");
                 userName.setTranslateY(5);
                 userName.setStyle("-fx-font-fill: #495057;\n" +
                         "-fx-font-size: 13px;\n" +
                         "-fx-font-weight: bold;");
                 siteDetailsObject.setComment(comment.getText());
                 comment.clear();
                 Label userComment = new Label(siteDetailsObject.getComment());
                 userComment.setAlignment(Pos.TOP_LEFT);
                 userComment.setWrapText(true);

                 section3element.getChildren().addAll(profileImageView,userName);
                 section3.getChildren().addAll(section3element,userComment);
             });

             section3.setStyle("-fx-padding: 0px 15px");
             section3.setPrefHeight(100); section3.setPrefWidth(100);
             scene2RootVbox.getChildren().add(section3);

             comment.setPrefHeight(50); comment.setPrefWidth(1000);
             comment.setStyle("-fx-border-width: 1;\n" +
                     "  -fx-border-color: #BDBDBD;\n" +
                     "  -fx-padding: 2px 50px;\n" +
                     "  -fx-background-radius: 50px;\n" +
                     "    -fx-border-radius: 50px;");

             HBox stars = siteDetailsObject.createDivFour();
             stars.setTranslateY(13);

             HBox div4plus = new HBox(40,stars,comment,sendImageView);
             div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                     "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
             div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
             div4plus.setAlignment(Pos.CENTER);
             scene2RootVbox.getChildren().addAll(div4plus);
             Scene newScene = new Scene(scene2RootVbox,1200,700);
             newWindow.setTitle("Details");
             primaryStage.setScene(newScene);
             primaryStage.show();
             //Go back to main
             back.setOnMouseClicked(eve->{
                 (siteDetailsObject.sv).stop();
                 primaryStage.setScene(scene);
                 primaryStage.show();
                 scene2RootVbox.getChildren().clear();
             });
         });

         HomeUI waterfall5 = new HomeUI(url+"ribaneng.jpg","Ribaneng","5QCH+27 Monaheng, Mafeteng",4.3,3);
         StackPane waterfall5Pane = waterfall5.createPlace();
         waterfall5Pane.setOnMouseClicked(hotelClick->{

             Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
             String[] hotelImagesURLs = {"/images/Waterfalls/ribaneng.jpg","/images/Waterfalls/ribaneng.jpg","/images/Waterfalls/ribaneng.jpg","/images/Waterfalls/ribaneng.jpg"};

             SiteDetails siteDetailsObject = new SiteDetails("Ribaneng","Ribaneng is a community council located in the Mafeteng District of Lesotho. " +
                     "Its population in 2006 was 7,509. Lesotho is linked with the South African railway system by a short line from Maseru to Marseilles on the Bloemfontein–KwaZulu-Natal main line, " +
                     "thus providing an outlet for farm produce, trade, and the transport of labourers. "
                     ,hotelImagesURLs,videoURL("/ribaneng.mp4"));
             ImageView back = siteDetailsObject.CreateHeader();
             //<-----------------handle rating-------------->//
             Polygon rateSite = siteDetailsObject.star1;
             Polygon rateSite2 = siteDetailsObject.star2;
             Polygon rateSite3 = siteDetailsObject.star3;
             Polygon rateSite4 = siteDetailsObject.star4;
             Polygon rateSite5 = siteDetailsObject.star5;

             rateSite.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);

                 Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                 for(Polygon stars: ratingStars){
                     stars.setFill(Color.TRANSPARENT);
                 }

             });


             rateSite2.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
                 rateSite4.setFill(Color.TRANSPARENT);
                 rateSite3.setFill(Color.TRANSPARENT);

             });

             rateSite3.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);
                 rateSite3.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
                 rateSite4.setFill(Color.TRANSPARENT);
             });

             rateSite4.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);
                 rateSite.setFill(Color.YELLOW);
                 rateSite2.setFill(Color.YELLOW);
                 rateSite3.setFill(Color.YELLOW);
                 rateSite4.setFill(Color.YELLOW);

                 rateSite5.setFill(Color.TRANSPARENT);
             });

             Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
             rateSite5.setOnMouseClicked(rate->{
                 String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                 int increased = Integer.parseInt(numToIncrease);
                 increased++;
                 siteDetailsObject.updateFinalRatingNumber(increased);

                 for(Polygon stars : ratingStars){
                     stars.setFill(Color.YELLOW);
                 }

             });



             TextField comment = new TextField();
             Stage newWindow = new Stage();
             VBox scene2RootVbox = new VBox(10);
             scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
             StackPane section1 = new StackPane();
             section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
             StackPane.setAlignment(back,Pos.TOP_LEFT);
             StackPane.setMargin(back,new Insets(5,0,0,5));
             HBox section2 = (HBox) createBoxNode(270,"box");
             section2.setStyle("-fx-padding: 0px 15px");
             VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

             Label title = new Label(siteDetailsObject.getName());
             title.setStyle("-fx-font-fill: #495057;\n" +
                     "-fx-font-size: 18px;\n" +
                     "-fx-font-weight: bold;");

             Label siteDescription = new Label(siteDetailsObject.getDescription());
             siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                     "-fx-text-fill:  #EEEEEE;\n" +
                     "-fx-font-size: 13px;");

             siteDescription.setMaxWidth(850);
             siteDescription.setAlignment(Pos.CENTER);
             siteDescription.setWrapText(true);

             siteDescriptionBox.getChildren().addAll(title,siteDescription);
             try {
                 section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
             } catch (URISyntaxException e) {
                 throw new RuntimeException(e);
             }
             VBox ratingsVbox = (VBox) createBoxNode(0,"");
             ratingsVbox = siteDetailsObject.createDivThree();
             ratingsVbox.setStyle("-fx-padding: 0px 15px");
             scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
             ImageView sendImageView = new ImageView(send);
             sendImageView.setFitWidth(25);
             sendImageView.setFitHeight(25);
             VBox section3 = new VBox();

             sendImageView.setOnMouseClicked(sendComment->{
                 HBox section3element = new HBox(5);
                 Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                 ImageView profileImageView = new ImageView(profileImage);
                 profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                 profileImageView.setPreserveRatio(true);
                 Rectangle rec = siteDetailsObject.profilePicRec();
                 profileImageView.setClip(rec);
                 Label userName = new Label("Maryjane Tahaji");
                 userName.setTranslateY(5);
                 userName.setStyle("-fx-font-fill: #495057;\n" +
                         "-fx-font-size: 13px;\n" +
                         "-fx-font-weight: bold;");
                 siteDetailsObject.setComment(comment.getText());
                 comment.clear();
                 Label userComment = new Label(siteDetailsObject.getComment());
                 userComment.setAlignment(Pos.TOP_LEFT);
                 userComment.setWrapText(true);

                 section3element.getChildren().addAll(profileImageView,userName);
                 section3.getChildren().addAll(section3element,userComment);
             });

             section3.setStyle("-fx-padding: 0px 15px");
             section3.setPrefHeight(100); section3.setPrefWidth(100);
             scene2RootVbox.getChildren().add(section3);

             comment.setPrefHeight(50); comment.setPrefWidth(1000);
             comment.setStyle("-fx-border-width: 1;\n" +
                     "  -fx-border-color: #BDBDBD;\n" +
                     "  -fx-padding: 2px 50px;\n" +
                     "  -fx-background-radius: 50px;\n" +
                     "    -fx-border-radius: 50px;");

             HBox stars = siteDetailsObject.createDivFour();
             stars.setTranslateY(13);

             HBox div4plus = new HBox(40,stars,comment,sendImageView);
             div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                     "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
             div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
             div4plus.setAlignment(Pos.CENTER);
             scene2RootVbox.getChildren().addAll(div4plus);
             Scene newScene = new Scene(scene2RootVbox,1200,700);
             newWindow.setTitle("Details");
             primaryStage.setScene(newScene);
             primaryStage.show();
             //Go back to main
             back.setOnMouseClicked(eve->{
                 (siteDetailsObject.sv).stop();
                 primaryStage.setScene(scene);
                 primaryStage.show();
                 scene2RootVbox.getChildren().clear();
             });
         });

                    if(sites.getChildren().size() > 0){
                        sites.getChildren().clear();
                        sites.getChildren().addAll(waterfall1Pane,waterfall2Pane,waterfall3Pane,waterfall4Pane,waterfall5Pane);
                    }else {
                        sites.getChildren().addAll(waterfall1Pane,waterfall2Pane,waterfall3Pane,waterfall4Pane,waterfall5Pane);
                    }
                }
        );

        parks.setOnMouseClicked(event->{
            String url = "/images/parks/";

            HomeUI park1 = new HomeUI(url+"honeymoon.jpg","Honeymoon Park","MFV8+VRV,Foso,Berea",2.5,4);
            StackPane park1Pane = park1.createPlace();
            park1Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/parks/honeymoon.jpg","/images/parks/honeymoon1.jpg","/images/parks/honeymoon2.jpg","/images/parks/honeymoon3.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Honeymoon Park","Honeymoon  is located deep in the front range of the Maloti Mountains at the foot of the Holomo Pass and only about 45 minutes from the South African border post of Caledonspoort (Caledonspoort is 15 minutes drive from the popular Freestate town of Clarens and about 4 hours from O.R Thambo International Airport)." +
                        "The route passes through the village of Khabo and parallels the Hlotse River along a very picturesque valley until it reaches the park entrance"
                        ,hotelImagesURLs,videoURL("/honeymoon.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });

            HomeUI park2 = new HomeUI(url+"sehlabathebe.jpg","Sehlabathebe National Park","Maluti Mountains, Qacha's Neck",4.8,2);
            StackPane park2Pane = park2.createPlace();
            park2Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/parks/sehlabathebe.jpg","/images/parks/sehlabathebe1.jpg","/images/parks/sehlabathebe2.jpg","/images/parks/sehlabathebe3.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Ribaneng","Majoana Mabeli water fall is in the valley of Quthing River from Lets’eng-la-Letsie." +
                        "Lets’eng-la-Letsie is Lesotho’s only Ramsar wetland, located in the south-eastern part of the mountain kingdom. It is not easy to reach this piece of paradise high-up in the mountains, " +
                        "as the only two ‘roads’ leading there are rough, tough, " +
                        "adventurous 4x4, and not for the faint hearted."
                        ,hotelImagesURLs,videoURL("/Sehlabathebe National Park(360P).mp4"));
                ImageView back = siteDetailsObject.CreateHeader();


                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });

            HomeUI park3 = new HomeUI(url+"ts1.jpg","Ts'ehlanyane National Park","Maluti Mountains, Holomo pass",0.9,990);
            StackPane park3Pane = park3.createPlace();
            park3Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/parks/ts1.jpg","/images/parks/ts2.jpg","/images/parks/ts3.jpg","/images/parks/ts4.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Ts'ehlanyane National Park","Lesotho’s first national park proclaimed in 1970, " +
                        " is remote, rugged and beautiful, and getting there is always a worthwhile adventure," +
                        " especially if you’re into wilderness, seclusion and fishing." +
                        " Sehlabathebe means the “Shield of the Plateau”, mirroring the rolling grasslands, wildflowers and silence provide a sense of complete isolation. " +
                        " Situated at an average elevation of some 2,400 metres. "
                        ,hotelImagesURLs,videoURL("/tsehlanyane.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });

            HomeUI park4 = new HomeUI(url+"lekhalong1.jpg","Lekhalong Park","Lancer's Gap. foso",3.0,3);
            StackPane park4Pane = park4.createPlace();
            park4Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/parks/lekhalong1.jpg","/images/parks/lekhalong.jpeg","/images/parks/lekhalong1.jpg","/images/parks/lekhalong.jpeg"};

                SiteDetails siteDetailsObject = new SiteDetails("Lekhalong Park","The horse is a source of pride in Lesotho and the Basotho are renowned as a nation of horsemen." +
                        " For generations, the sure-footed Basotho ‘pony’ has been bred as the ideal form of transport in the rugged mountains. Even today, the pony is still the most effective means of reaching the more inaccessible mountain villages. Pony trekking holidays on the hardy" +
                        " Basotho ponies are immensely popular and a fantastic way of exploring Lesotho’s beautiful rugged terrain"
                        ,hotelImagesURLs,videoURL("/lekhalong.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });

            HomeUI park5 = new HomeUI("/images/mdp.jpg","Maloti Drakensberg Park","Sehlabathebe National Park",3.7,173);
            StackPane park5Pane = park5.createPlace();
            park5Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/peaks/mdp.jpg","/images/peaks/mdp1.jpg","/images/peaks/mdp2.jpg","/images/peaks/mdp3.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Maloti Drakensberg Park","The Maloti-Drakensberg Park is a transnational property composed of the uKhahlamba Drakensberg National Park in " +
                        "South Africa and the Sehlathebe National Park in Lesotho. The site has exceptional natural beauty in its soaring basaltic buttresses, incisive dramatic cutbacks," +
                        " and golden sandstone ramparts as well as visually spectacular sculptured arches."
                        ,hotelImagesURLs,videoURL("/mdp.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });

            if(sites.getChildren().size() > 0 ){
                sites.getChildren().clear();
                sites.getChildren().addAll(park2Pane,park3Pane,park1Pane,park4Pane,park5Pane);
            }else {
                sites.getChildren().addAll(park2Pane,park3Pane,park1Pane,park4Pane,park5Pane);
            }

        });

        mountainP.setOnMouseClicked(event -> {
            String url = "/images/Passes/";
            HomeUI pass1 = new HomeUI(url+"bushman.jpg","Bushman Pass","Central highlights, western lesotho",4.5,90);
            StackPane pass1Pane = pass1.createPlace();
            pass1Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/Passes/bushman.jpg","/images/Passes/bushman3.jpg","/images/Passes/bushman1.jpg","/images/Passes/bushman3.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Bushman Pass","The Bushman's Nek Pass is suitable for hiking and horse riding. " +
                        "The hike from Bushamn's Nek camp to the top of the pass is 8km with a total elevation gain of 679m making this a moderatley difficult hike.The first half of the hike takes you past Cedric's Pool and is relatively flat, " +
                        "the next 3km are steep to the top of the pass and the final 2km to the Lesotho border is relatively flat."
                        ,hotelImagesURLs,videoURL("/bushmans.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });


            HomeUI pass2 = new HomeUI(url+"molimo.jpg","Molimo Nthuse","Western lesotho, 2nd Mountain Pass A3 road",5.1,900);
            StackPane pass2Pane = pass2.createPlace();
            pass2Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/Passes/molimo.jpg","/images/Passes/molimo2.jpg","/images/Passes/molimo3.jpg","/images/Passes/molimo4.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Molimo Nthuse","The Bushman's Nek Pass is suitable for hiking and horse riding. " +
                        "The hike from Bushamn's Nek camp to the top of the pass is 8km with a total elevation gain of 679m making this a moderatley difficult hike.The first half of the hike takes you past Cedric's Pool and is relatively flat, " +
                        "the next 3km are steep to the top of the pass and the final 2km to the Lesotho border is relatively flat."
                        ,hotelImagesURLs,videoURL("/molimo.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });

            HomeUI pass3 = new HomeUI(url+"motengpass.jpg","Moteng Pass","Maluti Mountains Butha Bothe",4.5,16);
            StackPane pass3Pane = pass3.createPlace();
            pass3Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/Passes/bushman.jpg","/images/Passes/bushman3.jpg","/images/Passes/bushman1.jpg","/images/Passes/bushman3.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Moteng Pass","\n" +
                        "This major pass is located between the town of Kala in the west and the " +
                        "Afriski Resort in the north in the northern quartile of Lesotho. " +
                        "It has a huge altitude gain of 896m that stretches over a distance of 15.3 km which " +
                        "converts into an average gradient of 1:17,but don't be fooled by that figure as it includes the descent.\n"
                        ,hotelImagesURLs,videoURL("/moteng.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });


            HomeUI pass4 = new HomeUI(url+"Rockeries1.jpg","Rockeries Pass","Mokhotlong",5.0,2);
            StackPane pass4Pane = pass4.createPlace();
            pass4Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/Passes/Rockeries4.jpg","/images/Passes/Rockeries3.jpg","/images/Passes/Rockeries1.jpg","/images/Passes/Rockeries2.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Rockeries Pass","This is a one-way trail that starts at the end of Mnweni Pass." +
                        " You can access it from the south as well but Mnweni Pass is the most likely access as it too is one-way.\n" +
                        "This steep but well-used trail drops off fast but levels off as you approach a few small farms and ends at the road leading up to the farms. "
                        ,hotelImagesURLs,videoURL("/rockeries.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });




            HomeUI pass5 = new HomeUI(url+"sani.jpg","Sani Pass","Mokhotlong",4.8,294);
            StackPane pass5Pane = pass5.createPlace();
            pass5Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/Passes/sani.jpg","/images/Passes/sani1.jpg","/images/Passes/sani2.jpg","/images/Passes/sani4.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Sani Pass","Sani Pass is the mother of all South African mountain passes. " +
                        "Statistically and in every sense, it out distances, out climbs, and out performs all it's competitors with consummate ease to have become the most iconic gravel pass in SA." +
                        " Situated between KZN and Lesotho the pass was built circa 1950 and remains a challenging drive in 4x4 vehicles with all the drama."
                        ,hotelImagesURLs,videoURL("/sani.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });

            if(sites.getChildren().size() > 0){
                sites.getChildren().clear();
                sites.getChildren().addAll(pass5Pane,pass4Pane,pass2Pane,pass1Pane,pass3Pane);
            }else {
                sites.getChildren().addAll(pass5Pane,pass4Pane,pass2Pane,pass1Pane,pass3Pane);
            }
                }
        );

        mountainPeaks.setOnMouseClicked(event -> {
            String url = "/images/peaks/";

            HomeUI peak1 = new HomeUI(url+"Hodgson.jpg","Hodgson Peak","Drakensburg, Mokhotlong",2.4,1);
            StackPane peakPane = peak1.createPlace();
            peakPane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/peaks/Hodgson.jpg","/images/peaks/Hodgson1.jpg","/images/peaks/Hodgson2.jpg","/images/peaks/Hodgson3.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Hodgson Peak","Mountain in the Drakensberg on the border of Lesotho, " +
                        "KwaZulu-Natal. The prominence is 195m/640ft.By elevation Hodgson's Peak North is: 59 out of 4813 in the Drakensberg; 35 out of 185 in uKhahlamba / Drakensberg Park; 53 out of 336 in Lesotho; 35 out of 2013 in KwaZulu-Natal;  10 out of 219 in Sisonke District Municipality. " +
                        "By prominence Hodgson's Peak North is:  28 out of 185 in uKhahlamba / Drakensberg Park. "
                        ,hotelImagesURLs,videoURL("/hodgson.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });


            HomeUI peak2 = new HomeUI(url+"Khoko-ntso.jpg","Khoko-ntso Peak","Drakensburg, Mokhotlong",2.1,0);
            StackPane peak2Pane = peak2.createPlace();
            peak2Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/peaks/Khoko-ntso.jpg","/images/peaks/Khoko-ntso1.jpg","/images/peaks/Khoko-ntso2.jpg","/images/peaks/Khoko-ntso.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Khoko-Ntso","Khoko-Ntso (Khoko-Ntšo) is a mountain (class T - Hypsographic) in South Africa (general), South Africa (Africa) with the region font code of Eastern Europe. It is located at an elevation of 2,480 meters above sea level.\n" +
                        "Khoko-Ntšo is also known as Khoko-Ntso, Khoko-Ntšo, Popple Peak. Its coordinates are 29°13'60\" S and 29°25'0\" E in DMS. \n"
                        ,hotelImagesURLs,videoURL("/qiloane0.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });


            HomeUI peak3 = new HomeUI(url+"Thaba-Putsoa.jpg","Thaba-Putsoa","Mohale Damn road, Lesotho",4.3,19);
            StackPane peak3Pane = peak3.createPlace();
            peak3Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/peaks/Thaba-Putsoa.jpg","/images/peaks/Thaba-Putsoa1.jpg","/images/peaks/Thaba-Putsoa2.jpg","/images/peaks/Thaba-Putsoa.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Thaba-Putsoa","This is one of the longest passes on the tarred A3 route between Maseru and Mohale at 18.3 km. " +
                        "Although the average gradient is a mild 1:40, those numbers are diluted by the long plateau section in the middle." +
                        " The reality is that the gradients get steep at either end - as steep as 1:6."
                        ,hotelImagesURLs,videoURL("/tPutsoa.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });

            HomeUI peak4 = new HomeUI(url+"thabanaN.jpg","Thabana-Ntlenyana","Drakensberg mountain range",2.9,191);
            StackPane peak4Pane = peak4.createPlace();
            peak4Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/peaks/thabanaN.jpg","/images/peaks/thabanaN1.jpg","/images/peaks/thabanaN2.jpg","/images/peaks/thabanaN.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Thabana Ntlenyane","The most-elevated stretch of the Drakensberg, " +
                        "in eastern and southern Lesotho, is composed of severely eroded basalt capping a sandstone base." +
                        " Its pinnacles and broken and fractured blocks present a steep eastern scarp (10,000 to more than 11,000 feet [3,000 to 3,300 metres] in elevation) " +
                        "along the length of the border between Lesotho and KwaZulu-Natal.."
                        ,hotelImagesURLs,videoURL("/thabanaN.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });


            HomeUI peak5 = new HomeUI("/images/thababosiu.jpg","Qiloane","PHa Ralikhalile, Maseru Lesotho",2.8,120);
            StackPane peak5Pane = peak5.createPlace();
            peak5Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/peaks/qiloane.jpg","/images/peaks/qiloane1.jpg","/images/peaks/qiloane2.jpg","/images/peaks/qiloane3.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Qiloane","This mountain inspired the famous Basotho hat, Mokorotlo. " +
                        "It takes about 2 hours to walk from the Basotho Pony Trekking base to Qiloane Falls. " +
                        "Recently, 16 lady hikers participated in a pilgrimage"
                        ,hotelImagesURLs,videoURL("/qiloane.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });

            if(sites.getChildren().size() > 0){
                sites.getChildren().clear();
                sites.getChildren().addAll(peak3Pane,peak4Pane,peak2Pane,peakPane,peak5Pane);
            }else {
                sites.getChildren().addAll(peak3Pane,peak4Pane,peak2Pane,peakPane,peak5Pane);
            }

                }
        );

        botanicalGarden.setOnMouseClicked(event->{
            String url = "/images/gardens/";

            HomeUI g1 = new HomeUI(url+"katseG.jpg","Katse Dam Gardens","MG74+7JC,Bokong,Lesotho",4.0,22);
            StackPane g1Pane = g1.createPlace();
            g1Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/gardens/katseG.jpeg","/images/gardens/katseG1.jpg","/images/gardens/katseG2.png","/images/gardens/katseG3.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Katse Dam Gardens","Katse Botanical Gardens is a centre for Alpine flora in Katse village, Lesotho." +
                        " The gardens were created as a result of plant rescue missions to mitigate the impact of the Katse Dam, particularly spiral aloes. The collection has a focus on traditional Sotho medicinal plants and has a large seed bank. " +
                        "The gardens were created as a result of plant rescue missions to mitigate the impact of the Katse Dam, particularly spiral aloes"
                        ,hotelImagesURLs,videoURL("/katse.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });



            HomeUI g2 = new HomeUI(url+"liphofung.jpg","Liphofung Nature Reserve","6FWW+R7M, Khukhune",4.2,56);
            StackPane g2Pane = g2.createPlace();
            g2Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/gardens/liphofung.jpg","/images/gardens/liphofung2.jpg","/images/gardens/liphofung3.jpg","/images/gardens/liphofung.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Liphofung Nature Reserve","Situated just off the main route from Botha-Bothe to Oxbow and Mokhotlong, " +
                        "the Liphofung Nature Reserve features a large cave overhang in the Clarens sandstone. Once a Bushman shelter and later used by King Moshoeshoe I, the founder of the Basotho nation, " +
                        "the cave features stone-age rock paintings as well as rich archaeological deposits."
                        ,hotelImagesURLs,videoURL("/liphofung.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });


            HomeUI g3 = new HomeUI(url+"malealea.jpg","Malealea Lodge","Malealea Village, Malealea",4.4,256);
            StackPane g3Pane = g3.createPlace();
            g3Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/gardens/malealea.jpg","/images/gardens/malealea1.jpg","/images/gardens/malealea2.jpg","/images/gardens/malealea4.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Malealea Lodge","Malealea Lodge is nestled in the Makhomalong Valley and surrounded by the beautiful Maloti Mountains." +
                        " Malealea Lodge dates back to 1905 when it was established as a Trading Post by Mervyn Bosworth Smith. Educated at Oxford, this charismatic, colonial character fought in both the Anglo Boer and First World Wars. " +
                        "He fell in love with Basutoland and lived there for over 40 years"
                        ,hotelImagesURLs,videoURL("/malealea.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });



            HomeUI g4 = new HomeUI(url+"maliba1.jpg","Maliba Lodge","A1 Maliba Butha-Bothe",4.4,135);
            StackPane g4Pane = g4.createPlace();
            g4Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/gardens/maliba1.jpg","/images/gardens/maliba2.jpg","/images/gardens/maliba3.jpg","/images/gardens/maliba1.jpg"};

                SiteDetails siteDetailsObject = new SiteDetails("Maliba Lodge","All rooms at Maliba Mountain Lodge feature a balcony with mountain view. Each has a TV, a fireplace and a private bathroom with a bath and shower. Towels and bathrobes are available in each unit.\n" +
                        "The main lodge features a gourmet restaurant and bistro, two bars with quiet discreet areas to admire the views of the surrounding mountains.\n" +
                        "Guests can explore the landscape on horseback, go hiking along the various mountain trails.\n."
                        ,hotelImagesURLs,videoURL("/maliba.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });



            HomeUI g5 = new HomeUI(url+"motebong.jpg","Motebong Garden","VGW3+VPC, Lejone",3.7,58);
            StackPane g5Pane = g5.createPlace();
            g5Pane.setOnMouseClicked(hotelClick->{

                Image send = new Image(Objects.requireNonNull(getClass().getResource("/images/send.png")).toString());
                String[] hotelImagesURLs = {"/images/gardens/motebong.jpeg","/images/gardens/motebong1.jpeg","/images/gardens/motebong2.jpeg","/images/gardens/motebong.jpeg"};

                SiteDetails siteDetailsObject = new SiteDetails("Motebong Garden","Motebong Lodge is located on the shores of the Katse Dam," +
                        " with direct access to the dam for fishing and boating. The lodge has fully equipped self catering units. There is also a Restaurant and bar on the premises.While staying with us guests can go hiking, horse riding and go on a guided tour of the Katse Dam.A sun-downer boat cruise can be enjoyed by the family and friends." +
                        " (CAMP)The Ha Lejone camp was constructed in 1990."
                        ,hotelImagesURLs,videoURL("/motebong.mp4"));
                ImageView back = siteDetailsObject.CreateHeader();
                //<-----------------handle rating-------------->//
                Polygon rateSite = siteDetailsObject.star1;
                Polygon rateSite2 = siteDetailsObject.star2;
                Polygon rateSite3 = siteDetailsObject.star3;
                Polygon rateSite4 = siteDetailsObject.star4;
                Polygon rateSite5 = siteDetailsObject.star5;

                rateSite.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);

                    Polygon[] ratingStars = {rateSite2,rateSite3,rateSite4,rateSite5};
                    for(Polygon stars: ratingStars){
                        stars.setFill(Color.TRANSPARENT);
                    }

                });


                rateSite2.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                    rateSite3.setFill(Color.TRANSPARENT);

                });

                rateSite3.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                    rateSite4.setFill(Color.TRANSPARENT);
                });

                rateSite4.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);
                    rateSite.setFill(Color.YELLOW);
                    rateSite2.setFill(Color.YELLOW);
                    rateSite3.setFill(Color.YELLOW);
                    rateSite4.setFill(Color.YELLOW);

                    rateSite5.setFill(Color.TRANSPARENT);
                });

                Polygon[] ratingStars = {rateSite,rateSite2,rateSite3,rateSite4,rateSite5};
                rateSite5.setOnMouseClicked(rate->{
                    String numToIncrease = siteDetailsObject.getFinalRatingsNumber();
                    int increased = Integer.parseInt(numToIncrease);
                    increased++;
                    siteDetailsObject.updateFinalRatingNumber(increased);

                    for(Polygon stars : ratingStars){
                        stars.setFill(Color.YELLOW);
                    }

                });

                TextField comment = new TextField();
                Stage newWindow = new Stage();
                VBox scene2RootVbox = new VBox(10);
                scene2RootVbox.setBackground(new Background(new BackgroundFill(Color.web("#E9ECEF"),CornerRadii.EMPTY,Insets.EMPTY)));
                StackPane section1 = new StackPane();
                section1.getChildren().addAll(siteDetailsObject.createDivOne(),back);
                StackPane.setAlignment(back,Pos.TOP_LEFT);
                StackPane.setMargin(back,new Insets(5,0,0,5));
                HBox section2 = (HBox) createBoxNode(270,"box");
                section2.setStyle("-fx-padding: 0px 15px");
                VBox siteDescriptionBox = (VBox) createBoxNode(10,"");

                Label title = new Label(siteDetailsObject.getName());
                title.setStyle("-fx-font-fill: #495057;\n" +
                        "-fx-font-size: 18px;\n" +
                        "-fx-font-weight: bold;");

                Label siteDescription = new Label(siteDetailsObject.getDescription());
                siteDescriptionBox.setStyle("-fx-font-smoothing-type: lcd;\n" +
                        "-fx-text-fill:  #EEEEEE;\n" +
                        "-fx-font-size: 13px;");

                siteDescription.setMaxWidth(850);
                siteDescription.setAlignment(Pos.CENTER);
                siteDescription.setWrapText(true);

                siteDescriptionBox.getChildren().addAll(title,siteDescription);
                try {
                    section2.getChildren().addAll(siteDescriptionBox,siteDetailsObject.createDivTwo());
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                VBox ratingsVbox = (VBox) createBoxNode(0,"");
                ratingsVbox = siteDetailsObject.createDivThree();
                ratingsVbox.setStyle("-fx-padding: 0px 15px");
                scene2RootVbox.getChildren().addAll(section1,section2,ratingsVbox);
                ImageView sendImageView = new ImageView(send);
                sendImageView.setFitWidth(25);
                sendImageView.setFitHeight(25);
                VBox section3 = new VBox();

                sendImageView.setOnMouseClicked(sendComment->{
                    HBox section3element = new HBox(5);
                    Image profileImage = new Image(Objects.requireNonNull(getClass().getResource("/images/profile3.jpg")).toString());
                    ImageView profileImageView = new ImageView(profileImage);
                    profileImageView.setFitWidth(30); profileImageView.setFitWidth(30);
                    profileImageView.setPreserveRatio(true);
                    Rectangle rec = siteDetailsObject.profilePicRec();
                    profileImageView.setClip(rec);
                    Label userName = new Label("Maryjane Tahaji");
                    userName.setTranslateY(5);
                    userName.setStyle("-fx-font-fill: #495057;\n" +
                            "-fx-font-size: 13px;\n" +
                            "-fx-font-weight: bold;");
                    siteDetailsObject.setComment(comment.getText());
                    comment.clear();
                    Label userComment = new Label(siteDetailsObject.getComment());
                    userComment.setAlignment(Pos.TOP_LEFT);
                    userComment.setWrapText(true);

                    section3element.getChildren().addAll(profileImageView,userName);
                    section3.getChildren().addAll(section3element,userComment);
                });

                section3.setStyle("-fx-padding: 0px 15px");
                section3.setPrefHeight(100); section3.setPrefWidth(100);
                scene2RootVbox.getChildren().add(section3);

                comment.setPrefHeight(50); comment.setPrefWidth(1000);
                comment.setStyle("-fx-border-width: 1;\n" +
                        "  -fx-border-color: #BDBDBD;\n" +
                        "  -fx-padding: 2px 50px;\n" +
                        "  -fx-background-radius: 50px;\n" +
                        "    -fx-border-radius: 50px;");

                HBox stars = siteDetailsObject.createDivFour();
                stars.setTranslateY(13);

                HBox div4plus = new HBox(40,stars,comment,sendImageView);
                div4plus.setStyle("-fx-padding: 0px 15px;" + "-fx-border-top-width: 2;"+
                        "-fx-border-color: #BDBDBD;" + "-fx-padding: 17px 0px" );
                div4plus.setBackground(new Background(new BackgroundFill(Color.web("#DEE2E6"),CornerRadii.EMPTY,Insets.EMPTY)));
                div4plus.setAlignment(Pos.CENTER);
                scene2RootVbox.getChildren().addAll(div4plus);
                Scene newScene = new Scene(scene2RootVbox,1200,700);
                newWindow.setTitle("Details");
                primaryStage.setScene(newScene);
                primaryStage.show();
                //Go back to main
                back.setOnMouseClicked(eve->{
                    (siteDetailsObject.sv).stop();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    scene2RootVbox.getChildren().clear();
                });
            });


            if(sites.getChildren().size() > 0){
                sites.getChildren().clear();
                sites.getChildren().addAll(g1Pane,g2Pane,g3Pane,g4Pane,g5Pane);
            }else{
                sites.getChildren().addAll(g1Pane,g2Pane,g3Pane,g4Pane,g5Pane);
            }
        });


        //Current trends
        Label trendsHeader = new Label("People Liked");
        trendsHeader.setId("trendsHeader");

        Label vnLabel = new Label("View Next");
        vnLabel.setTextFill(Color.web("#DD571C"));

        Image vn = new Image(Objects.requireNonNull(getClass().getResource("/images/viewNext.png")).toString());
        ImageView vnImageView = new ImageView(vn);
        vnImageView.setFitWidth(20);
        vnImageView.setFitHeight(20);

        HBox viewNext = new HBox(vnLabel, vnImageView);
        viewNext.setAlignment(Pos.CENTER);
        HBox headerBox = new HBox(1040,trendsHeader,viewNext);

        //Site One
        LikedPL siteOne = new LikedPL("/images/avani.jpg", "Avani Hotel & Casino","Main South 1 RD, Hilton, Maseru",19879, 312);

        site1ViewMoreIV.setFitHeight(25);
        site1ViewMoreIV.setFitWidth(25);
        s1ViewMore.getChildren().add(site1ViewMoreIV);
        s1ViewMore.setId("s1ViewMore");

        //Site Two
        LikedPL siteTwo = new LikedPL("/images/Waterfalls/maletsunyane2.jpg", "Maletsunyane Falls","Semonkong, Maseru, Lesotho",18253, 297);

        Image site2ViewMore = new Image(Objects.requireNonNull(getClass().getResource("/images/site1ViewMore.png")).toString());
        ImageView site2ViewMoreIV = new ImageView(site2ViewMore);
        site2ViewMoreIV.setFitHeight(25);
        site2ViewMoreIV.setFitWidth(25);

        VBox s2ViewMore = (VBox) createBoxNode(0,"");
        s2ViewMore.getChildren().add(site2ViewMoreIV);
        s2ViewMore.setStyle("-fx-border-width: 1;\n" +
                "  -fx-border-color: #BDBDBD;\n" +
                "  -fx-padding: 1px 5px;\n" +
                "  -fx-background-radius: 15px;\n" +
                "    -fx-border-radius: 15px;\n" +
                "    -fx-alignment: center;");

        //Site Three
        LikedPL siteThree = new LikedPL("/images/parks/sehlabathebe.jpg", "Sehlabathebe National Park","Malitu Mountains, Qacha's Nek",17853, 254);

        Image site3ViewMore = new Image(Objects.requireNonNull(getClass().getResource("/images/site1ViewMore.png")).toString());
        ImageView site3ViewMoreIV = new ImageView(site3ViewMore);
        site3ViewMoreIV.setFitHeight(25);
        site3ViewMoreIV.setFitWidth(25);

        VBox s3ViewMore = (VBox) createBoxNode(0,"");
        s3ViewMore.getChildren().add(site3ViewMoreIV);
        s3ViewMore.setStyle("-fx-border-width: 1;\n" +
                "  -fx-border-color: #BDBDBD;\n" +
                "  -fx-padding: 1px 5px;\n" +
                "  -fx-background-radius: 15px;\n" +
                "    -fx-border-radius: 15px;\n" +
                "    -fx-alignment: center;");

        HBox siteOneBox = new HBox( 920, siteOne.createPlace(), s1ViewMore);
        HBox siteTwoBox = new HBox( 920, siteTwo.createPlace(), s2ViewMore);
        HBox siteThreeBox = new HBox( 920, siteThree.createPlace(), s3ViewMore);

        trends.getChildren().addAll(siteOneBox,siteTwoBox,siteThreeBox);

        showHBox(siteOneBox);

        viewNext.setOnMouseClicked(event -> transitionToNextBox());

        StackPane details = new StackPane();
        appFeatures.getChildren().addAll( header, categories, sites, headerBox, trends);

        //Creating a scene
        scene.getStylesheets().add(style);
        primaryStage.setTitle("DeTour");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showHBox(HBox hBox){
        trends.getChildren().forEach(h-> h.setVisible(false));
        hBox.setVisible(true);
    }
    private void transitionToNextBox() {

        int nextHBoxIndex = (currentBoxIndex + 1) %
                trends.getChildren().size();

        HBox currentHBox = (HBox)
                trends.getChildren().get(currentBoxIndex);

        HBox nextHBox = (HBox)
                trends.getChildren().get(nextHBoxIndex);

        TranslateTransition transitionOut = new TranslateTransition(Duration.seconds(0.5), currentHBox);
        transitionOut.setToX(-currentHBox.getWidth());

        TranslateTransition transitionIn = new TranslateTransition(Duration.seconds(0.5), nextHBox);
        transitionIn.setFromX(nextHBox.getWidth());
        transitionIn.setToX(0);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(currentHBox.translateXProperty(), 0)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(currentHBox.translateXProperty(), -currentHBox.getWidth())),
                new KeyFrame(Duration.ZERO, new KeyValue(nextHBox.translateXProperty(), nextHBox.getWidth())),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(nextHBox.translateXProperty(), 0))
                );

        timeline.setOnFinished(e -> {
            currentHBox.setVisible(false);
            nextHBox.setVisible(true);
        });
        timeline.play();

        currentBoxIndex = nextHBoxIndex;

    }
    public static void main(String[] args) {
        launch();
    }
}