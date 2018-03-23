package be.jsilkens.StreamRecorder.Repository;

import be.jsilkens.StreamRecorder.Domain.RadioStationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadioStationScheduleRepository extends JpaRepository<RadioStationSchedule,Long> {

}
