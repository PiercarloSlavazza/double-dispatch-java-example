package com.java_tutorials.double_dispatch.mailbox.impl;

import com.java_tutorials.double_dispatch.mailbox.DeliveryOutcome;
import com.java_tutorials.double_dispatch.mailbox.MailBox;
import com.java_tutorials.double_dispatch.messages.Message;
import com.java_tutorials.double_dispatch.messages.impl.EmailMessage;
import com.java_tutorials.double_dispatch.messages.impl.SMSMessage;

public class MailBoxWithoutDoubleDispatchAntiPattern implements MailBox {

    @Override public DeliveryOutcome deliver(Message message) {
        if (message instanceof SMSMessage) return deliver((SMSMessage)message);
	if (message instanceof EmailMessage) return deliver((EmailMessage) message);
	throw new RuntimeException("unknown message type|" + message.getClass().getName());
    }

    private DeliveryOutcome deliver(SMSMessage smsMessage) {
	return new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.SMS_NUMBER);
    }

    private DeliveryOutcome deliver(EmailMessage emailMessage) {
	return new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.EMAIL_ADDRESS);
    }
}
