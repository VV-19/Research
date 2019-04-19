package com.vv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.opensymphony.xwork2.ActionContext;
import com.vv.datasource.C3p0DataSource;
import com.vv.domain.Participant;
import com.vv.domain.Research;

import freemarker.template.SimpleDate;

public class ReportDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int result = 0;
	String sql = "";
	
	//项目录入
	public int addReoprt(Research research) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String start_time = format.format(research.getStart_time());
		String end_time = format.format(research.getEnd_time());
		List<Participant> list;
		list = (List<Participant>) ActionContext.getContext().getSession().get("list");
		try {
			conn = C3p0DataSource.getConnection();
			conn.setAutoCommit(false);//开启事务
			String sql1 = "insert into report"
				+ "(res_id,res_name,res_type,res_host,res_content, res_fund, "
				+ "start_time, end_time,report_time,res_status,upd_status) values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, research.getRes_id());
			pstmt.setString(2, research.getRes_name());
			pstmt.setString(3, research.getRes_type());
			pstmt.setString(4, research.getRes_host());
			pstmt.setString(5, research.getRes_content());
			pstmt.setDouble(6, research.getRes_fund());
			pstmt.setString(7, start_time);
			pstmt.setString(8, end_time);
			pstmt.setDate(9, new Date(System.currentTimeMillis()));
			pstmt.setString(10, "已提交");
			pstmt.setString(11, "否");
			int rs1 = pstmt.executeUpdate();
			
			String sql2 = "insert into participant"
					+ "(res_id,tea_id,part_user,education,rating,unit,effect) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql2);
			for(int i=0;i<=4;i++) {
				if(list.get(i).getPart_user().isEmpty()) {
					System.out.println("list.get(i).getPart_user()==="+list.get(i).getPart_user());
					break;
				}
				pstmt.setString(1, research.getRes_id());
				pstmt.setString(2, list.get(i).getTea_id());
				pstmt.setString(3, list.get(i).getPart_user());
				pstmt.setString(4, list.get(i).getEducation());
				pstmt.setString(5, list.get(i).getRating());
				pstmt.setString(6, list.get(i).getUnit());
				pstmt.setString(7, list.get(i).getEffect());
				pstmt.addBatch();
			}
			int[] rs2=pstmt.executeBatch();
			System.out.println("Batch()");
			conn.commit();//提交事务
			return rs1;
		} catch (Exception e) {
			System.out.println("Dao出错了");
			return 0;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}
		
	}
	//查询全部项目
	public List<Research> findReport(Research research) {
		int i = 1;
		conn = C3p0DataSource.getConnection();
		List<Research> researchList = new ArrayList<Research>();
		Research res = null;
		sql = "select * from report where res_id=? or res_name like ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, research.getRes_id());
			pstmt.setString(2, "%"+research.getRes_id()+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				res = new Research();
				res.setNumber(i++);
				res.setRes_id(rs.getString(2));
				res.setRes_name(rs.getString(3));
				res.setRes_type(rs.getString(4));
				res.setRes_host(rs.getString(5));
				res.setRes_content(rs.getString(6));
				res.setRes_fund(rs.getDouble(7));				
				res.setStart_time(rs.getDate(8));
				res.setEnd_time(rs.getDate(9));
				res.setReport_time(rs.getDate(10));		
				res.setRes_status(rs.getString(11));
				res.setUpd_status(rs.getString(12));
				researchList.add(res);
			}
			return researchList;
		} catch (SQLException e) {
			return null;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}
		
	}
	//查询项目信息
	public List<Research> find(Research research) {
		Research findResearch = null;
		List<Research> list = new ArrayList<>();
		conn = C3p0DataSource.getConnection();
		sql="SELECT * FROM report inner join participant on report.res_id=participant.res_id where participant.res_id=?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,research.getRes_id());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				findResearch = new Research();
				findResearch.setRes_id(rs.getString(2));
				findResearch.setRes_name(rs.getString(3));
				findResearch.setRes_type(rs.getString(4));
				findResearch.setRes_host(rs.getString(5));
				findResearch.setRes_content(rs.getString(6));
				findResearch.setRes_fund(rs.getDouble(7));				
				findResearch.setStart_time(rs.getDate(8));
				findResearch.setEnd_time(rs.getDate(9));
				findResearch.setReport_time(rs.getDate(10));		
				findResearch.setRes_status(rs.getString(11));
				findResearch.setUpd_status(rs.getString(12));
				findResearch.setTea_id(rs.getString(15));
				findResearch.setPart_user(rs.getString(16));
				findResearch.setEducation(rs.getString(17));
				findResearch.setRating(rs.getString(18));
				findResearch.setUnit(rs.getString(19));
				findResearch.setEffect(rs.getString(20));
				list.add(findResearch);
			}
			System.out.println("list==="+list);
			return list;
		} catch (SQLException e) {
			return null;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}

	}
	//修改项目信息
	public int updateReport(Research research) {
		conn = C3p0DataSource.getConnection();
		sql = "update report set res_content=?,res_status=? where res_id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("research.getRes_content()==="+research.getRes_content());
			pstmt.setString(1, research.getRes_content());
			pstmt.setString(2, "已提交");
			System.out.println("research.getRes_id()===="+research.getRes_id());
			pstmt.setString(3, research.getRes_id());
			result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			return 0;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}
	}
	//修改权限
	public int requestPermission(Research research) {
		conn=C3p0DataSource.getConnection();
		sql = "update report set upd_status=? where res_id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "待审核");
			pstmt.setString(2, research.getRes_id());
			result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			return 0;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}
	}
	//查询待审核报告
	public List<Research> findUpdateReport(Research research) {
		int i = 1;
		conn = C3p0DataSource.getConnection();
		List<Research> researchList = new ArrayList<Research>();
		Research res = null;
		sql = "select * from report where upd_status=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "待审核");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				res = new Research();
				res.setNumber(i++);
				res.setRes_id(rs.getString(2));
				res.setRes_name(rs.getString(3));
				res.setRes_type(rs.getString(4));
				res.setRes_host(rs.getString(5));
				res.setRes_content(rs.getString(6));
				res.setRes_fund(rs.getDouble(7));				
				res.setStart_time(rs.getDate(8));
				res.setEnd_time(rs.getDate(9));
				res.setReport_time(rs.getDate(10));		
				res.setRes_status(rs.getString(11));
				res.setUpd_status(rs.getString(12));
				researchList.add(res);
			}
			return researchList;
		} catch (SQLException e) {
			return null;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}
	}
	//提交审核结果
	public int updateRequest(Research research) {
		conn=C3p0DataSource.getConnection();
		sql = "update report set res_status=?,upd_status=? where res_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("id==="+research.getRes_id());
			if(research.getResult().equals("yes")) {
			pstmt.setString(1, "可修改");
			pstmt.setString(2, "无");
			}else {
				pstmt.setString(1, "已提交");
				pstmt.setString(2, "未通过");
			}
			pstmt.setString(3, research.getRes_id());
			System.out.println("result====+下一个”");
			result = pstmt.executeUpdate();
			System.out.println("result===="+result);
			return result;
		} catch (SQLException e) {
			return 0;
		}finally {
			C3p0DataSource.close(rs, pstmt, conn);
		}

	}

}
