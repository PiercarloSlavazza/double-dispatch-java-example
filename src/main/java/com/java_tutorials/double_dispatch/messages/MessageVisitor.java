package com.java_tutorials.double_dispatch.messages;

import com.java_tutorials.double_dispatch.messages.impl.EmailMessage;
import com.java_tutorials.double_dispatch.messages.impl.MobilePushNotification;
import com.java_tutorials.double_dispatch.messages.impl.SMSMessage;

public interface MessageVisitor<T> {

    T visit(SMSMessage smsMessage);
    T visit(EmailMessage emailMessage);
    T visit(MobilePushNotification mobilePushNotification);

}
