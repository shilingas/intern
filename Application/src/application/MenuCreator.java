package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuCreator extends DisplayingData {
	public Label enterTheFood;
	public Label calories;
	public Label proteinLabel;
	public Label fatLabel;
	public Label carbsLabel;
	public Label infoLabel;
	public Button addButton;
	public Button nextButton;
	public Button removeButton;
	public Button backButton;
	public ListView<String> items;
	public TextField fieldForFood;
	public TextField fieldForCalories;
	public TextField fieldForCarbs;
	public TextField fieldForFat;
	public TextField fieldForProtein;
	public ObservableList<String> itemsList;
	public ListView<String> names;
	public ObservableList<String> namesList;
	public ListView<String> foodCalories;
	public ObservableList<String> caloriesList;
	public Food foods;
	public ObservableList<Food> foodsList;
	public TableView<Food> table;
	public TableColumn<Food, String> foodColumn;
	public TableColumn<Food, String> caloriesColumn;
	public TableColumn <Food, String> proteinColumn;
	public TableColumn<Food, String> fatsColumn;
	public TableColumn<Food, String> carbsColumn;
	@SuppressWarnings("unchecked")
	public void Menu(Main main, DisplayingData data, Stage primaryStage, Scene scene)
	{
		Pane root = new Pane();
		Scene scene2 = new Scene(root, 868, 509);
		Image icon = new Image("icon.jpg");
		enterTheFood = new Label("Food name");
		calories = new Label("Calories");
		carbsLabel = new Label("Carbs");
		proteinLabel = new Label("Protein");
		fatLabel = new Label("Fats");
		addButton = new Button("Add");
		nextButton = new Button("Next");
		backButton = new Button("Back");
		infoLabel = new Label("What is this?");
		infoLabel.setTooltip(new Tooltip("Create your own menu." + "\n" + "Enter food name,"
				+ " calories, protein, fat and carbs"));
		infoLabel.relocate(782, 479);
		infoLabel.setFont(new Font("Tahoma", 10));
		infoLabel.setTextFill(Color.web("bc4444"));
		foodsList = FXCollections.observableArrayList();
		removeButton = new Button("Remove");
		foods = new Food();
		items = new ListView<String>();
		itemsList = FXCollections.observableArrayList();
		foodColumn = new TableColumn<>("Name");
		caloriesColumn = new TableColumn<>("Calories");
		proteinColumn = new TableColumn<>("Protein");
		fatsColumn  = new TableColumn<>("Fats");
		carbsColumn = new TableColumn<>("Carbs");
		foodColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		caloriesColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));
		proteinColumn.setCellValueFactory(new PropertyValueFactory<>("protein"));
		carbsColumn.setCellValueFactory(new PropertyValueFactory<>("carbs"));
		fatsColumn.setCellValueFactory(new PropertyValueFactory<>("fats"));
		table = new TableView<>();
		foodColumn.setMinWidth(115);
		caloriesColumn.setMinWidth(115);
		fatsColumn.setMinWidth(115);
		carbsColumn.setMinWidth(115);
		proteinColumn.setMinWidth(115);
		table.getColumns().addAll(foodColumn, caloriesColumn, fatsColumn, carbsColumn,
				proteinColumn);
		fieldForFood = new TextField();
		fieldForCalories = new TextField();
		fieldForProtein = new TextField();
		fieldForCarbs=  new TextField();
		fieldForFat = new TextField();
		table.relocate(267, 37);
		table.setPrefHeight(439);
		table.setPrefWidth(575);
		
		fieldForFood.relocate(51, 51);
		fieldForFood.setPrefHeight(25);
		fieldForFood.setPrefWidth(149);
		
		fieldForCalories.relocate(54, 118);
		fieldForCalories.setPrefHeight(25);
		fieldForCalories.setPrefWidth(149);
		
		fieldForProtein.relocate(54, 184);
		fieldForProtein.setPrefHeight(25);
		fieldForProtein.setPrefWidth(149);
		
		fieldForFat.relocate(54, 248);
		fieldForFat.setPrefHeight(25);
		fieldForFat.setPrefWidth(149);
		
		fieldForCarbs.relocate(54, 308);
		fieldForCarbs.setPrefHeight(25);
		fieldForCarbs.setPrefWidth(149);
		
		
		enterTheFood.relocate(95, 24);
		enterTheFood.setPrefWidth(59.2);
		enterTheFood.setPrefHeight(28);
		
		enterTheFood.setFont(new Font("Tahoma", 12));
		enterTheFood.setTextFill(Color.web("bc4444"));
		calories.relocate(105, 94);
		calories.setPrefHeight(17);
		calories.setPrefWidth(42);
		calories.setFont(new Font("Tahoma", 12));
		calories.setTextFill(Color.web("bc4444"));
		
		proteinLabel.relocate(106, 160);
		proteinLabel.setPrefWidth(38);
		proteinLabel.setPrefHeight(17);
		proteinLabel.setFont(new Font("Tahoma", 12));
		proteinLabel.setTextFill(Color.web("bc4444"));
		
		fatLabel.relocate(114, 224);
		fatLabel.setPrefHeight(17);
		fatLabel.setPrefWidth(22);
		fatLabel.setFont(new Font("Tahoma", 12));
		fatLabel.setTextFill(Color.web("bc4444"));
		
		carbsLabel.relocate(110, 282);
		carbsLabel.setPrefHeight(17);
		carbsLabel.setPrefWidth(30);
		carbsLabel.setFont(new Font("Tahoma", 12));
		carbsLabel.setTextFill(Color.web("bc4444"));
		
		removeButton.relocate(96, 386);
		addButton.relocate(106, 352);
		nextButton.relocate(105, 421);
		backButton.relocate(105, 454);
		
		items.relocate(27, 118);
		items.setPrefHeight(200);
		items.setPrefWidth(545);
		addButton.setOnAction(e->CreatingList(main));
		nextButton.setOnAction(e->NextAction(main, primaryStage, scene2));
		removeButton.setOnAction(e->Remove());
		backButton.setOnAction(e->ChangeScene(primaryStage, scene));
		root.getChildren().addAll(enterTheFood, calories, proteinLabel, fatLabel, carbsLabel, addButton
				,fieldForFood,fieldForCalories, infoLabel, backButton, fieldForProtein, fieldForFat, fieldForCarbs, nextButton, removeButton, table);
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("Adding products");
		primaryStage.setScene(scene2);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	public void CreatingList(Main main)
	{
		String food = fieldForFood.getText();
		if(fieldForCalories.getText().equals("") || fieldForProtein.getText().equals("")
				|| fieldForCarbs.getText().equals("") || fieldForFat.getText().equals(""))
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("There is empty spaces, check again");
			alert.show();
		} else if(!fieldForCalories.getText().matches("[0-9]+") || !fieldForProtein.getText().matches("[0-9]+")
				|| !fieldForCarbs.getText().matches("[0-9]+") || !fieldForFat.getText().matches("[0-9]+"))
				{
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("Enter a integer only.");
					alert.show();
				}
		else 
		{
			foodsList.add(new Food(food, fieldForCalories.getText(), fieldForProtein.getText(), fieldForFat.getText(),
					fieldForCarbs.getText()));
			foods.addCalories(Integer.parseInt(fieldForCalories.getText()));
			foods.addCarbs(Integer.parseInt(fieldForCarbs.getText()));
			foods.addProtein(Integer.parseInt(fieldForProtein.getText()));
			foods.addFats(Integer.parseInt(fieldForFat.getText()));
			table.setItems(foodsList);
		}
		fieldForFood.setText("");
		fieldForCalories.setText("");
		fieldForProtein.setText("");
		fieldForCarbs.setText("");
		fieldForFat.setText("");
	}
	public void NextAction(Main main, Stage primaryStage, Scene scene)
	{
		Results results = new Results();
		results.PrintingResults(main, primaryStage, scene);
	}
	public void Remove()
	{
		Food id = table.getSelectionModel().getSelectedItem();
		if(id == null)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please select an item to delete.");
			alert.show();
		} else
		{
			table.getItems().remove(id);
			foods.removeCalories(Integer.parseInt(id.getCalories()));
			foods.removeCarbs(Integer.parseInt(id.getCarbs()));
			foods.removeFats(Integer.parseInt(id.getFats()));
			foods.removeProtein(Integer.parseInt(id.getProtein()));
		}
	}
	public void ChangeScene(Stage primaryStage, Scene scene)
	{
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Vegetarian food maker");
		primaryStage.setResizable(false);
	}
}
