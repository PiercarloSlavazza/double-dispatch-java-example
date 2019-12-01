package com.java_tutorials.double_dispatch.mailbox.impl;

import com.java_tutorials.double_dispatch.mailbox.DeliveryOutcome;
import com.java_tutorials.double_dispatch.mailbox.MailBox;
import com.java_tutorials.double_dispatch.messages.Message;
import com.java_tutorials.double_dispatch.messages.MessageVisitor;
import com.java_tutorials.double_dispatch.messages.impl.EmailMessage;
import com.java_tutorials.double_dispatch.messages.impl.MobilePushNotification;
import com.java_tutorials.double_dispatch.messages.impl.SMSMessage;

public class MailBoxWithDoubleDispatch implements MailBox, MessageVisitor<DeliveryOutcome> {

    @Override public DeliveryOutcome deliver(Message message) {
	return message.accept(this);
    }

    @Override public DeliveryOutcome visit(SMSMessage smsMessage) {
	return new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.SMS_NUMBER);
    }

    @Override public DeliveryOutcome visit(EmailMessage emailMessage) {
	return new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.EMAIL_ADDRESS);
    }

    @Override public DeliveryOutcome visit(MobilePushNotification mobilePushNotification) {
	return new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.MOBILE_DEVICE);
    }
}
