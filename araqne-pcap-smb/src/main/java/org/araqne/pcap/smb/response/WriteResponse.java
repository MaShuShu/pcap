package org.araqne.pcap.smb.response;
import org.araqne.pcap.smb.structure.SmbData;
// 0x0B
public class WriteResponse implements SmbData{

	boolean malformed = false;
	byte wordCount; // 
	short countOfBytesWritten;
	short byteCount; // 
	public byte getWordCount() {
		return wordCount;
	}
	public void setWordCount(byte wordCount) {
		this.wordCount = wordCount;
	}
	public short getCountOfBytesWritten() {
		return countOfBytesWritten;
	}
	public void setCountOfBytesWritten(short countOfBytesWritten) {
		this.countOfBytesWritten = countOfBytesWritten;
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
		return String.format("First Level : Write Response \n" +
				"isMalformed =%s\n" +
				"wordCount = 0x%s\n" +
				"countofBytesWritten = 0x%s\n" +
				"byteCount = 0x%s\n",
				this.malformed,
				Integer.toHexString(this.wordCount),
				Integer.toHexString(this.countOfBytesWritten),
				Integer.toHexString(this.byteCount));
	}
}
