package com.example.tdssi.controller.init;


import com.example.tdssi.model.Utilisateur;
import com.example.tdssi.service.UtilisateurService;
import com.example.tdssi.util.Utility;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class InitControllerImpl implements InitController {


    private final UtilisateurService utilisateurService;

    @Override
    public String login() {

        return "login";
    }

    @Override
    public String index() {
        return "enregistrer_utilisateur";
    }

    @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {

        return "forgot_password_form";

    }

    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model model) {
        String email = request.getParameter("username");
        String token = RandomString.make(30);
        try {
            utilisateurService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            utilisateurService.sendEmail(email, resetPasswordLink);
            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");

        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
        }

        return "forgot_password_form";
    }

    public void sendEmail() {

    }


    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
        Utilisateur customer = utilisateurService.getByResetPasswordToken(token);
        System.err.println(customer);
        model.addAttribute("token", token);

        if (customer == null) {
            model.addAttribute("message", "Invalid Token");
            return "message";
        }

        return "reset_password_form";
    }

    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request, Model model) {

        String token = request.getParameter("token");
        String password = request.getParameter("password");

        System.out.println(password);

        Utilisateur customer = utilisateurService.getByResetPasswordToken(token);

        System.out.println("Voir utilisateur");
        System.err.println(customer.toString());

        if (customer == null) {

            System.out.println("il na pas ete vu");
            return "message";
        } else {
            utilisateurService.updatePassword(customer, password);
            return "redirect:/login";

        }

    }
}
