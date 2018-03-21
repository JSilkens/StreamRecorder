package be.jsilkens.StreamRecorder.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
    Schedule
    =============
    A schedule is a single program from a specific channel (stream).
    It has a recording plan and a list of saved recordings.
 */
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "scheduleid")
    private Long id;

    @OneToOne(targetEntity = Stream.class)
    @JoinColumn(name = "streamid", nullable = false)
    private Stream recordStream;

    @OneToMany(targetEntity = ScheduleItem.class, mappedBy = "schedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ScheduleItem> scheduleItems;

    @ManyToOne
    @JoinColumn(name = "schedulelistid")
    private ScheduleList scheduleList;

    public Schedule(Stream recordStream, ScheduleList scheduleList) {
        this.recordStream = recordStream;
        this.scheduleList = scheduleList;
    }

    public Schedule() {
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

    public List<ScheduleItem> getScheduleItems() {
        return scheduleItems;
    }

    public void setScheduleItems(List<ScheduleItem> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }

    public ScheduleList getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(ScheduleList scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", recordStream=" + recordStream +
                ", scheduleItems=" + scheduleItems +
                ", scheduleList=" + scheduleList +
                '}';
    }
}
