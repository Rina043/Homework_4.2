package ru.netology.manager;
import ru.netology.domain.AirRoute;
import ru.netology.repository.AirRouteRepository;

import java.util.Arrays;
import java.util.Comparator;

public class AirRouteManager {
    private AirRouteRepository repository;

    public AirRouteManager(AirRouteRepository repository) {
        this.repository = repository;
    }

    public void add(AirRoute item) {
        repository.save(item);
    }

    public AirRoute[] findAllPriceSort(String airportFrom, String airportTo) {
        AirRoute[] result = new AirRoute[0];
        for (AirRoute item : repository.findAll()) {
            if (item.getAirportFrom().equalsIgnoreCase(airportFrom) && item.getAirportTo().equalsIgnoreCase(airportTo)) {
                AirRoute[] tmp = new AirRoute[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public AirRoute[] findAllTimeSort(String airportFrom, String airportTo, Comparator<AirRoute> comparator) {
        AirRoute[] result = new AirRoute[0];
        for (AirRoute item : repository.findAll()) {
            if (item.getAirportFrom().equalsIgnoreCase(airportFrom) && item.getAirportTo().equalsIgnoreCase(airportTo)) {
                AirRoute[] tmp = new AirRoute[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}
