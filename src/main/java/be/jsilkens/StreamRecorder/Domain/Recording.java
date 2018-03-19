package be.jsilkens.StreamRecorder.Domain;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

/*
    Recording
    Recording has a start and end
 */
@Entity
public class Recording {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    Date start;
    Date end;
    File recording;

//    @ManyToOne
//    @JoinColumn(name = "scheduleItemId", nullable = false)
//    ScheduleItem scheduleItem;

    public Recording(String name, Date start, Date end, File recording) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.recording = recording;
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

    public File getRecording() {
        return recording;
    }

    public void setRecording(File recording) {
        this.recording = recording;
    }
}
