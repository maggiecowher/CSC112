/** This program uses the Video.java class to create a Video object that has a title string and date integer. The class
 * also has a default constructor, general constructor, copy constructor, and toString() method. The csv file used in
 * this program is a list of my most recent viewing history on the Netflix app. The list is therefore sorted by date.
 * This program reads from the csv file and creates a Video object for each title and date pair, then puts these objects
 * into an ArrayList of type Video. The program has a sort method, which uses the Compare.java class that has
 * implemented the Comparator.java class. The sort method continues to swap, using the swap method, until the list is
 * completely alphabetically sorted. The swap method utilizes the copy constructor in the Video class to create a
 * temporary Video object to store the information while swapping object indices in the ArrayList. The program also
 * tracks the time elapsed to sort the list.
 * </p>
 * Maggie Cowher
 * March 2, 2022
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        //To collect the execution time;
        // use the following lines before and after calling the method
        // you need to compute its execution time
        long startTime;
        long finishTime;

        // Declare as null
        FileInputStream myFile = null;

        // Try-catch to prevent file not found exception
        try {
            myFile = new FileInputStream("src/NetflixViewingHistory.csv");
        } catch (FileNotFoundException e) {
            System.out.println("That is not a valid file");
        }

        // Open file reader
        Scanner fileReader = new Scanner(myFile);

        // Declare array list of type video
        ArrayList<Video> netflix = new ArrayList<>();

        // Read data from file and put into array list
        while (fileReader.hasNextLine()) {
            String data = fileReader.nextLine();
            String[] dataSplit = data.split(","); // Split data in csv file by commas

            // Declare and initialize video object with data from csv file and add to array list
            Video video = new Video();
            video.setTitle(dataSplit[0]);
            video.setDate(dataSplit[1]);
            netflix.add(video);
        }

        fileReader.close(); // close the stream’s connection to a file

        // Get input from user for size of array list to be sorted
        Scanner scnr = new Scanner(System.in); // Create scanner object to read from user
        System.out.println("What size of the list would you like to be sorted");
        int size = scnr.nextInt();

        // Call method and track execution time
        startTime = System.nanoTime(); // Start time
        ArrayList<Video> sortedNetflix = sort(netflix, size);
        finishTime = System.nanoTime();
        long executionTime = finishTime - startTime;

        System.out.println("Exectution time: " + executionTime);

        // Open new file to print the sorted list
        FileOutputStream sortedFile = null;
        // Try catch block in case the file cannot be found
        try {
            sortedFile = new FileOutputStream("sortedDataset.txt"); // Opening a file
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open that file");
        }

        PrintWriter fileWriter = new PrintWriter(sortedFile); // Assigning a writer to the file

        // Print sorted information into new file
        for (int i = 0; i < size; i++) {
            fileWriter.println(sortedNetflix.get(i).getTitle() + "," + sortedNetflix.get(i).getDate());
        }

        fileWriter.close(); // Close the stream's connection to the file

        // Create new input stream
        FileInputStream sortFile = null;
        // Try catch block in case the file cannot be found
        try {
            sortFile = new FileInputStream("sortedDataset.txt");
        } catch (FileNotFoundException e) {
            System.out.println("That file cannot be found");
        }

        // Open file reader
        Scanner sortedFileReader = new Scanner(sortFile);

        // Read and print from sorted file
        while (sortedFileReader.hasNextLine()) {
            String sortedData = sortedFileReader.nextLine();
            System.out.println(sortedData);
        }

    }


    public static ArrayList<Video> sort(ArrayList<Video> netflix, int size) {
        Compare compare = new Compare(); // Create a Compare object to use the implemented comparator class

        boolean isSorted = false; // Declare and initialize boolean to determine if the list is sorted for the while loop

        while (!isSorted) { // Loop continues until the list is completely sorted
            boolean swapCheck = false; // Boolean to check if the swap method is being called

            for (int i = 0; i < size; i++) { // For loop to continue for the size given to be sorted
                int compareVal = compare.compare(netflix.get(i), netflix.get(i+1));
                if (compareVal == 1) { // If the objects need to be swapped
                    netflix = swap(netflix, i, i + 1); // Call swap method and re-initialize array list
                    swapCheck = true; // swapCheck boolean is true if swap is still being called
                }
            }

            if (!swapCheck) { // Once swapCheck is no longer true, the list is completely sorted
                isSorted = true;
            }
        }

        return netflix;
    }

    public static ArrayList<Video> swap(ArrayList<Video> netflix, int ind1, int ind2) {
        Video temp = new Video(netflix.get(ind1)); // Temporary video object to store swapped object
        netflix.set(ind1, netflix.get(ind2));
        netflix.set(ind2, temp);

        return netflix;
    }


}
