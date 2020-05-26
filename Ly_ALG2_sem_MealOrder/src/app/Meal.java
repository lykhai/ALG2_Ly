package app;

/**
 * Trida objektu Meal
 *
 * @author kajal
 */
public class Meal implements Comparable<Meal>{
    public int index;
    public String name;
    public int price;

    public Meal(int index, String name, int price) 
    {
        this.index = index;
        this.name = name;
        this.price = price;
    }

    /**
     * Metoda pro serazeni podle ceny
     * vzuziti Comparable
     * 
     * @param t
     * @return 
     */
    @Override
    public int compareTo(Meal t) {
        if(price == t.price)
            return 0;
        else if (price > t.price)
            return 1;
        else
            return -1;
    }
    
    
}
