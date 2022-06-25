package ma.ensaf.mypkg.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ensaf.mypkg.models.Cart;
import ma.ensaf.mypkg.models.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	 List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

}
