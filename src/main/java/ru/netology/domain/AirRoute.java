package ru.netology.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AirRoute implements Comparable <AirRoute>{
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int travelTimeMin;


    @Override
    public int compareTo(AirRoute o) {
        return price - o.price;
    }
}
