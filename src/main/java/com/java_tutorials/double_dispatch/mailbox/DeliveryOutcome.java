package com.java_tutorials.double_dispatch.mailbox;

public interface DeliveryOutcome {

    enum Recipient {
        PHONE_NUMBER, EMAIL_ADDRESS, MOBILE_DEVICE
    }

    Recipient getRecipient();
}
