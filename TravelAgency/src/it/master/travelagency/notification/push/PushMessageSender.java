package it.master.travelagency.notification.push;

/**
 * The <strong>Adaptee</strong> implementation that handles sending push notifications
 *
 */
public class PushMessageSender {

    public void pushMessage(PushMessageIcon icon, String message) {
        // send the push message, please
        System.out.println(getEmojiFromIcon(icon) + ": " + message);
    }

    protected String getEmojiFromIcon(PushMessageIcon icon) {
        switch(icon) {
            case INFO:
            default:
                return "ℹ️";
            case ALARM:
                return "⏰";
            case DANGER:
                return "☠️";
        }
    }
}


