package ru.netology.manager;
import ru.netology.domain.AirRoute;
import ru.netology.repository.AirRouteRepository;

import java.util.Arrays;

public class AirRouteManager {
    private AirRouteRepository repository;

    public AirRouteManager(AirRouteRepository repository) {
        this.repository = repository;
    }

    public void add(AirRoute item) {
        repository.save(item);
    }

    public AirRoute[] findAll(String airportFrom, String airportTo) {
        AirRoute[] result = new AirRoute[0];
        for (AirRoute airRoute : repository.findAll()) {
            if (airRoute.getAirportFrom().equalsIgnoreCase(airportFrom) && airRoute.getAirportTo().equalsIgnoreCase(airportTo)) {
                AirRoute[] tmp = new AirRoute[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = airRoute;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
