package com.example.tdssi.service;

import com.example.tdssi.dto.UtilisateurRequestDto;
import com.example.tdssi.dto.UtilisateurResponseDto;
import com.example.tdssi.model.Utilisateur;
import com.example.tdssi.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    String fromAddress;

    @Autowired
    private Environment env;
    private final ModelMapper modelMapper;

    private final UtilisateurRepository utilisateurRepository;

    private final JavaMailSender mailSender;


    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UtilisateurResponseDto save(UtilisateurRequestDto utilisateurRequestDto, String siteUrl) throws MessagingException {

        Utilisateur utilisateur = modelMapper.map(utilisateurRequestDto, Utilisateur.class);
        utilisateur.setStatus(false);
        utilisateur.setVerificationCode(RandomString.make(64));
        System.out.println(utilisateur.getEmail());
        System.out.println(utilisateur.getPassword());
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));

        Utilisateur save = utilisateurRepository.save(utilisateur);

        sendEmailVerification(utilisateur, siteUrl);
        return new UtilisateurResponseDto("fsdfds","dffsdf");
    }

    @Override
    public void sendEmailVerification(Utilisateur utilisateur, String siteURL) throws MessagingException {


        try {
            String toAddress = utilisateur.getEmail();

            String fromAddress = env.getProperty("spring.mail.username");

            String senderName = "Your company name";

            String subject = "Please verify your registration";
            String content = "Dear [[name]],<br>"
                    + "Please click the link below to verify your registration:<br>"
                    + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                    + "Thank you,<br>"
                    + "Your company name.";
           MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);

            content = content.replace("[[name]]", utilisateur.getEmail());
            String verifyURL = siteURL + "/verify?code=" + utilisateur.getVerificationCode();

            content = content.replace("[[URL]]", verifyURL);

            helper.setText(content, true);

            mailSender.send(message);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public UtilisateurResponseDto findById(Integer id) {
        return null;
    }

    @Override
    public UtilisateurResponseDto findByEmain(String email) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public UtilisateurResponseDto update(UtilisateurRequestDto utilisateurRequestDto, Integer id) {
        return null;
    }
}
