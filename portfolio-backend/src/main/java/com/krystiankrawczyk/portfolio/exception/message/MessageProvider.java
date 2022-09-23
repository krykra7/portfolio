package com.krystiankrawczyk.portfolio.exception.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageProvider {

    private static final Logger log = LoggerFactory.getLogger(MessageProvider.class);
    private static ResourceBundleMessageSource bundleMessageSource;

    public MessageProvider() {
        bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasename("locale/messages");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        bundleMessageSource.setUseCodeAsDefaultMessage(true);
    }

    public static String getMessage(ApiMessageCode messageCode) {
        String message = bundleMessageSource.getMessage(messageCode.name(), null, Locale.getDefault());
        log.info(message);
        return message;
    }
}
