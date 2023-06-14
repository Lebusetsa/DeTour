package com.example.denvertour;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Objects;

public class HomeUI {
    String urlImage,name,location;
    double ratings, reviews;

    public HomeUI(String imageURL, String n, String location, double ratingsNumber, int NumberofViews) {
        name=n; urlImage = imageURL;
        this.location = location; ratings = ratingsNumber;
        reviews = NumberofViews;
    }
    private Rectangle createRectangle(){
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(220);
        rectangle.setHeight(170);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        return rectangle;
    };

    public StackPane createPlace(){

        StackPane stackPane = new StackPane();
        VBox vBox = new VBox();
        StackPane.setMargin(vBox,new Insets(100,5,0,20));

        Image image = new Image(Objects.requireNonNull(getClass().getResource(urlImage)).toString());
        ImageView imageView= new ImageView(image);
        imageView.setFitHeight(170);
        imageView.setFitWidth(220);

        imageView.setClip(createRectangle());

        Image locationLogo = new Image(Objects.requireNonNull(getClass().getResource("/images/location.png")).toString());
        ImageView locationIV = new ImageView(locationLogo);
        locationIV.setFitHeight(15);
        locationIV.setFitWidth(15);

        Image ratingsLogo = new Image(Objects.requireNonNull(getClass().getResource("/images/star.png")).toString());
        ImageView ratingsIV = new ImageView(ratingsLogo);
        ratingsIV.setFitHeight(15);
        ratingsIV.setFitWidth(15);

        Label placeName = new Label(name);
        placeName.setStyle("-fx-text-fill: #F5F5F5;\n" +
                        "-fx-font-smoothing-type: lcd;\n" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 15px;\n" );

        Label locationName = new Label(location);
        locationName.setStyle("-fx-font-smoothing-type: lcd;\n" +
                "-fx-text-fill:  #EEEEEE;\n" +
                "-fx-font-size: 12px;\n");

        HBox locationHbox = new HBox(locationIV,locationName);

        Text ratingsText = new Text(Double.toString(ratings));
        ratingsText.setStyle("-fx-fill: #F5F5F5;\n" +
                "-fx-font-size: 12px;\n" +
                "-fx-font-smoothing-type: lcd;\n");

        HBox ratingHbox = new HBox(2);
        ratingHbox.getChildren().addAll(ratingsIV,ratingsText);

        Text reviewsText = new Text(Double.toString(reviews));
        reviewsText.setStyle("-fx-fill: #F5F5F5;\n" +
                "-fx-font-size: 12px;\n" +
                "-fx-font-smoothing-type: lcd;\n");

        Label review = new Label("Reviews");
        review.setStyle("-fx-text-fill: #F5F5F5;\n" +
                "-fx-font-size: 12px;\n" +
                "-fx-font-smoothing-type: lcd;\n");

        HBox reviewHbox = new HBox(2);
        reviewHbox.getChildren().addAll(reviewsText, review);

        HBox rr = new HBox(10, ratingHbox,reviewHbox);

        vBox.getChildren().addAll(placeName,locationHbox,rr);

        stackPane.getChildren().addAll(imageView,vBox);

        return stackPane;
    }
}

