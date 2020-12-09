import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MyApp extends Application { //this is the actual application class where our app will be coded

    @Override
    public void init() throws Exception { //will be executed before stage
        System.out.println("Before");
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*stage.setTitle("First Window"); //window title
        stage.show(); //makes window actually appear
        stage.setWidth(600); //width of window
        stage.setHeight(400); //height of window
        stage.setX(400); //x position of window
        stage.setY(250); //y position of window*/

        Stage stage2 = new Stage(); // thats how we create a new stage (window)
        stage2.setWidth(700);
        stage2.setHeight(400);
        stage2.setX(350);
        stage2.setY(100);
        stage2.setTitle("Second Window");



        //Stages

        //stage2.initModality(Modality.APPLICATION_MODAL); // other windows cant be used until this window is closed
        //stage2.initModality(Modality.NONE); // doesnt do anything (default)
        //stage2.initModality(Modality.WINDOW_MODAL); // only parent (owning) window cant be used before this window is closed, owner must be set first:
        //stage2.initOwner(stage); // sets owner
        stage2.initStyle(StageStyle.DECORATED); // regular style
        //stage2.initStyle(StageStyle.TRANSPARENT); //makes invisible
        //stage2.initStyle(StageStyle.UTILITY); // can only be closed, not minimized (used primarily in settings windows)
        //stage2.initStyle(StageStyle.UNDECORATED); // no frame just content
        //stage2.initStyle(StageStyle.UNIFIED); //removes border between content and decoration area
        //stage2.toBack(); // put window in the back
        stage2.toFront(); // put window in front
        stage2.setResizable(true); // makes window non resizable



        //Scenes

        VBox root = new VBox(); // layout manager; controls how layout looks; a stage can have multiple layout managers for different parts of the window

        Scene scene1 = new Scene(root); // creates new scene
        stage2.setScene(scene1); // adds scene to stage
        scene1.setCursor(Cursor.CLOSED_HAND); //changes how cursor looks
        scene1.getStylesheets().add("stylesheets/styles.css");



        //Labels and Images

        ImageView image1 = new ImageView("https://cdn.iconscout.com/icon/free/png-256/small-diamond-geometric-blue-38006.png"); // new image with link from web
        // now it is possible to change the properties of it with image1.
        //Image image = new Image("https://www.france-pub.com/images/city-paris-600.jpg"); // also possible to create new image object and then plug it into imageview instead of link
        //parent.getChildren().add(image1); // adds child node to parent

        Label label1 = new Label("This is a text label", image1); // creates new label; is child to "parent"; adds an image to that label
        label1.setTextFill(Color.web("#918273"));
        label1.setFont(new Font("Cambria", 45));
        label1.setRotate(34);

        Label label2 = new Label("This is a second label");
        label2.setId("special-label");

        root.getChildren().addAll(label1,label2); // adds child to parent (use .addAll(<controls>) if you want to add multiple



        //Hyperlinks

        /*Hyperlink link = new Hyperlink("Click here"); // creates new link
        parent.getChildren().add(link); // adds to parent
        link.setOnAction(e -> { // sets what happens when clicked
            System.out.println("Was clicked");
        });

        ImageView view = new ImageView("https://www.france-pub.com/images/city-paris-600.jpg");
        Label text = new Label("Not touched");
        Hyperlink newLink = new Hyperlink("Clk me", view); // adds image to link
        parent.getChildren().addAll(text, newLink); // adds label and link

        newLink.setOnAction(e -> { // when link is clicked text changes
            text.setText("You clicked");
        });*/



        //Buttons

        Button button = new Button("_Click");
        button.setStyle("-fx-font-size: 35px");
        button.setMinSize(10, 10);
        button.setPrefSize(100, 100);
        button.setOnAction(e -> {
            label1.setText("Test");
        });
        root.getChildren().addAll(button);



        //Mnemonic

        button.setMnemonicParsing(true); //basically a shortcut (alt + underlined character)




        stage2.show();

    }

    @Override
    public void stop() throws Exception { //will be executed after window
        System.out.println("After");
    }
}
