package org.araqne.pcap.smb.response;
import org.araqne.pcap.smb.structure.SmbData;

public class WriteRawResponse implements SmbData{

	boolean malformed = false;
	byte wordCount;
	short available;
	short count;
	short byteCount;
	public byte getWordCount() {
		return wordCount;
	}
	public void setWordCount(byte wordCount) {
		this.wordCount = wordCount;
	}
	public short getAvailable() {
		return available;
	}
	public void setAvailable(short available) {
		this.available = available;
	}
	public short getCount() {
		return count;
	}
	public void setCount(short count) {
		this.count = count;
	}
	public short getByteCount() {
		return byteCount;
	}
	public void setByteCount(short byteCount) {
		this.byteCount = byteCount;
	}
	@Override
	public boolean isMalformed() {
		// TODO Auto-generated method stub
		return malformed;
	}
	@Override
	public void setMalformed(boolean malformed) {
		this.malformed = malformed;
	}
	@Override
	public String toString(){
		return String.format("First Level : Write Raw Response\n" +
				"isMalformed = %s\n" +
				"wordCount = 0x%s\n" +
				"available = 0x%s , count = 0x%s\n" +
				"byteCount = 0x%s\n",
				this.malformed,
				Integer.toHexString(this.wordCount),
				Integer.toHexString(this.available) , Integer.toHexString(this.count),
				Integer.toHexString(this.byteCount));
	}
}
