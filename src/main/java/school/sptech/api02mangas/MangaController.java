package school.sptech.api02mangas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mangas")
public class MangaController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Listar todos
    @GetMapping
    public ResponseEntity<List<Manga>> listarTodos(){
        List<Manga> mangas = jdbcTemplate.query("SELECT * FROM manga", new BeanPropertyRowMapper<>(Manga.class));
        return ResponseEntity.status(200).body(mangas);
    }

    // Cadastro

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody Manga manga){

        jdbcTemplate.update("INSERT INTO manga(nome, autor, qtd_volumes, editora) VALUES(?, ?, ?, ?)", manga.getNome(), manga.getAutor(), manga.getQtdVolumes(), manga.getEditora());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Retorna apenas 1 por indice
    @GetMapping("/{id}")
    public ResponseEntity<Manga> buscarPorIndice(@PathVariable Integer id){

        List<Manga> mangas = jdbcTemplate.query("SELECT * FROM manga WHERE id = ?", new BeanPropertyRowMapper<>(Manga.class), id);
        if(mangas.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mangas.getFirst());
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorIndice(@PathVariable Integer id){

        List<Manga> mangas = jdbcTemplate.query("SELECT * FROM manga WHERE id = ?", new BeanPropertyRowMapper<>(Manga.class), id);

        if(mangas.isEmpty()) return ResponseEntity.notFound().build();

        jdbcTemplate.update("DELETE FROM manga WHERE id = ?", id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    }
