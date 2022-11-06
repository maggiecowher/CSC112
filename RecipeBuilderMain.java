/**
 * The purpose of this app is to help its user choose a meal to make. The app opens by asking the user which type of
 * dish they would like to see, such as breakfast, lunch, or dinner. Based on their input they will see a menu of two
 * dishes of the type they chose. They will then be prompted to pick a dish from the two options, and will be shown a
 * recipe card that displays prep time, serving size, type of dish, and calories per serving. The user will then be
 * asked if they would like to choose that dish. If they answer no the app will "restart" by again asking the user what
 * kind of dish they want to see, and will continue from there. If they answer yes, a menu will be displayed with
 * options to see ingredients, directions, or total calories, which is found by multiplying the serving size by the
 * calories per serving. The last menu option is to quit, which if selected will display a goodbye message and stop
 * running the code.
 * <p>
 * This class holds the main method, and other methods used to simplify the main. There are three array list of Dishes
 * objects and three of Menu objects, both separated by being either breakfast, lunch, or dinner. Both the Dishes and
 * Menu objects have their own behaviors that are accessed in other methods. The other methods used are to print the
 * list of dishes based on the user's selection of either breakfast, lunch, or dinner. There is a method that prints the
 * dish's recipe card and returns the name of the dish chosen by the user. The next method prints the menu, and is
 * implemented only after the user has decided which dish they would like to use. This method takes in what menu option
 * the user selects and returns that integer to the main method. The next three methods are each an implementation of one
 * of the menu options, for instance there is a printIngredients, printDirections, and printTotalCalories option. The
 * last method, called integrateMethod is used just to simplify code and prevent repeating if else statement blocks.
 * <p>
 * @authors Maggie Cowher, Michael Foster-Leon, Maya Rhodes Kopf
 */

import java.util.ArrayList;
import java.util.Scanner;

public class RecipeBuilderMain {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Create array lists to be filled and printed with the information in DishList.java
        ArrayList<Dishes> breakfast = new ArrayList<>();
        ArrayList<Dishes> lunch = new ArrayList<>();
        ArrayList<Dishes> dinner = new ArrayList<>();

        // Assign breakfast list with elements
        Dishes breakfast1 = new Dishes(); // First breakfast dish
        breakfast1.setDishName("Belgian Waffles");
        breakfast1.setServingSize(8);
        breakfast1.setPrepTime(35);
        breakfast1.setCalories(319);
        breakfast.add(breakfast1);
        Dishes breakfast2 = new Dishes(); // Second breakfast dish
        breakfast2.setDishName("Hashbrown Casserole");
        breakfast2.setServingSize(4);
        breakfast2.setPrepTime(50);
        breakfast2.setCalories(338);
        breakfast.add(breakfast2);

        // Assign lunch list with elements
        Dishes lunch1 = new Dishes(); // First lunch dish
        lunch1.setDishName("Cesar Salad");
        lunch1.setServingSize(6);
        lunch1.setPrepTime(20);
        lunch1.setCalories(115);
        lunch.add(lunch1);
        Dishes lunch2 = new Dishes(); // Second lunch dish
        lunch2.setDishName("Grilled Cheese");
        lunch2.setServingSize(2);
        lunch2.setPrepTime(10);
        lunch2.setCalories(400);
        lunch.add(lunch2);

        // Assign dinner list with elements
        Dishes dinner1 = new Dishes(); // First dinner dish
        dinner1.setDishName("Meatloaf");
        dinner1.setServingSize(6);
        dinner1.setPrepTime(70);
        dinner1.setCalories(344);
        dinner.add(dinner1);
        Dishes dinner2 = new Dishes(); // Second dinner dish
        dinner2.setDishName("Spaghetti and Meatballs");
        dinner2.setServingSize(4);
        dinner2.setPrepTime(40);
        dinner2.setCalories(801);
        dinner.add(dinner2);

        // Create array list for menu objects
        ArrayList<Menu> bfast = new ArrayList<>();
        ArrayList<Menu> lun = new ArrayList<>();
        ArrayList<Menu> din = new ArrayList<>();

        // Create menu object to assign each dish with ingredients and directions
        Menu bfast1 = new Menu();
        Menu bfast2 = new Menu();
        Menu lun1 = new Menu();
        Menu lun2 = new Menu();
        Menu din1 = new Menu();
        Menu din2 = new Menu();

