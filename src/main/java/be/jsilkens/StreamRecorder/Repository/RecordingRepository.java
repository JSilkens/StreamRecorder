package be.jsilkens.StreamRecorder.Repository;

import be.jsilkens.StreamRecorder.Domain.Recording;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordingRepository extends JpaRepository<Recording,Long> {

}
