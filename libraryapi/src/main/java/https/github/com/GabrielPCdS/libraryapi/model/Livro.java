package https.github.com.GabrielPCdS.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Livro")
@Data
public class Livro {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn; // é um código numérico de 13 dígitos que funciona como o "RG" ou "CPF" de um livro

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", length = 30, nullable = false)
    private GeneroLivro genero;

    @Column
    private BigDecimal preco;

    @ManyToOne//(cascade = CascadeType.ALL )
    @JoinColumn(name = "id_autor")
    private Autor autor;

}
