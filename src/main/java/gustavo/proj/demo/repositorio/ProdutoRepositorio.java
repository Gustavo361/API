package gustavo.proj.demo.repositorio;

import gustavo.proj.demo.modelo.ProdutoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProdutoRepositorio  extends CrudRepository<ProdutoEntity, Long> {
}
