package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Results {
	public TextArea textArea;
	public Food foods;
	public Button backButton;
	public Button quitButton;
	public Label resultsLabel;
	public void PrintingResults(Main main, Stage primaryStage, Scene scene2)
	{
		Pane root = new Pane();
		foods = new Food();
		backButton = new Button("Back");
		quitButton = new Button("Quit");
		Scene scene = new Scene(root, 600, 352);
		Stage stage = new Stage();
		Image icon = new Image("icon.jpg");
		stage.getIcons().add(icon);
		stage.setTitle("Results");
		textArea = new TextArea();
		quitButton.relocate(345, 305);
		textArea.relocate(62, 44);
		backButton.relocate(208, 305);
		Analysis(main);
		textArea.setPrefWidth(483);
		textArea.setPrefHeight(243);
		textArea.setEditable(false);
		backButton.setOnAction(e->GoingBack(scene2, primaryStage));
		quitButton.setOnAction(e-> Quit());
		root.getChildren().addAll(textArea, backButton, quitButton);
		primaryStage.setTitle("Results");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	void Analysis(Main main)
	{
		StringBuilder sb = new StringBuilder();
		if(main.r1.isSelected())
		{
			sb.append(String.format("You have entered " + main.caloriesField.getText() + " calories"
					+ ", you are male and the season is " + main.choices.getValue() + ". \n"));
		} else if (main.r2.isSelected())
		{
			sb.append(String.format("You have entered " + main.caloriesField.getText() + " calories"
					+ ", you are female and the season is " + main.choices.getValue() + ". \n"));
		} else
		{
			sb.append(String.format("You have entered " + main.caloriesField.getText() + " calories"
					+ ", your selected gender is Other and the season is " + main.choices.getValue() + ". \n"));
		}
		sb.append(String.format("With this amount of calories, you need: "+"\n"));
		sb.append(String.format(Integer.parseInt(main.caloriesField.getText()) * 12/100/4 + " grams of protein," + "\n"));
		sb.append(String.format(Integer.parseInt(main.caloriesField.getText()) * 58/100/4 + " grams of carbs," + "\n"));
		sb.append(String.format(Integer.parseInt(main.caloriesField.getText()) * 30/100/9 + " grams of fat." + "\n"));
		sb.append(String.format("With the items you have added, you would get: " +"\n"));
		sb.append(Food.currentCalories + " calories." + "\n");
		if(Food.currentCalories >= Integer.parseInt(main.caloriesField.getText()))
		{
			sb.append(String.format("It means that with the items you have entered you would get enough calories per day." + "\n"));
		} else
		{
			sb.append(String.format("It means that with the items you have entered you would not get enough calories per day." + "\n"));
		}
		sb.append(String.format("This is what you would get from your menu: " + "\n"));
		sb.append(String.format(Food.currentCarbs + " grams of carbs," + "\n"));
		sb.append(String.format(Food.currentProtein + " grams of protein," + "\n"));
		sb.append(String.format(Food.currentFat + " grams of fat," + "\n"));
		if(Food.currentCarbs >= Integer.parseInt(main.caloriesField.getText()) * 58/100/4)
		{
			sb.append(String.format("You would get enough carbs." + "\n"));
		} else 
		{
			sb.append(String.format("You wouldn't get enough carbs." + "\n"));
		}
		if (Food.currentProtein >= Integer.parseInt(main.caloriesField.getText()) * 12/100/4)
		{
			sb.append(String.format("You would get enough protein." + "\n"));
		} else
		{
			sb.append(String.format("You wouldn't get enough protein." + "\n"));
		}
		if (Food.currentFat >= Integer.parseInt(main.caloriesField.getText()) * 30/100/9)
		{
			sb.append(String.format("You would get enough fats." + "\n"));
		} else
		{
			sb.append(String.format("You wouldn't get enough fats." + "\n"));
		}
		if(Food.currentFat >= Integer.parseInt(main.caloriesField.getText()) * 30/100/9 && 
			Food.currentProtein >= Integer.parseInt(main.caloriesField.getText()) * 12/100/4 &&
			Food.currentCarbs >= Integer.parseInt(main.caloriesField.getText()) * 58/100/4)
		{
			sb.append(String.format("You will get all the protein, carbs and fat you need from this menu."
					+ " Congratulations!"));
		} else
		{
			sb.append(String.format("Press back button and try to create another menu."));
		}
		textArea.setText(sb.toString());
	}
	void GoingBack(Scene scene2, Stage primaryStage)
	{
		primaryStage.setScene(scene2);
		primaryStage.show();
		primaryStage.setTitle("Adding products");
		primaryStage.setResizable(false);
	}
	void Quit()
	{
		System.exit(0);
	}
}
