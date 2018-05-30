package it.master.travelagency.notification.email;

/**
 * The <strong>Adaptee</strong> implementation that handles sending e-mails
 */
public class EmailSender {

    public void sendEmail(String emailAddress, String subject, String message) {
       // send an e-mail please
        System.out.printf("📧 to %s, subject: %s, message: %s\n", emailAddress, subject, message);
    }
}