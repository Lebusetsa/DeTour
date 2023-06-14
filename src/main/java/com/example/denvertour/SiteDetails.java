package com.example.denvertour;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import java.net.URI;

import java.net.URISyntaxException;
import java.util.Objects;

public class SiteDetails {
    private static  final  double STAR_WIDTH = 40;
    private  static  final  double STAR_HEIGHT = 40;
    private final String Name;
    private final String Description ;
    private String comment;
    private final String[] ImageURLs;
    private final String VideoURL;
    private int finalRatingNumber = 15473;

    private int currentIndex;
    private MediaPlayer svMediaPlayer;
    private ImageView pauseIcon;
    private ImageView playIcon;
    private  ImageView replayIcon;


    public SiteDetails(String name,String desc,String[] IURLs, String VURLs){
        this.Name = name;
        this.Description = desc;
        this.ImageURLs = IURLs;
        this.VideoURL = VURLs;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public ImageView CreateHeader(){
        Image image = new Image(Objects.requireNonNull(getClass().getResource("/images/back.png")).toString());
        ImageView imageView= new ImageView(image);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
        return imageView;
    }

    public String getName(){return Name;}
    public String getDescription(){return Description;}


    public StackPane createDivOne(){
        StackPane pane = new StackPane();
        pane.setPrefHeight(100);
        pane.setPrefWidth(1200);

        Image image1 = new Image(Objects.requireNonNull(getClass().getResource(ImageURLs[0])).toString());
        Image image2 = new Image(Objects.requireNonNull(getClass().getResource(ImageURLs[1])).toString());
        Image image3 = new Image(Objects.requireNonNull(getClass().getResource(ImageURLs[2])).toString());
        Image image4 = new Image(Objects.requireNonNull(getClass().getResource(ImageURLs[3])).toString());

        Image[] images = {image1,image2,image3,image4};
        ImageView currentImageView = new ImageView(images[0]);
        currentImageView.setFitHeight(350); currentImageView.setFitWidth(1280);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(5), e-> {
                    currentIndex = (currentIndex + 1) % images.length;
                    Image nextImage = images[currentIndex];

                    Timeline fadeOut = new Timeline(
                            new KeyFrame(Duration.seconds(1), new KeyValue(currentImageView.opacityProperty(), 0))
                    );

                    fadeOut.setOnFinished(event -> {
                        currentImageView.setImage(nextImage);

                        Timeline fadeIn = new Timeline(
                                new KeyFrame(Duration.seconds(1), new KeyValue(currentImageView.opacityProperty(), 1))
                        );
                        fadeIn.play();
                    });
                    fadeOut.play();
                })
       );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        HBox gallery = new HBox(32);
        gallery.getChildren().addAll(currentImageView);

