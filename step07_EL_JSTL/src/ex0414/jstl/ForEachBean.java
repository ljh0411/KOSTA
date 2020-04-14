package ex0414.jstl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachBean {
	private String [] names = {"��ȣ", "��ȣ", "����", "ȿ��", "����", "����"};
	private List<String> menus = Arrays.asList(new String [] {"¥��", "«��", "«¥��", "�Ⱥ�ä","������","���", "��ä��"} );


	private List<MemberDTO> memberList= new ArrayList<MemberDTO>();

	private Map<String, String> map= new HashMap<String, String>();
	
	public ForEachBean() {
		//member����
		memberList.add(new MemberDTO("jang",20 ,"�Ǳ�", "111-222"));
		memberList.add(new MemberDTO("lee",21 ,"����", "111-33"));
		memberList.add(new MemberDTO("park",22 ,"�뱸", "111-444"));
		memberList.add(new MemberDTO("kim",23 ,"����", "111-555"));
		memberList.add(new MemberDTO("jung",24 ,"�λ�", "111-666"));
		
		map.put("kr", "���ѹα�");
		map.put("jp", "�Ϻ�");
		map.put("ch", "�߱�");
		map.put("am", "�̱�");
		map.put("fr", "������");
		
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
