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
