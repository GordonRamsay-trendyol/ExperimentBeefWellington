package com.trendx.notification.user.model;

public class Notification {
    private User to;
    private String title;
    private String message;

    private Notification() {
    }

    public static Notification from(User user, ProductPriceChangeMessage message) {
        Notification notification = new Notification();
        notification.to = user;
        notification.title = "Trendx product update notification";
        notification.message = "Hello the product " + message.getTitle() + " you were following is updated. " +
                "I hope it is ok for you !!! " +
                "Click the link to navigate to the product, \n" + message.getUrl();
        return notification;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public User getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
