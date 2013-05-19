package org.araqne.pcap.smb.request;

import org.araqne.pcap.smb.rr.FileAttributes;
import org.araqne.pcap.smb.structure.SmbData;

public class CreateRequest implements SmbData{
	boolean malformed = false;
	byte wordCount;
	FileAttributes fileattr;
	int createTime;
	short byteCount;
	byte bufferFormat;
	String fileName;
	public byte getWordCount() {
		return wordCount;
	}
	public void setWordCount(byte wordCount) {
		this.wordCount = wordCount;
	}
	public FileAttributes getFileattr() {
		return fileattr;
	}
	public void setFileattr(FileAttributes fileattr) {
		this.fileattr = fileattr;
	}
	public int getCreateTime() {
		return createTime;
	}
	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
	public short getByteCount() {
		return byteCount;
	}
	public void setByteCount(short byteCount) {
		this.byteCount = byteCount;
	}
	public byte getBufferFormat() {
		return bufferFormat;
	}
	public void setBufferFormat(byte bufferFormat) {
		this.bufferFormat = bufferFormat;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
		return String.format("First Level : CreateRequest\n" +
				"isMalformed = %s\n" +
				"wordCount = 0x%s\n" +
				"fileattribute = %s , createTime = 0x%s\n" +
				"byteCount = 0x%s\n" +
				"Bufferformat = 0x%s , filename = %s\n" ,
				this.malformed ,
				Integer.toHexString(this.wordCount) ,
				this.fileattr, Integer.toHexString(this.createTime) ,
				Integer.toHexString(this.byteCount) ,
				this.bufferFormat,this.fileName);
	}
}
