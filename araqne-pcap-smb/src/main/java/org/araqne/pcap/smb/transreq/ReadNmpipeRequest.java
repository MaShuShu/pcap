package org.araqne.pcap.smb.transreq;

import org.araqne.pcap.smb.TransData;

public class ReadNmpipeRequest implements TransData{
	short subcommand;
	short fid;
	public short getSubcommand() {
		return subcommand;
	}
	public void setSubcommand(short subcommand) {
		this.subcommand = subcommand;
	}
	public short getFid() {
		return fid;
	}
	public void setFid(short fid) {
		this.fid = fid;
	}
	@Override
	public String toString(){
		return String.format("");
	}
}
