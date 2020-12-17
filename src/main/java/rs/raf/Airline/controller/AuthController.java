package rs.raf.Airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rs.raf.Airline.model.authDto.AuthRequest;
import rs.raf.Airline.model.authDto.AuthResponse;
import rs.raf.Airline.model.authDto.RegisterDto;
import rs.raf.Airline.repositories.custom.services.UserService;
import rs.raf.Airline.services.MyUserDetailsService;
import rs.raf.Airline.util.JwtUtil;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    public AuthController(AuthenticationManager authenticationManager, MyUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authReq){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(401).build();
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getUsername());

        return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails)));
    }

    @PostMapping("/register")
    public String register(@Validated @RequestBody RegisterDto registerDto) {
        if(registerDto.getUsername().length() == 0)
            return "The username can't be null!";
        if(registerDto.getPassword().length() < 6)
            return "The password must be at least 6 characters long!";
        if(!registerDto.getPassword().matches(".*\\d.*"))
            return "The password must contain a number!";

        return userService.register(registerDto);
    }

}
