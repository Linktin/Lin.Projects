package Controller;

import Dao.city;
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
@WebServlet("/Controller/cityQuery")
public class CityQuery extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String provinceId = request.getParameter("provinceId");
        int id = Integer.parseInt(provinceId);
        String sql="select * from t_city where provinceId=?";
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        ArrayList<city>arrayList=new ArrayList<>();
        conn = JDBC.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while (rs.next()){
                String name=rs.getString("name");
                int ID =rs.getInt("id");
                arrayList.add(new city(ID,name,id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       JDBC.close(rs,ps,conn);

        response.setContentType("html/javasrcipt,charset=UTF-8");
        String json= JSON.toJSONString(arrayList);
        response.getWriter().print(json);
    }
}
