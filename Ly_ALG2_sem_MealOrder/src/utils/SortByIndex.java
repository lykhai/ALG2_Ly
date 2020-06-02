package utils;

import java.util.Comparator;
import app.Meal;

/**
 * Trida obsahuje metodu pro trideni
 * 
 * @author kajal
 */
public class SortByIndex implements Comparator<Meal>{

    /**
     * Metoda tridi dle indexu nebo-li poradi jidel v menu
     * jako  prvni parametr prijme LoadMenuData.listOfMeal typu ArrayList
     * druhy parametr bude objekt Comparatoru
     *
     * @param t
     * @param t1
     * @return 
     */
    @Override
    public int compare(Meal t, Meal t1) {
       return t.index - t1.index;
    }
    
}
