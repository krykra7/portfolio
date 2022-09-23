package com.krystiankrawczyk.portfolio.api.provider;

import com.krystiankrawczyk.portfolio.exception.AppException;
import com.krystiankrawczyk.portfolio.exception.message.ApiMessageCode;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MediaTypeProvider {
    private static final String JPG = "jpg";
    private static final String PNG = "png";
    private static final String PDF = "pdf";

    public MediaType getMediaType(String fileName) {
        return mapMediaType(getExtension(fileName));
    }

    private String getExtension(String fileName) {
        return Optional.ofNullable(fileName)
                .filter(name -> name.contains("."))
                .map(name -> name.substring(fileName.lastIndexOf(".") + 1))
                .orElseThrow(() -> new AppException(ApiMessageCode.FILENAME_DOES_NOT_EXIST));
    }

    private MediaType mapMediaType(String extension) {
        switch (extension) {
            case JPG:
                return MediaType.IMAGE_JPEG;
            case PNG:
                return MediaType.IMAGE_PNG;
            case PDF:
                return MediaType.APPLICATION_PDF;
            default:
                throw new AppException(ApiMessageCode.WRONG_MEDIA_TYPE);
        }
    }
}
