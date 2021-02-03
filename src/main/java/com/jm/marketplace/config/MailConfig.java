package com.jm.marketplace.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource(value = "classpath:email.properties")
public class MailConfig {

    @Value("${gmail.host}")
    private String host;
    @Value("${gmail.port}")
    private Integer port;
    @Value("${gmail.username}")
    private String username;
    @Value("${gmail.password}")
    private String password;
    @Value("${gmail.transport.protocol}")
    private String transportProtocol;
    @Value("${gmail.smtp.auth}")
    private String smtpAuth;
    @Value("${gmail.smtp.starttls.enable}")
    private String smtpStarttlsEnable;
    @Value("${gmail.debug}")
    private String debug;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(host);
        sender.setPort(port);

        sender.setUsername(username);
        sender.setPassword(password);

        Properties props = sender.getJavaMailProperties();
        props.put("mail.transport.protocol", transportProtocol);
        props.put("mail.smtp.auth", smtpAuth);
        props.put("mail.smtp.starttls.enable", smtpStarttlsEnable);
        props.put("mail.debug", debug);

        return sender;
    }
}
