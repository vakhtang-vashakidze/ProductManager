package ge.vakhtang.pm.repository;

import ge.vakhtang.pm.entity.ProductAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributesRepository extends JpaRepository<ProductAttributeEntity, Integer> {
}
