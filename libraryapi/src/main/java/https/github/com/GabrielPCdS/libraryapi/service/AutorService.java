package https.github.com.GabrielPCdS.libraryapi.service;

import https.github.com.GabrielPCdS.libraryapi.model.Autor;
import https.github.com.GabrielPCdS.libraryapi.repository.AutorRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository){
        this.repository = repository;
    }

    public Autor salvar(Autor autor){
        return repository.save(autor);
    }
}
