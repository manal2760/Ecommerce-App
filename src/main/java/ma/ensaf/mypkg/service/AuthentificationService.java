package ma.ensaf.mypkg.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ensaf.mypkg.Exception.AuthenticationFailException;
import ma.ensaf.mypkg.models.AuthentificationToken;
import ma.ensaf.mypkg.models.User;
import ma.ensaf.mypkg.repo.AuthentificationRepo;

@Service
public class AuthentificationService {
	
	@Autowired
    AuthentificationRepo tokenRepository;

    public void saveConfirmationToken(AuthentificationToken authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    public AuthentificationToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }

    public User getUser(String token) {
        final AuthentificationToken authenticationToken = tokenRepository.findByToken(token);
        if(Objects.isNull(authenticationToken)) {
            return null;
        }
        // authenticationToken is not null
        return authenticationToken.getUser();
    }

    public void authenticate(String token) throws AuthenticationFailException {
        // null check
        if(Objects.isNull(token)) {
            // throw an exception
            throw new AuthenticationFailException("token not present");
        }
        if(Objects.isNull(getUser(token))) {
            throw new AuthenticationFailException("token not valid");
        }
    }
}
