package application;

public class Food {
	public String name;
	public String calories;
	public String grams;
	public String fats;
	public String carbs;
	public String protein;
	public int proteinAmount;
	public int fatAmount;
	public int carbsAmount;
	static int currentCalories = 0;
	static int currentFat = 0;
	static int currentProtein = 0;
	static int currentCarbs = 0;
	public Food(int protein, int fat, int carbs)
	{
		this.proteinAmount = protein;
		this.fatAmount = fat;
		this.carbsAmount = carbs;
	}
	public Food()
	{
		
	}
	public String getCarbs()
	{
		return this.carbs;
	}
	public String getFats()
	{
		return this.fats;
	}
	public String getProtein()
	{
		return this.protein;
	}
	public String getName()
	{
		return this.name;
	}
	public String getCalories()
	{
		return this.calories;
	}
	public String getGrams()
	{
		return this.grams;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setCalories(String calories)
	{
		this.calories = calories;
	}
	public void setGrams(String grams)
	{
		this.grams = grams;
	}
	public void setProtein(String protein)
	{
		this.protein = protein;
	}
	public void setFats(String fat) {
		this.fats = fat;
	}
	public void setCarbs(String carbs)
	{
		this.carbs = carbs;
	}
	public Food(String name, String calories, String protein, String fats, String carbs)
	{
		this.name = name;
		this.calories = calories;
		this.protein = protein;
		this.fats = fats;
		this.carbs = carbs;
	}
	public void addCalories(int amount)
	{
		currentCalories+= amount;
	}
	public void removeCalories(int amount)
	{
		currentCalories-=amount;
	}
	public void addCarbs(int amount)
	{
		currentCarbs+= amount;
	}
	public void removeCarbs(int amount)
	{
		currentCarbs-= amount;
	}
	public void addProtein(int amount)
	{
		currentProtein+= amount;
	}
	public void removeProtein(int amount)
	{
		currentProtein-= amount;
	}
	public void addFats(int amount)
	{
		currentFat+= amount;
	}
	public void removeFats(int amount)
	{
		currentFat-=amount;
	}
}
