package io.github.cstaudigel.domain.requests;

import io.github.cstaudigel.domain.objects.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.sql.Date;

/**
 * The file CreateUserRequest.java was created by Chris on 1:09 PM at 3/17/2018
 */

public class CreateUserRequest {

    private User user;

    public CreateUserRequest(User u) {
        this.user = u;
    }

    public CreateUserRequest(Date dob, Date joinDate, String username, String email, String firstName, String lastName, String password) throws NoSuchAlgorithmException, NoSuchProviderException {
        byte[] salt = getSalt();
        String securePassword = getSecurePassword(password, salt);

        user = new User(dob, joinDate, username, email, firstName, lastName, securePassword, hash);
    }

    public User getUser() {
        return user;
    }

    //Add salt
    private static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt.toString();
    }

    private static String getSecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
