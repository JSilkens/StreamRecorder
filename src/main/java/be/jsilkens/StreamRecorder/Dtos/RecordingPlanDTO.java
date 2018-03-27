package be.jsilkens.StreamRecorder.Dtos;

import be.jsilkens.StreamRecorder.Domain.RecordingPlanItem;

import java.util.List;

public class RecordingPlanDTO {
    private Long id;
    private List<RecordingPlanItem> recordingPlanItems;

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
}
