package org.araqne.pcap.smb.trans2resp;

import org.araqne.pcap.smb.TransData;

public class FsctlResponse implements TransData{
	// not implement err
	@Override
	public String toString(){
		return String.format("Trans2 Seconde Level : Fsctl Response\n");
	}
}
