package com.miguel.Spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.miguel.Spring.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long>{
    Evento findByEmailAndPassword(String email, String password);
}
