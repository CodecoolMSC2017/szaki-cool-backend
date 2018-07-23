package com.codecool.web.service;


import com.codecool.web.component.EmailComponent;
import com.codecool.web.model.User;
import com.codecool.web.repository.UserRepository;
import com.codecool.web.security.RandomString;
import com.codecool.web.service.exceptions.ActivationKeyIsNullException;
import com.codecool.web.service.exceptions.FaildToFindAccountByVerificationCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

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
            if(usr.getActivationCode().equals(key)){
                usr.setEnabled(true);
                usr.setActivationCode(null);  //uncommented while testing
                userRepository.save(usr);
                return "User account verified";
            }
        }
        throw new FaildToFindAccountByVerificationCodeException();

    }

    public User add(String username, String password, String confirmationPassword, String email) {
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

                manageEmailVerification(user);

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

    private void manageEmailVerification(User user) {
        emailComponent.sendMail(user.getEmail(), "Registration succesful", user.getActivationCode());

    }
}
