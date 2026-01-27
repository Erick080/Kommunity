package koala.kommunity.DTOs;

import java.time.LocalDateTime;

public class CreateEventRequest {
    String name;
    LocalDateTime date;
    String place;
    String description;
    
    public CreateEventRequest(String name, LocalDateTime date, String place, String description) {
        this.name = name;
        this.date = date;
        this.place = place;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
