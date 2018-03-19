package io.github.cstaudigel.dal.implementations;

import io.github.cstaudigel.dal.interfaces.UserDAO;
import io.github.cstaudigel.domain.objects.User;
import io.github.cstaudigel.domain.requests.CreateUserRequest;
import io.github.cstaudigel.domain.requests.GetUserRequest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The file UserDAOImpl.java was created by Chris on 1:07 PM at 3/17/2018
 */
 @Component
 public class UserDAOImpl implements UserDAO {

     private JdbcTemplate jdbcTemplate;

     public UserDAOImpl(JdbcTemplate jdbcTemplate) {
         this.jdbcTemplate = jdbcTemplate;
     }

    /**
     * query database for all users
     *
     * @return List of all users in database
     */
    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM USERTABLE";

        return jdbcTemplate.query(sql,
                (rs, rowNum) ->
                    new User(rs.getInt("U_ID"),
                             rs.getDate("U_DOB"),
                             rs.getDate("U_JOINDATE"),
                             rs.getString("U_USERNAME"),
                             rs.getString("U_EMAIL"),
                             rs.getString("U_FIRSTNAME"),
                             rs.getString("U_LASTNAME"),
                             rs.getString("U_PASSWORD"),
                             rs.getString("U_PASSWORDHASH")));
    }

    /**
     * query database for specific user
     *
     * @param request GetUserRequest object
     * @return user from database
     */
    @Override
    public User getUser(GetUserRequest request) {
        User u;

        switch (request.getMethod()) {
            case ID:
                u = getUserID(request.getID());
                break;
            case EMAIL:
                u = getUserEmail(request.getEmail());
                break;
            case USERNAME:
                u = getUserUsername(request.getUsername());
                break;
            default:
                throw new IndexOutOfBoundsException("Invalid Request");
        }

        return u;
    }

    private User getUserID(int ID) {
        String sql = "SELECT * FROM USERTABLE WHERE U_ID = " + ID;

        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
        User u;

        if (users.size() == 0) {
            u = null;
        } else {
            u = users.get(0);
        }

        return u;
    }

    private User getUserEmail(String email) {
        String sql = "SELECT * FROM USERTABLE WHERE U_EMAIL = " + email;

        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
        User u;

        if (users.size() == 0) {
            u = null;
        } else {
            u = users.get(0);
        }

        return u;
    }

    private User getUserUsername(String username) {
        String sql = "SELECT * FROM USERTABLE WHERE U_USERNAME = " + username;

        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
        User u;

        if (users.size() == 0) {
            u = null;
        } else {
            u = users.get(0);
        }

        return u;
    }

    /**
     * insert user into database
     *
     * @param u CreateUserRequest object
     * @return newly created user
     */
    @Override
    public User createUser(User u) {
        String sql = "INSERT INTO USERTABLE (U_USERNAME, U_EMAIL, U_FIRSTNAME, U_LASTNAME, U_DOB, U_JOINDATE, U_PASSWORD, U_PASSWORDHASH) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                u.getUsername(),
                u.getEmail(),
                u.getFirstName(),
                u.getLastName(),
                u.getDob(),
                u.getJoinDate(),
                u.getPassword(),
                u.getPasswordHash());

        return u;
    }


}
