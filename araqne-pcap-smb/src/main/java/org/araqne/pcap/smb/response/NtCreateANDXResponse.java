package org.araqne.pcap.smb.response;
import org.araqne.pcap.smb.rr.ExtFileAttributes;
import org.araqne.pcap.smb.rr.NamedPipeStatus;
import org.araqne.pcap.smb.structure.SmbData;


//0xA2
public class NtCreateANDXResponse implements SmbData{
	public final static byte NO_OP_GRANTED = 0x00;
	public final static byte EXCLUSIVE_OPLOCK_GRANTED = 0x01;
	public final static byte BATCH_OPLOCK_GRANTED = 0x02;
	public final static byte LEVEL_2_OPLOCK_GRANTED = 0x03;

	boolean malformed = false;
	byte wordCount; // it must 0x00
	byte andxCommand;
	byte andxReserved;
	short andxOffset;
	byte opLockLevel;
	short fid;
	int createDisposition;
	int createTime;
	int lastAccessTime;
	int lastWriteTime;
	int lastChangeTime;
	ExtFileAttributes extFileAttributes;
	long allocationSize;
	long endOfFile;
	short ResourceType;
	NamedPipeStatus nmPipestatus;
	byte directory;
	short byteCount; // it must 0x0000
	public byte getWordCount() {
		return wordCount;
	}
	public void setWordCount(byte wordCount) {
		this.wordCount = wordCount;
	}
	public byte getAndxCommand() {
		return andxCommand;
	}
	public void setAndxCommand(byte andxCommand) {
		this.andxCommand = andxCommand;
	}
	public byte getAndxReserved() {
		return andxReserved;
	}
	public void setAndxReserved(byte andxReserved) {
		this.andxReserved = andxReserved;
	}
	public short getAndxOffset() {
		return andxOffset;
	}
	public void setAndxOffset(short andxOffset) {
		this.andxOffset = andxOffset;
	}
	public byte getOpLockLevel() {
		return opLockLevel;
	}
	public void setOpLockLevel(byte opLockLevel) {
		this.opLockLevel = opLockLevel;
	}
	public short getFid() {
		return fid;
	}
	public void setFid(short fid) {
		this.fid = fid;
	}
	public int getCreateDisposition() {
		return createDisposition;
	}
	public void setCreateDisposition(int createDisposition) {
		this.createDisposition = createDisposition;
	}
	public int getCreateTime() {
		return createTime;
	}
	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
	public int getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(int lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	public int getLastWriteTime() {
		return lastWriteTime;
	}
	public void setLastWriteTime(int lastWriteTime) {
		this.lastWriteTime = lastWriteTime;
	}
	public int getLastChangeTime() {
		return lastChangeTime;
	}
	public void setLastChangeTime(int lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}
	public ExtFileAttributes getExtFileAttributes() {
		return extFileAttributes;
	}
	public void setExtFileAttributes(ExtFileAttributes extFileAttributes) {
		this.extFileAttributes = extFileAttributes;
	}
	public long getAllocationSize() {
		return allocationSize;
	}
	public void setAllocationSize(long allocationSize) {
		this.allocationSize = allocationSize;
	}
	public long getEndOfFile() {
		return endOfFile;
	}
	public void setEndOfFile(long endOfFile) {
		this.endOfFile = endOfFile;
	}
	public short getResourceType() {
		return ResourceType;
	}
	public void setResourceType(short resourceType) {
		ResourceType = resourceType;
	}
	public NamedPipeStatus getNmPipestatus() {
		return nmPipestatus;
	}
	public void setNmPipestatus(NamedPipeStatus nmPipestatus) {
		this.nmPipestatus = nmPipestatus;
	}
	public byte getDirectory() {
		return directory;
	}
	public void setDirectory(byte directory) {
		this.directory = directory;
	}
	public short getByteCount() {
		return byteCount;
	}
	public void setByteCount(short byteCount) {
		this.byteCount = byteCount;
	}
	public boolean isOplockNoOpGranted()
	{
		if((this.opLockLevel & NO_OP_GRANTED) == NO_OP_GRANTED)
			return true;
		else
			return false;
	}
	public boolean isOplockExclusiveOplockGranted()
	{
		if((this.opLockLevel & EXCLUSIVE_OPLOCK_GRANTED) ==EXCLUSIVE_OPLOCK_GRANTED)
			return true;
		else
			return false;
	}
	public boolean isOplockBatchOplockGranted()
	{
		if((this.opLockLevel & BATCH_OPLOCK_GRANTED) == BATCH_OPLOCK_GRANTED)
			return true;
		else
			return false;
	}
	public boolean isOplockLevel2OplockGranted()
	{
		if((this.opLockLevel & LEVEL_2_OPLOCK_GRANTED) == LEVEL_2_OPLOCK_GRANTED)
			return true;
		else
			return false;
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
		return String.format("First Level : NtCreate Andx Response \n" +
				"isMalformed = %s\n" +
				"wordCount = 0x%s\n" +
				"andxCommand = 0x%s , andxReserved = 0x%s , andxOffset = 0x%s\n" +
				"opLockLevel = 0x%s , fid = 0x%s , crateDisposition = 0x%s, createTime = 0x%s\n" +
				"lastAccessTime = 0x%s, lastWriteTime = 0x%s, lastChangeTime = 0x%s\n" +
				"extFileAttributes = %s , allocationSize = 0x%s , endofFile = 0x%s\n" +
				"reSourceType = 0x%s , nmPipeStatus = 0x%s , directory = 0x%s\n" +
				"byteCount = 0x%s\n",
				this.malformed,
				Integer.toHexString(this.wordCount),
				Integer.toHexString(this.andxCommand) , Integer.toHexString(this.andxReserved) , Integer.toHexString(this.andxOffset),
				Integer.toHexString(this.opLockLevel), Integer.toHexString(this.fid) , Integer.toHexString(this.createDisposition) , Integer.toHexString(this.createTime),
				Integer.toHexString(this.lastAccessTime) , Integer.toHexString(this.lastWriteTime) , Integer.toHexString(this.lastChangeTime),
				this.extFileAttributes , Long.toHexString(this.allocationSize) , Long.toHexString(this.endOfFile),
				Integer.toHexString(this.ResourceType) , this.nmPipestatus , Integer.toHexString(this.directory),
				Integer.toHexString(this.byteCount));
	}
}
