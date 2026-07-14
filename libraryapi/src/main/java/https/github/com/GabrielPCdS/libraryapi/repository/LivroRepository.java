package https.github.com.GabrielPCdS.libraryapi.repository;

import https.github.com.GabrielPCdS.libraryapi.model.Autor;
import https.github.com.GabrielPCdS.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

    // query method
    //select * from livro where id_autor = id
    List<Livro> findByAutor(Autor autor);

    //select * from livro where titulo = titulo
    List<Livro> findByTitulo(String titulo);

    // select * from livro where isbn = ?
    List<Livro> findByIsbn(String titulo);

    //select ¨ from livro where titulo = ? and preco = ?
    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);

    //select * from livro where titulo = ? or isbn = ?
    List<Livro> findbytituloOrIsbn(String titulo, String isbn);
}
