package org.araqne.pcap.smb;

import java.util.HashMap;
import java.util.Map;


import org.araqne.pcap.smb.rr.UdpTransactionCommand;
import org.araqne.pcap.smb.transparser.TransParser;
import org.araqne.pcap.smb.udp.MailSlotParser;

public class UdpTransSubcommandMapper {
	private Map<UdpTransactionCommand, TransParser> parsers;

	public UdpTransSubcommandMapper() {
		parsers = new HashMap<UdpTransactionCommand, TransParser>();
		map(UdpTransactionCommand.TRANS_MAILSLOT_WRITE, new MailSlotParser()); // now not use this
		//TRANS_MAILSLOT_WRITE(0x0001),
	}
	
	private void map(UdpTransactionCommand command, TransParser parser) {
		parsers.put(command, parser);
	}
	public TransParser getParser(UdpTransactionCommand code){
//		System.out.println("this command = " + code);
		return parsers.get(code);
	}
}
