package ex0416.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex0416.domain.Member;
import ex0416.util.DbUtil;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int insert(Member member) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int	result=0;

		String sql="INSERT INTO MEMBER(ID, PWD, NAME, AGE, PHONE, ADDR, Join_Date) VALUES(?,?,?,?,?,?,sysdate)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1,member.getId());
			ps.setString(2,member.getPwd());
			ps.setString(3,member.getName());
			ps.setInt(4,member.getAge());
			ps.setString(5,member.getPhone());
			ps.setString(6,member.getAddr());

			result = ps.executeUpdate();

		}finally {

			DbUtil.dbClose(con, ps);
		}

		return result;

	}

	@Override
	public boolean idCheck(String id) throws SQLException {
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "select * from member where lower(id)=lower(?)";   //db에 대문자인지 소문자인지 모르기때문에 소문자로 통일시켜주고 비교
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id.trim());    //trim()은 공백제거
			rs = ps.executeQuery();
			if(rs.next()) result = true;   //요기가 중복체크 부분 next가 true이면 중복 false면 등록
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	@Override
	public List<Member> selectAll() throws SQLException {
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();

		String sql="SELECT ID, PWD, NAME, AGE, PHONE, ADDR, JOIN_DATE FROM MEMBER";
		try {
			//로드 연결 실행 닫기
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			//?의 개수 만큼 setXxx()가 필요하다.
			rs = ps.executeQuery();
			while(rs.next()) {
				Member member = new Member(rs.getString(1), rs.getString(2), rs.getString(3)
						, rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));  //멤버 한행을 담아준것

				//list에 추가
				list.add(member);

			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;
	}

	@Override
	public Member SelectById(String id) throws SQLException {
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		Member member = null;
		String sql="SELECT * FROM MEMBER WHERE ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id.trim());
			rs = ps.executeQuery();

			if(rs.next()) {
				member = new Member(rs.getString(1), rs.getString(2), rs.getString(3)
						, rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));  //멤버 한행을 담아준것

			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return member;
	}


	@Override
	public List<Member> searchByKeyword(String keyField, String keyWord) throws SQLException {
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();

		String sql="SELECT ID, PWD, NAME, AGE, PHONE, ADDR, JOIN_DATE FROM MEMBER ";
		try {

			if(keyField.equals("id")) {
				sql+="where id like ?";
			}else if(keyField.equals("name"))
				sql+="where name like ?";
			else if(keyField.equals("addr"))
				sql+="where addr like ?";

			//로드 연결 실행 닫기
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			//?의 개수 만큼 setXxx()가 필요하다.
			ps.setString(1, "%"+keyWord.trim()+"%");
			rs = ps.executeQuery();

			while(rs.next()) {
				Member member = new Member(rs.getString(1), rs.getString(2), rs.getString(3)
						, rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));  //멤버 한행을 담아준것

				//list에 추가
				list.add(member);

			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}

		return list;

	}

	@Override
	public int delete(String id) throws SQLException {
		Connection con =null;
		PreparedStatement ps=null;
		int result = 0;
		String sql="Delete  FROM MEMBER WHERE ID=? ";
		try {
			con=DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			result = ps.executeUpdate();

		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
