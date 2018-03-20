package be.jsilkens.StreamRecorder.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ScheduleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false , name = "scheduleitemid")
    Long id;
    String name;
    Date start;
    Date end;

    @ManyToOne
    @JoinColumn(name = "scheduleId", nullable = false)
    Schedule schedule;

    @OneToMany(targetEntity = Recording.class , mappedBy = "scheduleItem" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonIgnore
    List<Recording> recordings;

    public ScheduleItem(String name, Date start, Date end, Schedule schedule) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.recordings = recordings;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
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
