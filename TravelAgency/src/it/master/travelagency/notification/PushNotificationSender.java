package it.master.travelagency.notification;

import it.master.travelagency.notification.push.PushMessageIcon;
import it.master.travelagency.notification.push.PushMessageSender;

/**
 * The <strong>Adapter</strong> used to send push notifications. It wraps
 * an {@link PushMessageSender} object.
 *
 */
public class PushNotificationSender implements NotificationAdapter {

    protected PushMessageSender pushMessageSender;

    public PushNotificationSender() {
        this.pushMessageSender = new PushMessageSender();
    }

    @Override
    public void notify(String message) {
        this.pushMessageSender.pushMessage(PushMessageIcon.INFO, message);
    }
}
