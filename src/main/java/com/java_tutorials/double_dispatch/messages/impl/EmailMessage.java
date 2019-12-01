package com.java_tutorials.double_dispatch.messages.impl;

import com.java_tutorials.double_dispatch.messages.FormattedText;
import com.java_tutorials.double_dispatch.messages.Message;
import com.java_tutorials.double_dispatch.messages.MessageId;
import com.java_tutorials.double_dispatch.messages.MessageVisitor;

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

    @Override public <T> T accept(MessageVisitor<T> visitor) {
	return visitor.visit(this);
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
