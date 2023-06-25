package Controller;

import Dao.province;
import Utils.JDBC;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Controller/test")
public class test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs= null;
        String sql="select * from t_province ";

        ArrayList<province> arrayList =new ArrayList<>();
        //连接到数据库
        conn = JDBC.getConnection();
        try {
            ps = conn.prepareStatement(sql);

            rs=ps.executeQuery();
            while (rs.next()){
                String name=rs.getString("name");
                int id=rs.getInt("id");
                String pcode =rs.getString("pcode");
                String code=rs.getString("code");

                arrayList.add(new province(id,pcode,code,name));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBC.close(rs,ps,conn);

        response.setContentType("text/javascript,charset=UTF-8");
        String json= JSON.toJSONString(arrayList);
        response.getWriter().print(json);
    }


}
