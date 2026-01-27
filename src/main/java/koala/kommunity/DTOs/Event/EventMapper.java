package koala.kommunity.DTOs.Event;

import koala.kommunity.Persistence.EventJPA;

public class EventMapper {
    public static EventResponse toReponse(EventJPA eventJPA) {
        return new EventResponse(
            eventJPA.getName(),
            eventJPA.getDate(),
            eventJPA.getPlace(),
            eventJPA.getDescription()
        );
    }

    public static EventJPA toJPA(CreateEventRequest request) {
        return new EventJPA(
            request.getName(),
            request.getDate(),
            request.getPlace(),
            request.getDescription()
        );
    }
}
