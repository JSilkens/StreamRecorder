package be.jsilkens.StreamRecorder.Controllers;

import be.jsilkens.StreamRecorder.Domain.Recording;
import be.jsilkens.StreamRecorder.Repository.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import be.jsilkens.StreamRecorder.Dtos.RecordingDTO;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(path="/recording")
public class RecordingRestController {

    private RecordingRepository recordingRepository;

    @Autowired
    public RecordingRestController(RecordingRepository recordingRepository){
        this.recordingRepository = recordingRepository;
    }

    @GetMapping(value = "/list")
    public List<Recording> getRecordings(){
        return recordingRepository.findAll();
    }

    @GetMapping(value = "/get/{id}")
    public RecordingDTO getRecording(@PathVariable Long id , Recording recording , ModelMapper modelMapper) {
        recording = recordingRepository.getOne(id);
        //RecordingDTO dto = modelMapper.map(recording , RecordingDTO.class);
        return modelMapper.map(recording , RecordingDTO.class);
        //return dto;
    }

    @PutMapping(value = "/put")
    public ResponseEntity<Recording> putRecording(@RequestBody @Valid Recording recording){
        if(recordingRepository.findById(recording.getId()).isPresent()){
            return badRequest().build();
        }
        return ok(recordingRepository.save(recording));
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Recording> deleteOne(@PathVariable Long id) {
        try{
            recordingRepository.deleteById(id);
            return ok().build();
        }catch (Exception e){
            return badRequest().build();
        }
    }


}
