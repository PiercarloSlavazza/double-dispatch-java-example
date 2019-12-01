package com.java_tutorials.double_dispatch.mailbox.impl;

import com.java_tutorials.double_dispatch.messages_queue.MessageQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MailBoxWithDoubleDispatchTest extends MailBoxTest {

    @Before
    public void setUp() {
        messageQueue = mock(MessageQueue.class);
        mailBox = new MailBoxWithoutDoubleDispatchAntiPattern();
    }
}
