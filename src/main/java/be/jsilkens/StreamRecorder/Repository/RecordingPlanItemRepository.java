package be.jsilkens.StreamRecorder.Repository;

import be.jsilkens.StreamRecorder.Domain.RecordingPlanItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordingPlanItemRepository extends JpaRepository<RecordingPlanItem, Long> {
}
