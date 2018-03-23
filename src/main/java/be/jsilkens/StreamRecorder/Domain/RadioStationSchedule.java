package be.jsilkens.StreamRecorder.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/*
    RadioStationSchedule
    =============
    A schedule is a radio channel schedule containing (multiple) programs (schedule items).
 */
@Entity
public class RadioStationSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "scheduleid")
    private Long id;

    @OneToOne(targetEntity = Stream.class)
    @JoinColumn(name = "streamid", nullable = false)
    private Stream recordStream;


    @OneToMany(targetEntity = RadioProgram.class, mappedBy = "radioStationSchedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<RadioProgram> radioPrograms;

    @ManyToOne
    @JoinColumn(name = "schedulelistid")
    private RadioStationScheduleList radioStationScheduleList;

    public RadioStationSchedule(Stream recordStream, RadioStationScheduleList radioStationScheduleList, List<RadioProgram> radioPrograms) {
        this.recordStream = recordStream;
        this.radioStationScheduleList = radioStationScheduleList;
        this.radioPrograms = radioPrograms;
    }



    public RadioStationSchedule() {
    }

    public Stream getRecordStream() {
        return recordStream;
    }

    public void setRecordStream(Stream recordStream) {
        this.recordStream = recordStream;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "RadioStationSchedule{" +
                "id=" + id +
                ", recordStream=" + recordStream +
                ", radioPrograms=" + radioPrograms +
                ", radioStationScheduleList=" + radioStationScheduleList +
                '}';
    }
}
