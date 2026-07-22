package https.github.com.GabrielPCdS.libraryapi.service;

import https.github.com.GabrielPCdS.libraryapi.exceptions.OperacaoNaoPermitidaException;
import https.github.com.GabrielPCdS.libraryapi.model.Autor;
import https.github.com.GabrielPCdS.libraryapi.repository.AutorRepository;
import https.github.com.GabrielPCdS.libraryapi.repository.LivroRepository;
import https.github.com.GabrielPCdS.libraryapi.validator.AutorValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository repository;
    private final AutorValidator validator;
    private final LivroRepository livroRepository;


    public Autor salvar(Autor autor){
        validator.validar(autor);
        return repository.save(autor);
    }

    public void atualizar(Autor autor){
        if (autor.getId() == null){
            throw new IllegalArgumentException("Para Atualizar é necessario que o autor já " +
                    "esteja salvo na base.");
        }
        validator.validar(autor);
        repository.save(autor);
    }

    public Optional<Autor> obterPorId(UUID id){
        return repository.findById(id);
    }

    public void deletar(Autor autor){
        if (possuiLivro(autor)){
            throw new OperacaoNaoPermitidaException(
                    "Não é permitido excluir um Autor que possui Livros cadastrados!");
        }
        repository.delete(autor);


    }
    public List<Autor> pesquisa(String name, String nacionalidade){
        if (name != null && nacionalidade != null){
            return repository.findByNameAndNacionalidade(name, nacionalidade);
        }
        if (name != null){
            return repository.findByName(name);
        }

     if (nacionalidade != null){
         return repository.findByNacionalidade(nacionalidade);
     }
     return repository.findAll();
    }

    public boolean possuiLivro(Autor autor){
        return livroRepository.existsByAutor(autor);
    }

}
