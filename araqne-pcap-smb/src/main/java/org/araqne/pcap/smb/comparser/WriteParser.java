package org.araqne.pcap.smb.comparser;
import org.araqne.pcap.smb.SmbSession;
import org.araqne.pcap.smb.request.WriteRequest;
import org.araqne.pcap.smb.response.WriteResponse;
import org.araqne.pcap.smb.structure.SmbData;
import org.araqne.pcap.smb.structure.SmbHeader;
import org.araqne.pcap.util.Buffer;
import org.araqne.pcap.util.ByteOrderConverter;
// 0x0B
public class WriteParser implements SmbDataParser{

	@Override
	public SmbData parseRequest(SmbHeader h , Buffer b , SmbSession session) {
		WriteRequest data = new WriteRequest();
		byte []bytes;
		data.setWordCount(b.get());
		if(data.getWordCount() == 0x05){
			data.setFid(ByteOrderConverter.swap(b.getShort()));
			data.setCountOfBytesToWrtie(ByteOrderConverter.swap(b.getShort()));
			data.setWriteoffsetInBytes(ByteOrderConverter.swap(b.getInt()));
			data.setEstimateofRemainingBytesToBeWritten(ByteOrderConverter.swap(b.getShort()));
		}
		else{
			data.setMalformed(true);
		}
		data.setByteCount(ByteOrderConverter.swap(b.getShort()));
		if(b.readableBytes() != data.getByteCount()){
			data.setMalformed(true);
			return data;
		}
		else if(b.readableBytes() ==0){
			data.setMalformed(true);
			return data;
		}
		data.setBufferFormat(b.get());
		data.setDatalength(ByteOrderConverter.swap(b.getShort()));
		bytes = new byte[data.getCountOfBytesToWrtie()];
		b.gets(bytes);
		data.setData(bytes);
		return data;
	}
	@Override
	public SmbData parseResponse(SmbHeader h , Buffer b ,SmbSession session) {
		WriteResponse data = new WriteResponse();
		data.setWordCount(b.get());
		if(data.getWordCount() == 0x01){
			data.setCountOfBytesWritten(ByteOrderConverter.swap(b.getShort()));
		}
		else{
			data.setMalformed(true);
		}
		data.setByteCount(ByteOrderConverter.swap(b.getShort()));
		return data;
	}
}
