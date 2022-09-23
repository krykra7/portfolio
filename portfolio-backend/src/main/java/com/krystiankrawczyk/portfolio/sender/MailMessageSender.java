package com.krystiankrawczyk.portfolio.sender;

import com.krystiankrawczyk.portfolio.api.request.PostSendMessageRequest;
import com.krystiankrawczyk.portfolio.exception.AppException;
import com.krystiankrawczyk.portfolio.exception.message.ApiMessageCode;
import com.krystiankrawczyk.portfolio.exception.message.MessageProvider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailMessageSender {

    private final JavaMailSender javaMailSender;

    @Value("${mail.to}")
    private String mailTo;

    public MailMessageSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(PostSendMessageRequest sendMessageRequest) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sendMessageRequest.getSenderEmail());
            mailMessage.setTo(mailTo);
            mailMessage.setText(sendMessageRequest.getMessage() +
                    "\n\n\n" +
                    "Sent by: " +
                    sendMessageRequest.getSenderName() +
                    " " +
                    sendMessageRequest.getSenderEmail());
            mailMessage.setSubject("Portfolio");

            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            throw new AppException(ApiMessageCode.MAIL_FAILED, e);
        }
    }
}
