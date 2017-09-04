package ua.goit.java8.module7;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import ua.goit.java8.module7.utils.FileUtils;


/**
 * Created by t.oleksiv on 04/09/2017.
 */
public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        Date parsingDate = date;

        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd/MM/yyyy");
        String str = args.length == 0 ? "04/08/2017" : args[0];
        try {
            parsingDate = formatForDateNow.parse(str);
            //System.out.println(parsingDate);
        }catch (ParseException e) {
            System.out.println("Unable to parse date " + formatForDateNow);
        }

        Fruit fruit1 = new Fruit(Fruit.Type.apple,10,parsingDate,25);
        Fruit fruit2 = new Fruit(Fruit.Type.tangerine,15,parsingDate,55);
        Fruit fruit3 = new Fruit(Fruit.Type.apricot,10,parsingDate,35);
        Fruit fruit4 = new Fruit(Fruit.Type.plum,20,parsingDate,20);
        Fruit fruit5 = new Fruit(Fruit.Type.banana,25,parsingDate,45);

        String json1 = JSON.toJSONStringWithDateFormat(fruit1, "dd/MM/yyyy");
        String json2 = JSON.toJSONStringWithDateFormat(fruit2, "dd/MM/yyyy");
        String json3 = JSON.toJSONStringWithDateFormat(fruit3, "dd/MM/yyyy");
        String json4 = JSON.toJSONStringWithDateFormat(fruit4, "dd/MM/yyyy");
        String json5 = JSON.toJSONStringWithDateFormat(fruit5, "dd/MM/yyyy");

        ArrayList<String > income1 = new ArrayList<>(5);
        income1.add(json1);
        income1.add(json2);
        income1.add(json3);
        income1.add(json4);
        income1.add(json5);

        String json = JSON.toJSONString(income1);
        //System.out.println(json1);

        try {
            FileUtils.writeToFile(json, "files/supply1.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        str = args.length == 0 ? "04/09/2017" : args[0];
        try {
            parsingDate = formatForDateNow.parse(str);
            //System.out.println(parsingDate);
        }catch (ParseException e) {
            System.out.println("Unable to parse date " + formatForDateNow);
        }

        Fruit fruit6 = new Fruit(Fruit.Type.grapefruit,10,parsingDate,25);
        Fruit fruit7 = new Fruit(Fruit.Type.watermelon,10,parsingDate,25);
        Fruit fruit8 = new Fruit(Fruit.Type.mellon,10,parsingDate,25);
        Fruit fruit9 = new Fruit(Fruit.Type.pear,10,parsingDate,25);
        Fruit fruit10 = new Fruit(Fruit.Type.peach,10,parsingDate,25);

        ArrayList<Fruit> income2 = new ArrayList<>(5);
        income2.add(fruit1);
        income2.add(fruit2);
        income2.add(fruit3);
        income2.add(fruit4);
        income2.add(fruit5);

        json = JSON.toJSONString(income2);
        try {
            FileUtils.writeToFile(json, "files/supply2.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
