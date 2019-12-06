import java.util.ArrayList;
import java.util.Scanner;

class Methods extends Movie{
    Methods() {}


    //static int size = 0;
    private static Scanner stdIn = new Scanner(System.in);

    static ArrayList<Movie> movieList = new ArrayList<>();

    void fillArray() {
        movieList.add(new Movie("Avengers", "Robert Downey Jr", "2012", "Action"));
        movieList.add(new Movie("Incredibles", "Craig Nelson", "2004", "Animation"));
        movieList.add(new Movie("Godfather", "Al Pacino", "1972", "Crime"));
        movieList.add(new Movie("Inception", "Leonardo DiCaprio", "2010", "Action"));
        movieList.add(new Movie("Matrix", "Keanu Reeves", "1999", "Action"));
        movieList.add(new Movie("Interstellar", "Matthew McConaughey", "2014", "Drama"));
        movieList.add(new Movie("Se7en", "Brad Pitt", "1995", "Crime"));
        movieList.add(new Movie("Prestige", "Christian Bale", "2006", "Drama"));
        movieList.add(new Movie("Departed", "Leonardo DiCaprio", "2006", "Crime"));
        movieList.add(new Movie("Memento", "Guy Pierce", "2000", "Drama"));
        movieList.add(new Movie("Pianist", "Adrien Brody", "2002", "Drama"));
        movieList.add(new Movie("Gladiator", "Russel Crowe", "2000", "Action"));
        movieList.add(new Movie("Terminator", "Arnold Schwarzenegger", "1984", "Action"));
        movieList.add(new Movie("Superman", "Christopher Reeve", "1978", "Action"));
        movieList.add(new Movie("Alien", "Sigourney Weaver", "1978", "Horror"));
        movieList.add(new Movie("Braveheart", "Mel Gibson", "1995", "Action"));
        movieList.add(new Movie("Scarface", "Al Pacino", "1983", "Crime"));
//        size = 16;

    }


    void addMovies() {

        System.out.println("Title:");
        String newTitle = stdIn.nextLine();
        System.out.println("Lead Actor/Actress:");
        String newActor = stdIn.nextLine();
        System.out.println("Year:");
        String newYear = stdIn.nextLine();
        System.out.println("Genre:");
        String newGenre = stdIn.nextLine();
        addMovies(newTitle, newActor, newYear, newGenre);
    }

    private void addMovies(Movie newMovie){
        movieList.add(newMovie);
        // size++;
    }

    private void addMovies(String title, String actor, String year, String genre) {

        movieList.add(new Movie(title, actor, year, genre));
        // size++;
    }


    private ArrayList<Movie> getMovieList() {
        return movieList;
    }



    private Movie searchMoviesByTitle(String titleSearch) {

        int movieIndex = -1;
        boolean movieFound = false;
        for (int i = 0; i < movieList.size(); i++) {

            if (movieList.get(i).getTitle().equalsIgnoreCase(titleSearch)) {
                movieFound = true;
                movieIndex = i;
            }
        }
        if (movieFound) {
            movieFound(movieList.get(movieIndex));
        }

        return movieList.get(movieIndex);
    }

    private Movie searchMoviesByActor(String actorSearch) {

        int movieIndex = -1;
        boolean movieFound = false;
        for (int i = 0; i < movieList.size(); i++) {

            if (movieList.get(i).getActor().equalsIgnoreCase(actorSearch)) {
                movieFound = true;
                movieIndex = i;
            }
        }
        if (movieFound) {
            movieFound(movieList.get(movieIndex));
        }

        return movieList.get(movieIndex);
    }


    private Movie searchMoviesByYear(String yearSearch) {

        int movieIndex = -1;
        boolean movieFound = false;
        for (int i = 0; i < movieList.size(); i++) {

            if (movieList.get(i).getYear().equalsIgnoreCase(yearSearch)) {
                movieFound = true;
                movieIndex = i;
            }
        }
        if (movieFound) {
            movieFound(movieList.get(movieIndex));
        }

        return movieList.get(movieIndex);
    }


    private Movie searchMoviesByGenre(String genreSearch) {
        int movieIndex = -1;
        boolean movieFound = false;
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getGenre().equalsIgnoreCase(genreSearch)) {
                movieFound = true;
                movieIndex = i;
            }
        }
        if (movieFound) {
            movieFound(movieList.get(movieIndex));
        }

        return movieList.get(movieIndex);
    }





    void removeMovie() {
        boolean nonValid= true;
        do {

            try {
                System.out.println("Select number associated with movie to be removed");
                int deleteMovie;
                deleteMovie = Integer.parseInt(stdIn.nextLine());
                getMovieList().remove(deleteMovie - 1);
                System.out.println("Updated List:\n" + toString());
                nonValid = false;

            } catch (IndexOutOfBoundsException e)
            {

                System.out.println("Non valid Entry. Selection out of bound of list.");

            } catch (NumberFormatException nfe){
                System.out.println("Non valid entry. Input must be a number.");
            }

        }   while (nonValid);
    }

    private void movieFound(Movie movieFound) {

        System.out.println("" + movieFound.getTitle() + ", "  +movieFound.getYear());
    }


    static Methods reverseMovies()
    {
        Methods reverseMovies = new Methods();

        for (int i = movieList.size() - 1; i >= 0; i--) {


            reverseMovies.addMovies(movieList.get(i));
        }

        return reverseMovies;
    }

    public String toString(){

        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i <movieList.size() ; i++) {
            returnString.append(i+1).append("\n");
            returnString.append("Movie title: ").append(movieList.get(i).getTitle()).append("\n");
            returnString.append("Lead Actor: ").append(movieList.get(i).getActor()).append("\n");
            returnString.append("Release Year: ").append(movieList.get(i).getYear()).append("\n");
            returnString.append("Genre: ").append(movieList.get(i).getGenre()).append("\n");


        }

        return returnString.toString();

    }

    void searchMovie() {

        System.out.println("Search by:\n1. Title\n2. Lead Actor/Actress\n3. Release Year\n4. Genre");
        boolean isValid = false;
        int searchType = 0;
        while (!isValid) {
            while (!stdIn.hasNextInt()) {
                System.out.println("Valid number not entered. Enter 1, 2, 3, or 4.");
                stdIn.next();
            }
            searchType = stdIn.nextInt();
            if (searchType != 1 && searchType != 2 && searchType != 3 && searchType != 4) {
                System.out.println("Please select either 1, 2, or 3.");
                continue;
            }
            isValid = true;
        }
        stdIn.nextLine();


        if (searchType == 1) {
            System.out.println("Please enter a movie title to search for.");
            String titleSearch = stdIn.nextLine().toLowerCase();
            System.out.println(searchMoviesByTitle(titleSearch));


        } else if (searchType == 2) {
            System.out.println("Please enter an actor or actress to search for");
            String actorSearch = stdIn.nextLine().toLowerCase();
            System.out.println(searchMoviesByActor(actorSearch));

        } else if (searchType == 3) {
            System.out.println("Please enter a release year to search.");
            String yearSearch = stdIn.next().toLowerCase();
            System.out.println(searchMoviesByYear(yearSearch));
            Sorting.sortFound(stdIn, movieList);
        } else {
            System.out.println("Please enter a genre to search for.");
            String genreSearch = stdIn.next();
            System.out.println(searchMoviesByGenre(genreSearch));
            Sorting.sortFound(stdIn, movieList);
        }
    }

}


