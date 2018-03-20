package be.jsilkens.StreamRecorder.Domain;

import java.util.Date;

public class RecordingPlanItem {
    private Date start;
    private Date end;

    public RecordingPlanItem(Date start, Date end) {
        this.start = start;
        this.end = end;
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

    @Override
    public String toString() {
        return "RecordingPlanItem{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
