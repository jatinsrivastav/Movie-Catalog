package com.movie_catalog.Controller;

import com.movie_catalog.model.CatalogItem;
import com.movie_catalog.model.Movie;
import com.movie_catalog.model.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        RestTemplate restTemplate =new RestTemplate();

        Rating rating1 =new Rating("123",9);
        Rating rating2 = new Rating("34",8);
        List<Rating> ratings = Arrays.asList(rating1,rating2);


      return ratings.stream().map(rating -> {
          Movie movie=restTemplate.getForObject("http://localhost:8081/movies/"
              +rating.getMovieId(), Movie.class);
          return new CatalogItem(movie.getName(),"noic",rating.getRating());
        }).collect(Collectors.toList());


        //return Collections.singletonList(new CatalogItem("you", "noic",9));
    }

}
