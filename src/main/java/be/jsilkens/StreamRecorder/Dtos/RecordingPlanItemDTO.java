package be.jsilkens.StreamRecorder.Dtos;

import be.jsilkens.StreamRecorder.Domain.RecordingPlan;

import java.time.LocalDateTime;

public class RecordingPlanItemDTO {
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private RecordingPlan recordingPlan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public RecordingPlan getRecordingPlan() {
        return recordingPlan;
    }

    public void setRecordingPlan(RecordingPlan recordingPlan) {
        this.recordingPlan = recordingPlan;
    }
}
