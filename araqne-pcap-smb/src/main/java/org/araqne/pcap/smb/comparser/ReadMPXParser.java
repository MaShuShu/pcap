package org.araqne.pcap.smb.comparser;

import org.araqne.pcap.smb.SmbSession;
import org.araqne.pcap.smb.request.ReadMPXRequest;
import org.araqne.pcap.smb.response.ReadMPXResponse;
import org.araqne.pcap.smb.structure.SmbData;
import org.araqne.pcap.smb.structure.SmbHeader;
import org.araqne.pcap.util.Buffer;
import org.araqne.pcap.util.ByteOrderConverter;

public class ReadMPXParser implements SmbDataParser{
	
	@Override
	public SmbData parseRequest(SmbHeader h,Buffer b , SmbSession session) {
		ReadMPXRequest data = new ReadMPXRequest();
		data.setWordCount(b.get());
		data.setFid(ByteOrderConverter.swap(b.getShort()));
		data.setOffset(ByteOrderConverter.swap(b.getInt()));
		data.setMaxCountOfBytesToReturn(ByteOrderConverter.swap(b.getShort()));
		data.setMinCountOfBytesToReturn(ByteOrderConverter.swap(b.getShort()));
		data.setTimeout(ByteOrderConverter.swap(b.getInt()));
		data.setReserved(ByteOrderConverter.swap(b.getShort()));// it only 0x0000
		data.setByteCount(ByteOrderConverter.swap(b.getShort()));
		return data;
	}
	@Override
	public SmbData parseResponse(SmbHeader h,Buffer b ,SmbSession session) {
		ReadMPXResponse data = new ReadMPXResponse();
		byte []pad; 
		byte []datas;
		data.setWordCount(b.get());
		data.setOffset(ByteOrderConverter.swap(b.getInt()));
		data.setCount(ByteOrderConverter.swap(b.getShort()));
		data.setRemaining(ByteOrderConverter.swap(b.getShort()));
		data.setDataCompactionMode(ByteOrderConverter.swap(b.getShort()));
		data.setReserved(ByteOrderConverter.swap(b.getShort()));
		data.setDataLength(ByteOrderConverter.swap(b.getShort()));
		data.setDataOffset(ByteOrderConverter.swap(b.getShort()));
		data.setByteCount(ByteOrderConverter.swap(b.getShort()));
		if(b.readableBytes() != data.getByteCount()){
			data.setMalformed(true);
			return data;
		}
		pad = new byte[data.getDataOffset()-(32+19)];
		if(pad.length !=0){
		b.gets(pad);
		}
		datas = new byte[data.getDataLength()];
		data.setPad(pad);
		data.setData(datas);
		return data;
	}
}
