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
