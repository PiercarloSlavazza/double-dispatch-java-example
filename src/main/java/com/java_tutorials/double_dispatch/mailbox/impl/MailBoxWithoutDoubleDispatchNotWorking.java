package com.java_tutorials.double_dispatch.mailbox.impl;

import com.java_tutorials.double_dispatch.mailbox.DeliveryOutcome;
import com.java_tutorials.double_dispatch.mailbox.MailBox;
import com.java_tutorials.double_dispatch.messages.Message;
import com.java_tutorials.double_dispatch.messages.MessageVisitor;
import com.java_tutorials.double_dispatch.messages.impl.EmailMessage;
import com.java_tutorials.double_dispatch.messages.impl.SMSMessage;

public class MailBoxWithoutDoubleDispatchNotWorking implements MailBox {

    @Override public DeliveryOutcome deliver(Message message) {
	return null;
    }

    private DeliveryOutcome deliver(SMSMessage smsMessage) {
	return new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.SMS_NUMBER);
    }

    private DeliveryOutcome deliver(EmailMessage emailMessage) {
	return new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.EMAIL_ADDRESS);
    }
}
