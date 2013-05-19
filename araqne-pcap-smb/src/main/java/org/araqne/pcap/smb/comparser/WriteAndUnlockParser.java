package org.araqne.pcap.smb.comparser;
import org.araqne.pcap.smb.SmbSession;
import org.araqne.pcap.smb.request.WriteAndUnlockRequest;
import org.araqne.pcap.smb.response.WriteAndUnlockResponse;
import org.araqne.pcap.smb.structure.SmbData;
import org.araqne.pcap.smb.structure.SmbHeader;
import org.araqne.pcap.util.Buffer;
import org.araqne.pcap.util.ByteOrderConverter;
//0x14
public class WriteAndUnlockParser implements SmbDataParser{
	@Override
	public SmbData parseRequest(SmbHeader h , Buffer b , SmbSession session) {
		WriteAndUnlockRequest data = new WriteAndUnlockRequest();
		byte []datas;
		data.setWordCount(b.get());
		if(data.getWordCount() == 0x05){
			data.setFid(ByteOrderConverter.swap(b.getShort()));
			data.setCountOfBytesToWrite(ByteOrderConverter.swap(b.getShort()));
			data.setWriteOffsetInBytes(ByteOrderConverter.swap(b.getShort()));
			data.setEstimateOfRemainingBytesToBeWritten(ByteOrderConverter.swap(b.getShort()));
		}
		data.setByteCount(ByteOrderConverter.swap(b.getShort()));
		if(b.readableBytes() != data.getByteCount()){
			data.setMalformed(true);
			return data;
		}
		data.setBufferFormat(b.get());
		data.setDataLength(ByteOrderConverter.swap(b.getShort()));
		datas = new byte[data.getDataLength()];
		b.gets(datas);
		data.setData(datas);
		return data;
	}
	@Override
	public SmbData parseResponse(SmbHeader h , Buffer b ,SmbSession session){
		WriteAndUnlockResponse data = new WriteAndUnlockResponse();
		data.setWordCount(b.get());
		if(data.getWordCount() == 0x01){
			data.setCountOfBytesWritten(ByteOrderConverter.swap(b.getShort()));
		}
		data.setByteCount(ByteOrderConverter.swap(b.getShort()));
		return data;
	}
}
