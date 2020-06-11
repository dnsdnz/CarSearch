package com.denizcakmak.carsearch.service;


import com.denizcakmak.carsearch.model.Car;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component  //Car class is a spring Bean, bean: Spring container,manager
public class ReadFile {
    List<Car> carInfos ;

    public void readFile(String path){

        carInfos = new ArrayList<>();

        File file = new File(path);
        String str;
        BufferedReader bufferedReader;

        {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));

                while((str = bufferedReader.readLine())!=null){

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
