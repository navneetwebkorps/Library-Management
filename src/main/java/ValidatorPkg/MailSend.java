package ValidatorPkg;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailSend {

public static boolean SendEmail(String memberId,String password)
{
	  String from = "navneet.b@webkorps.com";
      String host = "smtp.gmail.com";
      String to="navneetbundela240@gmail.com";
      String pass="hqfe baph ivwt spxj";

      Properties properties = System.getProperties();
      properties.put("mail.smtp.host", host);
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable", "true");

      Session session = Session.getInstance(properties, new Authenticator() {
          @Override
		protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(from, pass);
          }
      });

      try {
          MimeMessage message = new MimeMessage(session);
          message.setFrom(new InternetAddress(from));
          message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
          message.setSubject("User membership id and password");
          
           message.setText("User Id:      "+memberId+"              User Password:     " +password);

          Transport.send(message);
          System.out.println("Sent message successfully...");
      } catch (Exception e) {
          e.printStackTrace();
      }
      return true;}




}

