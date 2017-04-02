package com.crossover.techtrial.java.se.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.crossover.techtrial.java.se.dtos.BuyTicketsRequest;
import com.crossover.techtrial.java.se.entities.Order;

public class SendMail {

	public static boolean sendOrderMail(Order order) {

		final String username = "taher.hassan.233@gmail.com";
		final String password = "pass_t#12";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("taher.hassan.233@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(order.getUser().getEmail()));
			message.setSubject("Ticket Details");
			message.setText("From: " + order.getRoute().getfrom() + " \nTo: "
					+ order.getRoute().getto() + " \n Amount: "
					+ order.getAmount() + " \n Price: "
					+ order.getPrice().getAmount() + " "
					+ order.getPrice().getCurrency()
					+ " \n Reserved For User: " + order.getUser().getEmail());

			Transport.send(message);

			return true;
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
