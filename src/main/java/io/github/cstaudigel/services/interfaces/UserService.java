package io.github.cstaudigel.services.interfaces;

import io.github.cstaudigel.domain.objects.User;
import io.github.cstaudigel.domain.requests.CreateUserRequest;
import io.github.cstaudigel.domain.requests.GetUserRequest;
import io.github.cstaudigel.domain.responses.CreateUserResponse;

import java.util.List;

/**
 * The file UserService.java was created by Chris on 1:06 PM at 3/17/2018
 */

public interface UserService {

    /**
     * call DAO to return all users in database
     * @return list of all users in database
     */
    List<User> getAllUsers();

    /**
     * Create user and pass to DAO for insertion into database
     * @param request CreateUserRequest object
     * @return created user
     */
    CreateUserResponse createUser(CreateUserRequest request);

    /**
     * get user from DAO
     * @param request GetUserRequestObject
     * @return User from DAO
     */
    User getUser(GetUserRequest request);
}
