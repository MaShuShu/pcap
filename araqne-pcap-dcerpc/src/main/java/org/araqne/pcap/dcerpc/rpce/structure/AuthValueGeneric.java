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
package org.araqne.pcap.dcerpc.rpce.structure;

import org.araqne.pcap.util.Buffer;
import org.araqne.pcap.util.ByteOrderConverter;

public class AuthValueGeneric implements AuthValue {

	private int assocUuidCrc;
	private byte subType;
	private byte checksumLength;
	private short credLength;
	private byte[] credentials;
	private byte[] checksum;

	public int getAssocUuidCrc() {
		return assocUuidCrc;
	}

	public void setAssocUuidCrc(int assocUuidCrc) {
		this.assocUuidCrc = assocUuidCrc;
	}

	public byte getSubType() {
		return subType;
	}

	public void setSubType(byte subType) {
		this.subType = subType;
	}

	public byte getChecksumLength() {
		return checksumLength;
	}

	public void setChecksumLength(byte checksumLength) {
		this.checksumLength = checksumLength;
	}

	public short getCredLength() {
		return credLength;
	}

	public void setCredLength(short credLength) {
		this.credLength = credLength;
	}

	public byte[] getCredentials() {
		return credentials;
	}

	public void setCredentials(byte[] credentials) {
		this.credentials = credentials;
	}

	public byte[] getChecksum() {
		return checksum;
	}

	public void setChecksum(byte[] checksum) {
		this.checksum = checksum;
	}

	@Override
	public void parse(Buffer b) {
		assocUuidCrc = ByteOrderConverter.swap(b.getInt());
		subType = b.get();
		checksumLength = b.get();
		credLength = ByteOrderConverter.swap(b.getShort());
		credentials = new byte[credLength];
		checksum = new byte[checksumLength];
		b.gets(credentials);
		b.gets(checksum);
	}

}
