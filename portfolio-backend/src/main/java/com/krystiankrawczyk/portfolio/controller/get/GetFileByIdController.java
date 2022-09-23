package com.krystiankrawczyk.portfolio.controller.get;

import com.krystiankrawczyk.portfolio.api.provider.MediaTypeProvider;
import com.krystiankrawczyk.portfolio.provider.FileProvider;

import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/")
public class GetFileByIdController {

    private final FileProvider fileProvider;
    private final MediaTypeProvider mediaTypeProvider;

    @GetMapping(value = "/files/{fileId}")
    public ResponseEntity<Resource> getFileById(@PathVariable("fileId") Long fileId) {
        Resource file = fileProvider.getFileById(fileId);

        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .contentType(mediaTypeProvider.getMediaType(file.getFilename()))
                .body(file);
    }

    public GetFileByIdController(FileProvider fileProvider,
                                   MediaTypeProvider mediaTypeProvider) {
        this.mediaTypeProvider = mediaTypeProvider;
        this.fileProvider = fileProvider;
    }
}
