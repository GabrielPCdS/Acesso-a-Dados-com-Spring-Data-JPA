package https.github.com.GabrielPCdS.libraryapi.repository;

import https.github.com.GabrielPCdS.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AutorRepository  extends JpaRepository<Autor, UUID> {

    List<Autor>findByName(String name);
    List<Autor>findByNacionalidade(String nacionalidade);
    List<Autor>findByNameAndNacionalidade(String name, String nacionalidade);

    List<Autor> findByNameAndDataNascimentoAndNacionalidade(
            String nome, LocalDate dataNascimento, String nacionalidade
    );

}


