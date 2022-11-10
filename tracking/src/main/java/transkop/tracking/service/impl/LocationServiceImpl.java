package transkop.tracking.service.impl;

import org.springframework.stereotype.Service;
import transkop.tracking.model.Location;
import transkop.tracking.repository.LocationRepository;
import transkop.tracking.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location create(Location location) {
        return locationRepository.save(location);
    }
}
