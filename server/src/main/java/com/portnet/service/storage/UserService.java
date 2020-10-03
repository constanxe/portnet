package com.portnet.service.storage;

import com.portnet.dao.storage.UserDao;
import com.portnet.entity.storage.Domain;
import com.portnet.entity.storage.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service tasks that use DAO methods
 * - retrieve and modify database
 * - useful for REST APIs for User
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DomainService domainService;


    /**
     * Add User to database if data passes validity checks
     * @param user object
     * @return message indicating if user registration successful
     */
    public String saveUser(User user) {
        // retrieve input values
        String name = user.getName();
        String email = user.getEmail();
        String pwd = user.getPassword();

        // input length validity (avoid error when exceed minimum set in database)
        if (name.length()>32 || email.length()>32 || pwd.length()>32) {
            return "Registration unsuccessful - inputs too long, keep within 32 characters";
        }

        // email validity
        if (getUserByEmail(email) != null) {
            return "Registration unsuccessful - email already exists";
        } else if (!domainService.domainAccepted(email)) {
            return "Registration unsuccessful - email domain not accepted";
        }

        // passed checks
        userDao.save(user);
        return "Registration successful";
    }

    /**
     * Get all Users in database
     * @return users object
     */
    public List<User> getUsers() {
        return userDao.findAll();
    }

    /**
     * Get User with specified id in database
     * @param id the auto-generated ID of the user
     * @return user object
     */
    public User getUserById(int id) {
        return userDao.findById(id).orElse(null);
    }

    /**
     * Get User with specified email in database
     * @param email the email registered by the User
     * @return user object
     */
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    /**
     * Update User with same id from database
     */
    public void updateUser(User user) {
        User existingUser = getUserById(user.getId());

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        userDao.save(existingUser);
    }

}
