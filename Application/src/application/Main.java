package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Main extends Application {
	public Label label1;
	public Label label2;
	public Label label3;
	public Label label4;
	public TextField caloriesField;
	public ChoiceBox<String> choices;
	public RadioButton r1;
	public RadioButton r2;
	public RadioButton r3;
	public ToggleGroup group;
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Scene scene = new Scene(root,438,233);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			label1 = new Label("Enter calories");
			label2 = new Label("Choose a season");
			label3 = new Label("Choose your gender");
			label4 = new Label("How it works?");
			label4.setPrefHeight(15.2);
			label4.setPrefWidth(62.4);
			label4.relocate(357, 197);
			label4.setFont(new Font("Tahoma", 10));
			group = new ToggleGroup();
			r1 = new RadioButton("Male");
			r2 = new RadioButton("Female");
			r3 = new RadioButton("Other");
			r1.setToggleGroup(group);
			r1.setSelected(true);
			r2.setToggleGroup(group);
			r3.setToggleGroup(group);
			caloriesField = new TextField();
			choices = new ChoiceBox<String>();
			choices.getItems().add("Winter");
			choices.getItems().add("Summer");
			choices.getItems().add("Spring");
			choices.getItems().add("Autumn");
			label1.relocate(14, 16.9);
			label2.relocate(238, 16.9);
			label2.setFont(new Font("Tahoma", 18));
			label2.setTextFill(Color.web("bc4444"));
			label1.setFont(new Font("Tahoma", 18));
			label3.relocate(14, 104);
			label1.setTextFill(Color.web("bc4444"));
			label3.setFont(new Font("Tahoma", 18));
			label3.setTextFill(Color.web("bc4444"));
			caloriesField.relocate(14, 49);
			choices.relocate(238, 49);
			choices.setPrefWidth(138);
			choices.setPrefHeight(26);
			r1.relocate(14, 146);
			r2.relocate(85, 146);
			r3.relocate(168, 146);
			Button button = new Button("Submit");
			button.relocate(14, 192);
			button.setOnAction(e->CreateMenu(primaryStage, scene));
			primaryStage.setTitle("Vegetarian menu maker");
			Image icon = new Image("icon.jpg");
			primaryStage.getIcons().add(icon);
			primaryStage.setResizable(false);
			label4.setTooltip(new Tooltip("This JAVAFX app allows to create your own menu. You can check if you can get enough calories, carbs, fat and protein with your created data."
					+ "\n" + "Enter calories, choose your gender and the season."));
			root.getChildren().addAll(label1, label2, label3, caloriesField, choices, r1, r2, r3, button, label4);
			DisplayingData data = new DisplayingData();
			data.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public void CreateMenu(Stage primaryStage, Scene scene)
	{
		if(caloriesField.getText().matches("[0-9]+") && !choices.getSelectionModel().isEmpty())
		{
			DisplayingData data = new DisplayingData();
			MenuCreator mc = new MenuCreator();
			mc.Menu(this, data, primaryStage, scene);
		} else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Check for a number or season.");
			Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image("icon.jpg"));
			alert.setHeaderText("It is not a number or you forgot to select the season");
			alert.show();
		}
	}
}
