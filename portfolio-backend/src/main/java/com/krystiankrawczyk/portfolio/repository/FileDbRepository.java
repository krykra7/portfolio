package com.krystiankrawczyk.portfolio.repository;

import com.krystiankrawczyk.portfolio.db.FileDb;
import com.krystiankrawczyk.portfolio.db.enums.AppFileType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileDbRepository extends JpaRepository<FileDb, Long> {

    @Query(value = "SELECT fileDb FROM FileDb as fileDb WHERE fileDb.fileType = :type ORDER BY fileDb.id DESC")
    Page<FileDb> findLatestByType(AppFileType type, Pageable pageable);

    default Optional<FileDb> findLatestByType(AppFileType type) {
        return Optional.of(findLatestByType(type, PageRequest.of(0, 1)).getContent())
                .filter(content -> !content.isEmpty())
                .map(content -> content.get(0));
    }
}
