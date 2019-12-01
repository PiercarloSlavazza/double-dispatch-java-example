package com.java_tutorials.double_dispatch.mailbox;

import com.java_tutorials.double_dispatch.messages.Message;

public interface MailBox {

    DeliveryOutcome deliver(Message message);

}
