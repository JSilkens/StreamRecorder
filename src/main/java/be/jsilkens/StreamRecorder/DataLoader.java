package be.jsilkens.StreamRecorder;

import be.jsilkens.StreamRecorder.Domain.*;
import be.jsilkens.StreamRecorder.Repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private StreamRepository streamRepository;
    private RecordingRepository recordingRepository;
    private RadioProgramRepository radioProgramRepository;
    private RadioStationScheduleListRepository radioStationScheduleListRepository;
    private RadioStationScheduleRepository radioStationScheduleRepository;
    private RecordingPlanRepository recordingPlanRepository;
    private RecordingPlanItemRepository recordingPlanItemRepository;
    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    public DataLoader(StreamRepository steamRepository , RecordingRepository recordingRepository ,
                      RadioProgramRepository radioProgramRepository, RadioStationScheduleListRepository radioStationScheduleListRepository,
                      RadioStationScheduleRepository radioStationScheduleRepository , RecordingPlanRepository recordingPlanRepository,
                      RecordingPlanItemRepository recordingPlanItemRepository) {
        this.streamRepository = steamRepository;
        this.recordingRepository = recordingRepository;
        this.radioProgramRepository = radioProgramRepository;
        this.radioStationScheduleListRepository = radioStationScheduleListRepository;
        this.radioStationScheduleRepository = radioStationScheduleRepository;
        this.recordingRepository = recordingRepository;
        this.recordingPlanRepository = recordingPlanRepository;
        this.recordingPlanItemRepository = recordingPlanItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        addRadioStationScheduleList();
        addStreams();
        addRadioStationSchedule();
        addRadioPrograms();
        addRecordings();

    }



    private void addRadioStationScheduleList() {
        radioStationScheduleListRepository.save(new RadioStationScheduleList("My radio list"));
        LOG.info("RadioStationSchedule lists added " +  radioStationScheduleListRepository.findAll().size());
    }
    private void addRadioStationSchedule() {
        List<RadioProgram> kexpItems = new ArrayList<>();
        List<RadioProgram> radioScorpioItems = new ArrayList<>();
        List<RadioProgram> studioBrusselItems = new ArrayList<>();


        radioStationScheduleRepository.save(new RadioStationSchedule(streamRepository.getOne((long) 1),
                radioStationScheduleListRepository.getOne((long) 1) , kexpItems)); //KEXP
        radioStationScheduleRepository.save(new RadioStationSchedule(streamRepository.getOne((long) 2),
                radioStationScheduleListRepository.getOne((long) 1) , radioScorpioItems)); //Radio Scorpio
        radioStationScheduleRepository.save(new RadioStationSchedule(streamRepository.getOne((long) 3),
                radioStationScheduleListRepository.getOne((long) 1) , studioBrusselItems)); //Studio Brussel

        LOG.info("Schedules added " +  radioStationScheduleRepository.findAll().size());
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
                , radioProgramRepository.getOne((long) 1)));
        LOG.info("Recordings added " +  recordingRepository.findAll().size());
    }
    private void addRadioPrograms() {
        addRecordingPlans();


        radioProgramRepository.save(new RadioProgram("Lefto",
                LocalDateTime.of(2018,5,5,12,00),
                LocalDateTime.of(2018,5,12,12,00) ,
                radioStationScheduleRepository.getOne((long) 3), recordingPlanRepository.getOne((long) 1)));
        LOG.info("RadioStationSchedule Items added " +  radioProgramRepository.findAll().size());
    }

    private void addRecordingPlans() {
        addRecordingPlanItems();
       // recordingPlanRepository.save(new RecordingPlan());
    }

    private void addRecordingPlanItems() {
        recordingPlanRepository.save(new RecordingPlan());
        LOG.info("Recordingplans added " + recordingPlanRepository.findAll().size());
        RecordingPlanItem item = new RecordingPlanItem(LocalDateTime.of(2018,5,5,12,00),
                LocalDateTime.of(2018,5,5,12,00),
                recordingPlanRepository.getOne((long)1));

        recordingPlanItemRepository.save(item);
        LOG.info("Recordingplan items added " + recordingPlanItemRepository.findAll().size());
    }
}
