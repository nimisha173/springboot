package com.example.SharathMotors.service;

import com.example.SharathMotors.model.Car;
import com.example.SharathMotors.repository.Sharathrepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SharathserviceImplTest {

    private SharathserviceImpl sharathserviceImplUnderTest;

    @BeforeEach
    void setUp() {
        sharathserviceImplUnderTest = new SharathserviceImpl();
        sharathserviceImplUnderTest.sharathrepo = mock(Sharathrepo.class);
    }

    @Test
    void testAddCar() {
        // Setup
        final Car car = new Car(0, "cname", "price", "brand", "color", 0, "date");
        final Car expectedResult = new Car(0, "cname", "price", "brand", "color", 0, "date");

        // Configure Sharathrepo.save(...).
        final Car car1 = new Car(0, "cname", "price", "brand", "color", 0, "date");
        when(sharathserviceImplUnderTest.sharathrepo.save(
                new Car(0, "cname", "price", "brand", "color", 0, "date"))).thenReturn(car1);

        // Run the test
        final Car result = sharathserviceImplUnderTest.addCar(car);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllcar() {
        // Setup
        final List<Car> expectedResult = List.of(new Car(0, "cname", "price", "brand", "color", 0, "date"));

        // Configure Sharathrepo.findAll(...).
        final List<Car> cars = List.of(new Car(0, "cname", "price", "brand", "color", 0, "date"));
        when(sharathserviceImplUnderTest.sharathrepo.findAll()).thenReturn(cars);

        // Run the test
        final List<Car> result = sharathserviceImplUnderTest.getAllCar();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllcar_SharathrepoReturnsNoItems() {
        // Setup
        when(sharathserviceImplUnderTest.sharathrepo.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Car> result = sharathserviceImplUnderTest.getAllCar();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetdate() {
        // Setup
        final Car expectedResult = new Car(0, "cname", "price", "brand", "color", 0, "date");

        // Configure Sharathrepo.findByDate(...).
        final Car car = new Car(0, "cname", "price", "brand", "color", 0, "date");
        when(sharathserviceImplUnderTest.sharathrepo.findByDate("date")).thenReturn(car);

        // Run the test
        final Car result = sharathserviceImplUnderTest.getCarByDate("date");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
