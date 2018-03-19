package be.jsilkens.StreamRecorder.Repository;

import be.jsilkens.StreamRecorder.Domain.ScheduleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleItemRepository extends JpaRepository<ScheduleItem, Long> {
}
