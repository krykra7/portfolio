package com.krystiankrawczyk.portfolio.repository;

import com.krystiankrawczyk.portfolio.db.EntryLogDb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryLogRepository extends JpaRepository<EntryLogDb, Long> {
}
