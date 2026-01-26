package koala.kommunity.DTOs;

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
}
