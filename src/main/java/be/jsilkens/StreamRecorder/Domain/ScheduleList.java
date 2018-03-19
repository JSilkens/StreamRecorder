package be.jsilkens.StreamRecorder.Domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class ScheduleList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false , name = "schedulelistid")
    Long id;
    String collectionName;
    @OneToMany(targetEntity = Schedule.class , mappedBy = "scheduleList" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    List<Schedule> scheduleList;

    public ScheduleList() {
    }

    public ScheduleList(String collectionName){
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

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public String toString() {
        return "ScheduleList{" +
                "id=" + id +
                ", collectionName='" + collectionName + '\'' +
                ", scheduleList=" + scheduleList +
                '}';
    }
}