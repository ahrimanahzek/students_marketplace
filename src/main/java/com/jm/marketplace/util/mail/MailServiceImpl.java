package com.jm.marketplace.util.mail;

import com.jm.marketplace.model.User;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collection;

@Component
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;
    private MailService mailService;
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
        javaMailSender.send(mailMessage);
    }

    @Override
    public void send(@NonNull User user, @NonNull String subject, @NonNull String message, @NonNull File... files) {

    }

    @Override
    public void broadcast(@NonNull Collection<User> users, @NonNull String subject, @NonNull String message) {
        users.forEach(user -> send(user, subject, message));
    }

    @Override
    public void broadcast(@NonNull Collection<User> users, @NonNull String subject, @NonNull String message, @NonNull File... files) {

    }
}
