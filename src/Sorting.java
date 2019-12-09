import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

class Sorting extends Methods {
    Sorting (){}

    private static int partition(ArrayList<Movie> arr, int low, int high)
    {

        Movie pivot = arr.get(high);
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr.get(j).compareTo(pivot) < 0)
            {

                i++;


                swap(i,j, arr);
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
                    swap(j, j+1, arr);
    }
    private static void swap(int i, int j, ArrayList<Movie> arr){
        Movie temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static String sortFound(int sortType, int sortChoice, ArrayList<Movie> movieList) {
        ArrayList<Movie> sortedMovieList = (ArrayList<Movie>) movieList.clone();
        if (movieList.size() != 0) {
            long time = sortMovies(sortType, sortedMovieList);

            String message = "List sorted in " + time + " nano seconds.";
            JOptionPane.showMessageDialog(new JFrame(), message, "Fun Fact",
                    JOptionPane.INFORMATION_MESSAGE);
            if (sortChoice == 1)
                return sortedMovieList.toString();
            else
                return Methods.reverseMovies(sortedMovieList).toString();
        }
        return "No Movies to sort.";
    }


    static long sortMovies(int i, ArrayList<Movie> sortedMovieList){
        long startTime;
        if (i == 1) {
            startTime = System.nanoTime();
            quickSort(sortedMovieList, 0, sortedMovieList.size()-1);
            return System.nanoTime() - startTime;
        }
        else {
            startTime = System.nanoTime();
            bubbleSort(sortedMovieList, sortedMovieList.size());
            return  System.nanoTime() - startTime;
        }
    }
}
