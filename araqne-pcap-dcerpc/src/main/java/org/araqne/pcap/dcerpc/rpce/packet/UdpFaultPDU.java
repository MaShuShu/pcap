/*
 * Copyright 2011 Future Systems
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
package org.araqne.pcap.dcerpc.rpce.packet;

import org.araqne.pcap.dcerpc.rpce.RpcUdpHeader;
import org.araqne.pcap.util.Buffer;
import org.araqne.pcap.util.ByteOrderConverter;

public class UdpFaultPDU implements UdpPDUInterface{

	private int st; // status

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

	@Override
	public void parse(Buffer b, RpcUdpHeader h) {
		st = ByteOrderConverter.swap(b.getInt());
	}
	
}