        // Assign each dish with ingredients and directions
        // Breakfast objects
        bfast1.setDirections("""
                1. Preheat your waffle iron, spray with non stick cooking spray and set aside.
                2. In a large bowl whisk together the flour, baking powder, sugar, salt, and cinnamon.
                3. In a medium bowl beat the egg whites with a hand mixer until stiff peaks form. Set aside.
                4. In a separate medium bowl mix together the egg yolks, vegetable oil, milk, and vanilla extract.
                5. Add the egg yolk mixture to the dry ingredients and mix well.
                6. Fold in the egg whites.
                7. Pour the batter onto your hot waffle iron and cook according to manufacturer's directions**
                8. Serve immediately with butter, syrup, powdered sugar or any other favorite toppings.
                """);
        bfast1.setIngredients("""
                2 ¼ Cups All Purpose Flour
                1 Tablespoon Baking Powder
                3 Tablespoons Sugar
                ½ Teaspoon Salt
                1 Teaspoon Cinnamon
                2 Large Eggs Separated
                ½ Cup Vegetable Oil
                2 Cups Milk
                1 Teaspoon Vanilla Extract
                """);
        bfast.add(bfast1); // Add first breakfast object to the menu array list
        bfast2.setDirections("""
                1. Preheat the oven to 350 degrees F (175 degrees C).
                2. Mix hash browns, cream of chicken soup, Cheddar cheese, sour cream, butter, onion, salt, and pepper together in a bowl. Arrange in a 9x13-inch baking dish. Sprinkle on top. Drizzle butter over the cornflakes.
                3. Bake in the preheated oven until the sauce is bubbly and the top is golden brown, 1 to 1 ½ hours.
                """);
        bfast2.setIngredients("""
                1 (2 pound) package frozen hash brown potatoes, thawed\s
                1 (10.75 ounce) can condensed cream of chicken soup\s
                2 cups shredded Cheddar cheese\s
                1 (8 ounce) container sour cream \s
                ½ cup melted butter\s
                ½ cup chopped onion \s
                ½ teaspoon salt\s
                ½ teaspoon ground black pepper
                """);
        bfast.add(bfast2); // Add second breakfast object to the menu array list

        // Lunch objects
        lun1.setDirections("""
                1. Combine olive oil and garlic:\s
                2. In a very large bowl, whisk together 1/2 cup olive oil and garlic. Let sit for at least half an hour.
                3. Make the toasted croutons:\s
                While the garlic is sitting, make the croutons. Spread the baguette slices out on a baking sheet. (You may need to do in batches.)
                Brush or spray with olive oil (or melted butter). If you want garlicky croutons, dip pastry brush in the garlic infused oil you have sitting in Step 1. Broil for a couple of minutes until the tops are lightly browned. (Note: do not walk away, these can easily go from browned to burnt.) Remove and let cool. The steps up until this point can be made ahead.
                4. Make the dressing:\s
                Add minced anchovies (or anchovy paste, if using) and eggs to the oil-garlic mixture. Whisk until creamy. Add salt and pepper and 1/4 cup of lemon juice. Whisk in half of the Parmesan cheese. Taste, add more lemon juice, salt and pepper to taste. The lemon should give an edge to the dressing, but not overwhelm it.
                5. Tear off chunks of romaine lettuce:\s
                Using your hands, tear off chunks of lettuce from the heads of romaine lettuce (do not use a knife to cut). Add to the dressing and toss until coated. Add the rest of the Parmesan cheese, and toss.
                6. Combine and serve:\s
                Coarsely chop the toasted bread into croutons and add to the salad. Brush in any crumbs from chopping the bread, too. Toss and serve immediately.
                """);
        lun1.setIngredients("""
                ½ cup high-quality extra virgin olive oil, plus more for brushing\s
                4 cloves garlic, minced\s
                1 baguette, preferably a day old, thinly sliced\s
                ¼ cup fresh lemon juice (plus more to taste)\s
                4 ounces Parmesan cheese, grated\s
                1 teaspoon anchovy paste, or 1 to 2 anchovies, minced\s
                2 eggs\s
                ¼ teaspoon freshly ground black pepper (or to taste)\s
                ½ teaspoon salt (or to taste)\s
                4 to 6 small heads romaine lettuce, rinsed, patted dry, wilted outer leaves discarded\s
                """);
        lun.add(lun1); // Add first lunch object to the menu array list
        lun2.setDirections("""
                1. Preheat the skillet over medium heat.\s
                2. Generously butter one side of a slice of bread.\s
                3. Place bread butter-side-down onto the skillet bottom and add 1 slice of cheese.\s
                4. Butter a second slice of bread on one side and place butter-side-up on top of the sandwich.\s
                5. Grill until lightly browned and flip over; continue grilling until cheese is melted. Repeat with remaining 2 slices of bread, butter and a slice of cheese.
                """);
        lun2.setIngredients("""
                4 slices white bread\s
                3 tablespoons butter, divided\s
                2 slices Cheddar cheese
                """);
        lun.add(lun2); // Add second lunch object to the menu array list

