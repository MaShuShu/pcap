package org.araqne.pcap.smb.response;
import org.araqne.pcap.smb.structure.SmbData;

public class NtTransactSecondaryResponse implements SmbData{

	boolean malformed = false;
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
		return String.format("First Level : NtTransactSecondaryResponse\n" +
				"isMalformed = %s\n",
				this.malformed);
	}
}
