/*
 * Copyright  2019 Piercarlo Slavazza
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.java_tutorials.double_dispatch.mailbox.impl;

import com.java_tutorials.double_dispatch.mailbox.DeliveryOutcome;
import com.java_tutorials.double_dispatch.mailbox.MailBox;
import com.java_tutorials.double_dispatch.messages.FormattedText;
import com.java_tutorials.double_dispatch.messages.Message;
import com.java_tutorials.double_dispatch.messages.MessageId;
import com.java_tutorials.double_dispatch.messages.impl.*;
import com.java_tutorials.double_dispatch.messages_queue.MessageQueue;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Ignore
public class MailBoxTest {

    MessageQueue messageQueue;
    MailBox mailBox;

    @Test
    public void shouldDeliverSMSToSMSNumber() {

	when(messageQueue.nextMessage()).thenReturn(new SMSMessage(mock(MessageId.class), mock(FormattedText.class), mock(PhoneNumber.class)));

	Message message = messageQueue.nextMessage();
	DeliveryOutcome actualDeliveryOutcome = mailBox.deliver(message);
	DeliveryOutcomeImpl expectedDeliveryOutcome = new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.PHONE_NUMBER);
	assertEquals(expectedDeliveryOutcome, actualDeliveryOutcome);
    }

    @Test
    public void shouldDeliverEmailToEmailAddress() {

	when(messageQueue.nextMessage()).thenReturn(new EmailMessage(mock(MessageId.class), mock(FormattedText.class), mock(EmailAddress.class)));

	Message message = messageQueue.nextMessage();
	DeliveryOutcome actualDeliveryOutcome = mailBox.deliver(message);
	DeliveryOutcomeImpl expectedDeliveryOutcome = new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.EMAIL_ADDRESS);
	assertEquals(expectedDeliveryOutcome, actualDeliveryOutcome);
    }

    @Test
    public void shouldDeliverPushNotificationToMobileDevice() {

	when(messageQueue.nextMessage()).thenReturn(new MobilePushNotification(mock(MessageId.class), mock(FormattedText.class), mock(MobileDeviceId.class)));

	Message message = messageQueue.nextMessage();
	DeliveryOutcome actualDeliveryOutcome = mailBox.deliver(message);
	DeliveryOutcomeImpl expectedDeliveryOutcome = new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.MOBILE_DEVICE);
	assertEquals(expectedDeliveryOutcome, actualDeliveryOutcome);
    }

}
