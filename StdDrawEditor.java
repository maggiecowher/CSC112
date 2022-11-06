/**
 * This code utilizes the StdDraw.java class to create an animated canvas of the student's choice. The drawing creates
 * a blue sky and green grass, and a red house with a yellow roof and gray door on the grass. A stick figure character
 * shows up with a balloon in its hand, and then lets go of the balloon. The character is in shock as the balloon floats
 * away.
 *  <p>
 *  To create the sky, I cleared the canvas with the color light blue by the clear method in StdDraw, and then added a
 *  green rectangle that takes up much of the bottom half of the page by the filledRectangle method in StdDraw. Then to
 *  create the house I made a red square with the filledSquare method and used the filledPolygon method to create a
 *  yellow triangular roof. The stick figure and the string on the balloon were made using the line method, and the two
 *  balloon images were created in separate for loops so that they could appear and disappear in the animation. By
 *  clearing the entire canvas and then recreating the backdrop, I was able to create the allusion that the balloon was
 *  the only image being cleared off the page. When I recreated the stick figure I changed the original coordinates of
 *  the arm lines and added two extras to create the illusion of someone covering their mouth in shock.
 *  <p>
 *  @author: Maggie Cowher
 */

import java.awt.*;

public class StdDrawEditor {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(500, 500);//window dimensions in pixels
        StdDraw.setXscale(0, 1);//scale of window
        StdDraw.setYscale(0, 1);//scale of window

        StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE); // Draw blue sky

        // Draw green grass
        StdDraw.setPenColor(Color.GREEN); // Set the grass color to green
        StdDraw.filledRectangle(0.5, 0.2, 0.6, 0.2); // Coordinates for rectangle

        // Create triangle
        double xPoints[] = {0.35, 0.65, 0.5};
        double yPoints[] = {0.555, 0.555, 0.8};

        // Created animated house
        StdDraw.enableDoubleBuffering();

        for (double t = 0; true; t += 0.02) {
            // Create base of house
            StdDraw.show(1500);
            StdDraw.setPenColor(Color.RED);
            StdDraw.filledSquare(0.5, 0.4, 0.155);
            // Create roof of house
            StdDraw.setPenColor(Color.YELLOW);
            StdDraw.filledPolygon(xPoints, yPoints);
            // Create door and door handle
            StdDraw.setPenColor(Color.lightGray);
            StdDraw.filledRectangle(0.435, 0.335, 0.03875, 0.08975);
            StdDraw.setPenColor(Color.darkGray);
            StdDraw.filledCircle(0.44, 0.325, 0.008);
            // Create stick figure that appears after creation of house
            StdDraw.show(1500);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.005);
            StdDraw.line(0.15, 0.2, 0.175, 0.275);
            StdDraw.line(0.175, 0.275, 0.2, 0.2);
            StdDraw.line(0.175, 0.275, 0.175, 0.35);
            StdDraw.filledCircle(0.175, 0.385, 0.035);
            StdDraw.line(0.175, 0.315, 0.13, 0.33);
            StdDraw.line(0.175, 0.315, 0.215, 0.33);
            for (double i = 0; i < 0.05; i += 0.02) { // Balloon that stays in stick figures hand
                // Create balloon
                StdDraw.show(400);
                StdDraw.setPenColor(Color.white);
                StdDraw.line(0.13, 0.33, 0.13, 0.45);
                StdDraw.setPenColor(Color.MAGENTA);
                StdDraw.filledEllipse(0.13, 0.5, 0.03, 0.05);
            }
            // Clears canvas and re-creates backdrop and stick figure to emulate person letting go of balloon
            StdDraw.clear(StdDraw.CYAN); // Draw blue sky
            // Draw green grass
            StdDraw.setPenColor(Color.GREEN); // Set the grass color to green
            StdDraw.filledRectangle(0.5, 0.2, 0.6, 0.2); // Coordinates for rectangle
            // Create base of house
            StdDraw.setPenColor(Color.RED);
            StdDraw.filledSquare(0.5, 0.4, 0.155);
            // Create roof of the house
            StdDraw.setPenColor(Color.YELLOW);
            StdDraw.filledPolygon(xPoints, yPoints);
            // Create door and door handle
            StdDraw.setPenColor(Color.lightGray);
            StdDraw.filledRectangle(0.435, 0.335, 0.03875, 0.08975);
            StdDraw.setPenColor(Color.darkGray);
            StdDraw.filledCircle(0.44, 0.325, 0.008);
            // Create stick figure that appears after creation of house
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.005);
            StdDraw.line(0.15, 0.2, 0.175, 0.275);
            StdDraw.line(0.175, 0.275, 0.2, 0.2);
            StdDraw.line(0.175, 0.275, 0.175, 0.35);
            StdDraw.filledCircle(0.175, 0.385, 0.035);
            StdDraw.line(0.175, 0.315, 0.16, 0.33);
            StdDraw.line(0.175, 0.315, 0.19, 0.33);
            StdDraw.line(0.16, 0.33, 0.175, 0.385);
            StdDraw.line(0.19, 0.33, 0.175, 0.385);
            for (double i = 0; i < 0.10; i += 0.02) { // Balloon is now up in the air
                StdDraw.show(400);
                StdDraw.setPenColor(Color.white);
                StdDraw.line(0.13, 0.63, 0.13, 0.75);
                StdDraw.setPenColor(Color.MAGENTA);
                StdDraw.filledEllipse(0.13, 0.8, 0.03, 0.05);
            }
            // Clears canvas and re-creates backdrop and stick figure to emulate person letting go of balloon
            StdDraw.clear(StdDraw.CYAN); // Draw blue sky
            // Draw green grass
            StdDraw.setPenColor(Color.GREEN); // Set the grass color to green
            StdDraw.filledRectangle(0.5, 0.2, 0.6, 0.2); // Coordinates for rectangle
            // Create base of house
            StdDraw.setPenColor(Color.RED);
            StdDraw.filledSquare(0.5, 0.4, 0.155);
            // Create roof of the house
            StdDraw.setPenColor(Color.YELLOW);
            StdDraw.filledPolygon(xPoints, yPoints);
            // Create door and door handle
            StdDraw.setPenColor(Color.lightGray);
            StdDraw.filledRectangle(0.435, 0.335, 0.03875, 0.08975);
            StdDraw.setPenColor(Color.darkGray);
            StdDraw.filledCircle(0.44, 0.325, 0.008);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.005);
            StdDraw.line(0.15, 0.2, 0.175, 0.275);
            StdDraw.line(0.175, 0.275, 0.2, 0.2);
            StdDraw.line(0.175, 0.275, 0.175, 0.35);
            StdDraw.filledCircle(0.175, 0.385, 0.035);
            // The arms of the stick figure are now different to emulate someone clasping their hands over their mouth
            StdDraw.line(0.175, 0.315, 0.16, 0.33);
            StdDraw.line(0.175, 0.315, 0.19, 0.33);
            StdDraw.line(0.16, 0.33, 0.175, 0.385);
            StdDraw.line(0.19, 0.33, 0.175, 0.385);
            StdDraw.clear(StdDraw.CYAN); // Draw blue sky
            // Reset drawing to make a smoother transition for the restart of the animation
            // Draw green grass
            StdDraw.setPenColor(Color.GREEN); // Set the grass color to green
            StdDraw.filledRectangle(0.5, 0.2, 0.6, 0.2); // Coordinates for rectangle
        }

    }
}
