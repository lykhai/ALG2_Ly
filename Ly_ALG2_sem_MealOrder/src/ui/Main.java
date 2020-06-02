package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import app.Customer;
import app.Email;
import utils.loadData.LoadCustomersData;
import utils.loadData.LoadMenuData;
import app.Logic;
import utils.ValidInformations;
import java.util.Collections;
import utils.SortByIndex;

/**
 *
 * @author kajal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    static Scanner sc = new Scanner(System.in);
    
    /**
     * Metoda main simuluje uzivatelske rozhrani
     * obsahuje menu s vyberem
     * vstupem jsou udaje o uzivateli a jeho objednavce
     * je mozne se zaregistrovat do systemu
     * prohlidnout si menu jidel
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {        
        String name;
        String lName;
        String email;
        String phone;
        ArrayList<Integer> mealNum = new ArrayList<Integer>();
        
        /**
         * objekty pro volani potrebnych metod a praci s daty ulozenych v 
         * ArrayListu
         */
        LoadMenuData lmd = new LoadMenuData();
        LoadCustomersData lcd = new LoadCustomersData();
        ValidInformations vi = new ValidInformations();
        lmd.loadData();
 
        String menuOption = ""; //vyber v menu
        int orderInfo;          //vstup uzivatele - zadani potrebnych informaci k objednavce
        while (!"5".equals(menuOption)) {
            lcd.loadData();
            System.out.println("\n-------- MENU --------");
            System.out.print("  1 - New customer\n  2 - Iam registered\n"
                    + "  3 - Show menu"
                    + "\n  4 - Sort menu by price\n  5 - Leave\n: ");
            menuOption = sc.next();    
            
            switch (menuOption) {
                /*
                 uzivatel zada informace potrebne k objednavce
                */
                case "1":   
                    System.out.println("Contact informations:");
                    System.out.print("Name: ");
                    name = sc.next();
                    System.out.print("Lastname: ");
                    lName = sc.next();
                    System.out.print("E-mail: ");
                    email = sc.next();
                    System.out.print("Phone number (+420-xxx-xxx-xxx,\n"
                            + "xxx-xxx-xxx, or without \"-\" dashes)\n:");
                    phone = sc.next();
                    /**
                     * Kontrola zda email neni uz v systemu registrovan pokud ne,
                     * muze pokracovat dale v objednavce
                    */
                    if (Logic.isRegistered(email)) {
                        System.out.println("This email is already registered...\n"
                                + "Try option 2 in menu or enter unregistered email...");
                    } else {
                        /**
                         * Kontrola zda jsou informace zadane ve spravnem formatu,
                         * pokud ne, vytiskne se na vystup chybova hlaska
                         */
                        if ((vi.validMail(email)) && (vi.validPhone(phone))) {
                            /**
                             * Zakaznikuv vyber jidla na prani
                             */
                            System.out.println("Enter your order: \n(end selection with 0 - zero)");
                            orderInfo = sc.nextInt();
                            String temp = "";
                            /**
                             * Zada-li objednavku, kt. neni v menu, bude na vystupu upozornen
                             * Pokud si objednavku rozmysli, muze se vratit zpet do menu
                            */
                            while (orderInfo == 0) {
                                System.out.println("You did order nothing\nDo you want to leave?\n(Y - YES / N - NO)");
                                temp = sc.next();
                                /**
                                 * Navrat do menu, pokud si zakaznik nechce nic objednat
                                 */
                                if ("Y".equals(temp.toUpperCase()))   break;
                                else {
                                    System.out.println("Enter your order: \n(end selection with 0 - zero)");
                                    orderInfo = sc.nextInt();
                                }
                            }
                            /**
                             * Vyber jidla
                             */
                            if(!"Y".equals(temp.toUpperCase())) {
                                while(orderInfo != 0){
                                    if (orderInfo > lmd.listOfMeal.size()){
                                        System.out.println("This meal is not in menu...");
                                    } else {
                                        mealNum.add(orderInfo);
                                        orderInfo = sc.nextInt();
                                    }   
                                }
                                /**
                                 * zakaznik se muze registrovat - nemusi pak vypisovat sve udaje znova
                                 */
                                System.out.println("Do you wish to be registered to the system?\n(Y - YES / any key for NO)");
                                if ("Y".equals(sc.next().toUpperCase())) {
                                    try {
                                        Logic.customersData.add(new Customer(name, lName, email, phone, mealNum));
                                        Logic.saveCustomersData();  //ulozeni do systemu
                                    } catch (IOException e) {
                                        System.out.println("Something went wrong :|\nWe were not able to register you...");
                                    }
                                }
                                /**
                                 * Na vystup se vytiskne uctenka, kt. se posle i na email zakaznika
                                 */
                                System.out.println(Logic.printBill(name, lName, phone, mealNum));
                                if (Email.email(email)) {
                                    System.out.println("\tWe send you an email with order informations...");
                                } else {
                                    System.out.println("\tWe were not able to send you and order informations...");
                                }
                            }
                        } else {
                            System.out.println("Not valid email adress or phone number...");
                        }
                    }
                    mealNum.clear();    //je treba vycistit ArrayList pro nove objednavky
                    break;
                
                case "2":
                    /**
                     * Pokud je zakaznik jiz regsitrovan, staci zadat email, v 
                     * pripade neshody se zobrazi chybove hlaseni
                     */
                    System.out.print("Enter your registered email adress: ");
                    email = sc.next();
                    System.out.println("\nEnter your order:\n(end selection with 0 - zero)");
                    orderInfo = sc.nextInt();
                    String temp = "";
                    /**
                     * Zakaznik muze odejit zpet do menu nebo pokracovat v objednavce
                     */
                    while (orderInfo == 0) {
                        System.out.println("You did order nothing\nDo you want to leave? (Y - YES / N - NO)");
                        temp = sc.next();
                        if ("y".equals(temp))   break;
                        else {
                            System.out.println("Enter your order: \n(end selection with 0 - zero)");
                            orderInfo = sc.nextInt();
                        }
                    }
                    if (!"y".equals(temp)) {
                        while(orderInfo != 0){
                            if (orderInfo > lmd.listOfMeal.size()){
                                System.out.println("This meal is not in menu...");
                            } else {
                                mealNum.add(orderInfo);
                                orderInfo = sc.nextInt();
                            }   
                        }
                        /**
                         * Kontrola zda je uzivatel zaregistrovan
                         */
                        if (Logic.isRegistered(email)) {
                            System.out.println(Logic.printBill(lcd.cstData.get(Logic.lnPointer).getName(),
                            lcd.cstData.get(Logic.lnPointer).getlName(),
                            lcd.cstData.get(Logic.lnPointer).getPhone(), mealNum));
                            //Zaslani emailu s uctenkou
                            if (Email.email(email)) {
                                System.out.println("\tWe send you an email with order informations...");
                            } else {
                                System.out.println("\tWe were not able to send you and order informations...");
                            }
                        } else {
                            System.out.println("Wrong e-mail adress or you are not registered yet...");
                        }
                    }
                    mealNum.clear();
                    break;
                
                case "3":
                    /**
                     * Zobrazeni menu - seradi se podle poradi
                     * Collections.sort zavola metodu, kt. vyuziva knihovnu Comparator
                     */
                    Collections.sort(lmd.listOfMeal, new SortByIndex());
                    for (int i = 0; i < LoadMenuData.listOfMeal.size(); i++) {
                        System.out.format("%5s %-35s %-10d", lmd.listOfMeal.get(i).index,
                                lmd.listOfMeal.get(i).name,
                                lmd.listOfMeal.get(i).price);
                        System.out.println();
                    }
                    break;
                    
                case "4":
                    /**
                     * Zobrazeni menu - serazene podle ceny
                     * Collections.sort zavola metodu compareTo - knihovna Comparable
                     */
                    Collections.sort(lmd.listOfMeal);
                    for (int i = 0; i < lmd.listOfMeal.size(); i++) {
                        System.out.format("%5s %-35s %-10d", lmd.listOfMeal.get(i).index,
                                lmd.listOfMeal.get(i).name,
                                lmd.listOfMeal.get(i).price);
                        System.out.println();
                    }
                    break;
            }
        }   
    }
    
}
