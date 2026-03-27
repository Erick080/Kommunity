package koala.kommunity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.ArrayList;

import koala.kommunity.DTOs.Event.CreateEventRequest;
import koala.kommunity.DTOs.Event.EventResponse;
import koala.kommunity.Services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
    EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public ArrayList<EventResponse> getAllEvents(){
        return new ArrayList<>(eventService.getAllEvents());
    }

    @GetMapping("/search")
    public ResponseEntity<EventResponse> searchEventByName(@RequestParam String name){
        return eventService.searchByName(name)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<EventResponse> createEvent(@Valid @RequestBody CreateEventRequest request){
        return ResponseEntity.ok(eventService.createEvent(request));
    }
}
