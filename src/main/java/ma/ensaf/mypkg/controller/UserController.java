package ma.ensaf.mypkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.ensaf.mypkg.Exception.AuthenticationFailException;
import ma.ensaf.mypkg.Exception.CustomException;
import ma.ensaf.mypkg.common.ApiResponse;
import ma.ensaf.mypkg.dto.ResponseDto;
import ma.ensaf.mypkg.dto.user.SignInDto;
import ma.ensaf.mypkg.dto.user.SignInResponseDto;
import ma.ensaf.mypkg.dto.user.SignupDto;
import ma.ensaf.mypkg.models.User;
import ma.ensaf.mypkg.repo.UserRepo;
import ma.ensaf.mypkg.service.AuthentificationService;
import ma.ensaf.mypkg.service.UserService;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    UserService userService;
    
    @Autowired
    AuthentificationService authentificationService;
    @Autowired
    UserRepo userRepo;

    
    // signup

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) {
        return userService.signUp(signupDto);
    }
    
    @PostMapping("/signin")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto) {
        return userService.signIn(signInDto);
    }
   

	@GetMapping("/all")
	public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
		authentificationService.authenticate(token);
		return userRepo.findAll();
	}
	
	
	
	
}
