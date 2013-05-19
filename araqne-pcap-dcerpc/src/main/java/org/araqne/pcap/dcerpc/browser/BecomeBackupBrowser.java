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
package org.araqne.pcap.dcerpc.browser;

import org.araqne.pcap.netbios.NetBiosNameCodec;
import org.araqne.pcap.dcerpc.rpce.RpcUdpHeader;
import org.araqne.pcap.dcerpc.rpce.packet.UdpPDUInterface;
import org.araqne.pcap.util.Buffer;

public class BecomeBackupBrowser implements UdpPDUInterface {

	byte opcode;
	String browserToPromote;// nullterminate String;

	public byte getOpcode() {
		return opcode;
	}

	public void setOpcode(byte opcode) {
		this.opcode = opcode;
	}

	public String getBrowserToPromote() {
		return browserToPromote;
	}

	public void setBrowserToPromote(String browserToPromote) {
		this.browserToPromote = browserToPromote;
	}

	@Override
	public void parse(Buffer b, RpcUdpHeader h) {
		opcode = b.get();
		browserToPromote = NetBiosNameCodec.readOemName(b);
	}

}
