package Utils;

import java.sql.*;

    public class JDBC {

        //反射机制注册数据库驱动
        static{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private static Connection conn = null;
        private static PreparedStatement ps = null;
        private static ResultSet rs = null;
        private static String url ="jdbc:mysql://localhost:3306/student";
        private static String user = "root";
        private static String password = "123456";

        //连接数据库
        public static Connection getConnection(){
            //获取连接
            try{
                conn = DriverManager.getConnection(url, user, password);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return conn;


    }
        //关闭资源
        public static void close(ResultSet rs,PreparedStatement ps,Connection conn)  {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}
