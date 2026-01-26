package koala.kommunity.Persistence;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class EventJPA {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private LocalDateTime date;
    
    @Column(nullable = false)
    private String place;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    public EventJPA() {}
    
    public EventJPA(String name, LocalDateTime date, String place, String description) {
        this.name = name;
        this.date = date;
        this.place = place;
        this.description = description;
    }
    
    public Long getId() {
        return id;
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
    
    public void setDate(LocalDateTime date) {
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
