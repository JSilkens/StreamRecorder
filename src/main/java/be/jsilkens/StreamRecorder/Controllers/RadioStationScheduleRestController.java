package be.jsilkens.StreamRecorder.Controllers;

import be.jsilkens.StreamRecorder.Domain.RadioStationSchedule;
import be.jsilkens.StreamRecorder.Repository.RadioStationScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/radiostationschedule")
public class RadioStationScheduleRestController {
    private RadioStationScheduleRepository radioStationScheduleRepository;

    @Autowired
    public RadioStationScheduleRestController(RadioStationScheduleRepository radioStationScheduleRepository) {
        this.radioStationScheduleRepository = radioStationScheduleRepository;
    }

    @GetMapping(value = "/list")
    public List<RadioStationSchedule> getRadioStationSchedules() {
        return this.radioStationScheduleRepository.findAll();
    }


}
