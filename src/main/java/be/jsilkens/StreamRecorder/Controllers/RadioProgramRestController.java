package be.jsilkens.StreamRecorder.Controllers;

import be.jsilkens.StreamRecorder.Domain.RadioProgram;
import be.jsilkens.StreamRecorder.Repository.RadioProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/radioprogram")
public class RadioProgramRestController {
    private RadioProgramRepository radioProgramRepository;

    @Autowired
    public RadioProgramRestController(RadioProgramRepository radioProgramRepository) {
        this.radioProgramRepository = radioProgramRepository;
    }
    @GetMapping(value = "/list")
    public List<RadioProgram> getRadioPrograms(){
        return this.radioProgramRepository.findAll();
    }

}
