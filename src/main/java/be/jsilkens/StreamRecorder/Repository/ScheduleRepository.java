package be.jsilkens.StreamRecorder.Repository;

import be.jsilkens.StreamRecorder.Domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

}
