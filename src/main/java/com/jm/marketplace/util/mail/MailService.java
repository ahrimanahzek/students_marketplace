package com.jm.marketplace.util.mail;

import com.jm.marketplace.model.User;

import java.io.File;
import java.util.Collection;

public interface MailService {

    void send(User user, String subject, String message);
    void send(User user, String subject, String message, File... files);
    void broadcast(Collection<User> users, String subject, String message);
    void broadcast(Collection<User> users, String subject, String message, File... files);
}
