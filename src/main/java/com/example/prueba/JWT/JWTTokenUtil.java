package com.example.prueba.JWT;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenUtil {
	@Value("${jwt.secret}")
    private String secretKey;

    
    @Value("${jwt.expiration}")
    private long expirationTime;
    
    public String getEmailFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
    public String getUserIdFromToken(String token) {
        return getClaimFromToken(token, claims -> claims.get("userId", String.class));
    }
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    private static final Logger logger = LoggerFactory.getLogger(JWTTokenUtil.class);
    private Claims getAllClaimsFromToken(String token) {
    	Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            logger.error("Error al obtener los claims del token", e);
        }
        return claims;
    }
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    public String generateToken(UserDetails userDetails) {
    	Map<String, Object> claims = new HashMap<>();
        
        claims.put("email", userDetails.getUsername());
        
        claims.put("roles", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        String subject = userDetails.getUsername(); 
        return doGenerateToken(claims, subject);
    }
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTime);

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(createdDate)
                .setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secretKey).compact();
    }
    public Boolean canTokenBeRefreshed(String token) {
        return (!isTokenExpired(token));
    }

    
    public String refreshToken(String token) {
        final String email = getEmailFromToken(token);
        return doGenerateToken(new HashMap<>(), email);
    }

    
    public Boolean validateToken(String token, UserDetails userDetails) {
    	final String email = getEmailFromToken(token);
    	final List<String> roles = (List<String>) getClaimFromToken(token, claims -> claims.get("roles", List.class))
    	        .stream()
    	        .map(Object::toString)
    	        .collect(Collectors.toList());
        return (email.equals(userDetails.getUsername()) 
                && !isTokenExpired(token) 
                && userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()).equals(roles));
    }


}
