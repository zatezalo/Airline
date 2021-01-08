package rs.raf.Airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rs.raf.Airline.exeptions.ApiRequestException;
import rs.raf.Airline.model.dto.authDto.AuthRequest;
import rs.raf.Airline.model.dto.authDto.AuthResponse;
import rs.raf.Airline.model.dto.authDto.RegisterDto;
import rs.raf.Airline.repositories.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

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
            throw new ApiRequestException("Wrong password or username!");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getUsername());

        return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails)));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/register")
    public String register(@Validated @RequestBody RegisterDto registerDto) {
        if(registerDto.getUsername().length() == 0 || registerDto.getUsername().equals(""))
            throw new ApiRequestException("The username can't be null!");

        if(registerDto.getPassword().length() == 0 || registerDto.getPassword().equals(""))
            throw new ApiRequestException("The password can't be null!");

        if(registerDto.getUserType().equals(null) || registerDto.getUserType().equals(""))
            throw new ApiRequestException("The user type can't be null!");

        if(userRepository.findByUsername(registerDto.getUsername()) != null)
            throw new ApiRequestException("The username is taken!");

        if(registerDto.getPassword().length() < 6)
            throw new ApiRequestException("The password must be at least 6 characters long!");

        if(!registerDto.getPassword().matches(".*\\d.*"))
            throw new ApiRequestException("The password must contain a number!");

        return userService.register(registerDto);
    }

}
