package com.example.prueba.Controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.Formularios.ClienteDto;
import com.example.prueba.Formularios.LoginRequest;
import com.example.prueba.Formularios.PersonalDto;
import com.example.prueba.JWT.JWTTokenUtil;
import com.example.prueba.Model.JWT.JWTResponse;
import com.example.prueba.Service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userservice;
	@Autowired
    private AuthenticationManager authenticationManager;
	public UserController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
	@Autowired
	private JWTTokenUtil jwtTokenUtil;
	@Autowired
	private UserDetailsService userDetailsService;
	//crear Usuario Cliente
	@PostMapping("/RegistrarUsuarioCliente")
    public ResponseEntity<Void> crearUsuarioYCliente(@RequestBody ClienteDto clientedto) {
    	userservice.crearUsuarioYCliente(clientedto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	//crear Usuario Personal
	@PostMapping("/RegistrarUsuarioPersonal")
	public ResponseEntity<Void> crearUsuarioYPersonal(@RequestBody PersonalDto personaldto) {
	    userservice.crearUsuarioYPersonal(personaldto);
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}
	//Ingresar Logueo
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JWTResponse(token));
    }
	//Verificardor de Tokens
	@PostMapping("/tokenInfo")
	public String getTokenInfo(@RequestBody Map<String, String> tokenMap) {
	    String authToken = tokenMap.get("token");

	    String email = jwtTokenUtil.getEmailFromToken(authToken);
	    UserDetails userDetails = userDetailsService.loadUserByUsername(email);
	    if (jwtTokenUtil.validateToken(authToken, userDetails)) {
	        
	        String emailuser = jwtTokenUtil.getEmailFromToken(authToken);
	        Date expirationDate = jwtTokenUtil.getExpirationDateFromToken(authToken);
	        List<String> roles = jwtTokenUtil.getClaimFromToken(authToken, claims -> claims.get("roles", List.class));

	        
	        JSONObject tokenInfo = new JSONObject();
	        tokenInfo.put("email", emailuser);
	        tokenInfo.put("expirationDate", expirationDate);
	        tokenInfo.put("roles", roles);

	       
	        return tokenInfo.toString();
	    } else {
	        
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build().toString();
	    }
	}

}
