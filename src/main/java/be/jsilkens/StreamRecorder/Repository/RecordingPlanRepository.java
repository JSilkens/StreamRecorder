package be.jsilkens.StreamRecorder.Repository;

import be.jsilkens.StreamRecorder.Domain.RecordingPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordingPlanRepository extends JpaRepository<RecordingPlan , Long> {
}
