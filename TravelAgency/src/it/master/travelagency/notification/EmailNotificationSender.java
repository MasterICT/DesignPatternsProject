package it.master.travelagency.notification;

import it.master.travelagency.notification.email.EmailSender;

public class EmailNotificationSender implements NotificationAdapter {

    protected String email;
    protected EmailSender emailSender;

    public EmailNotificationSender(String email) {
        this.email = email;
        this.emailSender = new EmailSender();
    }

    @Override
    public void notify(String message) {
        this.emailSender.sendEmail(this.email, "Notification from TravelAgency", message);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
