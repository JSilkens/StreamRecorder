package be.jsilkens.StreamRecorder.Dtos;

import be.jsilkens.StreamRecorder.Domain.RadioProgram;

import java.io.File;
import java.time.LocalDateTime;

public class RecordingDTO {
    private Long id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private File recordingFile;
    private RadioProgram radioProgram;

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

    public File getRecordingFile() {
        return recordingFile;
    }

    public void setRecordingFile(File recordingFile) {
        this.recordingFile = recordingFile;
    }

    public RadioProgram getRadioProgram() {
        return radioProgram;
    }

    public void setRadioProgram(RadioProgram radioProgram) {
        this.radioProgram = radioProgram;
    }
}
