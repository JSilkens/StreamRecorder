package be.jsilkens.StreamRecorder;

import be.jsilkens.StreamRecorder.Domain.*;
import be.jsilkens.StreamRecorder.Repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        addSchedule();
        addStreams();
        addRecordings();
    }

    private void addScheduleList() {
        scheduleListRepository.save(new ScheduleList("My list"));
    }
    private void addSchedule() {
    }

    private void addStreams() {
        streamRepository.save(new Stream("KEXP","http://live-aacplus-64.kexp.org/kexp64.aac","","KEXP - Where music matters"));
        streamRepository.save(new Stream("Radio Scorpio","http://193.190.253.57:8000/stream","audio/mpeg","www.radioscorpio.be"));
        streamRepository.save(new Stream("Studio Brussel","http://icecast.vrtcdn.be/stubru-high.mp3","audio/mpeg","Life is music"));
        LOG.info("Streams added " +  streamRepository.findAll().size());

    }

    private void addRecordings(){
        recordingRepository.save(new Recording("eerste rec", new Date(), new Date(), null));
    }
}
