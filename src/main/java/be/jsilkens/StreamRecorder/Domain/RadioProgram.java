package be.jsilkens.StreamRecorder.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/*
 Schedule Item
 -------------
 A Schedule item a radio station's program. It contains a list of saved recordings and a recording plan.
 It has a start and end date for the recording period. The recording plan will repeat forever if no end date is given.
 */
@Entity
public class RadioProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "scheduleitemid")
    private Long id;

    private String name;

    private LocalDateTime start;

    private LocalDateTime end;

    @ManyToOne
    @JoinColumn(name = "scheduleId", nullable = false)
    private RadioStationSchedule radioStationSchedule;

    @OneToMany(targetEntity = Recording.class, mappedBy = "radioProgram", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Recording> recordings;

    @OneToOne(targetEntity = RecordingPlan.class)
    @JoinColumn(name = "streamid", nullable = false)
    private RecordingPlan recordingPlan;

    public RadioProgram(String name, LocalDateTime start, LocalDateTime end, RadioStationSchedule radioStationSchedule, RecordingPlan recordingPlan) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.radioStationSchedule = radioStationSchedule;
        this.recordingPlan = recordingPlan;
    }

    public RadioProgram() {
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

    public List<Recording> getRecordings() {
        return recordings;
    }

    public void setRecordings(List<Recording> recordings) {
        this.recordings = recordings;
    }

    public RadioStationSchedule getRadioStationSchedule() {
        return radioStationSchedule;
    }

    public void setRadioStationSchedule(RadioStationSchedule radioStationSchedule) {
        this.radioStationSchedule = radioStationSchedule;
    }

    public RecordingPlan getRecordingPlan() {
        return recordingPlan;
    }

    public void setRecordingPlan(RecordingPlan recordingPlan) {
        this.recordingPlan = recordingPlan;
    }

    @Override
    public String toString() {
        return "RadioProgram{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", recordings=" + recordings +
                ", radioStationSchedule =" + radioStationSchedule +
                '}';
    }
}
