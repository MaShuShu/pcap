package org.araqne.pcap.smb.request;
import org.araqne.pcap.smb.structure.SmbData;

public class WriteMPXSecondaryRequest implements SmbData{

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
	//not use
	@Override
	public String toString(){
		return String.format("First Level : Write MPX Secondary Request\n" +
				"isMalformed = %s\n",
				this.malformed);
	}
}
