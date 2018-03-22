package be.jsilkens.StreamRecorder.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/*
 Recording plan
 --------------
 A recording plan is a radio station's recording week schedule.

 */
@Entity
public class RecordingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "recordingplanid")
    private Long id;

    @OneToMany(targetEntity = RecordingPlanItem.class, mappedBy = "recordingPlan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<RecordingPlanItem> recordingPlanItems;

    public RecordingPlan(List<RecordingPlanItem> recordingPlanItems) {
        this.recordingPlanItems = recordingPlanItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RecordingPlanItem> getRecordingPlanItems() {
        return recordingPlanItems;
    }

    public void setRecordingPlanItems(List<RecordingPlanItem> recordingPlanItems) {
        this.recordingPlanItems = recordingPlanItems;
    }

    @Override
    public String toString() {
        return "RecordingPlan{" +
                "id=" + id +
                ", recordingPlanItems=" + recordingPlanItems +
                '}';
    }
}
