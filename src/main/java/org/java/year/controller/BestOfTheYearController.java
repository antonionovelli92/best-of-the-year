package org.java.year.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BestOfTheYearController {

    @GetMapping("/")
    public String home(Model model) {
        String name = "Antonio Novelli";
        model.addAttribute("name", "Best of the year by: " + name);
        return "index";
    }

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Rocky"));
        movies.add(new Movie(2, " Cambia la tua vita con un click"));
       
        return movies;
    }

    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Oasis - Wonderwall"));
        songs.add(new Song(2, " Viva la chiesa cristiana"));
        return songs;
    }

//    @GetMapping("/movies")
//    public String movies(Model model) {
//        List<Movie> movies = getBestMovies();
//        List<String> movieTitles = new ArrayList<>();
//        for (Movie movie : movies) {
//            movieTitles.add(movie.getTitolo());
//        }
//        model.addAttribute("titoli", String.join(",", movieTitles));
//        return "movies";
//    }
    
    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<Movie> movies = getBestMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }


//    @GetMapping("/songs")
//    public String songs(Model model) {
//        List<Song> songs = getBestSongs();
//        List<String> songTitles = new ArrayList<>();
//        for (Song song : songs) {
//            songTitles.add(song.getTitolo());
//        }
//        model.addAttribute("titoli", String.join(",", songTitles));
//        return "songs";
//    }
//    
    
    @GetMapping("/songs")
    public String getSongs(Model model) {
        List<Song> songs = getBestSongs();
        model.addAttribute("songs", songs);
        return "songs";
    }

    //****************************************** dettagli *************************
    
    
    
    @GetMapping("/movies/{id}")
    public String movieDetails(@PathVariable int id, Model model) {
        List<Movie> movies = getBestMovies();
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                model.addAttribute("titolo", movie.getTitolo());
                break;
            }
        }
        return "movie-details";
    }
    
    
    @GetMapping("/songs/{id}")
    public String songDetails(@PathVariable int id, Model model) {
        List<Song> songs = getBestSongs();
        for (Song song : songs) {
            if (song.getId() == id) {
                model.addAttribute("titolo", song.getTitolo());
                break;
            }
        }
        return "song-details";
    }
    
    }

