package transkop.tracking.service;

import transkop.tracking.model.Location;

import java.util.List;

public interface LocationService {

    Location create(Location location);
    List<Location> getAll();
    void deleteAll();
}
