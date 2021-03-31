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

import java.util.Objects;

public class EmailMessage implements Message {

    private final MessageId messageId;
    private final FormattedText formattedText;
    private final EmailAddress emailAddress;

    public EmailMessage(MessageId messageId, FormattedText formattedText, EmailAddress emailAddress) {
	this.messageId = messageId;
	this.formattedText = formattedText;
	this.emailAddress = emailAddress;
    }

    public EmailAddress getEmailAddress() {
	return emailAddress;
    }

    @Override public FormattedText getFormattedText() {
	return null;
    }

    @Override public MessageId getMessageId() {
	return null;
    }

    @Override public String toString() {
	return "EmailMessage{" +
			"messageId=" + messageId +
			", formattedText=" + formattedText +
			", emailAddress=" + emailAddress +
			'}';
    }

    @Override public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (!(o instanceof EmailMessage))
	    return false;
	EmailMessage that = (EmailMessage) o;
	return Objects.equals(messageId, that.messageId) &&
			Objects.equals(formattedText, that.formattedText) &&
			Objects.equals(emailAddress, that.emailAddress);
    }

    @Override public int hashCode() {
	return Objects.hash(messageId, formattedText, emailAddress);
    }
}
