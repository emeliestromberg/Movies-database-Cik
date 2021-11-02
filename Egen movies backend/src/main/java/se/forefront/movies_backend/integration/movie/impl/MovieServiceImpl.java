package se.forefront.movies_backend.integration.movie.impl;

import org.springframework.stereotype.Service;
import se.forefront.movies_backend.domain.model.Movie;
import se.forefront.movies_backend.integration.movie.api.MovieService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


// Den här sidan är inte behövd pga här skapade vi metoder som vi importerade i ApiControllern.
// Nu skapar vi metoderna där vi kallade på metoderna. Allt finns i ApiControllern.


@Service
public class MovieServiceImpl implements MovieService {

    List<Movie> ourOwnMovieDatabase = new ArrayList<>();

    public List<Movie> getAllMovies() {
        return ourOwnMovieDatabase;
    }

    public void addMovie(Movie movie) {
        int id = ourOwnMovieDatabase.size() + 1;
        movie.setId(id.toString());
        ourOwnMovieDatabase.add(movie);
    }
    
    public void deleteMovie(String id) {    // Varför har vi String och id?
        ourOwnMovieDatabase = ourOwnMovieDatabase.stream()
                .filter(movie -> !movie.getId().equals(id)).collect(Collectors.toList()); 
        // Den filtrerar databasen och säger att alla som inte har id:et vi anger (alltså den filmen med
        // det id:t som vi hatar) de, alltså de bra filmerna, de samlar vi och lägger undan. 

    }
}
