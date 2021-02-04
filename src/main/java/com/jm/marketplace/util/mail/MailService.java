package com.jm.marketplace.util.mail;

import com.jm.marketplace.model.User;

import java.io.File;
import java.util.Collection;

public interface MailService {

    void send(User user, String message);
    void send(User user, String message, File... files);
    void broadcast(Collection<User> user, String message);
    void broadcast(Collection<User> user, String message, File... files);
}
