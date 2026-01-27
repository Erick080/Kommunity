package koala.kommunity.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koala.kommunity.DTOs.Event.CreateEventRequest;
import koala.kommunity.DTOs.Event.EventMapper;
import koala.kommunity.DTOs.Event.EventResponse;
import koala.kommunity.Persistence.EventJPA;
import koala.kommunity.Persistence.EventRepository;

@Service
public class EventService {
    EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public List<EventResponse> getAllEvents(){
        return eventRepository.findAll()
            .stream()
            .map(EventMapper::toReponse)
            .toList();
    }

    public Optional<EventResponse> searchByName(String name){
        return eventRepository.findByNameIgnoreCase(name)
                .map(EventMapper::toReponse);
    }

    public EventResponse createEvent(CreateEventRequest request){
        EventJPA eventJPA = EventMapper.toJPA(request);
        EventJPA savedEvent = eventRepository.save(eventJPA);
        return EventMapper.toReponse(savedEvent);
    }
}
