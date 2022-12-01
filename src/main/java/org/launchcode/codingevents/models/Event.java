package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @ManyToOne
    @NotNull(message = "Category is required")
    private EventCategory eventCategory;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

    @NotBlank(message="Location is required")
    private String location;

    @Positive(message="Number of attendees must be one or more.")
    private int numOfAttendees;

    public Event(String name, String location, int numOfAttendees, EventCategory eventCategory) {
        this.name = name;
        this.location = location;
        this.numOfAttendees = numOfAttendees;
        this.eventCategory = eventCategory;
    }

    public Event() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumOfAttendees() {
        return numOfAttendees;
    }

    public void setNumOfAttendees(int numOfAttendees) {
        this.numOfAttendees = numOfAttendees;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    @Override
    public String toString() {
        return name;
    }


}
