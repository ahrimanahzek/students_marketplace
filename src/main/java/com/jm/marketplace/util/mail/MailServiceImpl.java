package com.jm.marketplace.util.mail;

import com.jm.marketplace.model.User;
import org.springframework.mail.MailMessage;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MailServiceImpl implements MailService {

    @Override
    public void send(MailMessage message, User user) {

    }

    @Override
    public void broadcast(MailMessage message, Collection<User> user) {

    }
}
