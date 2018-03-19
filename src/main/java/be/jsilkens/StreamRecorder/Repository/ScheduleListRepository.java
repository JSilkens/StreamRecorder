package be.jsilkens.StreamRecorder.Repository;

import be.jsilkens.StreamRecorder.Domain.ScheduleList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleListRepository extends JpaRepository<ScheduleList , Long> {

}
