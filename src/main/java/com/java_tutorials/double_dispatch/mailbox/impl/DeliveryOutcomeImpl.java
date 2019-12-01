package com.java_tutorials.double_dispatch.mailbox.impl;

import com.java_tutorials.double_dispatch.mailbox.DeliveryOutcome;

import java.util.Objects;

public class DeliveryOutcomeImpl implements DeliveryOutcome {

    private final DeliveryOutcome.Recipient recipient;

    DeliveryOutcomeImpl(DeliveryOutcome.Recipient recipient) {
	this.recipient = recipient;
    }

    public DeliveryOutcome.Recipient getRecipient() {
	return recipient;
    }

    @Override public String toString() {
	return "DeliveryOutcomeImpl{" +
			"recipient=" + recipient +
			'}';
    }

    @Override public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (!(o instanceof DeliveryOutcomeImpl))
	    return false;
	DeliveryOutcomeImpl that = (DeliveryOutcomeImpl) o;
	return recipient == that.recipient;
    }

    @Override public int hashCode() {
	return Objects.hash(recipient);
    }
}
