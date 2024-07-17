package br.com.ifpe.oxefood.api.fabricante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.model.fabricante.Fabricante;
import br.com.ifpe.oxefood.model.fabricante.FabricanteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/fabricante")
@CrossOrigin
public class FabricanteController {
    
    @Autowired
    private FabricanteService fabricanteService;
    
    @Operation(
       summary = "Serviço responsável por salvar um fabricante no sistema."
    )
    @PostMapping
    public ResponseEntity<Fabricante> save(@RequestBody FabricanteRequest request) {

        Fabricante fabricante = fabricanteService.save(request.build());
        return new ResponseEntity<Fabricante>(fabricante, HttpStatus.CREATED);
    }

    @Operation(
       summary = "Serviço responsável por listar todos os fabricantes no sistema."
    )
    @GetMapping
    public List<Fabricante> listarTodos() {
        return fabricanteService.listarTodos();
    }

    @Operation(
       summary = "Serviço responsável por deletar um fornecedor no sistema."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fabricanteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
