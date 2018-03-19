package io.github.cstaudigel.services.implementations;

import io.github.cstaudigel.dal.interfaces.UserDAO;
import io.github.cstaudigel.domain.helpers.GetMethodEnum;
import io.github.cstaudigel.domain.objects.User;
import io.github.cstaudigel.domain.requests.CreateUserRequest;
import io.github.cstaudigel.domain.requests.GetUserRequest;
import io.github.cstaudigel.domain.responses.CreateUserResponse;
import io.github.cstaudigel.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The file UserServiceImpl.java was created by Chris on 1:06 PM at 3/17/2018
 */

@Component
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * call DAO to return all users in database
     *
     * @return list of all users in database
     */
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    /**
     * Create user and pass to DAO for insertion into database
     *
     * @param request CreateUserRequest object
     * @return created user
     */
    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        GetUserRequest getRequest = new GetUserRequest(GetMethodEnum.ID, request.getUser().getId(), "", "");
        CreateUserResponse response;
        User u = userDAO.getUser(getRequest);

        if (u == null) {
            u = userDAO.createUser(request.getUser());
            response = new CreateUserResponse(u, true);
        } else {
            response = new CreateUserResponse(u, false);
        }

        return response;
    }

    /**
     * get user from DAO
     * @param request GetUserRequestObject
     * @return User from DAO
     */
    @Override
    public User getUser(GetUserRequest request) {
        return userDAO.getUser(request);
    }
}
