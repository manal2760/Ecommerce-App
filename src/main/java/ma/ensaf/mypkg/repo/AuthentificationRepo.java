package ma.ensaf.mypkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ensaf.mypkg.models.AuthentificationToken;
import ma.ensaf.mypkg.models.User;

@Repository
public interface AuthentificationRepo extends JpaRepository<AuthentificationToken, Integer> {

	AuthentificationToken findByUser(User user);
	AuthentificationToken findByToken(String token);

}
