package com.example.prueba.Model.JWT;

import java.util.Date;

public class JWTUserDetails {
	private String email;
    private Date expirationDate;

    public JWTUserDetails(String email, Date expirationDate) {
        this.email = email;
        this.expirationDate = expirationDate;
    }

    public String getEmail() {
        return email;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

}
