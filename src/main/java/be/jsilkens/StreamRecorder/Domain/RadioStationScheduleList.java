package be.jsilkens.StreamRecorder.Domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/*
    A schedule list class. The list contains a radio station schedule.
 */
@Entity
public class RadioStationScheduleList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "schedulelistid")
    private Long id;

    private String collectionName;

    @OneToMany(targetEntity = RadioStationSchedule.class, mappedBy = "radioStationScheduleList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<RadioStationSchedule> radioStationScheduleList;

    public RadioStationScheduleList() {
    }

    public RadioStationScheduleList(String collectionName) {
        this.collectionName = collectionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public List<RadioStationSchedule> getRadioStationScheduleList() {
        return radioStationScheduleList;
    }

    public void setRadioStationScheduleList(List<RadioStationSchedule> radioStationScheduleList) {
        this.radioStationScheduleList = radioStationScheduleList;
    }

    @Override
    public String toString() {
        return "RadioStationScheduleList{" +
                "id=" + id +
                ", collectionName='" + collectionName + '\'' +
                ", radioStationScheduleList=" + radioStationScheduleList +
                '}';
    }
}
