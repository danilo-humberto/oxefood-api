package br.com.ifpe.oxefood.model.entregador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EntregadorService {
    
    @Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {
        
        entregador.setHabilitado(true);
        entregador.setVersao(1L);
        entregador.setDataCriacao(LocalDate.now());

        return repository.save(entregador);
    }
}
