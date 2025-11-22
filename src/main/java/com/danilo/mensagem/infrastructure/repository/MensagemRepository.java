package com.danilo.mensagem.infrastructure.repository;

import com.danilo.mensagem.infrastructure.entity.MensagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends JpaRepository<MensagemEntity, Long> {
}
