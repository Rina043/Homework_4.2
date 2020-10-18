package ru.netology.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class AirRoute implements Comparable <AirRoute>{
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int travelTimeMinutes;


    @Override
    public int compareTo(AirRoute o) {
        return price - o.price;
    }

}