        // Dinner objects
        din1.setDirections("""
                1. Line a 9”x5” loaf pan with parchment paper and preheat oven to 375°F.
                2. In a large bowl, add all of the ingredients for the meatloaf. Mix well to combine.
                3. Add meat to the loaf pan, gently press meat down and shape evenly and bake meatloaf at 375˚F for 40 minutes.
                4. In a small bowl, mix all of the ingredients together for the sauce. Spread the sauce over the meatloaf then return to the oven and bake for an additional 15-20 minutes. Rest meatloaf 10 minutes before slicing. Drizzle with baking juices from the pan.\s
                """);
        din1.setIngredients("""
                2 lbs ground beef, 85% or 90% lean
                1 med onion, finely chopped
                2 large eggs
                3 garlic cloves, minced
                3 Tbsp ketchup
                3 Tbsp fresh parsley, finely chopped
                ¾ cup Panko breadcrumbs
                ⅓ cup milk
                1 ½ tsp salt, or to taste
                1 ½ tsp Italian seasoning
                ¼ tsp ground black pepper
                ½ tsp ground paprika
                For sauce:¾ cup ketchup
                1 ½ tsp white vinegar
                2 ½ Tbsp brown sugar
                1 tsp garlic powder
                ½ tsp onion powder¼ tsp ground black pepper
                ¼ tsp salt
                """);
        din.add(din1); // Add first dinner object to the menu array list
        din2.setDirections("""
                1. In a large pot of boiling salted water, cook spaghetti according to package instructions. Drain.\s
                2. In a large bowl, combine beef with bread crumbs, parsley, Parmesan, egg, garlic, 1 teaspoon salt, and red pepper flakes. Mix until just combined then form into 16 balls.
                3. In a large pot over medium heat, heat oil. Add meatballs and cook, turning occasionally, until browned on all sides, about 10 minutes. Transfer meatballs to a plate.
                4. Add onion to pot and cook until soft, 5 minutes. Add crushed tomatoes and bay leaf. Season with salt and pepper and bring to a simmer. Return meatballs to pot and cover. Simmer until the sauce has thickened, 8 to 10 minutes.
                5. Serve pasta with a healthy scoop of meatballs and sauce. Top with Parmesan before serving.
                """);
        din2.setIngredients("""
                1 lb. spaghetti
                1 lb. ground beef
                ⅓ cup bread crumbs
                ¼ cup finely chopped parsley
                ¼ cup freshly grated Parmesan, plus more for serving
                1 egg
                2 garlic cloves, minced
                Kosher salt
                ½ tsp. red pepper flakes
                2 tbsp. extra-virgin olive oil
                ½ cup onion, finely chopped
                1 (28-oz.) can crushed tomatoes
                1 bay leaf
                Freshly ground black pepper
                """);
        din.add(din2); // Add second dinner object to the menu array list

        boolean cont = false;
        int menuOpt;
        int selection;
        String choice;

        boolean input = false;
        do {
                // Print greeting message and prompt to show dish lists
                System.out.println("Hello! Would you like to see a menu of breakfast, lunch, or dinner options?");

                // Print menu based on user's selection
                selection = menuChoice(breakfast, lunch, dinner);

                // Print recipe card based on user's selection
                choice = recipeCard(selection, breakfast, lunch, dinner);
                do { // Do while loop to ensure that the user enters "yes" or "no" when asked if they would like to continue with the dish
                    System.out.println("Would you like to choose this dish? (yes/no)"); // Ask user if they would like to continue with this dish
                    String ans = scnr.next();
                    if (ans.equalsIgnoreCase("yes")) {
                        input = true;
                        cont = true;
                    } else if (ans.equalsIgnoreCase("no")) {
                        input = true;
                    } else {
                        System.out.println("That is not a valid input");
                    }
                } while (!input);
        } while (!cont);

