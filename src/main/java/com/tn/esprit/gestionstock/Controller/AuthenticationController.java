package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Config.Security.SecurityConfig;
import com.tn.esprit.gestionstock.Config.Security.TokenProvider;
import com.tn.esprit.gestionstock.Service.User.UserServiceDetails;
import com.tn.esprit.gestionstock.Utils.JwtRespone;
import com.tn.esprit.gestionstock.Utils.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Import(SecurityConfig.class)
@RestController
@CrossOrigin("*")
@RequestMapping("/auth/")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserServiceDetails userDetailsService;

//    @PostMapping("login/{isRemembered}")
//    public ResponseEntity<?> authenticate(@RequestBody LoginModel loginModel, @PathVariable("isRemembered") boolean isRemembered){


    @PostMapping("login")
    public ResponseEntity<?> authenticate(@RequestBody LoginModel loginModel){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginModel.getEmail(),
                        loginModel.getPassword()
                )
        );


        UserDetails userDetails = userDetailsService.loadUserByUsername(loginModel.getEmail());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token;
//        if (!isRemembered)
            token = tokenProvider.generateToken(userDetails,1);
//        else token = tokenProvider.generateToken(userDetails,9999);

        return ResponseEntity.ok(new JwtRespone(token));
    }



}
