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

import org.araqne.pcap.dcerpc.browser.AnnounceRequestBrowser;
import org.araqne.pcap.dcerpc.browser.BecomeBackupBrowser;
import org.araqne.pcap.dcerpc.browser.DomainAnnouncementBrowser;
import org.araqne.pcap.dcerpc.browser.ElectionBrowserRequest;
import org.araqne.pcap.dcerpc.browser.GetBackupListRequest;
import org.araqne.pcap.dcerpc.browser.GetBackupListResponse;
import org.araqne.pcap.dcerpc.browser.HostAnnounceBrowser;
import org.araqne.pcap.dcerpc.browser.LocalMasterAnnouncementBrowser;
import org.araqne.pcap.dcerpc.browser.MasterAnnouncementBrowser;
import org.araqne.pcap.dcerpc.browser.ResetstateRequestBrowser;
import org.araqne.pcap.dcerpc.rpce.packet.UdpPDUInterface;
import org.araqne.pcap.dcerpc.rpce.rr.BrowserType;
import org.araqne.pcap.dcerpc.rpce.tcppacket.association.TcpPDUInterface;
import org.araqne.pcap.smb.SmbProcessor;
import org.araqne.pcap.util.Buffer;
import org.araqne.pcap.util.ByteOrderConverter;

public class RpcDecoder implements SmbProcessor{

	@Override
	public void processUdp(Buffer b) {
		RpcUdpPacket udpP = new RpcUdpPacket();
		RpcUdpHeader header = new RpcUdpHeader(); // header
		UdpPacketTypeMapper mapper = new UdpPacketTypeMapper();  
		UdpPDUInterface data; // data
		header.parse(b);
		udpP.setHeader(header);
		data = mapper.getPDU(udpP.getHeader().getpType());
		data.parse(b , header);
		udpP.setData(data);	
		//System.out.println(udpP);
		// add browser protocol
	}

	@Override
	public void processTcpRx(Buffer b) {
		RpcTcpPacket tcpP = new RpcTcpPacket();
		RpcTcpHeader header = new RpcTcpHeader();
		TcpPacketTypeMapper mapper = new TcpPacketTypeMapper();
		TcpPDUInterface data;
		header.parse(b);
		tcpP.setHeader(header);
		data = mapper.getPDU(tcpP.getHeader().getPtype());
		data.parse(b , header);
		tcpP.setData(data);
		//System.out.println(tcpP);
	}

	@Override
	public void processTcpTx(Buffer b) {
		RpcTcpPacket tcpP = new RpcTcpPacket();
		RpcTcpHeader header = new RpcTcpHeader();
		TcpPacketTypeMapper mapper = new TcpPacketTypeMapper();
		TcpPDUInterface data;
		header.parse(b);
		tcpP.setHeader(header);
		//System.out.println(tcpP.getHeader().getPtype());
		data = mapper.getPDU(tcpP.getHeader().getPtype());
		data.parse(b , header);
		tcpP.setData(data);
		//System.out.println(tcpP);
	}

	@Override
	public void processMailslot(Buffer b) {
		RpcUdpPacket udpP = new RpcUdpPacket();
		RpcUdpHeader header = null;
		UdpPDUInterface data; // data
		BrowserType opCode;
		b.mark();
		opCode = BrowserType.parse(ByteOrderConverter.swap(b.getShort()) & 0xffff);
		b.reset();
		switch(opCode){
			case HostAnnouncement:
				data = new HostAnnounceBrowser();
				data.parse(b, header);
				break;
			case AnnouncementRequest:
				data = new AnnounceRequestBrowser();
				data.parse(b, header);
				break;
			case RequestElection:
				data = new ElectionBrowserRequest();
				data.parse(b, header);
				break;
			case GetBackupListRequest:
				data = new GetBackupListRequest();
				data.parse(b, header);
				break;
			case GetBackupListResponse:
				data = new GetBackupListResponse();
				data.parse(b, header);
				break;
			case BecomeBackup:
				data = new BecomeBackupBrowser();
				data.parse(b, header);
				break;
			case DomainAnnouncement:
				data = new DomainAnnouncementBrowser();
				data.parse(b, header);
				break;
			case MasterAnnouncement:
				data = new MasterAnnouncementBrowser();
				data.parse(b, header);
				break;
			case ResetStateRequest:
				data = new ResetstateRequestBrowser();
				data.parse(b, header);
				break;
			case LocalMasterAnnouncement:
				data = new LocalMasterAnnouncementBrowser();
				data.parse(b, header);
				break;
			default:
				throw new IllegalArgumentException();
		}
		udpP.setHeader(header);
		udpP.setData(data);
		//System.out.println(udpP.getData());
	}
}
