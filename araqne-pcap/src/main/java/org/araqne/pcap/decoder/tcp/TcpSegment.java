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
package org.araqne.pcap.decoder.tcp;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.araqne.pcap.decoder.ip.IpPacket;
import org.araqne.pcap.util.Buffer;

public interface TcpSegment {
	IpPacket getIpPacket();
	
	boolean isSyn();

	boolean isAck();

	boolean isPsh();
	
	boolean isFin();

	boolean isRst();
	
	boolean isUrg();

	TcpDirection getDirection();

	TcpSessionKey getSessionKey();
	
	InetSocketAddress getSource();
	
	InetSocketAddress getDestination();

	InetAddress getSourceAddress();

	InetAddress getDestinationAddress();

	int getTotalLength();

	int getSourcePort();

	int getDestinationPort();

	int getSeq();

	int getAck();

	int getRelativeSeq();

	int getRelativeAck();

	Buffer getData();
}
