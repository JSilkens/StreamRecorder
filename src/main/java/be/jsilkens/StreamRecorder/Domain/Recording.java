package be.jsilkens.StreamRecorder.Domain;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;

/*
    Recording
    ---------
    Recording has a start and end date and and a recording file.
 */
@Entity
public class Recording{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "recordingid")
    private Long id;

    private String name;

    private LocalDateTime start;

    private LocalDateTime end;

    private File recordingFile;

    @ManyToOne
    @JoinColumn(name = "scheduleitemid", nullable = false)
    private RadioProgram radioProgram;

    public Recording(String name, LocalDateTime start, LocalDateTime end, File recordingFile, RadioProgram radioProgram) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.recordingFile = recordingFile;
        this.radioProgram = radioProgram;
    }

    public Recording() {
    }

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

    @Override
    public String toString() {
        return "Recording{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
