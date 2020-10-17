package ru.netology.repository;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AirRoute;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AirRouteRepositoryTest {
    private AirRouteRepository repository = new AirRouteRepository();
    private AirRoute first = new AirRoute(1, 10_000, "SVO", "KHV", 480);
    private AirRoute second = new AirRoute(2, 20_000, "SVO", "CDG", 600);

    @Test
    void shouldSave() {
        repository.save(first);
        AirRoute[] expected = new AirRoute[]{first};
        AirRoute[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmpty() {
        AirRoute[] expected = new AirRoute[]{};
        AirRoute[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIfExists() {
        repository.save(first);
        repository.save(second);
        int idToFind = 2;
        repository.findById(idToFind);
        AirRoute expected = second;
        AirRoute actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNullIfNotExists() {
        repository.save(first);
        repository.save(second);
        int idToFind = 5;
        repository.findById(idToFind);
        AirRoute expected = null;
        AirRoute actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveIfExists() {
        int idToRemove =1;
        repository.save(first);
        repository.save(second);
        repository.removeById(idToRemove);
        AirRoute[] actual = repository.findAll();
        AirRoute[] expected = new AirRoute[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        repository.save(first);
        repository.save(second);
        assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));
    }

}