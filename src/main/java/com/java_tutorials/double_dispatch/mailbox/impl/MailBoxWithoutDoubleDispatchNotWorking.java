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
import com.java_tutorials.double_dispatch.messages.Message;
import com.java_tutorials.double_dispatch.messages.impl.EmailMessage;
import com.java_tutorials.double_dispatch.messages.impl.SMSMessage;

@SuppressWarnings("unused") public class MailBoxWithoutDoubleDispatchNotWorking implements MailBox {

    @Override public DeliveryOutcome deliver(Message message) {
	return null;
    }

    public DeliveryOutcome deliver(SMSMessage smsMessage) {
	return new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.PHONE_NUMBER);
    }

    public DeliveryOutcome deliver(EmailMessage emailMessage) {
	return new DeliveryOutcomeImpl(DeliveryOutcome.Recipient.EMAIL_ADDRESS);
    }
}
