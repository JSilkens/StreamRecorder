package be.jsilkens.StreamRecorder.Repository;

import be.jsilkens.StreamRecorder.Domain.Stream;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreamRepository extends JpaRepository<Stream,Long> {
    List<Stream> findByDescription(String description);
}
