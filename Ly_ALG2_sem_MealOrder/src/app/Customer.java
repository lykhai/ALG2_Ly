package app;

import java.util.ArrayList;

/**
 *Trida pro vytvoreni objektu o zakaznikovi
 * 
 * @author kajal
 */
public class Customer {
    
    private String name;
    private String lName;
    private String email;
    private String phone;
    private ArrayList<Integer> mealNum;
    private String meal;

    public Customer(String name, String lName, String email, String phone, ArrayList<Integer> mealNum) {
        this.name = name;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.mealNum = mealNum;
    }
    
    //constructor for loading data from created CustomersData.txt file for sorting
    public Customer(String name, String lName, String email, String phone, String meal) {
        this.name = name;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.meal = meal;
    }
    
    public String getMeal() {
        return meal;
    }

    public String getName() {
        return name;
    }

    public String getlName() {
        return lName;
    }

    public String getPhone() {
        return phone;
    }    

    public String getEmail() {
        return email;
    }

    public ArrayList<Integer> getMealNum() {
        return mealNum;
    }
    
    
    
    
}
