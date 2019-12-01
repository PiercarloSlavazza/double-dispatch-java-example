package com.java_tutorials.double_dispatch.messages_queue;

import com.java_tutorials.double_dispatch.messages.Message;

public interface MessageQueue {

    Message nextMessage();

}
