package ex0414.jstl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachBean {
	private String [] names = {"¼±È£", "¹ÎÈ£", "ÈñÀ±", "È¿Á¤", "ÁøÇõ", "¿µÁø"};
	private List<String> menus = Arrays.asList(new String [] {"Â¥Àå", "Â«»Í", "Â«Â¥¸é", "ÆÈº¸Ã¤","ÅÁ¼öÀ°","¿ï¸é", "ÀâÃ¤¹ä"} );


	private List<MemberDTO> memberList= new ArrayList<MemberDTO>();

	private Map<String, String> map= new HashMap<String, String>();
	
	public ForEachBean() {
		//memberÀúÀå
		memberList.add(new MemberDTO("jang",20 ,"ÆÇ±³", "111-222"));
		memberList.add(new MemberDTO("lee",21 ,"¼­¿ï", "111-33"));
		memberList.add(new MemberDTO("park",22 ,"´ë±¸", "111-444"));
		memberList.add(new MemberDTO("kim",23 ,"´ëÀü", "111-555"));
		memberList.add(new MemberDTO("jung",24 ,"ºÎ»ê", "111-666"));
		
		map.put("kr", "´ëÇÑ¹Î±¹");
		map.put("jp", "ÀÏº»");
		map.put("ch", "Áß±¹");
		map.put("am", "¹Ì±¹");
		map.put("fr", "ÇÁ¶û½º");
		
	}

	public String[] getNames() {
		return names;
	}

	public List<String> getMenus() {
		return menus;
	}

	public List<MemberDTO> getMemberList() {
		return memberList;
	}

	public Map<String, String> getMap() {
		return map;
	}
	
}
