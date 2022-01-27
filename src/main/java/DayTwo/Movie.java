package DayTwo;

import java.util.ArrayList;
import java.util.Collections;

/*
A comparable object is capable of comparing itself with another object. The class itself must implements
 the java.lang.Comparable interface to compare its instances.
Consider a Movie class that has members like, rating, name, year. Suppose we wish to sort a list of Movies
 based on year of release. We can implement the Comparable interface with the Movie class, and we override
  the method compareTo() of Comparable interface.

 */

public class Movie implements Comparable<Movie>{
    private double rating;
    private String name;
    private int year;

    public static void main(String[] args)
    {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        Collections.sort(list);

        System.out.println("Movies after sorting : ");
        for (Movie movie: list)
        {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }
    }
    // Used to sort movies by year
    public int compareTo(Movie m)
    {
        return this.year - m.year;
    }

    // Constructor
    public Movie(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    // Getter methods for accessing private data
    public double getRating() { return rating; }
    public String getName()   {  return name; }
    public int getYear()      {  return year;  }

}
