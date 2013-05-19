package org.araqne.pcap.smb;

import java.util.HashMap;
import java.util.Map;

import org.araqne.pcap.smb.rr.FindInformationLevel;
import org.araqne.pcap.smb.trans2struct.findinfolevelstruct.SmbFindFileBothdirectoryInfo;
import org.araqne.pcap.smb.trans2struct.findinfolevelstruct.SmbFindFileDirectoryInfo;
import org.araqne.pcap.smb.trans2struct.findinfolevelstruct.SmbFindFileFullDirectoryInfo;
import org.araqne.pcap.smb.trans2struct.findinfolevelstruct.SmbFindFileIDFullDirectoryInfo;
import org.araqne.pcap.smb.trans2struct.findinfolevelstruct.SmbFindFileNamesInfo;
import org.araqne.pcap.smb.trans2struct.findinfolevelstruct.SmbInfoQueryEaSize;
import org.araqne.pcap.smb.trans2struct.findinfolevelstruct.SmbInfoStandard;
import org.araqne.pcap.smb.trans2struct.findinfolevelstruct.SmbInfoQueryEasFromList;

public class FindInfoLevelMapper {

	private Map<FindInformationLevel, TransStruct> findInfoMap = new HashMap<FindInformationLevel, TransStruct>();
	public FindInfoLevelMapper() {
		findInfoMap.put(FindInformationLevel.SmbInfoStandard, new SmbInfoStandard());
		findInfoMap.put(FindInformationLevel.SmbInfoQueryEaSize, new SmbInfoQueryEaSize());
		findInfoMap.put(FindInformationLevel.SmbInfoQueryEasFromList , new SmbInfoQueryEasFromList());
		findInfoMap.put(FindInformationLevel.SmbFindFileDirectoryInfo, new SmbFindFileDirectoryInfo());
		findInfoMap.put(FindInformationLevel.SmbFindFileFullDirectoryInfo , new SmbFindFileFullDirectoryInfo());
		findInfoMap.put(FindInformationLevel.SmbFindFileNamesInfo , new SmbFindFileNamesInfo());
		findInfoMap.put(FindInformationLevel.SmbFindFileBothDirectoryInfo, new SmbFindFileBothdirectoryInfo());
		findInfoMap.put(FindInformationLevel.SmbFindFileIDFullDirectoryInfo, new SmbFindFileIDFullDirectoryInfo());
		
	}
	public TransStruct getStruct(FindInformationLevel level){
		return findInfoMap.get(level);
	}
}
