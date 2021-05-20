package gustavo.proj.demo.controle;

import gustavo.proj.demo.modelo.ProdutoEntity;
import gustavo.proj.demo.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
    public class ProdutoControle {

@Autowired
    private ProdutoRepositorio produtoRepositorio;
@GetMapping
    public ResponseEntity<List<ProdutoEntity>> findAll() {
        return new ResponseEntity<List<ProdutoEntity>>(
                (List<ProdutoEntity>) this.produtoRepositorio.findAll(),
        new HttpHeaders(), HttpStatus.OK);
}

@GetMapping(path = "/{id}")
    public ResponseEntity<ProdutoEntity> findByID(@PathVariable("id") long id) {
    if (this.produtoRepositorio.findById(id).isPresent()) {
        return new ResponseEntity<ProdutoEntity>(
                this.produtoRepositorio.findById(id).get(),
                new HttpHeaders(), HttpStatus.OK); //error 404

    }
    return new ResponseEntity<ProdutoEntity>(HttpStatus.NOT_FOUND);
}


    public ResponseEntity<ProdutoEntity> cadastrar (@RequestBody ProdutoEntity produtoEntity) {
        return new ResponseEntity<ProdutoEntity>(
                this.produtoRepositorio.save(produtoEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );
}

@PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoEntity> atualizar (@PathVariable("id") long id,
    @RequestBody ProdutoEntity produtoEntity) throws Exception {

    if(id == 0 || !this.produtoRepositorio.existsById(id)){
        throw new Exception("Código não encontrado ou não existe");
    }
    return new ResponseEntity<ProdutoEntity>(
        this.produtoRepositorio.save(produtoEntity),
        new HttpHeaders(),
        HttpStatus.OK);
}

@DeleteMapping(value = "/{id}")
    public ResponseEntity<ProdutoEntity> deletar (@PathVariable("id") long id){
        this.produtoRepositorio.deleteById(id);
        return new ResponseEntity<ProdutoEntity>(new HttpHeaders(), HttpStatus.OK);
}
}