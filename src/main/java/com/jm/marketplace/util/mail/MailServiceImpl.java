package com.jm.marketplace.util.mail;

import com.jm.marketplace.model.User;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;

@Component
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(@NonNull User user, @NonNull String subject, @NonNull String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setText(message);
        mailMessage.setSubject(subject);
        mailMessage.setTo(user.getEmail());
        try {
            javaMailSender.send(mailMessage);
        } catch (MailException e) {
            throw new RuntimeException("", e);
        }
    }

    @Override
    public void send(@NonNull User user, @NonNull String subject, @NonNull String message, @NonNull File... files) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setText(message);
            helper.setSubject(subject);
            helper.setTo(user.getEmail());
            Arrays.stream(files).forEach(file -> {
                try {
                    helper.addAttachment(file.getName(), new FileSystemResource(file));
                } catch (MessagingException e) {
                    throw new RuntimeException("", e);
                }
            });
            javaMailSender.send(mimeMessage);
        } catch (MessagingException messageException) {
            throw new RuntimeException("", messageException);
        }
    }

    @Override
    public void broadcast(@NonNull Collection<User> users, @NonNull String subject, @NonNull String message) {
        users.forEach(user -> send(user, subject, message));
    }

    @Override
    public void broadcast(@NonNull Collection<User> users, @NonNull String subject, @NonNull String message, @NonNull File... files) {
        users.forEach(user -> send(user, subject, message, files));
    }
}
