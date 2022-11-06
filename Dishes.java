/**
 * The Dishes.java class defines the behaviors of the Dishes objects used in RecipeBuilderMain.java
 * <p>
 * @authors Maggie Cowher, Michael Foster-Leon, Maya Rhodes Kopf
 */

public class Dishes {
    // Initialize private variables given to the Dishes objects in the main class
    private int servingSize;
    private int prepTime;
    private String dishName;
    private String dishType;
    private int calories;

    // Default constructor to define private variables
    public Dishes() {
        servingSize = 0;
        prepTime = 0;
        dishName = "";
        dishType = "";
        calories = 0;
    }

    // Setter method for serving size variable
    public void setServingSize(int size) {

        servingSize = size;
    }

    // Getter method for serving size variable
    public int getServingSize() {
        return servingSize;
    }

    // Setter method for prep time variable
    public void setPrepTime(int time) {
        prepTime = time;
    }

    // Getter method for prep time variable
    public int getPrepTime() {
        return prepTime;
    }

    // Setter method for dish name variable
    public void setDishName(String name) {
        dishName = name;
    }

    // Getter method for dish name variable
    public String getDishName() {
        return dishName;
    }

    // Setter method for calories variable
    public void setCalories(int calories) {
        this.calories = calories;
    }

    // Getter method for calories variable
    public int getCalories() {
        return calories;
    }
}
