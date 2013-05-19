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
import org.araqne.pcap.dcerpc.rpce.structure.AuthVerifierCo;
import org.araqne.pcap.util.Buffer;
import org.araqne.pcap.util.ByteOrderConverter;

public class UdpResponse implements UdpPDUInterface {

	private int allocHint;
	private short pContId;
	private byte cancelCount;
	private byte reserved;
	private AuthVerifierCo authVerifier;

	public UdpResponse() {
		authVerifier = new AuthVerifierCo();
	}

	@Override
	public void parse(Buffer b , RpcUdpHeader h) {
		allocHint = ByteOrderConverter.swap(b.getInt());
		pContId = ByteOrderConverter.swap(b.getShort());
		cancelCount = b.get();
		reserved = b.get();
		authVerifier.parse(b);
	}

	public int getAllocHint() {
		return allocHint;
	}

	public void setAllocHint(int allocHint) {
		this.allocHint = allocHint;
	}

	public short getpContId() {
		return pContId;
	}

	public void setpContId(short pContId) {
		this.pContId = pContId;
	}

	public byte getCancelCount() {
		return cancelCount;
	}

	public void setCancelCount(byte cancelCount) {
		this.cancelCount = cancelCount;
	}

	public byte getReserved() {
		return reserved;
	}

	public void setReserved(byte reserved) {
		this.reserved = reserved;
	}

	public AuthVerifierCo getAuthVerifier() {
		return authVerifier;
	}

	public void setAuthVerifier(AuthVerifierCo authVerifier) {
		this.authVerifier = authVerifier;
	}

}
