package gustavo.proj.demo.modelo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Component
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

@Entity
@Table (name= "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_produto")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name= "marca")
    private String marca;

    @Column(name= "cor")
    private String cor;

    @Column(name= "preco")
    private double preco;

}