import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WelcomeScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        // label code
        Label welcomeLabel = new Label();
        welcomeLabel.setFont(Font.font("STENCIL", 68));
        welcomeLabel.setWrapText(true);
        welcomeLabel.setPrefWidth(350);

        Text codeText = new Text("CODE ");
        codeText.setFill(Color.DARKBLUE);
        codeText.setFont(Font.font("STENCIL", 68));

        Text modeText = new Text("MODE");
        modeText.setFill(Color.DARKMAGENTA);
        modeText.setFont(Font.font("STENCIL", 68));

        welcomeLabel.setGraphic(new HBox(codeText, modeText));

        // start button
        Button startButton = new Button("START!");
        startButton.setOnAction(event -> showNextScreen(primaryStage));
        startButton.setStyle("-fx-font-family: Elephant; -fx-font-size: 27px; -fx-text-fill: slateblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px; -fx-underline: true;");
        // directions button
        Button directionsButton = new Button("Directions");
        directionsButton.setOnAction(event -> showDirectionsScreen(primaryStage));
        directionsButton.setStyle("-fx-font-family: Elephant; -fx-font-size: 22px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px; -fx-underline: true;");
       
        // vbox to show labal & buttons
        VBox welcomeBox = new VBox(40, welcomeLabel, startButton, directionsButton);
        welcomeBox.setAlignment(Pos.CENTER);

        // holds vbox
        BorderPane root = new BorderPane();
        root.setCenter(welcomeBox);
        BorderPane.setMargin(welcomeBox, new Insets(50));

        // create new tab
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        private void showWelcomeScreen(Stage primaryStage) {
            WelcomeScreen welcomeScreen = new WelcomeScreen();
            welcomeScreen.start(primaryStage);
        }


     // directions screen
    private void showDirectionsScreen(Stage primaryStage) {
        Label directionsScreenLabel = new Label("Directions");
        directionsScreenLabel.setFont(Font.font("Elephant", 46));
        directionsScreenLabel.setTextFill(Color.DARKMAGENTA);

          // back button
    Button backButton = new Button("Back");
    backButton.setOnAction(event -> showWelcomeScreen(primaryStage));
    backButton.setStyle("-fx-font-size: 22px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

    // text for a paragraph
        Text directionsText = new Text("This app is designed to teach you the coding language JavaScript in a simple and easy to follow learning environment. "
        + "This app has 3 sections. " + "section 1 is 'Basic Concepts', " + "section 2 is 'Statements', " + "and section 3 is 'Permissions.'"
        + " Enjoy!");
        directionsText.setStyle("-fx-font-size: 20px; -fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: none;");
        directionsText.setWrappingWidth(480); 
        directionsText.setTextAlignment(TextAlignment.JUSTIFY); 

        // vbox
        VBox directionsBox = new VBox(18, directionsScreenLabel, directionsText, backButton);
        directionsBox.setAlignment(Pos.CENTER);
 
        BorderPane directionsRoot = new BorderPane();
        directionsRoot.setCenter(directionsBox);
        BorderPane.setMargin(directionsBox, new Insets(50));

        Scene directionsScene = new Scene(directionsRoot, 600, 400);
        primaryStage.setScene(directionsScene);
    }


    private void showNextScreen(Stage primaryStage) {
        // label
        Label nextScreenLabel = new Label();
        nextScreenLabel.setFont(Font.font("STENCIL", 55));
        nextScreenLabel.setWrapText(true);
        nextScreenLabel.setPrefWidth(350);

        Text chooseAText = new Text("Choose A");
        chooseAText.setFill(Color.DARKBLUE);
        chooseAText.setFont(Font.font("STENCIL", 55));

        Text sectionText = new Text(" section");
        sectionText.setFill(Color.DARKMAGENTA);
        sectionText.setFont(Font.font("STENCIL", 55));

        nextScreenLabel.setGraphic(new HBox(chooseAText, sectionText));

        //back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showWelcomeScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        //button for section 1
        Button firstButton = new Button("Section 1");
        firstButton.setStyle("-fx-font-family: Elephant; -fx-font-size: 23px; -fx-text-fill: darkmagenta; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px; -fx-underline: true;");
        firstButton.setOnAction(event -> showFirstScreen(primaryStage));

        //button for section 2
        Button secondButton = new Button("Section 2");
        secondButton.setStyle("-fx-font-family: Elephant; -fx-font-size: 23px; -fx-text-fill: darkmagenta; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px; -fx-underline: true;");
        secondButton.setOnAction(event -> showSecondScreen(primaryStage));

        //button for section 3
        Button thirdButton = new Button("Section 3");
        thirdButton.setStyle("-fx-font-family: Elephant; -fx-font-size: 23px; -fx-text-fill: darkmagenta; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px; -fx-underline: true;");
        thirdButton.setOnAction(event -> showThirdScreen(primaryStage));

        //spacing of buttons
        HBox buttonsBox = new HBox(35, firstButton, secondButton, thirdButton);
        buttonsBox.setAlignment(Pos.TOP_CENTER);

        //spacing of title & other buttons
        VBox nextScreenBox = new VBox(80, nextScreenLabel, buttonsBox, backButton);
        nextScreenBox.setAlignment(Pos.CENTER);  

        BorderPane root = new BorderPane();
        root.setCenter(nextScreenBox);
        BorderPane.setMargin(nextScreenBox, new Insets(50));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    //first section (multiple choice) screen after clicking sectioin 1
    private void showFirstScreen(Stage primaryStage) {
        // label
        Label firstScreenLabel = new Label("Basic Concepts");
        firstScreenLabel.setFont(Font.font("STENCIL", 50));
        firstScreenLabel.setAlignment(Pos.TOP_CENTER);
        firstScreenLabel.setTextFill(Color.DARKBLUE);
   
        // label for choose level text
        Label chooseLevelLabel = new Label("Choose A Level");
        chooseLevelLabel.setStyle("-fx-font-family: Elephant; -fx-font-size: 30px; -fx-font-style: normal; -fx-font-weight: bold; -fx-text-fill: DARKMAGENTA;");
        chooseLevelLabel.setLayoutX(100);
        chooseLevelLabel.setLayoutY(300);
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showNextScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        //button for level 1
        Button level1Button = new Button("Multiple Choice");
        level1Button.setStyle("-fx-font-family: Elephant; -fx-font-size: 24px; -fx-text-fill: mediumseagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        level1Button.setOnAction(event -> showS1L1Q1Screen(primaryStage));
        // button for level 2
        Button level2Button = new Button("Fill In The Blank");
        level2Button.setStyle("-fx-font-family: Elephant;-fx-font-size: 24px; -fx-text-fill: darkorange; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        level2Button.setOnAction(event -> showS1L2Q1Screen(primaryStage));
       
       
        // vbox for labels and back button
        VBox firstScreenBox = new VBox(40, firstScreenLabel, chooseLevelLabel, backButton);
        firstScreenBox.setAlignment(Pos.TOP_CENTER);
       
        // hbox for level buttons
        HBox buttonBox = new HBox(20, level1Button, level2Button);
       
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        // adds the HBox to the VBox
        firstScreenBox.getChildren().add(1, buttonBox);
   
        BorderPane root = new BorderPane();
        root.setCenter(firstScreenBox);
        BorderPane.setMargin(firstScreenBox, new Insets(50));
   
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
    //second section screen (fill in the blank) after clicking section 2
    private void showSecondScreen(Stage primaryStage) {
        //label for the second screen
        Label secondScreenLabel = new Label("Statements");
        secondScreenLabel.setFont(Font.font("STENCIL", 50));
        secondScreenLabel.setTextFill(Color.DARKBLUE);
   
        // label for choose level text
        Label chooseLevelLabel = new Label("Choose A Level");
        chooseLevelLabel.setStyle("-fx-font-family: Elephant; -fx-font-size: 30px; -fx-text-fill: darkmagenta; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;");
        chooseLevelLabel.setLayoutX(100);
        chooseLevelLabel.setLayoutY(300);
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showNextScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        //button for level 1
        Button level1 = new Button("Multiple Choice");
        level1.setStyle("-fx-font-family: Elephant; -fx-font-size: 24px; -fx-text-fill: mediumseagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        level1.setOnAction(event -> showS2L1Q1Screen(primaryStage));
        // button for level 2
        Button level2 = new Button("Fill In The Blank");
        level2.setStyle("-fx-font-family: Elephant; -fx-font-size: 24px; -fx-text-fill: darkorange; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        level2.setOnAction(event -> showS2L2Q1Screen(primaryStage));

        // vbox for labels and back button
        VBox secondScreenBox = new VBox(40, secondScreenLabel, chooseLevelLabel, backButton);
        secondScreenBox.setAlignment(Pos.TOP_CENTER);
       
        // hbox for level buttons
        HBox buttonBox = new HBox(20, level1, level2);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        secondScreenBox.getChildren().add(1, buttonBox);
   
        BorderPane root = new BorderPane();
        root.setCenter(secondScreenBox);
        BorderPane.setMargin(secondScreenBox, new Insets(50));
   
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
        //third level screen (create your own) after clicking section 3
        private void showThirdScreen(Stage primaryStage) {
        // label for the third screen
        Label thirdScreenLabel = new Label("Permissions");
        thirdScreenLabel.setFont(Font.font("STENCIL", 50));
        thirdScreenLabel.setTextFill(Color.DARKBLUE);
   
        // label for choose level text
        Label chooseLevelLabel = new Label("Choose A Level");
        chooseLevelLabel.setStyle("-fx-font-family: Elephant; -fx-font-size: 30px; -fx-text-fill: darkmagenta; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;");
        chooseLevelLabel.setLayoutX(100);
        chooseLevelLabel.setLayoutY(300);
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showNextScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        //button for level 1
        Button level1 = new Button("Multiple Choice");
        level1.setStyle("-fx-font-family: Elephant; -fx-font-size: 24px; -fx-text-fill: mediumseagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        level1.setOnAction(event -> showS3L1Q1Screen(primaryStage));
        // button for level 2
        Button level2 = new Button("Fill In The Blank");
        level2.setStyle("-fx-font-family: Elephant; -fx-font-size: 24px; -fx-text-fill: darkorange; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        level2.setOnAction(event -> showS3L2Q1Screen(primaryStage));

        // vbox for labels and back button
        VBox thirdScreenBox = new VBox(40, thirdScreenLabel, chooseLevelLabel, backButton);
        thirdScreenBox.setAlignment(Pos.TOP_CENTER);
       
        // hbox for level buttons
        HBox buttonBox = new HBox(20, level1, level2);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        thirdScreenBox.getChildren().add(1, buttonBox);

        BorderPane root = new BorderPane();
        root.setCenter(thirdScreenBox);
        BorderPane.setMargin(thirdScreenBox, new Insets(50));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();  
    }


    // actual code for multiple choice & fill in the blank questions


    // multiple choice  
    private Button[] answerButtons;


    //section 1 level 1 question 1
    private void showS1L1Q1Screen(Stage primaryStage) {
        // label for title
        Label S1L1ScreenLabel = new Label("Question 1");
        S1L1ScreenLabel.setFont(Font.font("Elephant", 30));
        S1L1ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L1ScreenLabel.setTextFill(Color.DARKBLUE);
   
        //label for question
        Label questionLabel = new Label("What is the data type 'int' used for?");
        questionLabel.setAlignment(Pos.TOP_CENTER);
        questionLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: darkmagenta; -fx-font-weight: bold; -fx-padding: 10px;");
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showFirstScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
   
        //next button
        Button nextButton = new Button("Next Question ->");
        nextButton.setOnAction(event -> showS1L1Q2Screen(primaryStage));
        nextButton.setStyle("-fx-font-size: 20px; -fx-text-fill: seagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        nextButton.setAlignment(Pos.BOTTOM_CENTER);
   
        // answer buttons
        answerButtons = new Button[3];
        answerButtons[0] = new Button("Integer");
        answerButtons[1] = new Button("Fraction");
        answerButtons[2] = new Button("Decimal");
   
        // the style of the answer buttons
        for (Button button : answerButtons) {
            button.setStyle("-fx-background-color: lightgray; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 10px;");
            button.setOnAction(this::handleAnswerButton);
        }
   
        // vbox for labels, answer buttons, and back button
        VBox S1L1ScreenBox = new VBox(30, S1L1ScreenLabel, questionLabel, nextButton, backButton);
        S1L1ScreenBox.setAlignment(Pos.TOP_CENTER);
   
        //HBox for answer buttons
        HBox buttonBox = new HBox(5, answerButtons[0], answerButtons[1], answerButtons[2]);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        S1L1ScreenBox.getChildren().add(1, buttonBox);
   
        BorderPane root = new BorderPane();
        root.setCenter(S1L1ScreenBox);
        BorderPane.setMargin(S1L1ScreenBox, new Insets(20));
       
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
   // make the answer buttons turn red or green depending on correct or not
    private void handleAnswerButton(ActionEvent event) {
        Label questionLabel = new Label();
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("Integer")) {
            clickedButton.setStyle("-fx-font-size: 20px;-fx-background-color: green;-fx-font-weight: bold;");
            questionLabel.setText("Correct!");
        } else {
            clickedButton.setStyle("-fx-font-size: 18px;-fx-background-color: red;-fx-font-weight: bold;");
            questionLabel.setText("Incorrect");
        }
    }
   
  //section 1 level 1 question 2
  private void showS1L1Q2Screen(Stage primaryStage) {
    //label
    Label S1L1ScreenLabel = new Label("Question 2");
    S1L1ScreenLabel.setFont(Font.font("Elephant", 30));
    S1L1ScreenLabel.setAlignment(Pos.TOP_CENTER);
    S1L1ScreenLabel.setTextFill(Color.DARKBLUE);

    // label for question
    Text questionLabel = new Text("True or False; Boolean is used for True or False questions?");
    questionLabel.setTextAlignment(TextAlignment.CENTER);
    questionLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-padding: 10px;");
    questionLabel.setFill(Color.DARKMAGENTA); 
    questionLabel.setWrappingWidth(430);


    // back button
    Button backButton = new Button("Back");
    backButton.setOnAction(event -> showFirstScreen(primaryStage));
    backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

    // answer buttons
    answerButtons = new Button[2];
    answerButtons[0] = new Button("True");
    answerButtons[1] = new Button("False");
   
     //next button
     Button nextButton = new Button("Next Question ->");
     nextButton.setOnAction(event -> showS1L1Q3Screen(primaryStage));
     nextButton.setStyle("-fx-font-size: 20px; -fx-text-fill: seagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
     nextButton.setAlignment(Pos.BOTTOM_CENTER);

    // style of answer buttons
    for (Button button : answerButtons) {
        button.setStyle("-fx-background-color: lightgray; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 10px;");
        button.setOnAction(this::handleAnswerButton4);
    }

    // vbox for labels, answer buttons, and back button
    VBox S1L1ScreenBox = new VBox(26, S1L1ScreenLabel, questionLabel, nextButton, backButton);
    S1L1ScreenBox.setAlignment(Pos.TOP_CENTER);

    HBox buttonBox = new HBox(5, answerButtons[0], answerButtons[1]);
    buttonBox.setAlignment(Pos.BOTTOM_CENTER);

    S1L1ScreenBox.getChildren().add(1, buttonBox);

    BorderPane root = new BorderPane();
    root.setCenter(S1L1ScreenBox);
    BorderPane.setMargin(S1L1ScreenBox, new Insets(50));

    Scene scene = new Scene(root, 600, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
}
 //changes color of answer buttons depending on correctness
private void handleAnswerButton4(ActionEvent event) {
    Label questionLabel = new Label();
    Button clickedButton = (Button) event.getSource();
    if (clickedButton.getText().equals("True")) {
        clickedButton.setStyle("-fx-font-size: 20px;-fx-background-color: green;-fx-font-weight: bold;");
        questionLabel.setText("Correct!");
    } else {
        clickedButton.setStyle("-fx-font-size: 18px;-fx-background-color: red;-fx-font-weight: bold;");
        questionLabel.setText("Incorrect");
    }
}

//section 1 level 1 question 3
private void showS1L1Q3Screen(Stage primaryStage) {
    // label
    Label S1L1ScreenLabel = new Label("Question 3");
    S1L1ScreenLabel.setFont(Font.font("Elephant", 30));
    S1L1ScreenLabel.setAlignment(Pos.TOP_CENTER);
    S1L1ScreenLabel.setTextFill(Color.DARKBLUE);

    // label for question
    Text questionLabel = new Text("Up until how many decimal digits can float store?");
    questionLabel.setTextAlignment(TextAlignment.CENTER);
    questionLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-padding: 10px;");
    questionLabel.setFill(Color.DARKMAGENTA); 
    questionLabel.setWrappingWidth(440);

    // back button
    Button backButton = new Button("Back");
    backButton.setOnAction(event -> showFirstScreen(primaryStage));
    backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

    // answer buttons
    answerButtons = new Button[3];
    answerButtons[0] = new Button("6 to 7");
    answerButtons[1] = new Button("8 to 9");
    answerButtons[2] = new Button("10 to 11");

    // style of answer buttons
    for (Button button : answerButtons) {
        button.setStyle("-fx-background-color: lightgray; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 10px;");
        button.setOnAction(this::handleAnswerButton5);
    }

    // vbox for labels, answer buttons, and back button
    VBox S1L1ScreenBox = new VBox(40, S1L1ScreenLabel, questionLabel, backButton);
    S1L1ScreenBox.setAlignment(Pos.TOP_CENTER);

    HBox buttonBox = new HBox(5, answerButtons[0], answerButtons[1], answerButtons[2]);
    buttonBox.setAlignment(Pos.BOTTOM_CENTER);

    S1L1ScreenBox.getChildren().add(1, buttonBox);

    BorderPane root = new BorderPane();
    root.setCenter(S1L1ScreenBox);
    BorderPane.setMargin(S1L1ScreenBox, new Insets(50));

    Scene scene = new Scene(root, 600, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
}

// changes color depending on correctness
private void handleAnswerButton5(ActionEvent event) {
    Label questionLabel = new Label();
    Button clickedButton = (Button) event.getSource();
    if (clickedButton.getText().equals("6 to 7")) {
        clickedButton.setStyle("-fx-font-size: 20px;-fx-background-color: green;-fx-font-weight: bold;");
        questionLabel.setText("Correct!");
    } else {
        clickedButton.setStyle("-fx-font-size: 18px;-fx-background-color: red;-fx-font-weight: bold;");
        questionLabel.setText("Incorrect");
    }
}


    //section 1 level 2 question 1
    private void showS1L2Q1Screen(Stage primaryStage) {
        // label
        Label S1L3ScreenLabel = new Label("Question 1");
        S1L3ScreenLabel.setFont(Font.font("Elephant", 28));
        S1L3ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L3ScreenLabel.setTextFill(Color.DARKBLUE);

        Text questionLabel = new Text("Char stores a ______ character or letter");
        questionLabel.setStyle("-fx-font-size: 30px; -fx-text-fill: darkmagenta; -fx-font-weight: bold; -fx-background-color: none;");
        questionLabel.setWrappingWidth(440); 
        questionLabel.setTextAlignment(TextAlignment.CENTER); 
        questionLabel.setFill(Color.DARKMAGENTA); 
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showFirstScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        TextField answerField = new TextField();
   
        // check button
        Button checkButton = new Button("Check");
        checkButton.setStyle("-fx-font-size: 14px");
        answerField.setStyle("-fx-font-size: 14px");
        checkButton.setOnAction(event -> checkAnswer(answerField.getText(), checkButton));
   
         //next button
         Button nextButton = new Button("Next Question ->");
         nextButton.setOnAction(event -> showS1L2Q2Screen(primaryStage));
         nextButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkorange; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
         nextButton.setAlignment(Pos.BOTTOM_CENTER);

        // hbox for answer field and check button
        HBox answerBox = new HBox(13, answerField, checkButton);
        answerBox.setAlignment(Pos.CENTER);
   
        // vbox for labels, and buttons
        VBox S1L3ScreenBox = new VBox(25, S1L3ScreenLabel, questionLabel, answerBox, nextButton, backButton);
        S1L3ScreenBox.setAlignment(Pos.TOP_CENTER);
   
        BorderPane root = new BorderPane();
        root.setCenter(S1L3ScreenBox);
        BorderPane.setMargin(S1L3ScreenBox, new Insets(50));
   
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    private void checkAnswer(String answer, Button checkButton) {
        if (answer.equalsIgnoreCase("single")) {
            // set check button color to green and update message
            checkButton.setStyle("-fx-background-color: green; -fx-font-size: 12pt");
            checkButton.setText("Correct!");
        } else {
            // set check button color to red and update message
            checkButton.setStyle("-fx-background-color: red; -fx-font-size: 12pt");
            checkButton.setText("Incorrect!");
        }
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            // reset the check button after 2 sec
            checkButton.setText("Check");
            checkButton.setStyle("-fx-background-color:lightgray; -fx-font-size: 12pt");
        });
        pause.play();
    }
   
    //section 1 level 2 question 2

    private void showS1L2Q2Screen(Stage primaryStage) {
        // label
        Label S1L3ScreenLabel = new Label("Question 2");
        S1L3ScreenLabel.setFont(Font.font("Elephant", 28));
        S1L3ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L3ScreenLabel.setTextFill(Color.DARKBLUE);

        //question text
        Text questionLabel = new Text("When using fractional numbers the data type ____ is used");
        questionLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: none;");
        questionLabel.setWrappingWidth(440); 
        questionLabel.setTextAlignment(TextAlignment.CENTER); 
        questionLabel.setFill(Color.DARKMAGENTA); 

        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showFirstScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        TextField answerField = new TextField();
   
        // check button
        Button checkButton = new Button("Check");
        checkButton.setOnAction(event -> checkAnswer2(answerField.getText(), checkButton));
        checkButton.setStyle("-fx-font-size: 14px");
        answerField.setStyle("-fx-font-size: 14px");
   
         //next button
         Button nextButton = new Button("Next Question ->");
         nextButton.setOnAction(event -> showS1L2Q3Screen(primaryStage));
         nextButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkorange; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        // hbox for answer field and check button
        HBox answerBox = new HBox(13, answerField, checkButton);
        answerBox.setAlignment(Pos.CENTER);
   
        // vbox for labels, answer box, and back button
        VBox S1L3ScreenBox = new VBox(26, S1L3ScreenLabel, questionLabel, answerBox, nextButton, backButton);
        S1L3ScreenBox.setAlignment(Pos.TOP_CENTER);
   
        // border pane to hold the VBox
        BorderPane root = new BorderPane();
        root.setCenter(S1L3ScreenBox);
        BorderPane.setMargin(S1L3ScreenBox, new Insets(50));
   
        // create tab
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    private void checkAnswer2(String answer, Button checkButton) {
        if (answer.equalsIgnoreCase("double")) {
            // set check button color to green and update message
            checkButton.setStyle("-fx-background-color: green; -fx-font-size: 12pt");
            checkButton.setText("Correct!");
        } else {
            // set check button color to red and update message
            checkButton.setStyle("-fx-background-color: red; -fx-font-size: 12pt");
            checkButton.setText("Incorrect!");
        }
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            // reset the check button after 2 sec
            checkButton.setText("Check");
            checkButton.setStyle("-fx-background-color:lightgray; -fx-font-size: 12pt");
        });
        pause.play();
    }

    //section 1 level 2 question 3

     private void showS1L2Q3Screen(Stage primaryStage) {
        // label
        Label S1L3ScreenLabel = new Label("Question 3");
        S1L3ScreenLabel.setFont(Font.font("Elephant", 28));
        S1L3ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L3ScreenLabel.setTextFill(Color.DARKBLUE);

        Text questionLabel = new Text("Long/short both store ______________ numbers");
        questionLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: none;");
        questionLabel.setWrappingWidth(440); 
        questionLabel.setTextAlignment(TextAlignment.CENTER); 
        questionLabel.setFill(Color.DARKMAGENTA); 
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showFirstScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        TextField answerField = new TextField();
   
        // check button
        Button checkButton = new Button("Check");
        checkButton.setOnAction(event -> checkAnswer3(answerField.getText(), checkButton));
        checkButton.setStyle("-fx-font-size: 14px");
        answerField.setStyle("-fx-font-size: 14px");
   
        HBox answerBox = new HBox(13, answerField, checkButton);
        answerBox.setAlignment(Pos.CENTER);
   
        VBox S1L3ScreenBox = new VBox(40, S1L3ScreenLabel, questionLabel, answerBox, backButton);
        S1L3ScreenBox.setAlignment(Pos.TOP_CENTER);
   
        BorderPane root = new BorderPane();
        root.setCenter(S1L3ScreenBox);
        BorderPane.setMargin(S1L3ScreenBox, new Insets(50));
   
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    private void checkAnswer3(String answer, Button checkButton) {
        if (answer.equalsIgnoreCase("whole")) {
            // set check button color to green and update message
            checkButton.setStyle("-fx-background-color: green; -fx-font-size: 12pt");
            checkButton.setText("Correct!");
        } else {
            // set check button color to red and update message
            checkButton.setStyle("-fx-background-color: red; -fx-font-size: 12pt");
            checkButton.setText("Incorrect!");
        }

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            // reset the check button after 2 sec
            checkButton.setText("Check");
            checkButton.setStyle("-fx-background-color:lightgray; -fx-font-size: 12pt");
        });
        pause.play();
    }
    //section 2 level 1 question 1
    private void showS2L1Q1Screen(Stage primaryStage) {
        // label
        Label S2L1ScreenLabel = new Label("Question 1");
        S2L1ScreenLabel.setFont(Font.font("Elephant", 28));
        S2L1ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S2L1ScreenLabel.setTextFill(Color.DARKBLUE);
   
        // label for question
        Text questionLabel = new Text("What loop is used when you know how many times you want to loop through a code block?");
        questionLabel.setTextAlignment(TextAlignment.CENTER);
        questionLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-padding: 10px;");
        questionLabel.setFill(Color.DARKMAGENTA); 
        questionLabel.setWrappingWidth(485);
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showSecondScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
   
        // answer buttons
        answerButtons = new Button[3];
        answerButtons[0] = new Button("if..else");
        answerButtons[1] = new Button("for");
        answerButtons[2] = new Button("while");

         //next button
         Button nextButton = new Button("Next Question ->");
         nextButton.setOnAction(event -> showS2L1Q2Screen(primaryStage));
         nextButton.setStyle("-fx-font-size: 20px; -fx-text-fill: seagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
         nextButton.setAlignment(Pos.BOTTOM_CENTER);
   
        // style of answer buttons
        for (Button button : answerButtons) {
            button.setStyle("-fx-background-color: lightgray; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 10px;");
            button.setOnAction(this::handleAnswerButton3);
        }
   
        // vbox 
        VBox S2L1ScreenBox = new VBox(24, S2L1ScreenLabel, questionLabel, nextButton, backButton);
        S2L1ScreenBox.setAlignment(Pos.TOP_CENTER);
   
        HBox buttonBox = new HBox(5, answerButtons[0], answerButtons[1], answerButtons[2]);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
   
        S2L1ScreenBox.getChildren().add(1, buttonBox);
   
        BorderPane root = new BorderPane();
        root.setCenter(S2L1ScreenBox);
        BorderPane.setMargin(S2L1ScreenBox, new Insets(50));
   
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    private void handleAnswerButton3(ActionEvent event) {
        Label questionLabel = new Label();
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("for")) {
            clickedButton.setStyle("-fx-font-size: 20px;-fx-background-color: green;-fx-font-weight: bold;");
            questionLabel.setText("Correct!");
        } else {
            clickedButton.setStyle("-fx-font-size: 18px;-fx-background-color: red;-fx-font-weight: bold;");
            questionLabel.setText("Incorrect");
        }
    }

    //section 2 level 1 question 2
    private void showS2L1Q2Screen(Stage primaryStage) {
        // label
        Label S2L1ScreenLabel = new Label("Question 2");
        S2L1ScreenLabel.setFont(Font.font("Elephant", 28));
        S2L1ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S2L1ScreenLabel.setTextFill(Color.DARKBLUE);
   
        // label for question
        Text questionLabel = new Text("'Switch' specifies how many alternative blocks of code to be executed?");
        questionLabel.setTextAlignment(TextAlignment.CENTER);
        questionLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-padding: 10px;");
        questionLabel.setFill(Color.DARKMAGENTA); 
        questionLabel.setWrappingWidth(480);
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showSecondScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
   
        // answer buttons
        answerButtons = new Button[3];
        answerButtons[0] = new Button("one maximum");
        answerButtons[1] = new Button("five maximum");
        answerButtons[2] = new Button("no maximum");
   
         //next button
         Button nextButton = new Button("Next Question ->");
         nextButton.setOnAction(event -> showS2L1Q3Screen(primaryStage));
         nextButton.setStyle("-fx-font-size: 20px; -fx-text-fill: seagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
         nextButton.setAlignment(Pos.BOTTOM_CENTER);

        // style of answer buttons
        for (Button button : answerButtons) {
            button.setStyle("-fx-background-color: lightgray; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 10px;");
            button.setOnAction(this::handleAnswerButton6);
        }
   
        // vbox 
        VBox S2L1ScreenBox = new VBox(23, S2L1ScreenLabel, questionLabel, nextButton, backButton);
        S2L1ScreenBox.setAlignment(Pos.TOP_CENTER);
   
        HBox buttonBox = new HBox(5, answerButtons[0], answerButtons[1], answerButtons[2]);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        S2L1ScreenBox.getChildren().add(1, buttonBox);

        BorderPane root = new BorderPane();
        root.setCenter(S2L1ScreenBox);
        BorderPane.setMargin(S2L1ScreenBox, new Insets(50));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    private void handleAnswerButton6(ActionEvent event) {
        Label questionLabel = new Label();
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("no maximum")) {
            clickedButton.setStyle("-fx-font-size: 20px;-fx-background-color: green;-fx-font-weight: bold;");
            questionLabel.setText("Correct!");
        } else {
            clickedButton.setStyle("-fx-font-size: 18px;-fx-background-color: red;-fx-font-weight: bold;");
            questionLabel.setText("Incorrect");
        }
    }
   
    //section 2 level 1 question 3
    private void showS2L1Q3Screen(Stage primaryStage) {
        // label
        Label S2L1ScreenLabel = new Label("Question 3");
        S2L1ScreenLabel.setFont(Font.font("Elephant", 28));
        S2L1ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S2L1ScreenLabel.setTextFill(Color.DARKBLUE);
   
        // label for question
        Text questionLabel = new Text("This loop loops through a block of code as long as a specified condition is true");
        questionLabel.setTextAlignment(TextAlignment.CENTER);
        questionLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-padding: 10px;");
        questionLabel.setFill(Color.DARKMAGENTA); 
        questionLabel.setWrappingWidth(485);
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showSecondScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
   
        // answer buttons
        answerButtons = new Button[3];
        answerButtons[0] = new Button("for");
        answerButtons[1] = new Button("while");
        answerButtons[2] = new Button("if...else");

        // style of answer buttons 
        for (Button button : answerButtons) {
            button.setStyle("-fx-background-color: lightgray; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 10px;");
            button.setOnAction(this::handleAnswerButton7);
        }
   
        VBox S2L1ScreenBox = new VBox(30, S2L1ScreenLabel, questionLabel, backButton);
        S2L1ScreenBox.setAlignment(Pos.TOP_CENTER);
   
        HBox buttonBox = new HBox(5, answerButtons[0], answerButtons[1], answerButtons[2]);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        S2L1ScreenBox.getChildren().add(1, buttonBox);

        BorderPane root = new BorderPane();
        root.setCenter(S2L1ScreenBox);
        BorderPane.setMargin(S2L1ScreenBox, new Insets(50));
   
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    private void handleAnswerButton7(ActionEvent event) {
        Label questionLabel = new Label();
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("while")) {
            clickedButton.setStyle("-fx-font-size: 20px;-fx-background-color: green;-fx-font-weight: bold;");
            questionLabel.setText("Correct!");
        } else {
            clickedButton.setStyle("-fx-font-size: 18px;-fx-background-color: red;-fx-font-weight: bold;");
            questionLabel.setText("Incorrect");
        }
    }
   
    //section 2 level 2 question 1
    private void showS2L2Q1Screen(Stage primaryStage) {
        // label
        Label S1L3ScreenLabel = new Label("Question 1");
        S1L3ScreenLabel.setFont(Font.font("Elephant", 28));
        S1L3ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L3ScreenLabel.setTextFill(Color.DARKBLUE);

        //label for question
        Text questionLabel = new Text("Arrays are used to store multiple values in a _________ variable");
        questionLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: none;");
        questionLabel.setWrappingWidth(440); 
        questionLabel.setTextAlignment(TextAlignment.CENTER); 
        questionLabel.setFill(Color.DARKMAGENTA); 
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showSecondScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        TextField answerField = new TextField();
   
        // check button
        Button checkButton = new Button("Check");
        checkButton.setOnAction(event -> checkAnswer4(answerField.getText(), checkButton));
        checkButton.setStyle("-fx-font-size: 14px");
        answerField.setStyle("-fx-font-size: 14px");

         //next button
         Button nextButton = new Button("Next Question ->");
         nextButton.setOnAction(event -> showS2L2Q2Screen(primaryStage));
         nextButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkorange; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
         nextButton.setAlignment(Pos.BOTTOM_CENTER);
 
        HBox answerBox = new HBox(10, answerField, checkButton);
        answerBox.setAlignment(Pos.CENTER);
   
        VBox S1L3ScreenBox = new VBox(26, S1L3ScreenLabel, questionLabel, answerBox, nextButton, backButton);
        S1L3ScreenBox.setAlignment(Pos.TOP_CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(S1L3ScreenBox);
        BorderPane.setMargin(S1L3ScreenBox, new Insets(50));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void checkAnswer4(String answer, Button checkButton) {
        if (answer.equalsIgnoreCase("single")) {
            // set check button color to green and update message
            checkButton.setStyle("-fx-background-color: green; -fx-font-size: 12pt");
            checkButton.setText("Correct!");
        } else {
            // set check button color to red and update message
            checkButton.setStyle("-fx-background-color: red; -fx-font-size: 12pt");
            checkButton.setText("Incorrect!");
        }
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                // reset the check button after 2 sec
                checkButton.setText("Check");
                checkButton.setStyle("-fx-background-color:lightgray; -fx-font-size: 12pt");
            });
            pause.play();
    }

    //section 2 level 2 question 2
    private void showS2L2Q2Screen(Stage primaryStage) {
        // label
        Label S1L3ScreenLabel = new Label("Question 2");
        S1L3ScreenLabel.setFont(Font.font("Elephant", 30));
        S1L3ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L3ScreenLabel.setTextFill(Color.DARKBLUE);

        //label for question
        Text questionLabel = new Text("if is used to execute a block of code if condition is ___________");
        questionLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: none;");
        questionLabel.setWrappingWidth(440); 
        questionLabel.setTextAlignment(TextAlignment.CENTER); 
        questionLabel.setFill(Color.DARKMAGENTA); 
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showSecondScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        TextField answerField = new TextField();
   
        // check button
        Button checkButton = new Button("Check");
        checkButton.setOnAction(event -> checkAnswer5(answerField.getText(), checkButton));
        checkButton.setStyle("-fx-font-size: 14px");
        answerField.setStyle("-fx-font-size: 14px");
   
         //next button
         Button nextButton = new Button("Next Question ->");
         nextButton.setOnAction(event -> showS2L2Q3Screen(primaryStage));
         nextButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkorange; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
         nextButton.setAlignment(Pos.BOTTOM_CENTER);

        HBox answerBox = new HBox(10, answerField, checkButton);
        answerBox.setAlignment(Pos.CENTER);

        VBox S1L3ScreenBox = new VBox(26, S1L3ScreenLabel, questionLabel, answerBox, nextButton, backButton);
        S1L3ScreenBox.setAlignment(Pos.TOP_CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(S1L3ScreenBox);
        BorderPane.setMargin(S1L3ScreenBox, new Insets(50));
   
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void checkAnswer5(String answer, Button checkButton) {
        if (answer.equalsIgnoreCase("true")) {
            // set check button color to green and update message
            checkButton.setStyle("-fx-background-color: green; -fx-font-size: 12pt");
            checkButton.setText("Correct!");
        } else {
            // set check button color to red and update message
            checkButton.setStyle("-fx-background-color: red; -fx-font-size: 12pt");
            checkButton.setText("Incorrect!");
        }
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                // reset the check button after 2 sec
                checkButton.setText("Check");
                checkButton.setStyle("-fx-background-color:lightgray; -fx-font-size: 12pt");
            });
            pause.play();
    }

     //section 2 level 2 question 3
     private void showS2L2Q3Screen(Stage primaryStage) {
        // Create a label for the first screen
        Label S1L3ScreenLabel = new Label("Question 3");
        S1L3ScreenLabel.setFont(Font.font("Elephant", 30));
        S1L3ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L3ScreenLabel.setTextFill(Color.DARKBLUE);

        Text questionLabel = new Text("else if specifies a new condition only if the previous condition was __________");
        questionLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: none;");
        questionLabel.setWrappingWidth(440); 
        questionLabel.setTextAlignment(TextAlignment.CENTER); 
        questionLabel.setFill(Color.DARKMAGENTA); 
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showSecondScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        TextField answerField = new TextField();
   
        // check button
        Button checkButton = new Button("Check");
        checkButton.setOnAction(event -> checkAnswer6(answerField.getText(), checkButton));
        checkButton.setStyle("-fx-font-size: 14px");
        answerField.setStyle("-fx-font-size: 14px");
 
        HBox answerBox = new HBox(10, answerField, checkButton);
        answerBox.setAlignment(Pos.CENTER);
   
        VBox S1L3ScreenBox = new VBox(38, S1L3ScreenLabel, questionLabel, answerBox, backButton);
        S1L3ScreenBox.setAlignment(Pos.TOP_CENTER);
   
        BorderPane root = new BorderPane();
        root.setCenter(S1L3ScreenBox);
        BorderPane.setMargin(S1L3ScreenBox, new Insets(50));
   
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void checkAnswer6(String answer, Button checkButton) {
        if (answer.equalsIgnoreCase("false")) {
            // set check button color to green and update message
            checkButton.setStyle("-fx-background-color: green; -fx-font-size: 12pt");
            checkButton.setText("Correct!");
        } else {
            // set check button color to red and update message
            checkButton.setStyle("-fx-background-color: red; -fx-font-size: 12pt");
            checkButton.setText("Incorrect!");
        }
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                // reset the check button after 2 sec
                checkButton.setText("Check");
                checkButton.setStyle("-fx-background-color:lightgray; -fx-font-size: 12pt");
            });
            pause.play();
    }
   
    //section 3 level 1 question 1
    private void showS3L1Q1Screen(Stage primaryStage) {
        // label
        Label S2L1ScreenLabel = new Label("Question 1");
        S2L1ScreenLabel.setFont(Font.font("Elephant", 28));
        S2L1ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S2L1ScreenLabel.setTextFill(Color.DARKBLUE);
   
        // label for question
        Text questionLabel = new Text("The code is accessible for all classes when it is");
        questionLabel.setTextAlignment(TextAlignment.CENTER);
        questionLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-padding: 10px;");
        questionLabel.setFill(Color.DARKMAGENTA); 
        questionLabel.setWrappingWidth(480);
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showThirdScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
   
         //next button
         Button nextButton = new Button("Next Question ->");
         nextButton.setOnAction(event -> showS3L1Q2Screen(primaryStage));
         nextButton.setStyle("-fx-font-size: 20px; -fx-text-fill: seagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
         nextButton.setAlignment(Pos.BOTTOM_CENTER);

        // answer buttons
        answerButtons = new Button[3];
        answerButtons[0] = new Button("public");
        answerButtons[1] = new Button("private");
        answerButtons[2] = new Button("static");
   
        // style of buttons
        for (Button button : answerButtons) {
            button.setStyle("-fx-background-color: lightgray; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 10px;");
            button.setOnAction(this::handleAnswerButton8);
        }
   
        VBox S2L1ScreenBox = new VBox(25, S2L1ScreenLabel, questionLabel, nextButton, backButton);
        S2L1ScreenBox.setAlignment(Pos.TOP_CENTER);
   
        HBox buttonBox = new HBox(5, answerButtons[0], answerButtons[1], answerButtons[2]);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        S2L1ScreenBox.getChildren().add(1, buttonBox);
   
        BorderPane root = new BorderPane();
        root.setCenter(S2L1ScreenBox);
        BorderPane.setMargin(S2L1ScreenBox, new Insets(50));
   
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    private void handleAnswerButton8(ActionEvent event) {
        Label questionLabel = new Label();
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("public")) {
            clickedButton.setStyle("-fx-font-size: 20px;-fx-background-color: green;-fx-font-weight: bold;");
            questionLabel.setText("Correct!");
        } else {
            clickedButton.setStyle("-fx-font-size: 18px;-fx-background-color: red;-fx-font-weight: bold;");
            questionLabel.setText("Incorrect");
        }
    }

    //section 3 level 1 question 2
    private void showS3L1Q2Screen(Stage primaryStage) {
        // label 
        Label S2L1ScreenLabel = new Label("Question 2");
        S2L1ScreenLabel.setFont(Font.font("Elephant", 28));
        S2L1ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S2L1ScreenLabel.setTextFill(Color.DARKBLUE);
   
        // label for question
        Text questionLabel = new Text("When there is no modifier, the code cannot be accessed to");
        questionLabel.setTextAlignment(TextAlignment.CENTER);
        questionLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-padding: 10px;");
        questionLabel.setFill(Color.DARKMAGENTA); 
        questionLabel.setWrappingWidth(480);
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showThirdScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
   
        // answer buttons
        answerButtons = new Button[3];
        answerButtons[0] = new Button("subclass");
        answerButtons[1] = new Button("class");
        answerButtons[2] = new Button("method");

         //next button
         Button nextButton = new Button("Next Question ->");
         nextButton.setOnAction(event -> showS3L1Q3Screen(primaryStage));
         nextButton.setStyle("-fx-font-size: 20px; -fx-text-fill: seagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
         nextButton.setAlignment(Pos.BOTTOM_CENTER);
   
        // style of buttons
        for (Button button : answerButtons) {
            button.setStyle("-fx-background-color: lightgray; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 10px;");
            button.setOnAction(this::handleAnswerButton9);
        }
   
        VBox S2L1ScreenBox = new VBox(25, S2L1ScreenLabel, questionLabel, nextButton, backButton);
        S2L1ScreenBox.setAlignment(Pos.TOP_CENTER);
   
        HBox buttonBox = new HBox(5, answerButtons[0], answerButtons[1], answerButtons[2]);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
   
        S2L1ScreenBox.getChildren().add(1, buttonBox);
   
        BorderPane root = new BorderPane();
        root.setCenter(S2L1ScreenBox);
        BorderPane.setMargin(S2L1ScreenBox, new Insets(50));
   
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    private void handleAnswerButton9(ActionEvent event) {
        Label questionLabel = new Label();
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("subclass")) {
            clickedButton.setStyle("-fx-font-size: 20px;-fx-background-color: green;-fx-font-weight: bold;");
            questionLabel.setText("Correct!");
        } else {
            clickedButton.setStyle("-fx-font-size: 18px;-fx-background-color: red;-fx-font-weight: bold;");
            questionLabel.setText("Incorrect");
        }
    }
   
    //section 3 level 1 question 3
    private void showS3L1Q3Screen(Stage primaryStage) {
        // label
        Label S2L1ScreenLabel = new Label("Question 3");
        S2L1ScreenLabel.setFont(Font.font("Elephant", 28));
        S2L1ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S2L1ScreenLabel.setTextFill(Color.DARKBLUE);
   
        // label for question
        Text questionLabel = new Text("When the code is accessible in the same package and subclass it is");
        questionLabel.setTextAlignment(TextAlignment.CENTER);
        questionLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-padding: 10px;");
        questionLabel.setFill(Color.DARKMAGENTA); 
        questionLabel.setWrappingWidth(480);
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showThirdScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
   
        // answer buttons
        answerButtons = new Button[3];
        answerButtons[0] = new Button("protected");
        answerButtons[1] = new Button("public");
        answerButtons[2] = new Button("private");
   
        // style of buttons
        for (Button button : answerButtons) {
            button.setStyle("-fx-background-color: lightgray; -fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 10px;");
            button.setOnAction(this::handleAnswerButton10);
        }
   
        VBox S2L1ScreenBox = new VBox(35, S2L1ScreenLabel, questionLabel, backButton);
        S2L1ScreenBox.setAlignment(Pos.TOP_CENTER);
   
        HBox buttonBox = new HBox(5, answerButtons[0], answerButtons[1], answerButtons[2]);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        S2L1ScreenBox.getChildren().add(1, buttonBox);

        BorderPane root = new BorderPane();
        root.setCenter(S2L1ScreenBox);
        BorderPane.setMargin(S2L1ScreenBox, new Insets(50));
  
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    private void handleAnswerButton10(ActionEvent event) {
        Label questionLabel = new Label();
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("protected")) {
            clickedButton.setStyle("-fx-font-size: 20px;-fx-background-color: green;-fx-font-weight: bold;");
            questionLabel.setText("Correct!");
        } else {
            clickedButton.setStyle("-fx-font-size: 18px;-fx-background-color: red;-fx-font-weight: bold;");
            questionLabel.setText("Incorrect");
        }
    }
   
    //section 3 level 2 question 1
    private void showS3L2Q1Screen(Stage primaryStage) {
        // label
        Label S1L3ScreenLabel = new Label("Question 1");
        S1L3ScreenLabel.setFont(Font.font("Elephant", 28));
        S1L3ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L3ScreenLabel.setTextFill(Color.DARKBLUE);

        // label for question
        Text questionLabel = new Text("fields and methods cannot be overridden in a ________ class");
        questionLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: none;");
        questionLabel.setWrappingWidth(440); 
        questionLabel.setTextAlignment(TextAlignment.CENTER); 
        questionLabel.setFill(Color.DARKMAGENTA); 
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showThirdScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        TextField answerField = new TextField();
   
        // check button
        Button checkButton = new Button("Check");
        checkButton.setOnAction(event -> checkAnswer7(answerField.getText(), checkButton));
        checkButton.setStyle("-fx-font-size: 14px");
        answerField.setStyle("-fx-font-size: 14px");
   
         //next button
         Button nextButton = new Button("Next Question ->");
         nextButton.setOnAction(event -> showS3L2Q2Screen(primaryStage));
         nextButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkorange; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
         nextButton.setAlignment(Pos.BOTTOM_CENTER);

        HBox answerBox = new HBox(10, answerField, checkButton);
        answerBox.setAlignment(Pos.CENTER);

        VBox S1L3ScreenBox = new VBox(26, S1L3ScreenLabel, questionLabel, answerBox, nextButton, backButton);
        S1L3ScreenBox.setAlignment(Pos.TOP_CENTER);
   
        BorderPane root = new BorderPane();
        root.setCenter(S1L3ScreenBox);
        BorderPane.setMargin(S1L3ScreenBox, new Insets(50));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void checkAnswer7(String answer, Button checkButton) {
        if (answer.equalsIgnoreCase("final")) {
            // set check button color to green and update message
            checkButton.setStyle("-fx-background-color: green; -fx-font-size: 12pt");
            checkButton.setText("Correct!");
        } else {
            // set check button color to red and update message
            checkButton.setStyle("-fx-background-color: red; -fx-font-size: 12pt");
            checkButton.setText("Incorrect!");
        }
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                // reset the check button after 2 sec
                checkButton.setText("Check");
                checkButton.setStyle("-fx-background-color:lightgray; -fx-font-size: 12pt");
            });
            pause.play();
    }

    //section 3 level 2 question 2
    private void showS3L2Q2Screen(Stage primaryStage) {
        // label
        Label S1L3ScreenLabel = new Label("Question 2");
        S1L3ScreenLabel.setFont(Font.font("Elephant", 28));
        S1L3ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L3ScreenLabel.setTextFill(Color.DARKBLUE);

        //label for question
        Text questionLabel = new Text("When the code is only accessible to a declared class it is _____________");
        questionLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: none;");
        questionLabel.setWrappingWidth(440); 
        questionLabel.setTextAlignment(TextAlignment.CENTER); 
        questionLabel.setFill(Color.DARKMAGENTA); 
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showThirdScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        TextField answerField = new TextField();
   
        // check button
        Button checkButton = new Button("Check");
        checkButton.setOnAction(event -> checkAnswer8(answerField.getText(), checkButton));
        checkButton.setStyle("-fx-font-size: 14px");
        answerField.setStyle("-fx-font-size: 14px");
   
         //next button
         Button nextButton = new Button("Next Question ->");
         nextButton.setOnAction(event -> showS3L2Q3Screen(primaryStage));
         nextButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkorange; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
         nextButton.setAlignment(Pos.BOTTOM_CENTER);

        HBox answerBox = new HBox(10, answerField, checkButton);
        answerBox.setAlignment(Pos.CENTER);
   
        VBox S1L3ScreenBox = new VBox(26, S1L3ScreenLabel, questionLabel, answerBox, nextButton, backButton);
        S1L3ScreenBox.setAlignment(Pos.TOP_CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(S1L3ScreenBox);
        BorderPane.setMargin(S1L3ScreenBox, new Insets(50));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void checkAnswer8(String answer, Button checkButton) {
        if (answer.equalsIgnoreCase("private")) {
            // set check button color to green and update message
            checkButton.setStyle("-fx-background-color: green; -fx-font-size: 12pt");
            checkButton.setText("Correct!");
        } else {
            // set check button color to red and update message
            checkButton.setStyle("-fx-background-color: red; -fx-font-size: 12pt");
            checkButton.setText("Incorrect!");
        }
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                // reset the check button after 2 sec
                checkButton.setText("Check");
                checkButton.setStyle("-fx-background-color:lightgray; -fx-font-size: 12pt");
            });
            pause.play();
    }

     //section 3 level 2 question 3
     private void showS3L2Q3Screen(Stage primaryStage) {
        // label
        Label S1L3ScreenLabel = new Label("Question 3");
        S1L3ScreenLabel.setFont(Font.font("Elephant", 28));
        S1L3ScreenLabel.setAlignment(Pos.TOP_CENTER);
        S1L3ScreenLabel.setTextFill(Color.DARKBLUE);

        // label for question
        Text questionLabel = new Text("fields and methods belong to the class not the object when it is _______");
        questionLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: none;");
        questionLabel.setWrappingWidth(440); 
        questionLabel.setTextAlignment(TextAlignment.CENTER); 
        questionLabel.setFill(Color.DARKMAGENTA); 
   
        // back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> showThirdScreen(primaryStage));
        backButton.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        Button completeButton = new Button("COMPLETE!");
        completeButton.setOnAction(event -> showCertificateScreen(primaryStage));
        completeButton.setStyle("-fx-font-size: 22px; -fx-text-fill: seagreen; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");

        TextField answerField = new TextField();
   
        // check button
        Button checkButton = new Button("Check");
        checkButton.setOnAction(event -> checkAnswer9(answerField.getText(), checkButton));
        checkButton.setStyle("-fx-font-size: 14px");
        answerField.setStyle("-fx-font-size: 14px");

        HBox answerBox = new HBox(10, answerField, checkButton);
        answerBox.setAlignment(Pos.CENTER);

        HBox completeBox = new HBox(30, backButton, completeButton);
        completeBox.setAlignment(Pos.CENTER);
   
        VBox S1L3ScreenBox = new VBox(30, S1L3ScreenLabel, questionLabel, answerBox, completeBox);
        S1L3ScreenBox.setAlignment(Pos.TOP_CENTER);
  
        BorderPane root = new BorderPane();
        root.setCenter(S1L3ScreenBox);
        BorderPane.setMargin(S1L3ScreenBox, new Insets(50));
   
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void checkAnswer9(String answer, Button checkButton) {
        if (answer.equalsIgnoreCase("static")) {
            // set check button color to green and update message
            checkButton.setStyle("-fx-background-color: green; -fx-font-size: 12pt");
            checkButton.setText("Correct!");
        } else {
            // set check button color to red and update message
            checkButton.setStyle("-fx-background-color: red; -fx-font-size: 12pt");
            checkButton.setText("Incorrect!");
        }
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                // reset the check button after 2 sec
                checkButton.setText("Check");
                checkButton.setStyle("-fx-background-color:lightgray; -fx-font-size: 12pt");
            });
            pause.play();       
        }

        private void showCertificateScreen(Stage primaryStage) {
            Label certificateScreen = new Label("WOOHOO!!");
            certificateScreen.setFont(Font.font("Elephant", 45));
            certificateScreen.setTextFill(Color.SLATEBLUE);
            certificateScreen.setAlignment(Pos.TOP_CENTER);;
        
            Button backButton = new Button("Return To Start");
            backButton.setOnAction(event -> showWelcomeScreen(primaryStage));
            backButton.setStyle("-fx-font-size: 22px; -fx-text-fill: darkblue; -fx-font-weight: bold; -fx-background-color: none; -fx-padding: 10px;-fx-underline: true;");
        
            Text congratsText = new Text("Congrats! You completed CODE MODE! You're ready to make your own ideas come to life!");
            congratsText.setStyle("-fx-font-size: 26px; -fx-text-fill: darkmagenta; -fx-font-weight: bold; -fx-background-color: none;");
            congratsText.setFill(Color.DARKMAGENTA);
            congratsText.setWrappingWidth(480);
            congratsText.setTextAlignment(TextAlignment.CENTER);
        
            Image image = new Image("file:C:/Users/miran/Desktop/crown/crown.png");
            ImageView imageView = new ImageView(image);
            imageView.setStyle("-fx-background-color: null;");
            imageView.setLayoutX(300);
            imageView.setLayoutY(200);
            imageView.setFitWidth(250);
            imageView.setFitHeight(90);
        
            TranslateTransition transition = new TranslateTransition(Duration.seconds(2), imageView);
            transition.setToY(25); // Update Y position to -100
            transition.setInterpolator(Interpolator.EASE_OUT); // Use EASE_OUT interpolator
            transition.play();
        
            VBox directionsBox = new VBox(20, imageView, certificateScreen, congratsText, backButton);
            directionsBox.setAlignment(Pos.TOP_CENTER);
        
            BorderPane directionsRoot = new BorderPane();
            directionsRoot.setCenter(directionsBox);
            BorderPane.setMargin(directionsBox, new Insets(50));
        
            Scene directionsScene = new Scene(directionsRoot, 600, 400);
            primaryStage.setScene(directionsScene);
        }
    
    public static void main(String[] args) {
        launch(args);
    }
}




//  movement of a picture
//         Image image = new Image("file:C:/Users/miran/Pictures/bing/bingus.png");
//         // make the image in the scene
//         ImageView imageView = new ImageView(image);
//         imageView.setLayoutX(300);
//         imageView.setLayoutY(100);
//         imageView.setFitWidth(100);
//         imageView.setFitHeight(100);
//         // adding image to vbox
//         welcomeBox.getChildren().add(imageView);

//         // Create a translate transition to move the image
//         TranslateTransition transition = new TranslateTransition(Duration.seconds(3), imageView);
//         transition.setToX(10);
//         transition.setToY(-50);
//         transition.play();  


// adding a picture 
 //adding a picture
//  Image image = new Image("file:C:/Users/miran/Pictures/bing/bingus.png");
//  // make the image in the scene
//  ImageView imageView = new ImageView(image);
//  imageView.setLayoutX(300);
//  imageView.setLayoutY(100);
//  imageView.setFitWidth(100);
//  imageView.setFitHeight(100);
//vbox; imageView