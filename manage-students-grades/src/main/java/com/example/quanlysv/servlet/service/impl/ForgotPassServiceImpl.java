package com.example.quanlysv.servlet.service.impl;

import com.example.quanlysv.servlet.dao.IAccountDao;
import com.example.quanlysv.servlet.dao.impl.AccountDaoImpl;
import com.example.quanlysv.servlet.entity.AccountEntity;
import com.example.quanlysv.servlet.service.IForgotPassService;
import org.mindrot.jbcrypt.BCrypt;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Properties;

public class ForgotPassServiceImpl implements IForgotPassService {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$";

    private final IAccountDao accountDao;


    public ForgotPassServiceImpl() {
        this.accountDao = new AccountDaoImpl();
    }

    @Override
    public boolean existEmailUser(String email) {
        try {
            if(accountDao.existEmailUser(email) != null) return true;
            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean sendEmail(String emailFinish) {
        try {
            // Sử dụng mail này làm mail hệ thống
            final String fromEmail = "ggdriversfin01@gmail.com";
            // Mat khai email cua ban
            final String password = "ziaoaqkvumbqthir";

            final String subject = "Reset password account !";
            String verification = generateRandomPassword();
            final String body = "Mã code reset password là: " + verification;
            MimeMessage msg = AuthenEmailStart(fromEmail, password);
            //set message headers
            setMetadataForMail(fromEmail, subject, body, msg);
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailFinish, false));
            Transport.send(msg);
            System.out.println("Gui mail thanh cong");
            return updateVerification(verification, emailFinish);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateVerification(String verification, String email) {
        AccountEntity account = accountDao.existEmailUser(email);
        System.out.println(account.getUsername());
        return accountDao.updateVerification(verification, account.getUsername());
    }


    private static void setMetadataForMail(String fromEmail, String subject, String body, MimeMessage msg) throws MessagingException, UnsupportedEncodingException {
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");
        msg.setFrom(new InternetAddress(fromEmail, "NoReply-Email"));
        msg.setReplyTo(InternetAddress.parse(fromEmail, false));
        msg.setSubject(subject, "UTF-8");
        msg.setText(body, "UTF-8");
    }

    private static MimeMessage AuthenEmailStart(String fromEmail, String password) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        MimeMessage msg = new MimeMessage(session);
        return msg;
    }


    public static String generateRandomPassword() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int randomIndex = secureRandom.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }


}
