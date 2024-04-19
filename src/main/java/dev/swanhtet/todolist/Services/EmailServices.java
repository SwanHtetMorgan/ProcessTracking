package dev.swanhtet.todolist.Services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServices {
  @Autowired private JavaMailSender javaMailSender;

  public void MailSendingFunction(String destinationAddress, String Subject, String Content) {
    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);

    try {
      helper.setTo(destinationAddress);
      helper.setSubject(Subject);
      helper.setText(Content);
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
    javaMailSender.send(message);
  }
}
