package org.araqne.pcap.smb.trans2struct.findinfolevelstruct;

import org.araqne.pcap.netbios.NetBiosNameCodec;
import org.araqne.pcap.smb.SmbSession;
import org.araqne.pcap.smb.TransStruct;
import org.araqne.pcap.smb.rr.ExtFileAttributes;
import org.araqne.pcap.util.Buffer;
import org.araqne.pcap.util.ByteOrderConverter;

public class SmbFindFileFullDirectoryInfo implements TransStruct{
	int nextEntryOffset;
	int fileIndex;
	long creationTime;
	long lastAccessTime;
	long lastWriteTime;
	long lastAttrChangeTime;
	long endOfFile;
	long allocationSize;
	ExtFileAttributes extFileAttributes;
	int fileNameLength;
	int eaSize;
	String fileName;
	public int getNextEntryOffset() {
		return nextEntryOffset;
	}
	public void setNextEntryOffset(int nextEntryOffset) {
		this.nextEntryOffset = nextEntryOffset;
	}
	public int getFileIndex() {
		return fileIndex;
	}
	public void setFileIndex(int fileIndex) {
		this.fileIndex = fileIndex;
	}
	public long getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}
	public long getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	public long getLastWriteTime() {
		return lastWriteTime;
	}
	public void setLastWriteTime(long lastWriteTime) {
		this.lastWriteTime = lastWriteTime;
	}
	public long getLastAttrChangeTime() {
		return lastAttrChangeTime;
	}
	public void setLastAttrChangeTime(long lastAttrChangeTime) {
		this.lastAttrChangeTime = lastAttrChangeTime;
	}
	public long getEndOfFile() {
		return endOfFile;
	}
	public void setEndOfFile(long endOfFile) {
		this.endOfFile = endOfFile;
	}
	public long getAllocationSize() {
		return allocationSize;
	}
	public void setAllocationSize(long allocationSize) {
		this.allocationSize = allocationSize;
	}
	public ExtFileAttributes getExtFileAttributes() {
		return extFileAttributes;
	}
	public void setExtFileAttributes(ExtFileAttributes extFileAttributes) {
		this.extFileAttributes = extFileAttributes;
	}
	public int getFileNameLength() {
		return fileNameLength;
	}
	public void setFileNameLength(int fileNameLength) {
		this.fileNameLength = fileNameLength;
	}
	public int getEaSize() {
		return eaSize;
	}
	public void setEaSize(int eaSize) {
		this.eaSize = eaSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public TransStruct parse(Buffer b , SmbSession session){
		nextEntryOffset = ByteOrderConverter.swap(b.getInt());
		fileIndex = ByteOrderConverter.swap(b.getInt());
		creationTime = ByteOrderConverter.swap(b.getLong());
		lastAccessTime = ByteOrderConverter.swap(b.getLong());
		lastWriteTime = ByteOrderConverter.swap(b.getLong());
		lastAttrChangeTime = ByteOrderConverter.swap(b.getLong());
		endOfFile = ByteOrderConverter.swap(b.getLong());
		allocationSize = ByteOrderConverter.swap(b.getLong());
		extFileAttributes = ExtFileAttributes.parse(ByteOrderConverter.swap(b.getInt()));
		fileNameLength = ByteOrderConverter.swap(b.getInt());
		eaSize = ByteOrderConverter.swap(b.getInt());
		fileName = NetBiosNameCodec.readSmbUnicodeName(b, fileNameLength);
		b.rewind();
		b.skip(nextEntryOffset);
		return this;
	}
	@Override
	public String toString(){
		return String.format("Third Level Structure : Smb Find File Full directory Info\n" +
				"nextEntryOffset = 0x%s , fileIndex = 0x%s , creationTime = 0x%s\n" +
				"lastAccessTime = 0x%s,  lastWriteTime = 0x%s, lastAttrChageTime = 0x%s\n" +
				"endOfFile = 0x%s , allocationSize = 0x%s , extfileattributes = %s\n" +
				"fileNameLength = %s , eaSize = 0x%s\n" +
				"fileName = %s\n",
				Integer.toHexString(this.nextEntryOffset) , Integer.toHexString(this.fileIndex) , Long.toHexString(this.creationTime),
				Long.toHexString(this.lastAccessTime) , Long.toHexString(this.lastWriteTime) , Long.toHexString(this.lastAttrChangeTime),
				Long.toHexString(this.endOfFile) , Long.toHexString(this.allocationSize) , this.extFileAttributes,
				Integer.toHexString(this.fileNameLength) , Integer.toHexString(this.eaSize),
				this.fileName);
	}
}
