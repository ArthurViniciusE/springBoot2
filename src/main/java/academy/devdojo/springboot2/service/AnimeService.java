package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    //private final AnimeRepository animeRepository;
    private static List<Anime> animes;
    static {
        animes = new ArrayList<>( List.of(new Anime(1L,"DBZ"), new Anime(2L,"InazumaEleven")));
    }
    public List<Anime> listAll(){
        return animes;
    }
    public Anime findByID(long id){
        return animes.stream().
                filter(anime -> anime.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3,2000));
        animes.add(anime);
        return anime;
    }

    public void delete(long id) {
        animes.remove(findByID(id));
    }

    public void replace(Anime anime) {
        delete(anime.getId());
        animes.add(anime);
    }
}

