package app;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;

/**
 * Trida se stara o zasilani emailu
 * 
 * @author kajal
 */
public class Email {
   
    /**
     * Metoda pro zaslani emailu
     * nutnou casti je nastavit vlastnosti portu, protokolu atd. - o tuto cast se
     * stara objekt prop (Properties)
     * Session zajistuje uzivatelske udaje pro pristup do emailove adresy, ze kt.
     * se bude odesilat
     * Objekt msg (MimeMessage) se nastavi parametry od kdo email posila, 
     * komu se ma poslat a zarizuje vypis hlavicky ("predmet") a zpravy
     * Transport je metoda, kt. zasila na email zakaznika
     * 
     * @param email
     * @return 
     */
    public static boolean email(String email){
        String to = email;
        String from = "khai.ly.dinh.8@gmail.com";
        
        /*
         Nastavi se emailovy protokol, port a opravneni
        */
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
        /*
         Session cast zajistuje pristup do emailu ze ktereho se bude posilat zprava
        */
        Session session = Session.getDefaultInstance(prop,
        new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("khai.ly.dinh.8@gmail.com", "Piskot123");
            }
        });

        /*
         Objekt msg (MimeMessage) zajisti odkud kam se ma email posilat
        */
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            /*
             Nastavi nazev predmetu a zpravy
             O zaslani emailu se stara Transport metoda
            */
            msg.setSubject("Meal Order");
            msg.setText(Logic.getBill());
            Transport.send(msg);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
