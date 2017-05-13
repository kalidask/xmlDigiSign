package org.apache.coheigea.camel.xmlsecurity;

import java.sql.*;  
class MysqlCon{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/test","root","root");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
Date startDate = new Date(0);
ResultSet rs=stmt.executeQuery("select * from Person");  
System.out.println("rs:-----------"+rs);
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
Date endDate = new Date(0);
int msElapsedTime = (int) (startDate.getTime() - endDate.getTime());
System.out.println("Time took::::::"+msElapsedTime);

con.close();  

}catch(Exception e){ System.out.println(e);}  
}  
}  