package ru.netology.domain;
import java.util.Comparator;

public class AirRouteByTimeAscComparator implements Comparator<AirRoute> {
    public int compare(AirRoute o1, AirRoute o2) {
        return o1.getTravelTimeMinutes() - o2.getTravelTimeMinutes();
    }
}
