package https.github.com.GabrielPCdS.libraryapi;

import https.github.com.GabrielPCdS.libraryapi.model.Autor;
import https.github.com.GabrielPCdS.libraryapi.repository.AutorRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	var context = SpringApplication.run(Application.class, args);
		AutorRepository repository = context.getBean(AutorRepository.class);

		exemploSalvarRegistro(repository);
	}

	 public static void exemploSalvarRegistro(AutorRepository autorRepository){
		 Autor autor = new Autor();
		 autor.setName("Jose");
		 autor.setNacionalidade("Brasileira");
		 autor.setDataNascimento(LocalDate.of(1980, 1,31));

		 var autorSalvo = autorRepository.save(autor);
		 System.out.println("Autor salvo: " + autorSalvo);

	 }
}
