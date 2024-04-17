package com.tsys.tsep.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

public class GenerateKeyRequest {

    @NotNull
    @Digits(integer = 12, fraction = 0)
    private Long mid;

    @NotBlank
    @Size(min = 3, max = 20)
    private String userID;

    @NotBlank
    @Size(min = 8, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9!@$^*_\\-.]*$")
    private String password;

    @Size(min = 32, max = 32)
    private String transactionKey;

    @NotBlank
    @Size(min = 2, max = 20)
    private String developerID;

    // Getters and Setters

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTransactionKey() {
        return transactionKey;
    }

    public void setTransactionKey(String transactionKey) {
        this.transactionKey = transactionKey;
    }

    public String getDeveloperID() {
        return developerID;
    }

    public void setDeveloperID(String developerID) {
        this.developerID = developerID;
    }
}
