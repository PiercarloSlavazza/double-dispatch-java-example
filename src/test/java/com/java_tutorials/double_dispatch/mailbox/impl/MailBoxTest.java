package com.java_tutorials.double_dispatch.mailbox.impl;

import com.java_tutorials.double_dispatch.mailbox.DeliveryOutcome;
import com.java_tutorials.double_dispatch.mailbox.MailBox;
import com.java_tutorials.double_dispatch.messages.Message;
import com.java_tutorials.double_dispatch.messages.impl.EmailMessage;
import com.java_tutorials.double_dispatch.messages.impl.SMSMessage;
import com.java_tutorials.double_dispatch.messages_queue.MessageQueue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MailBoxTest {

    MessageQueue messageQueue;
    MailBox mailBox;

    @Test
    public void shouldDeliverSMSToAnSMSNumber() {

	when(messageQueue.nextMessage()).thenReturn(mock(SMSMessage.class));

	Message message = messageQueue.nextMessage();
	DeliveryOutcome actualDeliveryOutcome = mailBox.deliver(message);
	DeliveryOutcomeImpl expectedDeliveryOutcome = new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.SMS_NUMBER);
	assertEquals(expectedDeliveryOutcome, actualDeliveryOutcome);
    }

    @Test
    public void shouldDeliverEmailToAnEmailAddress() {

	when(messageQueue.nextMessage()).thenReturn(mock(EmailMessage.class));

	Message message = messageQueue.nextMessage();
	DeliveryOutcome actualDeliveryOutcome = mailBox.deliver(message);
	DeliveryOutcomeImpl expectedDeliveryOutcome = new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.EMAIL_ADDRESS);
	assertEquals(expectedDeliveryOutcome, actualDeliveryOutcome);
    }

}
