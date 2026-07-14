package https.github.com.GabrielPCdS.libraryapi.repository;

import https.github.com.GabrielPCdS.libraryapi.model.Autor;
import https.github.com.GabrielPCdS.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

    // query method

    List<Livro> findByAutor(Autor autor);
}
