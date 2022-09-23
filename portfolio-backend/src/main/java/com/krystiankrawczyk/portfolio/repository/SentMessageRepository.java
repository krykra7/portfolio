package com.krystiankrawczyk.portfolio.repository;

import com.krystiankrawczyk.portfolio.db.SentMessageDb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentMessageRepository extends JpaRepository<SentMessageDb, Long> {
}
