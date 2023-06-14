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

public class LikedPL {
    private final String urlImage;
    private final String name;
    private final String location;
    private final int ratings;
    private final int reviews;

    public LikedPL(String imageURL, String placeName, String location, int ratingsNumber, int NumberOfViews) {
        name=placeName; urlImage = imageURL;
        this.location = location; ratings = ratingsNumber;
        reviews = NumberOfViews;
    }
    private Rectangle createRectangle(){
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(70);
        rectangle.setHeight(70);
        rectangle.setArcWidth(15);
        rectangle.setArcHeight(15);
        return rectangle;
    };

    public HBox createPlace(){

        HBox hBox = new HBox(10);
        VBox vBox = new VBox(5);

        Image image = new Image(Objects.requireNonNull(getClass().getResource(urlImage)).toString());
        ImageView imageView= new ImageView(image);
        imageView.setFitHeight(70);
        imageView.setFitWidth(70);

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
        placeName.setStyle("-fx-text-fill: #495057;\n" +
                "-fx-font-smoothing-type: lcd;\n" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 13px;\n" );

        Label locationName = new Label(location);
        locationName.setStyle("-fx-font-smoothing-type: lcd;\n" +
                "-fx-text-fill:  #495057;\n" +
                "-fx-font-size: 12px;\n");

        HBox locationHbox = new HBox(locationIV,locationName);

        Text ratingsText = new Text(Integer.toString(ratings));
        ratingsText.setStyle("-fx-fill: #495057;\n" +
                "-fx-font-size: 12px;\n" +
                "-fx-font-smoothing-type: lcd;\n");

        HBox ratingHbox = new HBox(2);
        ratingHbox.getChildren().addAll(ratingsIV,ratingsText);

        Text reviewsText = new Text(Integer.toString(reviews));
        reviewsText.setStyle("-fx-fill: #495057;\n" +
                "-fx-font-size: 12px;\n" +
                "-fx-font-smoothing-type: lcd;\n");

        Label review = new Label("Reviews");
        review.setStyle("-fx-text-fill: #495057;\n" +
                "-fx-font-size: 12px;\n" +
                "-fx-font-smoothing-type: lcd;\n");

        HBox reviewHbox = new HBox(2);
        reviewHbox.getChildren().addAll(reviewsText, review);

        HBox rr = new HBox(10, ratingHbox,reviewHbox);

        vBox.getChildren().addAll(placeName,locationHbox,rr);

        hBox.getChildren().addAll(imageView,vBox);

        return hBox;
}

}
