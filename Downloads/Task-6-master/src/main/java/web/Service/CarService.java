package web.Service;

import org.springframework.stereotype.Component;
import web.Model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CarService {
    public List<Car> carList;
    public CarService() {
        carList = new ArrayList<>();
        carList.add(new Car("UAZ", "black", 20000));
        carList.add(new Car("UAZ", "black", 20000));
        carList.add(new Car("UAZ", "black", 20000));
        carList.add(new Car("UAZ", "black", 20000));
        carList.add(new Car("UAZ", "black", 20000));
    }


    public List<Car> getCars(int count) {
        if (count >= carList.size()) {
            return carList;
        }
        return carList.subList(0, count);

    }
    public List<Car> getAllCars() {
        return carList;
    }

}
