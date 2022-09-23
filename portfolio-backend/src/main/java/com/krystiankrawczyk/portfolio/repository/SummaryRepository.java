package com.krystiankrawczyk.portfolio.repository;

import com.krystiankrawczyk.portfolio.db.SummaryDb;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.krystiankrawczyk.portfolio.db.SummaryDb.REVISION_COLUMN;

@Repository
public interface SummaryRepository extends JpaRepository<SummaryDb, Long> {

    default Optional<SummaryDb> findLatest() {
        return findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, REVISION_COLUMN)))
                .get()
                .findFirst();
    }
}
