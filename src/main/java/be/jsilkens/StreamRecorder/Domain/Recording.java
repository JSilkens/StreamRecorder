package be.jsilkens.StreamRecorder.Domain;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

/*
    Recording
    ---------
    Recording has a start and end date and and a recording file.
 */
@Entity
public class Recording {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "recordingid")
    private Long id;

    private String name;

    private Date start;

    private Date end;

    private File recordingFile;

    @ManyToOne
    @JoinColumn(name = "scheduleitemid", nullable = false)
    private ScheduleItem scheduleItem;

    public Recording(String name, Date start, Date end, File recordingFile, ScheduleItem scheduleItem) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.recordingFile = recordingFile;
        this.scheduleItem = scheduleItem;
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

    public File getRecordingFile() {
        return recordingFile;
    }

    public void setRecordingFile(File recordingFile) {
        this.recordingFile = recordingFile;
    }

    public ScheduleItem getScheduleItem() {
        return scheduleItem;
    }

    public void setScheduleItem(ScheduleItem scheduleItem) {
        this.scheduleItem = scheduleItem;
    }

    @Override
    public String toString() {
        return "Recording{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", recordingFile=" + recordingFile +
                ", scheduleItem=" + scheduleItem +
                '}';
    }
}
