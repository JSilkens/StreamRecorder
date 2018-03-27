package be.jsilkens.StreamRecorder.Dtos;

import be.jsilkens.StreamRecorder.Domain.RadioProgram;;
import be.jsilkens.StreamRecorder.Domain.RadioStationScheduleList;
import be.jsilkens.StreamRecorder.Domain.Stream;

import java.util.List;

public class RadioStationScheduleDTO {
    private Long id;
    private Stream recordStream;
    private List<RadioProgram> radioPrograms;
    private RadioStationScheduleList radioStationScheduleList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stream getRecordStream() {
        return recordStream;
    }

    public void setRecordStream(Stream recordStream) {
        this.recordStream = recordStream;
    }

    public List<RadioProgram> getRadioPrograms() {
        return radioPrograms;
    }

    public void setRadioPrograms(List<RadioProgram> radioPrograms) {
        this.radioPrograms = radioPrograms;
    }

    public RadioStationScheduleList getRadioStationScheduleList() {
        return radioStationScheduleList;
    }

    public void setRadioStationScheduleList(RadioStationScheduleList radioStationScheduleList) {
        this.radioStationScheduleList = radioStationScheduleList;
    }
}
