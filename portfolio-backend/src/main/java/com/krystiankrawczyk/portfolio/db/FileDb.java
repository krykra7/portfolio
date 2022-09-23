package com.krystiankrawczyk.portfolio.db;

import com.krystiankrawczyk.portfolio.db.enums.AppFileType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "file", schema = "portfolio")
public class FileDb {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "file_type")
    @Enumerated(EnumType.STRING)
    private AppFileType fileType;

    public long getId() {
        return id;
    }

    public FileDb setId(long id) {
        this.id = id;
        return this;
    }

    public String getFilename() {
        return filename;
    }

    public FileDb setFilename(String path) {
        this.filename = path;
        return this;
    }

    public AppFileType getFileType() {
        return fileType;
    }

    public FileDb setFileType(AppFileType fileType) {
        this.fileType = fileType;
        return this;
    }
}
