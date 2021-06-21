package com.stocks.site.controllers;

import com.stocks.site.model.Account;
import com.stocks.site.model.User;
import com.stocks.site.repository.AccountRepo;
import com.stocks.site.repository.UserRepo;
import com.stocks.site.service.UserService;
import com.stocks.site.util.Maker;
import com.stocks.site.util.Password;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AuthController {

    private final UserRepo userDao;
    private final AccountRepo accountDao;
    private final UserService userService;
    private final PasswordEncoder encoder;

    public AuthController(UserRepo userDao, AccountRepo accountDao, UserService userService, PasswordEncoder encoder){
        this.userDao = userDao;
        this.accountDao = accountDao;
        this.userService = userService;
        this.encoder = encoder;
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("loginPage", false);
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        User user = null;
        try{
            user = userService.getLoggedInUser();
        } catch (Exception ignored){}
        if(user != null) return "users/profile";

        model.addAttribute("user", new User());
        model.addAttribute("heading", "Create An Account");
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute @Validated User user, Errors validation, Model model, @RequestParam(name = "confirmPass") String confirmPass){

        List<String> errorMsg = new ArrayList<>();

        if(userDao.findByUsername(user.getUsername()) != null) {
            validation.rejectValue("username", "Username can not be the same as another user");
            errorMsg.add("Username can not be the same as another user");
        }
        if(userDao.findByEmail(user.getEmail()) != null) {
            validation.rejectValue("email", "Email is already in use for another account");
            errorMsg.add("Email is already in use for another account");
        }
        if(user.getEmail().isEmpty()){
            validation.rejectValue("email", "Email is blank");
            errorMsg.add("Email can not be blank");
        }
        if(confirmPass.isEmpty()){
            validation.rejectValue("password", "please confirm your password");
            errorMsg.add("Please confirm your password");
        }
        if(!confirmPass.equals(user.getPassword())) {
            validation.rejectValue("password", "passwords do not match");
            errorMsg.add("Passwords do not match");
        }
//        if (!Password.goodQualityPassword(user.getPassword())){
//            validation.rejectValue("password", "Password must be at least 8 characters, contain 1 Uppercase, and 1 number.");
//            errorMsg.add("Password must be at least 8 characters, contain 1 Uppercase, and 1 number.");
//        }
        if (user.getUsername().isEmpty()){
            validation.rejectValue("username", "Username can not be blank.");
            errorMsg.add("Username can not be blank.");
        }

        if(validation.hasErrors()){
            model.addAttribute("errorList", errorMsg);
            model.addAttribute("heading", "Error Creating an Account");
            model.addAttribute("user", user);
            return "auth/register";
        }

        int newAccountNumber = accountDao.findAll().size();
        Account newAccount = new Account(newAccountNumber + 1, 1000.00);
        accountDao.save(newAccount);

        Maker.makeUser(userDao, encoder, newAccount, user);

        return "redirect:/login";

    }

}
