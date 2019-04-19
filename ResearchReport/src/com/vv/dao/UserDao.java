package com.vv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.vv.datasource.C3p0DataSource;
import com.vv.domain.Teacher;
import com.vv.domain.User;

public class UserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	String tableName;
	int result = 0;
	//用户登陆
	public User findUser(User user) {

		User users = new User();
		try {
			conn = C3p0DataSource.getConnection();
			tableName = user.getPermission();
			System.out.println(tableName);
			String sql = "";
			if(tableName.equals("admins")){
				sql = "select * from admins where adm_username = ? and adm_password = ?";
			}else {
				sql = "select * from teacher where tea_username = ? and tea_password = ?";
			}
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			System.out.println("结果集"+rs);
			if(rs.next()) {
				users.setPermission(tableName);
				users.setUsername(rs.getString(4));
				users.setPassword(rs.getString(5));
				return users;
			}
				return null;
		}catch(Exception e) {
			return null;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}
	}
	//添加用户
	public int addUser(Teacher teacher) {
		System.out.println("addUserDao");
		conn = C3p0DataSource.getConnection();
		tableName = teacher.getPermission();
		String sql;
		try {
			if(tableName.equals("admins")) {
				System.out.println("向"+tableName+"表中插入一条数据");
				sql="insert into admins(adm_id,adm_name,adm_username,adm_password,telephone,email) values(?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, teacher.getId());
				pstmt.setString(2, teacher.getName());
				pstmt.setString(3, teacher.getUsername());
				pstmt.setString(4, teacher.getPassword());
				pstmt.setString(5, teacher.getTelephone());
				pstmt.setString(6, teacher.getEmail());
			}else {
				System.out.println("向"+tableName+"表中插入一条数据");
				sql="insert into teacher(tea_id,tea_name,tea_username,tea_password,college,telephone,email,education,rating) values(?,?,?,?,?,?,?,?,?)";
				System.out.println(sql);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, teacher.getId());
				System.out.println("不输入数据时==="+teacher.getId());
				pstmt.setString(2, teacher.getName());
				pstmt.setString(3, teacher.getUsername());
				pstmt.setString(4, teacher.getPassword());
				pstmt.setString(5, teacher.getCollege());
				pstmt.setString(6, teacher.getTelephone());
				pstmt.setString(7, teacher.getEmail());
				pstmt.setString(8, teacher.getEducation());
				pstmt.setString(9, teacher.getRating());
				}
			System.out.println("result出了问题");
			result = pstmt.executeUpdate();
			System.out.println(result);
			return result;
		} catch (SQLException e) {
			System.out.println("插入"+tableName+"表用户错误");
			return 0;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}
	}
	//查询单个用户
	public Teacher findUserMessage(Teacher teacher) {
		System.out.println("UserDao中的===="+teacher.getId());
		Teacher tm = new Teacher();
		tableName = teacher.getPermission();
		System.out.println("tableName==="+tableName);
		conn = C3p0DataSource.getConnection();
		try {
			if(tableName.equals("teacher")) {
				sql = "select * from teacher where tea_id=? or tea_name=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, teacher.getId());
				pstmt.setString(2, teacher.getId());
				rs = pstmt.executeQuery();
				if(rs.next()) {
				tm.setPermission(tableName);
				tm.setId(rs.getString(2));
				tm.setName(rs.getString(3));
				tm.setUsername(rs.getString(4));
				tm.setPassword(rs.getString(5));
				tm.setCollege(rs.getString(6));
				tm.setTelephone(rs.getString(7));
				tm.setEmail(rs.getString(8));
				tm.setEducation(rs.getString(9));
				tm.setRating(rs.getString(10));
				}else {
					return null;
					}
			}else {
				sql = "select * from admins where adm_id=? or adm_name=?";
				System.out.println(sql);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, teacher.getId());
				pstmt.setString(2, teacher.getId());
				rs = pstmt.executeQuery();
				if(rs.next()) {
				tm.setPermission(tableName);
				tm.setId(rs.getString(2));
				tm.setName(rs.getString(3));
				tm.setUsername(rs.getString(4));
				tm.setPassword(rs.getString(5));
				tm.setTelephone(rs.getString(6));
				tm.setEmail(rs.getString(7));
				tm.setCollege("无");
				tm.setEducation("无");
				tm.setRating("无");
				}else {
					return null;
				}
			}
			System.out.println(tm);
			return tm;
		} catch (SQLException e) {
			return null;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}
	}
	//修改用户信息
	public int updateUser(Teacher teacher) {
		conn = C3p0DataSource.getConnection();
		tableName=teacher.getPermission();
		System.out.println("tableName===="+tableName);
		try {
			if(tableName.equals("admins")) {
				sql="update admins set telephone=?,email=? where adm_id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, teacher.getTelephone());
				pstmt.setString(2, teacher.getEmail());
				pstmt.setString(3, teacher.getId());
			}else {
				sql="update teacher set college=?, telephone=?, email=?, education=?, rating=? where tea_id=?";
				System.out.println(sql);
				pstmt=conn.prepareStatement(sql);
				System.out.println("test===="+pstmt);
				System.out.println("teacher.getCollege()===="+teacher.getCollege());
				pstmt.setString(1, teacher.getCollege());
				pstmt.setString(2, teacher.getTelephone());
				pstmt.setString(3, teacher.getEmail());
				pstmt.setString(4, teacher.getEducation());
				pstmt.setString(5, teacher.getRating());
				pstmt.setString(6, teacher.getId());
				}
					System.out.println("一定是这引起的");
					result=pstmt.executeUpdate();
					System.out.println("修改结果==="+result);
					return result;
		} catch (Exception e) {
			System.out.println("肯定是这出错了");
			return 0;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}
	}
	//查询全部用户
	public List<Teacher> findAllUser(Teacher teacher) {
		List<Teacher> list = new ArrayList<Teacher>();
		Teacher ts=null;
		conn=C3p0DataSource.getConnection();
		try {
			if(teacher.getPermission().equals("teacher")) {
				sql="select * from teacher";
				pstmt=conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					ts = new Teacher();
					ts.setPermission(tableName);
					ts.setId(rs.getString(2));
					ts.setName(rs.getString(3));
					ts.setUsername(rs.getString(4));
					ts.setPassword(rs.getString(5));
					ts.setCollege(rs.getString(6));
					ts.setTelephone(rs.getString(7));
					ts.setEmail(rs.getString(8));
					ts.setEducation(rs.getString(9));
					ts.setRating(rs.getString(10));
					list.add(ts);
				}
			}else {
				sql="select * from admins";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					ts= new Teacher();
					ts.setPermission(tableName);
					ts.setId(rs.getString(2));
					ts.setName(rs.getString(3));
					ts.setUsername(rs.getString(4));
					ts.setPassword(rs.getString(5));
					ts.setCollege("无");
					ts.setTelephone(rs.getString(6));
					ts.setEmail(rs.getString(7));
					ts.setEducation("无");
					ts.setRating("无");
					list.add(ts);
				}
			}
			return list;
		} catch (SQLException e) {
			return null;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}
	}
	//删除用户
	public int deleteUser(Teacher teacher) {
		conn=C3p0DataSource.getConnection();
		tableName=teacher.getPermission();
		System.out.println("删除哪张表的信息===="+tableName);
		try {
			if(tableName.equals("teacher")) {
				sql="delete from teacher where tea_id=?";
			}else {
				sql="delete from admins where adm_id=?";			
			}
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getId());
			result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			return 0;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}
	}

	//修改用户密码
	public int updatePw(Teacher teacher) {
		System.out.println("执行到了UserDao");
		conn = C3p0DataSource.getConnection();
		tableName = teacher.getPermission();
		try {
			if(tableName.equals("teacher")) {
				sql="update teacher set tea_password=? where tea_username=? and tea_password=?";
			}else {
				sql="update admins set adm_password=? where adm_username=? and adm_password=?";
			}
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getNewpassword());
			pstmt.setString(2, teacher.getUsername());
			pstmt.setString(3, teacher.getPassword());
			result = pstmt.executeUpdate();
			System.out.println("修改语句的返回值==="+result);
			return result;
		} catch (Exception e) {
			return 0;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}
		
	}
}