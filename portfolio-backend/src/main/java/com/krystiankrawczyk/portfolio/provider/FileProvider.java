package com.krystiankrawczyk.portfolio.provider;

import com.krystiankrawczyk.portfolio.db.enums.AppFileType;
import com.krystiankrawczyk.portfolio.exception.AppException;
import com.krystiankrawczyk.portfolio.exception.message.ApiMessageCode;
import com.krystiankrawczyk.portfolio.exception.message.MessageProvider;
import com.krystiankrawczyk.portfolio.repository.FileDbRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class FileProvider {

    private static final Logger log = LoggerFactory.getLogger(FileProvider.class);
    private static final String path = "classpath:files/";

    private final ResourceLoader resourceLoader;
    private final FileDbRepository fileDbRepository;

    public FileProvider(ResourceLoader resourceLoader, FileDbRepository fileDbRepository) {
        this.resourceLoader = resourceLoader;
        this.fileDbRepository = fileDbRepository;
    }

    public Resource getFileByType(AppFileType type) {
        return fileDbRepository.findLatestByType(type)
                .map(file -> getByFileName(file.getFilename()))
                .orElseThrow(() -> {
                    log.error(MessageProvider.getMessage(ApiMessageCode.FAILED_TO_FIND_FILE_DB));
                    throw new AppException(ApiMessageCode.FAILED_TO_FIND_FILE_DB);
                });
    }

    public Resource getFileById(Long id) {
        return fileDbRepository.findById(id)
                .map(file -> getByFileName(file.getFilename()))
                .orElseThrow(() -> {
                    log.error(MessageProvider.getMessage(ApiMessageCode.FAILED_TO_FIND_FILE_DB));
                    throw new AppException(ApiMessageCode.FAILED_TO_FIND_FILE_DB);
                });
    }

    private Resource getByFileName(String fileName) {
        try {
            Resource resource = resourceLoader.getResource(path + fileName);
            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                log.error(MessageProvider.getMessage(ApiMessageCode.FAILED_TO_FIND_FILE));
                throw new AppException(ApiMessageCode.FAILED_TO_FIND_FILE);
            }
        } catch (Exception e) {
            log.error(MessageProvider.getMessage(ApiMessageCode.FAILED_TO_FIND_FILE), e);
            throw new AppException(ApiMessageCode.FAILED_TO_FIND_FILE);
        }
    }
}
