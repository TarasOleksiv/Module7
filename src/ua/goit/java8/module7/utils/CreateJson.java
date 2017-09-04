package ua.goit.java8.module7.utils;

import ua.goit.java8.module7.Fruit;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateJson {
    private String[] dateDelivery = {"04/08/2017", "05/08/2017", "06/08/2017", "07/08/2017"};

    public CreateJson() {
        for (int i = 0; i < dateDelivery.length; i++) {
            List<Fruit> fruits = new ArrayList<>();
            fruits.add(new Fruit(Fruit.Type.apple, 10, dateDelivery[i], 25));
            fruits.add(new Fruit(Fruit.Type.tangerine, 5, dateDelivery[i], 35));
            fruits.add(new Fruit(Fruit.Type.apricot, 12, dateDelivery[i], 20));
            fruits.add(new Fruit(Fruit.Type.plum, 6, dateDelivery[i], 30));
            fruits.add(new Fruit(Fruit.Type.banana, 15, dateDelivery[i], 15));
            fruits.add(new Fruit(Fruit.Type.pear, 8, dateDelivery[i], 45));
            fruits.add(new Fruit(Fruit.Type.grapefruit, 18, dateDelivery[i], 55));
            fruits.add(new Fruit(Fruit.Type.peach, 9, dateDelivery[i], 40));
            fruits.add(new Fruit(Fruit.Type.mellon, 20, dateDelivery[i], 50));
            fruits.add(new Fruit(Fruit.Type.watermelon, 4, dateDelivery[i], 10));
            String json = JSON.toJSONString(fruits);
            try {
                FileUtils.writeToFile(json, "files/supply" + (i+1) + ".json");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish creating JSON files.");
    }

}
