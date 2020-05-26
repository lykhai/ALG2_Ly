package utils.loadData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import app.Meal;

/**
 * Trida obsahuje metodu pro nacteni dat
 * implementovana z LoadDataInterface
 * 
 * @author kajal
 */
public class LoadMenuData implements LoadDataInterface{
    public static ArrayList<Meal> listOfMeal = new ArrayList<Meal>();
    private final String PATH = ".\\data\\Menu.txt";
    private File file;
    private Scanner sc;
    
    /**
     * Metoda nacita data z Menu.txt
     * jednotliva data v souboru (oddelena tabulatorem) se vlozi
     * do objektu Meal a ten je nasledne prirazen do listOfMeal typu
     * ArrayList
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    @Override
    public void loadData() throws FileNotFoundException, IOException{
        String[] data;
        try {
            file = new File(PATH);
            file.createNewFile();
            file.setReadOnly();
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                data = sc.nextLine().split("\t");
                listOfMeal.add(new Meal(Integer.valueOf(data[0]), data[1], Integer.valueOf(data[2].substring(0, data[2].length()-2))));            
            }
        } catch (FileNotFoundException e) {     
        }
        
    }
    
}
