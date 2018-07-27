package com.codecool.web.service;


import com.codecool.web.component.EmailComponent;
import com.codecool.web.model.User;
import com.codecool.web.repository.UserRepository;
import com.codecool.web.security.RandomString;
import com.codecool.web.service.exceptions.ActivationKeyIsNullException;
import com.codecool.web.service.exceptions.FaildToFindAccountByVerificationCodeException;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailComponent emailComponent;

    @Autowired
    private DataSource dataSource;


    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> get(String username) {
        return userRepository.findByUsername(username);
    }

    private List<User> getAllRegisteredUserList(){
        Iterable<User> iterable = getAll();
        List<User> target = new ArrayList<>();
        iterable.forEach(target::add);
        return target;
    }


    public String activateUser(String key) throws FaildToFindAccountByVerificationCodeException, ActivationKeyIsNullException {
        List<User> users = getAllRegisteredUserList();
        if(key == null){
            throw new ActivationKeyIsNullException();
        }
        for (User usr: users) {
            if(key.equals(usr.getActivationCode())){
                usr.setEnabled(true);
                usr.setActivationCode(null);
                userRepository.save(usr);
                return "User account verified";
            }
        }
        throw new FaildToFindAccountByVerificationCodeException();

    }

    public User add(String username, String password, String confirmationPassword, String email, HttpServletRequest req) {
        if (!password.equals(confirmationPassword)) {
            throw new IllegalArgumentException("Password and confirmation password do not match!");
        }
        if (email.equals(null)) {
            throw new IllegalArgumentException("Email cannot be null!");
        }

        userDetailsManager.createUser(new org.springframework.security.core.userdetails.User(
            username,
            passwordEncoder.encode(password),
            AuthorityUtils.createAuthorityList("USER_ROLE")));
            try {
                RandomString rs = new RandomString(10, new Random());
                String activationCode = rs.nextString();
                User user = userRepository.findByUsername(username).get();
                user.setEmail(email);
                user.setEnabled(false);
                user.setActivationCode(activationCode);
                user = userRepository.save(user);

                manageEmailVerification(user, req);

                return user;
            }
            catch (NoSuchElementException x) {
                throw new NoSuchElementException("No value present");
            }
    }

    public Optional<User> get(Integer id) {
        return userRepository.findById(id);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public void changePassword(String oldPassword, String newPassword, String confirmationPassword) {
        if (!newPassword.equals(confirmationPassword)) {
            throw new IllegalArgumentException();
        }

        String encodedNewPassword = passwordEncoder.encode(newPassword);
        userDetailsManager.changePassword(oldPassword, encodedNewPassword);
    }

    private void manageEmailVerification(User user, HttpServletRequest req) {
        String makeVerifyLink = "http://" + req.getRemoteAddr() + ":4200/activate";
        String verifyEmailText = "Hi,\n" +
            "\n" +
            "Thank you for registering to the Szakicool. Please verify you acount by clicking this link " + makeVerifyLink + " ," +
            " and please enter your verification number: " + user.getActivationCode() + "\n" +
            "\n" +
            "If you did not create this account, please ignore this email. You are welcome to reply to this email with any questions or feedback you might have.\n" +
            "\n" +
            "Best regards,\n" +
            "\n" +
            "The Szakicool Account Team";

        emailComponent.sendMail(user.getEmail(), "Please verfy your registration!", verifyEmailText);
    }
}
