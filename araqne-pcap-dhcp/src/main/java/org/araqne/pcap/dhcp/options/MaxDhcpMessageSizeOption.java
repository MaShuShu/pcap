/*
 * Copyright 2010 NCHOVY
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.araqne.pcap.dhcp.options;

import org.araqne.pcap.util.ByteArrayParser;

public class MaxDhcpMessageSizeOption extends RawDhcpOption {
	public MaxDhcpMessageSizeOption(byte type, int length, byte[] value) {
		super(type, length, value);
	}

	public int getMaxSize() {
		byte[] b = getValue();
		short s = ByteArrayParser.getShort(b, 0);
		return (int) s & 0xFFFF;
	}

	@Override
	public String toString() {
		return "Maximum DHCP Message Size = " + getMaxSize();
	}
}
