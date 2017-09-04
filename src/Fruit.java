import java.util.Date;

/**
 * Created by t.oleksiv on 04/09/2017.
 */
public class Fruit {
    public enum Type {banana, apple, pear, plum, peach, apricot, mellon, watermelon, grapefruit, tangerine};
    private Type type;
    private int shelfLife;
    private Date date;
    private int price;

    public Fruit(Type type,int shelfLife, Date date, int price){
        this.type = type;
        this.shelfLife = shelfLife;
        this.date = date;
        this.price = price;
    }

    public Type getType(){
        return type;
    }

    public int getShelfLife(){
        return shelfLife;
    }

    public Date getDate(){
        return date;
    }

    public int getPrice(){
        return price;
    }
}
