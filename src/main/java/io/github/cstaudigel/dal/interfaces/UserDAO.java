package io.github.cstaudigel.dal.interfaces;

import io.github.cstaudigel.domain.objects.User;
import io.github.cstaudigel.domain.requests.CreateUserRequest;
import io.github.cstaudigel.domain.requests.GetUserRequest;

import java.util.List;

/**
 * The file UserDAO.java was created by Chris on 1:07 PM at 3/17/2018
 */

public interface UserDAO {

    /**
     * query database for all users
     * @return List of all users in database
     */
    List<User> getAllUsers();

    /**
     * query database for specific user
     * @param request GetUserRequest object
     * @return user from database
     */
    User getUser(GetUserRequest request);

    /**
     * insert user into database
     * @param user CreateUserRequest object
     * @return newly created user
     */
    User createUser(User user);
}
