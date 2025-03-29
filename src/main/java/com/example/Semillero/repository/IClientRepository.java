package com.example.Semillero.repository;

import com.example.Semillero.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<ClientEntity, Long> {
}
