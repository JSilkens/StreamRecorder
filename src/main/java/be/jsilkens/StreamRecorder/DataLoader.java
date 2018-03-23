package be.jsilkens.StreamRecorder;

import be.jsilkens.StreamRecorder.Domain.*;
import be.jsilkens.StreamRecorder.Repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private StreamRepository streamRepository;
    private RecordingRepository recordingRepository;
    private ScheduleItemRepository scheduleItemRepository;
    private ScheduleListRepository scheduleListRepository;
    private ScheduleRepository scheduleRepository;
    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    public DataLoader(StreamRepository steamRepository , RecordingRepository recordingRepository ,
                      ScheduleItemRepository scheduleItemRepository , ScheduleListRepository scheduleListRepository,
                      ScheduleRepository scheduleRepository) {
        this.streamRepository = steamRepository;
        this.recordingRepository = recordingRepository;
        this.scheduleItemRepository = scheduleItemRepository;
        this.scheduleListRepository = scheduleListRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        addScheduleList();
        addStreams();
        addSchedule();
        addScheduleItems();
        addRecordings();

    }



    private void addScheduleList() {
        scheduleListRepository.save(new ScheduleList("My radio list"));
        LOG.info("Schedule lists added " +  scheduleListRepository.findAll().size());
    }
    private void addSchedule() {
        List<ScheduleItem> kexpItems = new ArrayList<>();
        List<ScheduleItem> radioScorpioItems = new ArrayList<>();
        List<ScheduleItem> studioBrusselItems = new ArrayList<>();


        scheduleRepository.save(new Schedule(streamRepository.getOne((long) 1),
                scheduleListRepository.getOne((long) 1) , kexpItems)); //KEXP
        scheduleRepository.save(new Schedule(streamRepository.getOne((long) 2),
                scheduleListRepository.getOne((long) 1) , radioScorpioItems)); //Radio Scorpio
        scheduleRepository.save(new Schedule(streamRepository.getOne((long) 3),
                scheduleListRepository.getOne((long) 1) , studioBrusselItems)); //Studio Brussel

        LOG.info("Schedules added " +  scheduleRepository.findAll().size());
    }

    private void addStreams() {
        streamRepository.save(new Stream("KEXP","http://live-aacplus-64.kexp.org/kexp64.aac",
                "audio/aac","KEXP - Where music matters"));
        streamRepository.save(new Stream("Radio Scorpio","http://193.190.253.57:8000/stream",
                "audio/mpeg","www.radioscorpio.be"));
        streamRepository.save(new Stream("Studio Brussel","http://icecast.vrtcdn.be/stubru-high.mp3",
                "audio/mpeg","Life is music"));
        LOG.info("Streams added " +  streamRepository.findAll().size());

    }

    private void addRecordings(){
        recordingRepository.save(new Recording("eerste rec",
                LocalDateTime.of(2018,12,30,12,00),
                LocalDateTime.of(2018,12,30,13,00), null
                , scheduleItemRepository.getOne((long) 1)));
        LOG.info("Recordings added " +  recordingRepository.findAll().size());
    }
    private void addScheduleItems() {
        RecordingPlan leftoRecordingPlan = new RecordingPlan(new ArrayList<>());

        scheduleItemRepository.save(new ScheduleItem("Lefto",
                LocalDateTime.of(2018,5,5,12,00),
                LocalDateTime.of(2018,5,12,12,00) ,
                scheduleRepository.getOne((long) 3)));
        LOG.info("Schedule Items added " +  scheduleItemRepository.findAll().size());
    }
}
