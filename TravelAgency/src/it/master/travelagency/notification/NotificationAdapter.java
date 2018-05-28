package it.master.travelagency.notification;

/**
 * The <strong>Target Interface</strong> used by the Adapter pattern that handles
 * notification distribution.
 *
 */
public interface NotificationAdapter {
    void notify(String message);
}
