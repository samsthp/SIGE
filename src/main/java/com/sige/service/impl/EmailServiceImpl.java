package com.sige.service.impl;

import com.sige.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void enviarEmail(String para, String assunto, String texto) {
        System.out.println("Email enviado para " + para + ": " + assunto);
        // Aqui você pode integrar com JavaMailSender real se quiser
    }
}
