package org.araqne.pcap.smb.response;
import org.araqne.pcap.smb.structure.SmbData;
//0xA4
public class NtCancelResponse implements SmbData{

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
		return String.format("First Level : NtCancel Response\n" +
				"isMalformed = %s\n",
				this.malformed);
	}
}
