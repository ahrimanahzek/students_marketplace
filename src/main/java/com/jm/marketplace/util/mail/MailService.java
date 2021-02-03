package com.jm.marketplace.util.mail;

import com.jm.marketplace.model.User;
import org.springframework.mail.MailMessage;

import java.util.Collection;

public interface MailService {

    void send(MailMessage message, User user);
    void broadcast(MailMessage message, Collection<User> user);
}
