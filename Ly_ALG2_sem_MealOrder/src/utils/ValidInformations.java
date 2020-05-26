package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *Trida obsahuje metody pro kontrolu validnich informaci
 * 
 * @author kajal
 */
public class ValidInformations {
    private static String regex;
    private static Pattern p;
    private static Matcher m;
    
    /**
     * Metoda kontroluje validitu emailu
     * kontrola zadaneho parametru podle daneho reg. vyrazu
     *
     * @param mail
     * @return 
     */
    public boolean validMail(String mail){
        regex = "^(.+)@(.+)$";
        p = Pattern.compile(regex);
        m = p.matcher(mail);
        if (m.matches())    return true;
        return false;
    }
    
    /**
     * Metoda kontruje validitu tel. cisla
     * kontroluje vlozeny parametr, zda odpovida vytvorenemu reg. vyrazu
     * @param phone
     * @return 
     */
    public boolean validPhone(String phone){
        regex = "^(\\+420)?(\\s)?[1-9][0-9]{2}(\\s)?[0-9]{3}(\\s)?[0-9]{3}$";
        p = Pattern.compile(regex);
        m = p.matcher(phone);
        if (m.matches()) return true;  
        return false;
    }
}
