package com.aln.email_service.application;

import com.aln.email_service.adapters.EmailSenderGateway;
import com.aln.email_service.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emalgateway){
        this.emailSenderGateway = emalgateway;
    }


    @Override
    public void sendEmail(String to, String subject, String body) {
    this.emailSenderGateway.SendEmail(to, subject, body);

    }
}
