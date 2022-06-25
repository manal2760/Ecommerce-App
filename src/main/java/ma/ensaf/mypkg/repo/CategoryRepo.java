package ma.ensaf.mypkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ma.ensaf.mypkg.models.Category;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
