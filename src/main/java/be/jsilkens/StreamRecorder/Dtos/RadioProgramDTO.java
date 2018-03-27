package be.jsilkens.StreamRecorder.Dtos;

import be.jsilkens.StreamRecorder.Domain.RadioStationSchedule;
import be.jsilkens.StreamRecorder.Domain.Recording;
import be.jsilkens.StreamRecorder.Domain.RecordingPlan;

import java.time.LocalDateTime;
import java.util.List;

public class RadioProgramDTO {
    private Long id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private RadioStationSchedule radioStationSchedule;
    private List<Recording> recordings;
    private RecordingPlan recordingPlan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public RadioStationSchedule getRadioStationSchedule() {
        return radioStationSchedule;
    }

    public void setRadioStationSchedule(RadioStationSchedule radioStationSchedule) {
        this.radioStationSchedule = radioStationSchedule;
    }

    public List<Recording> getRecordings() {
        return recordings;
    }

    public void setRecordings(List<Recording> recordings) {
        this.recordings = recordings;
    }

    public RecordingPlan getRecordingPlan() {
        return recordingPlan;
    }

    public void setRecordingPlan(RecordingPlan recordingPlan) {
        this.recordingPlan = recordingPlan;
    }
}
