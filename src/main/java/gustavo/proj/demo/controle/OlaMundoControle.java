package gustavo.proj.demo.controle;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaMundoControle {

    @GetMapping("/")
    public String index() {
        return "Seja muito bem vindo ao Sistema de API";
    }
}
