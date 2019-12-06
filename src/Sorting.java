import java.util.ArrayList;
import java.util.Scanner;

class Sorting extends Methods {
    Sorting (){}
    private static boolean isValid;

    private static int partition(ArrayList<Movie> arr, int low, int high)
    {

        Movie pivot = arr.get(high);
        int i = (low-1);
        for (int j=low; j<high; j++)
        {

            if (arr.get(j).compareTo(pivot) < 0)
            {

                i++;


                swap(i,j);
            }

        }

        Movie temp = arr.get(i+1);
        arr.set(i+1, arr.get(high));
        arr.set(high, temp);

        return i+1;
    }


    private static void quickSort(ArrayList<Movie> arr, int low, int high)
    {

        if (low < high)
        {

            int pi = partition(arr, low, high);


            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    private static void bubbleSort(ArrayList<Movie> arr, int n)
    {
        int i, j;
        for (i = 0; i < n-1; i++)


            for (j = 0; j < n-i-1; j++)
                if (arr.get(j).compareTo(arr.get(j+1)) > 0)
                    swap(j, j+1);
    }
    private static void swap(int i, int j){
        Movie temp = movieList.get(i);
        movieList.set(i, movieList.get(j));
        movieList.set(j, temp);
    }

    static void sortFound(Scanner stdIn, ArrayList movieList) {
        if (movieList.size() != 0) {
            int sortChoice = -1;

            System.out.println("1. Quick Sort\n" +
                    "2. Bubble Sort");


            sortChoice = getSortChoice(stdIn, sortChoice);
            long time = sortMovies(sortChoice);
            isValid = false;
            System.out.println("Enter 1 for A-Z or 2 for Z-A.");
            while (!isValid) {
                while (!stdIn.hasNextInt()) {
                    System.out.println("Enter 1 for A-Z or 2 for Z-A.");
                    stdIn.next();
                }
                sortChoice = stdIn.nextInt();
                if (sortChoice != 1 && sortChoice != 2) {
                    System.out.println("Please select either 1 or 2.");
                    continue;
                }
                isValid = true;
            }
            if (sortChoice == 1) {
                for (int i = 0; i < movieList.size(); i++) {
                    System.out.printf("%s. %s\n", i+1, movieList.get(i));
                }


                System.out.println("List sorted in " + time + " nano seconds.");
            } else {

                System.out.println(Methods.reverseMovies().toString());
                System.out.println("List sorted in " + time + " nano seconds.");

            }
        }
    }

    static int getSortChoice(Scanner stdIn, int sortChoice) {
        while(!isValid) {
            while (!stdIn.hasNextInt()) {
                System.out.println("Number not entered. Enter 1 or 2.");
                stdIn.next();
            }
            sortChoice = stdIn.nextInt();
            if (sortChoice != 1 && sortChoice != 2) {
                System.out.println("Select either 1 or 2.");
                continue;
            }
            isValid = true;
        }
        return sortChoice;
    }


    static long sortMovies(int i){
        long startTime;
        if (i == 1) {
            startTime = System.nanoTime();
            quickSort(movieList, 0, movieList.size()-1);
            return System.nanoTime() - startTime;
        }
        else {
            startTime = System.nanoTime();
            bubbleSort(movieList, movieList.size());
            return  System.nanoTime() - startTime;
        }
    }
}
