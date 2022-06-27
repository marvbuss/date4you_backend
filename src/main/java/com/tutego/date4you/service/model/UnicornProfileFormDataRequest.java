package com.tutego.date4you.service.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class UnicornProfileFormDataRequest {

    private String email;

    private String password;

    private LocalDate birthdate;

    private String nickname;

    private int hornlength;

    private int gender;

    private Integer attractedToGender;

    private String description;

    private LocalDateTime lastseen;

    public UnicornProfileFormDataRequest() {
    }

    public UnicornProfileFormDataRequest(String email, String password, LocalDate birthdate, String nickname, int hornlength, int gender, Integer attractedToGender, String description, LocalDateTime lastseen) {
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.nickname = nickname;
        this.hornlength = hornlength;
        this.gender = gender;
        this.attractedToGender = attractedToGender;
        this.description = description;
        this.lastseen = lastseen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getHornlength() {
        return hornlength;
    }

    public void setHornlength(int hornlength) {
        this.hornlength = hornlength;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAttractedToGender() {
        return attractedToGender;
    }

    public void setAttractedToGender(int attractedToGender) {
        this.attractedToGender = attractedToGender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLastseen() {
        return lastseen;
    }

    public void setLastseen(LocalDateTime lastseen) {
        this.lastseen = lastseen;
    }

    @Override
    public String toString() {
        return "UnicornProfileFormDataRequest{" +
                ", password='" + password + '\'' +
                ", birthdate=" + birthdate +
                ", nickname='" + nickname + '\'' +
                ", hornlength=" + hornlength +
                ", gender=" + gender +
                ", attractedToGender=" + attractedToGender +
                ", description='" + description + '\'' +
                ", lastseen=" + lastseen +
                '}';
    }
}


