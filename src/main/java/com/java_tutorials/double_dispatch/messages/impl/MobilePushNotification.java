/*
 * Copyright  2019 Piercarlo Slavazza
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.java_tutorials.double_dispatch.messages.impl;

import com.java_tutorials.double_dispatch.messages.FormattedText;
import com.java_tutorials.double_dispatch.messages.Message;
import com.java_tutorials.double_dispatch.messages.MessageId;

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
