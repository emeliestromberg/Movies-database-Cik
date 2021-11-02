package se.forefront.movies_backend.integration.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.forefront.movies_backend.domain.model.Movie;
import se.forefront.movies_backend.integration.BaseApiController;
import se.forefront.movies_backend.integration.movie.api.MovieService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieApiController extends BaseApiController {

    List<Movie> testDatabase = new ArrayList<>();
    
    private final MovieService movieService;

    @Autowired
    public MovieApiController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movie/getAll")
    public List<Movie> getMovies() {
        return testDatabase;
    }

    @PostMapping("/movie/add")
    public void addMovie(@RequestBody Movie movie) {   //Vad gör en RequestBody? Ber om input för värden man bett om.

        int id = testDatabase.size() + 1;
        movie.setId(id.toString());
        testDatabase.add(movie);
    }

    @DeleteMapping("/movies/delete")
    public void deleteMovie(@RequestParam("id") String id) {
        testDatabase = testDatabase.stream()
                .filter(movie -> !movie.getId().equals(id)).collect(Collectors.toList());

    }
}
