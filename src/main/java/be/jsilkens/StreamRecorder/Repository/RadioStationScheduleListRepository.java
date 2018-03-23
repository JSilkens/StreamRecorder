package be.jsilkens.StreamRecorder.Repository;

import be.jsilkens.StreamRecorder.Domain.RadioStationScheduleList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadioStationScheduleListRepository extends JpaRepository<RadioStationScheduleList, Long> {

}
