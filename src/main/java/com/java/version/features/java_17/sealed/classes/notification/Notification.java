package com.java.version.features.java_17.sealed.classes.notification;

public sealed interface Notification permits EmailNotification, PushNotification, SMSNotification {
}
