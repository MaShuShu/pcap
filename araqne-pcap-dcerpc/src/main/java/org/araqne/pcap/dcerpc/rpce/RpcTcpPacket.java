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
package org.araqne.pcap.dcerpc.rpce;

import org.araqne.pcap.dcerpc.rpce.tcppacket.association.TcpPDUInterface;

public class RpcTcpPacket {

	private RpcTcpHeader header;
	private TcpPDUInterface data;
	public RpcTcpPacket() {
	}
	public RpcTcpHeader getHeader() {
		return header;
	}
	public void setHeader(RpcTcpHeader header) {
		this.header = header;
	}
	public TcpPDUInterface getData() {
		return data;
	}
	public void setData(TcpPDUInterface data2) {
		this.data = data2;
	}
	@Override
	public String toString() {
		
		return new String(header.toString()+data.toString());
	}
	
}
