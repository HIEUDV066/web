package dal;

import java.util.ArrayList;
import java.util.List;

import model.phone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneDAO extends DBContext {
	
	public List<phone> getAll(){
		List<phone> list=new ArrayList<>();
		String sql="select * from phone";
		try {
			PreparedStatement st=connection.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				phone p = new phone();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescrible(rs.getString("describle"));
				list.add(p);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public void delete(int id) {
		String sql = "delete from phone where id=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public phone getPhoneByID(int id) {
		String sql="select * from phone where id=?";
		try {
			PreparedStatement st=connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				phone p = new phone();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescrible(rs.getString("describle"));
				return p;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void insert(phone p) {
		String sql = "insert into phone values (?,?,?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, p.getId());
			st.setString(2, p.getName());
			st.setString(3, p.getDescrible());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
    
	public void update (phone p) {
		String sql="update phone set name=?, describle=? where id=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, p.getName());
			st.setString(2, p.getDescrible());
			st.setInt(3, p.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	//test ket noi database
	public static void main(String[] args) {
		PhoneDAO cDao = new PhoneDAO();
		List<phone> list = cDao.getAll();
		System.out.println(list.get(0).getName());
	}
	
}
