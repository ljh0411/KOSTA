package ex0416.dao;

import java.sql.SQLException;
import java.util.List;

import ex0416.domain.Member;

/**
 * 회원관리에 필요한 CRUD
 * @author SAMSUNG
 *
 */
public interface MemberDAO {
	
	/**
	 * 회원 등록
	 * insert into member(id, pwd, name, age, phone, addr, join_date)
	 * values(?,?,?,?,?,?,sysdate)
	 **/
	int insert(Member member) throws SQLException;
		
	
	
	
	/**
	 * 회원 id 중복체크
	 * @return : true 이면 중복, false이면 중복아님
	 **/
	boolean idCheck(String id) throws SQLException;
	
	
	/**
	 * 회원 전체검색
	 * : 결과 레코드가 0개이상 가능. -List
	 **/
	List<Member> selectAll() throws SQLException;
	
	
	/**
	 * id에 해당하는 레코드 검색
	 * : 결과 레ㅗ드가 0 or 1이면 Member
	 **/
	Member SelectById(String id) throws SQLException;
	
	/**
	 * keyField에 해당하는(필드명) keyword를 포함한 레코드 검색하기
	 * ex) 
	 * select * from member where id like '%a%' or
	 * select * from member where name like '%a%' or
	 * select * from member where addr like '%a%' 
	 **/
	List<Member> searchByKeyword(String keyField, String keyWord) throws SQLException;
	
	
	/**
	 * 회원 삭제
	 */
	int delete(String id)throws SQLException;
	
}
