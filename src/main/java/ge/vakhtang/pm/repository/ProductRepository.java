package ge.vakhtang.pm.repository;

import ge.vakhtang.pm.entity.ProductEntity;
import ge.vakhtang.pm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> getAllByUser(UserEntity userEntity);

    ProductEntity getById(Integer id);
}
