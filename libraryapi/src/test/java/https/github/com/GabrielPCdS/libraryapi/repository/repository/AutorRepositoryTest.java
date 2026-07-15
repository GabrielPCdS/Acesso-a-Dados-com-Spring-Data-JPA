package https.github.com.GabrielPCdS.libraryapi.repository.repository;

import https.github.com.GabrielPCdS.libraryapi.model.Autor;
import https.github.com.GabrielPCdS.libraryapi.model.GeneroLivro;
import https.github.com.GabrielPCdS.libraryapi.model.Livro;
import https.github.com.GabrielPCdS.libraryapi.repository.AutorRepository;
import https.github.com.GabrielPCdS.libraryapi.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setName("Jean");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1971, 1, 31));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor Salvo: " + autorSalvo);
    }

    @Test
    public void atualizarTest(){
        var id = UUID.fromString("7d67bb34-8557-4fcb-817b-73fbad368190");

        Optional<Autor> possivelAutor = repository.findById(id);

        if(possivelAutor.isPresent()){

            Autor autorEncontrado =  possivelAutor.get();
            System.out.println("Dados do Autor:");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(1990, 1, 30));

            repository.save(autorEncontrado);

        }
    }

    @Test
    public void listarTest(){
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTest(){
        System.out.println("Contagem de autores: " + repository.count());
    }

    @Test
    public void deletePorIdTest(){
        var id = UUID.fromString("7d67bb34-8557-4fcb-817b-73fbad368190");
        repository.deleteById(id);
    }

    @Test
    public void deleteTest(){
        var id = UUID.fromString("7d67bb34-8557-4fcb-817b-73fbad368190");
        var maria = repository.findById(id).get();
        repository.delete(maria);
    }

    @Test
    void salvarAutorComLivrosTest(){
        Autor autor = new Autor();
        autor.setName("Antonio");
        autor.setNacionalidade("Americano");
        autor.setDataNascimento(LocalDate.of(1970,8,5));

        Livro livro = new Livro();
        livro.setIsbn("20887-84874");
        livro.setPreco(BigDecimal.valueOf(204));
        livro.setGenero(GeneroLivro.MISTERIO);
        livro.setTitulo("O roubo da casa mal assombrada");
        livro.setDataPublicacao(LocalDate.of(1999, 1, 2));
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setIsbn("99999-84874");
        livro2.setPreco(BigDecimal.valueOf(654));
        livro2.setGenero(GeneroLivro.MISTERIO);
        livro2.setTitulo("O roubo da casa mal assombrada");
        livro2.setDataPublicacao(LocalDate.of(2000, 1, 2));
        livro2.setAutor(autor);


        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);

        livroRepository.saveAll(autor.getLivros());

    }

    @Test
    void listarLivrosAutor(){
        var id = UUID.fromString("a01bcf89-f01c-416b-a9ab-d8959a7a7bd2");
        var autor = repository.findById(id).get();

        List<Livro> livroLista = livroRepository.findByAutor(autor);
        autor.setLivros(livroLista);

        autor.getLivros().forEach(System.out::println);
    }

}
