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

package com.java_tutorials.double_dispatch.messages.impl;

import com.java_tutorials.double_dispatch.messages.FormattedText;
import com.java_tutorials.double_dispatch.messages.Message;
import com.java_tutorials.double_dispatch.messages.MessageId;
import com.java_tutorials.double_dispatch.messages.MessageVisitor;

import java.util.Objects;

public class SMSMessage implements Message {

    private final MessageId messageId;
    private final FormattedText formattedText;
    private final PhoneNumber phoneNumber;

    public SMSMessage(MessageId messageId, FormattedText formattedText, PhoneNumber phoneNumber) {
	this.messageId = messageId;
	this.formattedText = formattedText;
	this.phoneNumber = phoneNumber;
    }

    public PhoneNumber getPhoneNumber() {
	return phoneNumber;
    }

    @Override public FormattedText getFormattedText() {
	return null;
    }

    @Override public MessageId getMessageId() {
	return null;
    }

    @Override public <T> T accept(MessageVisitor<T> visitor) {
	return visitor.visit(this);
    }

    @Override public String toString() {
	return "SMSMessage{" +
			"messageId=" + messageId +
			", formattedText=" + formattedText +
			", phoneNumber=" + phoneNumber +
			'}';
    }

    @Override public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (!(o instanceof SMSMessage))
	    return false;
	SMSMessage that = (SMSMessage) o;
	return Objects.equals(messageId, that.messageId) &&
			Objects.equals(formattedText, that.formattedText) &&
			Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override public int hashCode() {
	return Objects.hash(messageId, formattedText, phoneNumber);
    }
}
