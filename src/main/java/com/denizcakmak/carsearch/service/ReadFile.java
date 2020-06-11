package com.denizcakmak.carsearch.service;

import com.denizcakmak.carsearch.model.Car;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component  //Car class is a spring Bean, bean: Spring container,manager
public class ReadFile {
    List<Car> carInfo;

    public void readFile(String path){

        carInfo = new ArrayList<>();

        File file = new File(path);
        String str;
        BufferedReader bufferedReader;  //buffered reader for reading file

        {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));

                while((str = bufferedReader.readLine())!=null){  //check the file is empty or not

                    String str2 [] = str.split(";");
                    carInfo.add(new Car(str2[0],str2[1],str2[2]));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Car> search(String criteria, String key){  //search with criteria and key
        List<Car> cars = new ArrayList<>();

        readFile("/Users/macbookair/Downloads/carInfo.txt"); //txt file path

        switch (criteria){
            case "BRAND":
                cars = carInfo.stream().filter(car -> car.getBrand().contains(key)).collect(Collectors.toList());
                break;
            case "MODEL":
                cars = carInfo.stream().filter(car -> car.getModel().contains(key)).collect(Collectors.toList());
                break;
            case "CLASS":
                cars = carInfo.stream().filter(car -> car.getCarClass().contains(key)).collect(Collectors.toList());
                break;
            case "ALL":
                cars = carInfo.stream().filter(car -> car.getBrand().contains(key)
                        || car.getCarClass().contains(key)
                        || car.getModel().contains(key)).collect(Collectors.toList());
                break;
            default:
                System.out.println("Not found");
        }

        cars.forEach(car -> {
          System.out.println(car);
        });

        return cars;
    }
}
