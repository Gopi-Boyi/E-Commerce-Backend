package com.E.Commerce.Backend.Controller;

import com.E.Commerce.Backend.Dto.ChangePasswordRequest;
import com.E.Commerce.Backend.Dto.EmailConfirmationRequest;
import com.E.Commerce.Backend.Dto.LoginRequest;
import com.E.Commerce.Backend.Exception.ResourceNotFoundException;
import com.E.Commerce.Backend.Model.User;
import com.E.Commerce.Backend.Repositories.UserRepository;
import com.E.Commerce.Backend.Service.JwtService;
import com.E.Commerce.Backend.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private  final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;




    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            String token = jwtService.generateToken(user);
            return ResponseEntity.ok(new AuthResponse(token));


    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        userService.changePassword(email, changePasswordRequest);
        return ResponseEntity.ok().body("Password Changed");
    }

    public ResponseEntity<?> confirmEmail(@RequestBody EmailConfirmationRequest request){
            try{
                userService.confirmEmail(request.getEmail(),request.getConfirmationCode());
                return ResponseEntity.ok().body("Email Confirmed successfully");
            }catch (BadCredentialsException e){
                return ResponseEntity.badRequest().body("Invalid confirmation code");
            }
            catch (ResourceNotFoundException e){
                return ResponseEntity.notFound().build();
            }
    }
}
