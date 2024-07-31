package br.com.ifpe.oxefood.model.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    @Query(value = "Select c from Cliente c where c.cpf like %:cpf%" )
    List<Cliente> buscarPorCpf(String cpf);

    @Query(value = "Select c from Cliente c where c.nome like %:nome%" )
    List<Cliente> buscarPorNome(String nome);

    @Query(value = "Select c from Cliente c where c.cpf like %:cpf% and c.nome like %:nome%")
    List<Cliente> consultarPorCpfENome(String cpf, String nome);
}
