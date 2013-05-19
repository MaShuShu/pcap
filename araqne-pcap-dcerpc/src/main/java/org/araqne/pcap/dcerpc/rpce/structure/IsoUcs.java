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

public class IsoUcs {

	private byte group;
	private byte plane;
	private byte row;
	private byte column;

	public void parse(Buffer b) {
		group = b.get();
		plane = b.get();
		row = b.get();
		column = b.get();
	}

	public byte getGroup() {
		return group;
	}

	public void setGroup(byte group) {
		this.group = group;
	}

	public byte getPlane() {
		return plane;
	}

	public void setPlane(byte plane) {
		this.plane = plane;
	}

	public byte getRow() {
		return row;
	}

	public void setRow(byte row) {
		this.row = row;
	}

	public byte getColumn() {
		return column;
	}

	public void setColumn(byte column) {
		this.column = column;
	}
}
