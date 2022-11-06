/**
 * The Menu.java class defines the behaviors of the Menu objects used in the RecipeBuilderMain.java
 * <p>
 * @authors Maggie Cowher, Michael Foster-Leon, Maya Rhodes Kopf
 */

public class Menu {
    // Initialize private variables given to the Menu objects in the main class
    private String ingredients;
    private String directions;

    // Default constructor to define private variables
    public Menu() {
        ingredients = "";
        directions = "";
    }

    // Setter method for ingredients variable
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    // Getter method for ingredients variable
    public String getIngredients() {
        return ingredients;
    }

    // Setter method for directions variable
    public void setDirections(String directions) {
        this.directions = directions;
    }

    // Getter method for directions variable
    public String getDirections() {
        return directions;
    }
}