        do {
            menuOpt = printMenu();
            int opt = 0;
            // If-else statement to differentiate between dishes when using the menu option
            if (selection == 1) {
                integrateMenu(breakfast, bfast, menuOpt, opt, choice);
            } else if (selection == 2) {
                integrateMenu(lunch, lun, menuOpt, opt, choice);
            } else {
                integrateMenu(dinner, din, menuOpt, opt, choice);
            }
        } while (menuOpt != 4);

        // Goodbye message
        System.out.println("Thanks for using our Recipe Builder app! Enjoy your meal!");
    }

    // A method for prompting user to select either breakfast, lunch, or dinner, and then display the menu for their
    // choice. The method then takes the input from the user and assigns an integer variable with either 1, 2, or 3,
    // prints the menu for that selection, and returns the integer value.
    public static int menuChoice(ArrayList<Dishes> breakfast, ArrayList<Dishes> lunch, ArrayList<Dishes> dinner) {
        Scanner scnr = new Scanner(System.in);
        // Do-while loop to decide what menu to print
        boolean option;
        int selection = 0;
        do {
            System.out.println("Enter your choice (I.E. \" dinner \" to see dinner options)");
            String choice = scnr.next();
            int i;
            switch (choice) {
                case "breakfast":
                    selection = 1;
                    System.out.println("Breakfast Menu:");
                    for (i = 0; i < 2; i++) {
                        System.out.println(breakfast.get(i).getDishName());
                    }
                    option = true;
                    break;
                case "lunch":
                    selection = 2;
                    System.out.println("Lunch Menu:");
                    for (i = 0; i < 2; i++) {
                        System.out.println(lunch.get(i).getDishName());
                    }
                    option = true;
                    break;
                case "dinner":
                    selection = 3;
                    System.out.println("Dinner Menu:");
                    for (i = 0; i < 2; i++) {
                        System.out.println(dinner.get(i).getDishName());
                    }
                    option = true;
                    break;
                default:
                    System.out.println("Im sorry, that is not an option");
                    option = false;
                    break;
            }
        } while (!option);
        return selection;
    }

    // A method used to print the recipe card. The method prompts the user to type what dish they want, returns this
    // String value, and prints the recipe card for the corresponding dish.
    public static String recipeCard(int selection, ArrayList<Dishes> breakfast, ArrayList<Dishes> lunch, ArrayList<Dishes> dinner) {
        Scanner scnr = new Scanner(System.in);
        // Prompt user to select a dish to see its recipe card
        String dishChoice;
        boolean valid;
        if (selection == 1) {
            do {
                System.out.println("Enter the dish name to see its recipe card");
                dishChoice = scnr.nextLine();
                if (dishChoice.equalsIgnoreCase(breakfast.get(0).getDishName())) {
                    valid = true;
                    System.out.println("----Recipe Card----");
                    System.out.println("Type of dish: breakfast");
                    System.out.println("Serving size: " + breakfast.get(0).getServingSize());
                    System.out.println("Calories per serving: " + breakfast.get(0).getCalories());
                    System.out.println("Prep time: " + breakfast.get(0).getPrepTime() + " minutes");
                } else if (dishChoice.equalsIgnoreCase(breakfast.get(1).getDishName())) {
                    valid = true;
                    System.out.println("----Recipe Card----");
                    System.out.println("Type of dish: breakfast");
                    System.out.println("Serving size: " + breakfast.get(1).getServingSize());
                    System.out.println("Calories per serving: " + breakfast.get(1).getCalories());
                    System.out.println("Prep time: " + breakfast.get(1).getPrepTime() + " minutes");
                } else {
                    valid = false;
                    System.out.println("That is not a valid dish");
                }
            } while (!valid);
        } else if (selection == 2) {
            do {
                System.out.println("Enter the dish name to see its recipe card");
                dishChoice = scnr.nextLine();
                if (dishChoice.equalsIgnoreCase(lunch.get(0).getDishName())) {
                    valid = true;
                    System.out.println("----Recipe Card----");
                    System.out.println("Type of dish: lunch");
                    System.out.println("Serving size: " + lunch.get(0).getServingSize());
                    System.out.println("Calories per serving: " + lunch.get(0).getCalories());
                    System.out.println("Prep time: " + lunch.get(0).getPrepTime() + " minutes");
                } else if (dishChoice.equalsIgnoreCase(lunch.get(1).getDishName())) {
                    valid = true;
                    System.out.println("----Recipe Card----");
                    System.out.println("Type of dish: lunch");
                    System.out.println("Serving size: " + lunch.get(1).getServingSize());
                    System.out.println("Calories per serving: " + lunch.get(1).getCalories());
                    System.out.println("Prep time: " + lunch.get(1).getPrepTime() + " minutes");
                } else {
                    valid = false;
                    System.out.println("That is not a valid dish");
                }
            } while (!valid);
        } else {
            do {
                System.out.println("Enter the dish name to see its recipe card");
                dishChoice = scnr.nextLine();
                if (dishChoice.equalsIgnoreCase(dinner.get(0).getDishName())) {
                    valid = true;
                    System.out.println("----Recipe Card----");
                    System.out.println("Type of dish: dinner");
                    System.out.println("Serving size: " + dinner.get(0).getServingSize());
                    System.out.println("Calories per serving: " + dinner.get(0).getCalories());
                    System.out.println("Prep time: " + dinner.get(0).getPrepTime() + " minutes");
                } else if (dishChoice.equalsIgnoreCase(dinner.get(1).getDishName())) {
                    valid = true;
                    System.out.println("----Recipe Card----");
                    System.out.println("Type of dish: dinner");
                    System.out.println("Serving size: " + dinner.get(1).getServingSize());
                    System.out.println("Calories per serving: " + dinner.get(1).getCalories());
                    System.out.println("Prep time: " + dinner.get(1).getPrepTime() + " minutes");
                } else {
                    valid = false;
                    System.out.println("That is not a valid dish");
                }
            } while (!valid);
        }
        return dishChoice;
    }

    // A method to print the menu. This method cleans up and simplifies code in the main method. This method prints the
    // menu, then takes in the users input (selection of menu option) and returns that integer value to a variable in
    // the main method.
    public static int printMenu() {
        Scanner scnr = new Scanner(System.in);
        int selection;
        boolean ans = false;
        System.out.println("------Menu------");
        System.out.println("1: See Ingredients");
        System.out.println("2: See Directions");
        System.out.println("3: See Total Calories");
        System.out.println("4: Quit");
        do { // The do-while loop makes sure that the user inputs a valid menu option
            System.out.println("Enter your selection (i.e. \"1\" for ingredients)");
            selection = scnr.nextInt();
            if (selection == 1) {
                ans = true;
            } else if (selection == 2) {
                ans = true;
            } else if (selection == 3) {
                ans = true;
            } else if (selection == 4) {
                ans = true;
            } else {
                System.out.println("That is not a valid input.");
            }
        } while (!ans);
        return selection;
    }

    // The method for printing a dish's ingredients.
    public static void printIngredients(ArrayList<Menu> dish, int choice) {
        System.out.println("------Ingredients------");
        if (choice == 1) {
            System.out.println(dish.get(0).getIngredients());
        } else {
            System.out.println(dish.get(1).getIngredients());
        }
    }

    // The method for printing a dish's directions.
    public static void printDirections(ArrayList<Menu> dish, int choice) {
        System.out.println("------Directions------");
        if (choice == 1) {
            System.out.println(dish.get(0).getDirections());
        } else {
            System.out.println(dish.get(1).getDirections());
        }
    }

    // The method for printing a dish's total calories. This value is calculated by multiplying the value of calories
    // per serving by the value for the serving size and prints this.
    public static void printTotalCalories(ArrayList<Dishes> dish, int choice) {
        System.out.println("------Total Calories------");
        if (choice == 1) {
            System.out.println(dish.get(0).getCalories() * dish.get(0).getServingSize());
        } else {
            System.out.println(dish.get(1).getCalories() * dish.get(1).getServingSize());
        }
    }

    // The purpose of this method is to prevent repeating lines of code, specifically the same if-else statement blocks
    // when trying to integrate the menu function.
    public static void integrateMenu(ArrayList<Dishes> dish, ArrayList<Menu> menu, int menuOpt, int opt, String choice) {
        // If statement for integer variable to dictate which dish is being used
            if (choice.equalsIgnoreCase(dish.get(0).getDishName())) {
                opt = 1;
            } else if (choice.equalsIgnoreCase(dish.get(1).getDishName())) {
                opt = 2;
            }
            // If statement for menu operation
            if (menuOpt == 1) {
                printIngredients(menu, opt);
            } else if (menuOpt == 2) {
                printDirections(menu, opt);
            } else if (menuOpt == 3) {
                printTotalCalories(dish, opt);
            }
    }
}
