package com.krystiankrawczyk.portfolio.repository;

import com.krystiankrawczyk.portfolio.db.SocialLogDb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialLogRepository extends JpaRepository<SocialLogDb, Long> {
}
