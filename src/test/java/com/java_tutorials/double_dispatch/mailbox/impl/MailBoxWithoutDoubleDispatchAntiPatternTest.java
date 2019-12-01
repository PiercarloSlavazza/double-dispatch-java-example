package com.java_tutorials.double_dispatch.mailbox.impl;

import com.java_tutorials.double_dispatch.mailbox.DeliveryOutcome;
import com.java_tutorials.double_dispatch.mailbox.MailBox;
import com.java_tutorials.double_dispatch.messages.Message;
import com.java_tutorials.double_dispatch.messages.impl.SMSMessage;
import com.java_tutorials.double_dispatch.messages_queue.MessageQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MailBoxWithoutDoubleDispatchAntiPatternTest extends MailBoxTest {

    @Before
    public void setUp() {
        messageQueue = mock(MessageQueue.class);
        mailBox = new MailBoxWithoutDoubleDispatchAntiPattern();
    }

}
