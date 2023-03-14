package jpamoney.jpacurrency.exchangerate.repository;

import jpamoney.jpacurrency.exchangerate.entity.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {
    Optional<ExchangeRateEntity> findByCurUnit(String cur_unit);
}
