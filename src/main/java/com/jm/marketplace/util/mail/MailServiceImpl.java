package com.jm.marketplace.util.mail;

import com.jm.marketplace.model.User;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collection;

@Component
public class MailServiceImpl implements MailService {

    @Override
    public void send(User user, String message) {

    }

    @Override
    public void send(User user, String message, File... files) {

    }

    @Override
    public void broadcast(Collection<User> user, String message) {

    }

    @Override
    public void broadcast(Collection<User> user, String message, File... files) {

    }
}
