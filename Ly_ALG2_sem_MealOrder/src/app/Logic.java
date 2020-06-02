package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.loadData.LoadCustomersData;
import utils.loadData.LoadMenuData;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Tato trida realizuje hlavni logiku programu
 *
 * @author kajal
 */
public class Logic {
    public static LoadCustomersData lcd = new LoadCustomersData();
    public static ArrayList<Customer> customersData = new ArrayList<Customer>();
    public static StringBuilder sb = new StringBuilder();
    /**
     * lnPointer - pomocna promenna, zjistuje, na kt. radku se data vyskytuji
     */
    public static int lnPointer;    


    /**
     * Metoda kontroluje zda je emailova adresa jiz zapsana v "systemu"
     * projizdi soubor s daty o zakaznicich a hleda shodu v emailu
     * 
     * @param email
     * @return 
     */
    public static boolean isRegistered(String email){
        for (int i = 0; i < lcd.cstData.size(); i++) {
            if (email.equals(lcd.cstData.get(i).getEmail())) {
                lnPointer = i;    //saves line of data of certain customer
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metoda zapisuje noveho zakaznika do "systemu" (souboru)
     * zapisuje data o zakaznikovy do ArrayListu a oddeluje jednotliva data
     * tabularorem (\t)
     * ze souboru lze cist, ale nelze do nej zapisovat
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void saveCustomersData() throws FileNotFoundException, IOException{
        File file = new File(".\\data\\CustomersData.txt");
        file.setWritable(true);
        try (FileWriter wFile = new FileWriter(file, true)) {
            for (int i = 0; i < customersData.size(); i++) {
                wFile.write(customersData.get(i).getName() + "\t" + customersData.get(i).getlName() + "\t" +
                        customersData.get(i).getEmail() + "\t" + customersData.get(i).getPhone() + "\t" + customersData.get(i).getMealNum() + "\n");    
            }
        }
        file.setReadOnly();
    }
    
    /**
     * Metoda schromazdi udaje o objednavce a vytiskne uctenku
     * zadane parametry jsou udaje o zakaznikovi, ktere vklada do 
     * statickeho StringBuilderu, dale vklada udaje kdy se objednavka 
     * uskutecnila a kolik je treba zaplatit
     * vracena hodnota je pretypovana se StringBuilderu na String pro vypis
     * 
     * @param name
     * @param lName
     * @param phone
     * @param mealNum
     * @return 
     */
    public static String printBill(String name, String lName, String phone, ArrayList<Integer> mealNum){
        String temp = "";
        String total = "";
        String bill = "";
        /*
        v cyklu for se naformatuji cast vystupu
        */
        for (int i = 0; i < mealNum.size(); i++) {
                temp += String.format("\t%-32s %-28s", LoadMenuData.listOfMeal.get(mealNum.get(i)-1).name, LoadMenuData.listOfMeal.get(mealNum.get(i)-1).price);
                if (i < mealNum.size()-1)   temp += "\n";

        }
        total = String.format("\t%-33s %-25s", "\n\tTotal:", orderTotal(mealNum) + "\n");
        char N = Character.toUpperCase(name.charAt(0));
        char LN = Character.toUpperCase(lName.charAt(0));
        
        sb.append("\n\tYour order code: ").append(generateOrderNum()).append("\n\t");
        sb.append(DateTimeFormatter.ofPattern("HH:mm\n\tyyyy/mm/dd").format(LocalDateTime.now()));
        sb.append("\n\tName: ").append((N + name.substring(1))).append(" ").append(LN + lName.substring(1));
        sb.append("\n\tPhone number: ").append(phone).append("\n\tYOUR ORDER:\n");
        sb.append(temp).append(total);
        bill = sb.toString();
        sb = new StringBuilder();
        return bill;
    }
    
    /**
     * Metoda generuje kod objednavky
     * metoda vytvori nahodne generovany 8-mi mistny kod a vklada jej do 
     * StringBuilderu
     * metoda vraci pretypovany StringBuilder na String
     * 
     * @return 
     */
    public static String generateOrderNum(){
        StringBuilder orderNum = new StringBuilder();
        final String ALPHA_NUM_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int character;
        for (int i = 0; i < 9; i++) {
            character = (int)(Math.random()*ALPHA_NUM_STRING.length());
            orderNum.append(ALPHA_NUM_STRING.charAt(character));
            
        }
        return orderNum.toString();
    }
    
    /**
     * Metoda resi celkovou castku za objednavku
     * metoda vyhleda danou cenu kazdeho pokrmu a spocita jeji sumu
     * vysledek je nutne vracet jako String, kvuli vypisu uctenky
     * 
     * @param mealNum
     * @return 
     */
    public static String orderTotal(ArrayList<Integer> mealNum){
        /*
        Pattern - nastavi reg. vyraz podle ktereho bude v souboru 
            hledat jeji shodu
        Matcher -  hleda shodu podle reg. vyrazu v ArrayListu nainplementovaneho
            ve tride LoadMenuData
        */
        Pattern p = Pattern.compile("\\d+");
        Matcher m;
        int total = 0;
        int temp = 0;
        for (int i = 0; i < mealNum.size(); i++) {
            m = p.matcher(Integer.toString(LoadMenuData.listOfMeal.get(mealNum.get(i)-1).price));
            while (m.find()) {                
                temp = Integer.parseInt(m.group());
                total += temp;
            }
        }
        return Integer.toString(total) + ",-";
    }  
    
    /**
     * Metoda vraci naformatovanou uctenku
     * 
     * @return 
     */
    public static String getBill(){
        return sb.toString();
    }

}
