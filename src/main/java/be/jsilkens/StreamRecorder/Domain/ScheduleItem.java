package be.jsilkens.StreamRecorder.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/*
 Schedule Item
 -------------
 A schedule item a radio station's program. It contains a list of saved recordings and a recording plan.
 It has a start and end date for the recording period. The recording plan will repeat forever if no end date is given.
 */
@Entity
public class ScheduleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "scheduleitemid")
    private Long id;

    private String name;

    private LocalDateTime start;

    private LocalDateTime end;

    @ManyToOne
    @JoinColumn(name = "scheduleId", nullable = false)
    private Schedule schedule;

    @OneToMany(targetEntity = Recording.class, mappedBy = "scheduleItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Recording> recordings;

    public ScheduleItem(String name, LocalDateTime start, LocalDateTime end, Schedule schedule) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.schedule = schedule;
    }

    public ScheduleItem() {
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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "ScheduleItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", recordings=" + recordings +
                ", schedule =" + schedule +
                '}';
    }
}
