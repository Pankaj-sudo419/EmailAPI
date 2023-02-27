package com.email.services;

import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
//    public static void main( String[] args )
//    {
//        System.out.println( "Sending....." );
//        String message = "Hello this is automatically generated Message";
//        String subject = "CoderArea : Confirmatio";
//        String to = "pp843958@gmail.com";
//        String from = "karl98perfect@gmail.com";
//
//        sendEmail(message,subject,to,from);
//    }

    public static boolean sendEmail(String subject, String message, String to) {
        // TODO Auto-generated method stub
        String from = "karl98perfect@gmail.com";
        // variable for gmail host
        boolean f =true;
        String host = "smtp.gmail.com";

        //get the system property
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES"+properties);

        //setting important information to properties object

        //host set


        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //to session object

        Session session = Session.getInstance(properties, new Authenticator() {

            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                // TODO Auto-generated method stub
                return new javax.mail.PasswordAuthentication("karl98perfect@gmail.com","Enter your Temporarily generated password");
            }

        });
        //compose message

        session.setDebug(true);
        MimeMessage m = new MimeMessage(session);

        try {
            //from email
            m.setFrom(from);

            //to email
            m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

            //add subject
            m.setSubject(subject);

            //adding text to message
            m.setText(message);

            //sending message
            Transport.send(m);
            System.out.println("Send Successfully........");
            f = true;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return f;

    }


}
