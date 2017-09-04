package ua.goit.java8.module7;

import com.alibaba.fastjson.JSON;
import ua.goit.java8.module7.utils.DateUtils;
import ua.goit.java8.module7.utils.FileUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Taras on 04.09.2017.
 */
public class TradingShop {
    private List<Fruit> fruits = new ArrayList<>();

    public void addFruits(String pathToJsonFile) throws IOException {
        String json;
        json = FileUtils.readFromFile(pathToJsonFile);
        fruits.addAll(JSON.parseArray(json,Fruit.class));
        System.out.println("Fruits are loaded from " + pathToJsonFile);
    }

    public void showInfo(List<Fruit> fruitList) throws ParseException {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("Fruit \t SupplyDate \t ShelfLife \t Price");
        System.out.println("--------------------------------------------------");
        for (Fruit fruit : fruitList) {
            String str = String.valueOf(fruit.getType()) + " \t" + fruit.getDateSupply() + " \t" + fruit.getShelfLife() + " \t" + fruit.getPrice();
            System.out.println(str);
        }
    }

    public void save(String pathToJsonFile){
        String json = JSON.toJSONString(fruits);
        try {
            FileUtils.writeToFile(json, pathToJsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Finish saving DB to file");
    }

    public void load(String pathToJsonFile) throws IOException, ParseException {
        fruits.clear();
        showInfo(fruits);
        addFruits(pathToJsonFile);
    }

    public List<Fruit> getSpoiledFruits(Date date) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            Date dateExpiration = DateUtils.getDateExpiration(fruit.getDateSupply(), fruit.getShelfLife());
            if (DateUtils.isSpoiled(dateExpiration, date)) {
                fruitList.add(fruit);
            }
        }
        return fruitList;
    }

    public List<Fruit> getSpoiledFruits(Date date, Fruit.Type fruitType) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getType().equals(fruitType)) {
                Date dateExpiration = DateUtils.getDateExpiration(fruit.getDateSupply(), fruit.getShelfLife());
                if (DateUtils.isSpoiled(dateExpiration, date)) {
                    fruitList.add(fruit);
                }
            }
        }
        return fruitList;
    }

    public List<Fruit> getAvailableFruits(Date date) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            Date dateExpiration = DateUtils.getDateExpiration(fruit.getDateSupply(), fruit.getShelfLife());
            if (!DateUtils.isSpoiled(dateExpiration, date)) {
                fruitList.add(fruit);
            }
        }
        return fruitList;
    }

    public List<Fruit> getAvailableFruits(Date date, Fruit.Type fruitType) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getType().equals(fruitType)) {
                Date dateExpiration = DateUtils.getDateExpiration(fruit.getDateSupply(), fruit.getShelfLife());
                if (!DateUtils.isSpoiled(dateExpiration, date)) {
                    fruitList.add(fruit);
                }
            }
        }
        return fruitList;
    }

    public List<Fruit> getAddedFruits(Date date) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (DateUtils.convertStringToDate(fruit.getDateSupply()).equals(date)) {
                fruitList.add(fruit);
            }
        }
        return fruitList;
    }

    public List<Fruit> getAddedFruits(Date date, Fruit.Type fruitType) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getType().equals(fruitType)) {
                if (DateUtils.convertStringToDate(fruit.getDateSupply()).equals(date)) {
                    fruitList.add(fruit);
                }
            }
        }
        return fruitList;
    }

    public List<Fruit> getFruits(){
        return fruits;
    }

}
