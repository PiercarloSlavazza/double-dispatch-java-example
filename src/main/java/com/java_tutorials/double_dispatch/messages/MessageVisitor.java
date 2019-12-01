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

package com.java_tutorials.double_dispatch.messages;

import com.java_tutorials.double_dispatch.messages.impl.EmailMessage;
import com.java_tutorials.double_dispatch.messages.impl.MobilePushNotification;
import com.java_tutorials.double_dispatch.messages.impl.SMSMessage;

public interface MessageVisitor<T> {

    T visit(SMSMessage smsMessage);
    T visit(EmailMessage emailMessage);
    T visit(MobilePushNotification mobilePushNotification);

}
