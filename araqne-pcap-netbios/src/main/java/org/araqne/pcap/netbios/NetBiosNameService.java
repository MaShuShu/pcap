/*
 * Copyright 2011 Future Systems, Inc
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
package org.araqne.pcap.netbios;

import org.araqne.pcap.util.Buffer;

public class NetBiosNameService {
	public NetBiosNamePacket parse(Buffer b) {
		NetBiosNameHeader header = NetBiosNameHeader.parse(b);
		NetBiosNameData data = NetBiosNameData.parse(header, b);
		return new NetBiosNamePacket(header, data);
	}
}
