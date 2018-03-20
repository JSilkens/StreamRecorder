package be.jsilkens.StreamRecorder.Domain;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class RecordingPlan {
    private List<RecordingPlanItem> recordingPlanItems;
    
}
