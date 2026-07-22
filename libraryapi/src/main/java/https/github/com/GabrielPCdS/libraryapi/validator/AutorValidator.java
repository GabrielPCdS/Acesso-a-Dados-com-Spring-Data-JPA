package https.github.com.GabrielPCdS.libraryapi.validator;

import https.github.com.GabrielPCdS.libraryapi.exceptions.RegistroDublicadoException;
import https.github.com.GabrielPCdS.libraryapi.model.Autor;
import https.github.com.GabrielPCdS.libraryapi.repository.AutorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AutorValidator {

    private final AutorRepository repository;

    public AutorValidator(AutorRepository repository) {
        this.repository = repository;
    }

    public void validar(Autor autor) {
        if (existeAutorCadastrado(autor)) {
            throw new RegistroDublicadoException("Autor já cadastrado!");

        }
    }
    private boolean existeAutorCadastrado(Autor autor){
        List<Autor> autorEncontrado = repository.findByNameAndDataNascimentoAndNacionalidade(
            autor.getName(), autor.getDataNascimento(), autor.getNacionalidade()
        );

        if (autorEncontrado.isEmpty()) {
            return false;
        }

        if(autor.getId() == null){
            return true;
        }
        return autorEncontrado.stream()
                .anyMatch(a -> !a.getId().equals(autor.getId()));
    }

}