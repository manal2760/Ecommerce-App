package ma.ensaf.mypkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ensaf.mypkg.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	  User findByEmail(String email);
}
