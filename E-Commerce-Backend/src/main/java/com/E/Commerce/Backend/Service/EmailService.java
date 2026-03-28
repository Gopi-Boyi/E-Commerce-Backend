package com.E.Commerce.Backend.Service;

import com.E.Commerce.Backend.Model.Order;

import com.E.Commerce.Backend.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService
{

    private final JavaMailSender mailSender;

    @Value("{spring.mail.username}")
    private String fromEmail;

    public void sendOrderConfirmation(Order order){

        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(order.getUser().getEmail());
        message.setSubject("Order Confirmation");
        message.setText("Your Order has been confirmed. Order Id :" + order.getId());
        mailSender.send(message);
    }
    public void sendConfirmationCode(User user){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(user.getEmail());
        message.setSubject("Confirm your email");
        message.setText("Please Confirm your email by entering the code" + user.getConfirmationCode());
        mailSender.send(message);
    }
}
