package ge.vakhtang.pm.repository;

import ge.vakhtang.pm.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {
    CurrencyEntity getByCode(String code);
}
