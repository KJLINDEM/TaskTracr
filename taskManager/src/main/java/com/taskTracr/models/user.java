package com.taskTracr.models;
import java.io.Serializable;
import java.time.LocalDateTime;



public class user implements Serializable {

    /*
     * Things associated with a user:
     * -------------------------
     * Upon Registration:
     * 1. First Name
     * 2. Last Name
     * 3. Email
     * 4. Password (Salt & Hashed)
     * 5. Role (Assigned by admin)
     * 6. createdAt - Final
     * 7. userID - Final
     * -------------------------
     * Account Settings
     * 1. Profile Picture (From URL)
     * 2. Theme (Light, Dark, etc.)
     * 3. Notifications
     * 4. Sounds
     * 5. isVerified
     * 6. isActive
     */

    private String firstName, lastName, email, salt, userHash, role, profilePictureURL;
    private byte theme, notifications;
    private boolean sounds, isVerified, isActive;
    private LocalDateTime lastLoggedIn, updatedAt;
    private LocalDateTime createdAt;
    private int userID;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserHash() {
        return userHash;
    }

    public void setUserHash(String userHash) {
        this.userHash = userHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
    }

    /*
     * Theme is defined by the following:
     * 0 = Normal light mode
     * 1 = Dark Mode
     * 2 = High Contrast
     * 3 = Blue
     * 4 = Green
     */
    public byte getTheme() {
        return theme;
    }

    public void setTheme(byte theme) {
        this.theme = theme;
    }

    /*
     * Notifications is defined by the following:
     * 0 = off
     * 1 = Email notifications
     * 2 = WBP notifications
     * 3 = Email & WBP
     */
    public byte getNotifications() {
        return notifications;
    }

    public void setNotifications(byte notifications) {
        this.notifications = notifications;
    }

    // Sounds is either on or off for true or false, respectively.
    public boolean isSounds() {
        return sounds;
    }

    public void setSounds(boolean sounds) {
        this.sounds = sounds;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    // Active is defined by any users who logged in the last month
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public final LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(LocalDateTime lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public final int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
