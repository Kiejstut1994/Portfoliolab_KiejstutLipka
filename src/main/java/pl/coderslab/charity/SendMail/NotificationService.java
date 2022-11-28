package pl.coderslab.charity.SendMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Classes.User;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;
    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }
    public void sendveryficatingwithtoken(User user,String token) throws MailException {
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setTo(user.getUsername());
        mail.setFrom("kiejstutlipka@gmail.com");
        mail.setSubject("Potwierdź adres email oraz aktywuj konto");
        mail.setText("Potwierdź email :"+"http://localhost:8080/emailandaccountveryfication/"+token);
        javaMailSender.send(mail);
    }
    public void sendresetpasswordwithtoken(User user,String token) throws MailException {
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setTo(user.getUsername());
        mail.setFrom("kiejstutlipka@gmail.com");
        mail.setSubject("Zmiana hasła");
        mail.setText("Przejdź do formularza zmiany hasła :"+"http://localhost:8080/changepasswordsend/"+token);
        javaMailSender.send(mail);
    }
}
