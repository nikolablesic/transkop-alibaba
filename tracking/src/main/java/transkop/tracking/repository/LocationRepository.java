package transkop.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transkop.tracking.model.Location;

public interface LocationRepository extends JpaRepository<Location, String> {
}