        pane.getChildren().add(gallery);
        return pane;
    }

    private Rectangle createRectangle(){
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(800);
        rectangle.setHeight(100);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        return rectangle;
    };

    public MediaPlayer sv;
    public StackPane createDivTwo() throws URISyntaxException {
        Media siteVideo = new Media(VideoURL);
        MediaView svMediaView = new MediaView();
        svMediaPlayer = new MediaPlayer(siteVideo);
        svMediaView.setMediaPlayer(svMediaPlayer);
        sv = svMediaPlayer;

        svMediaView.setFitWidth(800); svMediaView.setFitHeight(100);

        svMediaView.setClip(createRectangle());
        svMediaPlayer.setAutoPlay(true);

        Image pause = new Image(Objects.requireNonNull(getClass().getResource("/images/pause.png")).toString());
        Image play = new Image(Objects.requireNonNull(getClass().getResource("/images/play.png")).toString());
        Image replay = new Image(Objects.requireNonNull(getClass().getResource("/images/rp.png")).toString());


        playIcon = new ImageView(play);
        playIcon.setOnMouseClicked(event -> play());

        pauseIcon = new ImageView(pause);
        pauseIcon.setOnMouseClicked(event -> pause());

        replayIcon = new ImageView(replay);
        replayIcon.setOnMouseClicked(event -> replay());
        replayIcon.setFitHeight(30); replayIcon.setFitWidth(30);

        pauseIcon.setVisible(true);
        playIcon.setVisible(false);
        replayIcon.setVisible(false);

        StackPane playerPane = new StackPane(svMediaView, pauseIcon,playIcon,replayIcon);
        StackPane.setAlignment(playIcon, Pos.CENTER);
        StackPane.setAlignment(pauseIcon, Pos.CENTER);
        StackPane.setAlignment(replayIcon, Pos.CENTER);

        svMediaPlayer.setOnPlaying(() -> {
            playIcon.setVisible(false);
            pauseIcon.setVisible(true);
            replayIcon.setVisible(false);
        });


        svMediaPlayer.setOnPaused(() -> {
            playIcon.setVisible(true);
            pauseIcon.setVisible(false);
            replayIcon.setVisible(false);
        });

        svMediaPlayer.setOnEndOfMedia(() -> {
            playIcon.setVisible(false);
            pauseIcon.setVisible(false);
            replayIcon.setVisible(true);
        });
        svMediaPlayer.play();
        return playerPane;
    }

    private void play(){
        svMediaPlayer.play();
    }

    private void pause(){
        svMediaPlayer.pause();
    }

    private void replay(){
        svMediaPlayer.seek(svMediaPlayer.getStartTime());
        svMediaPlayer.play();
    }

    public Rectangle profilePicRec(){
        Rectangle dpRectangle = new Rectangle();
        dpRectangle.setWidth(30);
        dpRectangle.setHeight(30);
        dpRectangle.setArcWidth(50);
        dpRectangle.setArcHeight(50);
        return dpRectangle;
    };


    private Polygon star(double width,double height){
        Polygon star = new Polygon();
        double centerX = width / 2.0;
        double centerY = height / 2.0;

        double innerRadius = width * 0.2;
        double outerRadius = width * 0.5;

        for (int i = 0; i<5; i++){
            double angle = Math.PI * 2 * i/5;
            double x = centerX + Math.sin(angle) * outerRadius;
            double y = centerY - Math.cos(angle) * outerRadius;
            star.getPoints().addAll(x,y);

            angle += Math.PI / 5;
            x = centerX + Math.sin(angle) * innerRadius;
            y = centerY - Math.cos(angle) * innerRadius;
            star.getPoints().addAll(x,y);
        }

        star.setFill(Color.TRANSPARENT);
        star.setStroke(Color.BLACK);
        star.setStrokeWidth(1);
        star.setStrokeType(StrokeType.CENTERED);

        return star;
    }

    public Polygon star1 = star(20,20);  public Polygon star2 = star(20,20); public Polygon star3 = star(20,20);
    public Polygon star4 = star(20, 20); public Polygon star5 = star(20,20);

    public String getFinalRatingsNumber(){return Integer.toString(finalRatingNumber);}
    public void updateFinalRatingNumber(int number){
        finalRatingNumber = number;
    }
    public VBox createDivThree (){

        Label rnrTitle = new Label("Ratings And Reviews");
        rnrTitle.setStyle("-fx-font-fill: #495057;\n" +
                "-fx-font-size: 15px;\n" +
                "-fx-font-weight: bold;");

        Label finalRatings = new Label(Integer.toString(finalRatingNumber));
        finalRatings.setStyle("-fx-font-size: 13px;");
        finalRatings.setTranslateY(2);
        Image img1 = new Image(Objects.requireNonNull(getClass().getResource("/images/star.png")).toString());
        Image img2 = new Image(Objects.requireNonNull(getClass().getResource("/images/star.png")).toString());
        Image img3 = new Image(Objects.requireNonNull(getClass().getResource("/images/star.png")).toString());
        Image img4 = new Image(Objects.requireNonNull(getClass().getResource("/images/star.png")).toString());
        Image img5 = new Image(Objects.requireNonNull(getClass().getResource("/images/hs.png")).toString());

        ImageView imageView1 = new ImageView(img1);
        ImageView imageView2 = new ImageView(img2);
        ImageView imageView3 = new ImageView(img3);
        ImageView imageView4 = new ImageView(img4);
        ImageView imageView5 = new ImageView(img5);

        ImageView[] finalRating = {
                imageView1, imageView2, imageView3, imageView4, imageView5
        };

        for(ImageView img : finalRating){
            img.setFitHeight(15); img.setFitWidth(15);
            img.setTranslateY(3);
        }

        HBox rates = new HBox(imageView1,imageView2,imageView3,imageView4,imageView5);

        rates.setPrefWidth(100);
        rates.setPrefHeight(30);
        HBox ratings = new HBox(5,finalRatings,rates);
        ratings.setStyle("-fx-padding: 5px 0px 5px 0px");

        Image dp = new Image(Objects.requireNonNull(getClass().getResource("/images/profile1.jpg")).toString());
        ImageView dpImageView = new ImageView(dp);
        dpImageView.setFitWidth(30);
        dpImageView.setFitHeight(30);

        dpImageView.setClip(profilePicRec());

        Label userName = new Label("Leonardo Sidwell");
        userName.setTranslateY(5);
        userName.setStyle("-fx-font-fill: #495057;\n" +
                "-fx-font-size: 13px;\n" +
                "-fx-font-weight: bold;");

        HBox profile = new HBox(5,dpImageView, userName);

        Label reviewOne = new Label("Omg Lesotho is such a banger! I'm definitely revisiting as soon as i get a chance." +
                " Everything about the mountain kingdom is amazing. The people, weather, fresh air, mountains, accommodations, are literally the best. ");

        reviewOne.setStyle("-fx-font-size: 13px;");

        return new VBox(rnrTitle, ratings,profile,reviewOne);
    }

    public HBox createDivFour (){
        star1.setTranslateX(5); star2.setTranslateX(5); star3.setTranslateX(5); star4.setTranslateX(5); star5.setTranslateX(5);
        HBox rates = new HBox(star1,star2,star3, star4, star5);
        return new HBox(rates);
    }


}
