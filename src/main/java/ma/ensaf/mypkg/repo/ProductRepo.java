package ma.ensaf.mypkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ensaf.mypkg.models.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
