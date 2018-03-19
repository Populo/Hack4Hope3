package io.github.cstaudigel.domain.responses;

import io.github.cstaudigel.domain.objects.User;

/**
 * The file CreateUserResponse.java was created by Chris on 1:09 PM at 3/17/2018
 */

public class CreateUserResponse {
    private boolean successful;
    private User user;

    public CreateUserResponse(User u, boolean successful) {
        this.user = u;
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public User getUser() {
        return user;
    }
}
