package be.jsilkens.StreamRecorder.Dtos;

import be.jsilkens.StreamRecorder.Domain.RadioStationSchedule;

import java.util.List;

public class RadioStationScheduleListDTO {
    private Long id;
    private String collectionName;
    private List<RadioStationSchedule> radioStationScheduleList;

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
}
