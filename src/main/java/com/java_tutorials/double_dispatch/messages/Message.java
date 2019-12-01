package com.java_tutorials.double_dispatch.messages;

public interface Message {

    FormattedText getFormattedText();
    MessageId getMessageId();
    <T> T accept(MessageVisitor<T> visitor);

}
