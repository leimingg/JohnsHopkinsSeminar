package data;

import java.sql.*;

import model.CostInformation;
import model.RegistrationInfo;
import service.RegistrationServiceImplement;


public class RegistrationDB {
	
	static String dbError="There is Error When insert to database!<br>";
	public static String getDbError() {
		return dbError;
	}
	
	public static boolean insert(RegistrationInfo reg,RegistrationServiceImplement regSrv,CostInformation ci) {
		if(insertToUserTable(reg,regSrv)==1){
			if(insertToRegistrationTable(reg,regSrv)==1) {
				if(insertToCourseTable(reg,regSrv,ci)==1) {
					return true;
				}
				dbError +="Fail to insert into Course Table!<br>";
				delete(regSrv.getEmail());
				return false;
			}
			dbError +="Fail to insert into Registration Table!<br>";
			delete(regSrv.getEmail());
			return false;
		}
		dbError +="Fail to insert into User Table!<br>";
		return false;
	}
    public static int insertToUserTable(RegistrationInfo reg,RegistrationServiceImplement regSrv) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO UserTable (Name, Email, Employment) "
                + "VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, reg.getName());
            ps.setString(2, reg.getEmail());       
            ps.setString(3, reg.getEmploymentStatus());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int insertToRegistrationTable(RegistrationInfo reg,RegistrationServiceImplement regSrv) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String[] courses = new String[reg.getCourses().size()];
        String query
                = "INSERT INTO RegistrationTable (Name, CoursesDiscription) "
                + "VALUES (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, reg.getName());
            
            String[] arrayofString;
            int j=(arrayofString=reg.getCourses().toArray(courses)).length;
            for(int i=0;i<j;i++) {
            	String course=arrayofString[i];
            	ps.setString(2, course);
                ps.executeUpdate();
            }
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int insertToCourseTable(RegistrationInfo reg,RegistrationServiceImplement regSrv,CostInformation ci) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String[] courses = new String[reg.getCourses().size()];
        String query
                = "INSERT INTO CourseTable (Name, CostPerCourse, Courses) "
                + "VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, reg.getName());
           
			ps.setDouble(2, regSrv.getRegistrationInfo().getCostInfo().getEmployeeStatusCost());
            String[] arrayofString;
            int j=(arrayofString=reg.getCourses().toArray(courses)).length;
            for(int i=0;i<j;i++) {
            	String course=arrayofString[i];
            	ps.setString(3, course.substring(0, 2));
                ps.executeUpdate();
            }
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int delete(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM UserTable "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean emailExists(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Email FROM UserTable "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            dbError=dbError+e+"<br>";
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

}