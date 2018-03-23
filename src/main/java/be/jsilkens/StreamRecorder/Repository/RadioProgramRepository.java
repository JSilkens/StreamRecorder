package be.jsilkens.StreamRecorder.Repository;

import be.jsilkens.StreamRecorder.Domain.RadioProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadioProgramRepository extends JpaRepository<RadioProgram, Long> {
}
