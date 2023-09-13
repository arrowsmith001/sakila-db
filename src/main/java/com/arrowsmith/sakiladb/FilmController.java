package com.arrowsmith.sakiladb;

import com.arrowsmith.sakiladb.entities.Actor;
import com.arrowsmith.sakiladb.entities.Category;
import com.arrowsmith.sakiladb.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping("")
    public Film saveFilm(@RequestBody Film film) {
        return filmService.saveFilm(film);
    }

    @GetMapping("")
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable Integer id) {
        return filmService.getFilmById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Integer id) {
        filmService.deleteFilm(id);
    }

    @GetMapping("/test")
    public void f() {

        List<Film> films = filmService.getAllFilms();
        for (Film f: films)
        {
            System.out.println(f.getTitle());
            System.out.println("\t" + f.language.name);
//            for (Category a: f.categories
//                 ) {
//                System.out.println("\t" + a.name);
//            }
        }
    }

//    private void getImage(String title)
//    {
    //String key = ?;
//        String term = String.join("+", (title.toLowerCase() + " movie poster").split(" "));
//        String url = "https://www.googleapis.com/customsearch/v1?key="+key+"&cx=017576662512468239146:omuauf_lfve&q=" + term;
//
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "[{\"q\":\"apple inc\"},{\"q\":\"google inc\"},{\"q\":\"tesla inc\"}]");
//        Request request = new Request.Builder()
//                .url("https://google.serper.dev/images")
//                .method("POST", body)
//                .addHeader("X-API-KEY", "371e1d2d607724f2e063985de79df8c8aee2247d")
//                .addHeader("Content-Type", "application/json")
//                .build();
//        Response response = client.newCall(request).execute();
//
//    }
}