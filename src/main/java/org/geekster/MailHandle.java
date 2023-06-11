package org.geekster;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandle {

    void sendMail(){
        Properties systemProps = System.getProperties(); //properties is a kind of hashmap

        System.out.println(systemProps);

        systemProps.put("mail.smtp.host",MailData.CustomHost);
        systemProps.put("mail.smtp.port",MailData.CustomPort);
        systemProps.put(MailData.sslEnable,"true");
        systemProps.put(MailData.auth,"true");

        Authenticator mailAuthenticator = new CustomizedMailAuth(); //Authenticator is the parent class

        Session mailSession = Session.getInstance(systemProps,mailAuthenticator);

        //mime message

        MimeMessage mailMessage = new MimeMessage(mailSession);

        try {
            mailMessage.setFrom(MailData.myMail);
            mailMessage.setSubject("This is an Automated Email");
            mailMessage.setText("Hi...  This mail is just a testing purpose for generating an automation mail using java");
            // set the receiver
            Address receiveEmail = new InternetAddress(MailData.receiveMail);

            mailMessage.setRecipient(Message.RecipientType.TO, receiveEmail);

            Transport.send(mailMessage);
        }
        catch(Exception mailException){
            System.out.println(mailException.toString());
        }
    }
}
