package com.java_tutorials.double_dispatch.mailbox;

public interface DeliveryOutcome {

    enum Recipient {
        SMS_NUMBER, EMAIL_ADDRESS
    }

    Recipient getRecipient();
}
