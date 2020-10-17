package ru.netology.repository;
import ru.netology.domain.AirRoute;
import ru.netology.exception.NotFoundException;

public class AirRouteRepository {
    private AirRoute[] items = new AirRoute[0];

    public void save(AirRoute item) {
        int length = items.length + 1;
        AirRoute[] tmp = new AirRoute[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AirRoute[] findAll() {
        return items;
    }


    public AirRoute findById(int id) {
        for (AirRoute product : items) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id " + id + " not found");
        }
        int length = items.length - 1;
        AirRoute[] tmp = new AirRoute[length];
        int index = 0;
        for (AirRoute item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
