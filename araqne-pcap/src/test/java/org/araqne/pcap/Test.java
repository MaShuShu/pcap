package org.araqne.pcap;

import java.io.IOException;
import java.util.List;

import org.araqne.pcap.live.PcapDevice;
import org.araqne.pcap.live.PcapDeviceManager;
import org.araqne.pcap.packet.PcapPacket;
import org.araqne.pcap.util.PcapLiveRunner;

public class Test {
	public static void main(String[] args) throws IOException {
		PcapDevice device = PcapDeviceManager.openFor("8.8.8.8", 10000);
		long sum = 0;
		long volume = 0;
		long sumCount = 0;
		
		long last = System.currentTimeMillis();
		while (true) {
			List<PcapPacket> pkts = device.getPackets();
			sum += pkts.size();
			sumCount++;
			for (PcapPacket p : pkts) {
				volume += p.getPacketHeader().getOrigLen();
			}
			
			long now = System.currentTimeMillis();
			long elapsed = now - last;
			if (elapsed >= 1000) {
				System.out.println("recv ring: " + sum + " packets/sec. elaspsed " + elapsed + "ms, volume " + volume + " chunk avg count: " + (sum / sumCount));
				last = now;
				sum = 0;
				sumCount = 0;
				volume = 0;
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}
	}
}
