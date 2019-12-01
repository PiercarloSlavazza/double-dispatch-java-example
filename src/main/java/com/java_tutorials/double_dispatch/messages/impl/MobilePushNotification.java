package com.java_tutorials.double_dispatch.messages.impl;

import com.java_tutorials.double_dispatch.messages.FormattedText;
import com.java_tutorials.double_dispatch.messages.Message;
import com.java_tutorials.double_dispatch.messages.MessageId;
import com.java_tutorials.double_dispatch.messages.MessageVisitor;

import java.util.Objects;

public class MobilePushNotification implements Message {

    private final MessageId messageId;
    private final FormattedText formattedText;
    private final MobileDeviceId mobileDeviceId;

    public MobilePushNotification(MessageId messageId, FormattedText formattedText,
				  MobileDeviceId mobileDeviceId) {
	this.messageId = messageId;
	this.formattedText = formattedText;
	this.mobileDeviceId = mobileDeviceId;
    }

    public MobileDeviceId getMobileDeviceId() {
	return mobileDeviceId;
    }

    @Override public FormattedText getFormattedText() {
	return formattedText;
    }

    @Override public MessageId getMessageId() {
	return messageId;
    }

    @Override public <T> T accept(MessageVisitor<T> visitor) {
	return visitor.visit(this);
    }

    @Override public String toString() {
	return "MobilePushNotification{" +
			"messageId=" + messageId +
			", formattedText=" + formattedText +
			", mobileDeviceId=" + mobileDeviceId +
			'}';
    }

    @Override public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (!(o instanceof MobilePushNotification))
	    return false;
	MobilePushNotification that = (MobilePushNotification) o;
	return Objects.equals(messageId, that.messageId) &&
			Objects.equals(formattedText, that.formattedText) &&
			Objects.equals(mobileDeviceId, that.mobileDeviceId);
    }

    @Override public int hashCode() {
	return Objects.hash(messageId, formattedText, mobileDeviceId);
    }
}
