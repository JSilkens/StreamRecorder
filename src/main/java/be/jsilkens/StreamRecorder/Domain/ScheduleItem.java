package be.jsilkens.StreamRecorder.Domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ScheduleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    Date start;
    Date end;

    //@OneToMany(targetEntity = Recording.class)
    Recording[] recordings;

    public ScheduleItem(String name, Date start, Date end, Recording[] recordings) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.recordings = recordings;
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

    public Recording[] getRecordings() {
        return recordings;
    }

    public void setRecordings(Recording[] recordings) {
        this.recordings = recordings;
    }

    @Override
    public String toString() {
        return "ScheduleItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", recordings=" + recordings +
                '}';
    }
}
