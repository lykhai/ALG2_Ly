package utils.loadData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import app.Customer;

/**
 * Trida obsahuje metodu pro nacteni dat
 * implementovana z LoadDataInterface
 * 
 * @author kajal
 */
public class LoadCustomersData implements LoadDataInterface{
    public  static ArrayList<Customer> cstData = new ArrayList<Customer>();
    private final String PATH = ".\\data\\CustomersData.txt";
    private  File file;
    private  Scanner sc;
    
    /**
     * Metoda nacita data o registrovanem zakaznikovi
     * jednotliva data v souboru (oddelena tabulatorem) se vlozi
     * do objektu Customer a ten je nasledne prirazen do cstData typu
     * ArrayList
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    @Override
    public void loadData() throws FileNotFoundException, IOException {
        String[] data;
        try {
            file = new File(PATH);
            file.setReadOnly();
            sc = new Scanner(file);
            while (sc.hasNextLine()) {            
                data = sc.nextLine().split("\t");
                cstData.add(new Customer(data[0], data[1], data[2], data[3], data[4]));
            }
        } catch (FileNotFoundException e) {
        }
    }
}
