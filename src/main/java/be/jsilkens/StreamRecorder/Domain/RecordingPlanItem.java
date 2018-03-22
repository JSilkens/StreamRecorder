package be.jsilkens.StreamRecorder.Domain;

import javax.persistence.*;
import java.util.Date;
/*
 Recording plan
 --------------
 A recording plan item is a single item from a recording schedule.
 */
@Entity
public class RecordingPlanItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "recordingplanitemid")
    private Long id;

    private Date start;

    private Date end;

    @ManyToOne
    @JoinColumn(name = "recordingplanid", nullable = false)
    private RecordingPlan recordingPlan;

    public RecordingPlanItem(Date start, Date end, RecordingPlan recordingPlan) {
        this.start = start;
        this.end = end;
        this.recordingPlan = recordingPlan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public RecordingPlan getRecordingPlan() {
        return recordingPlan;
    }

    public void setRecording(RecordingPlan recordingPlan) {
        this.recordingPlan = recordingPlan;
    }

    @Override
    public String toString() {
        return "RecordingPlanItem{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", recordingPlan=" + recordingPlan +
                '}';
    }
}
