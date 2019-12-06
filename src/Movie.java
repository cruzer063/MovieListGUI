import java.util.ArrayList;


public class Movie extends ArrayList implements Comparable<Movie> {

    private String title;
    private String actor;
    private String year;
    private String genre;

    Movie(String title, String actor, String year, String genre) {
        this.title = title;
        this.actor = actor;
        this.year = year;
        this.genre = genre;

    }

    Movie() { }

    String getTitle() {
        return title;
    }

    String getActor() {
        return actor;
    }

    String getYear() {return year;}

    String getGenre() { return genre; }

    public int compareTo(Movie anotherMovie) {
        return this.getTitle().compareToIgnoreCase(anotherMovie.getTitle());


    }


}

