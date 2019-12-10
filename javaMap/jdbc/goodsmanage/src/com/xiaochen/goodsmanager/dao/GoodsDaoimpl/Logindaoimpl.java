package com.xiaochen.goodsmanager.dao.GoodsDaoimpl;

import com.xiaochen.goodsmanager.dao.Logindao;
import com.xiaochen.goodsmanager.entity.Admin;
import com.xiaochen.goodsmanager.entity.Pagelimit;
import com.xiaochen.goodsmanager.util.DBUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Logindaoimpl implements Logindao {
    private DBUtil dbUtil = new DBUtil();

    @Override
    public Admin adminlogin(Admin admin) throws SQLException, ClassNotFoundException {
        String sql = "select *from  admin where  account= ? AND pwd= ?";
        PreparedStatement preparedStatement = dbUtil.getPreparedStatement(sql);
        preparedStatement.setString(1, admin.getAccount());
        preparedStatement.setString(2, admin.getPwd());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String account = resultSet.getString("Account");
        String pwd = resultSet.getString("Pwd");
        int power = resultSet.getInt("power");
        admin.setAccount(account);
        admin.setPwd(pwd);
        admin.setPower(power);
        return admin;
    }

    @Override
    public <T, U> List Limit(T t, U u) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        StringBuffer buffer = new StringBuffer("select * from ");
        Class c = t.getClass();
        String simpleName = c.getSimpleName();
        buffer.append(simpleName).append(" LIMIT ").append("?,?");
        PreparedStatement preparedStatement = dbUtil.getPreparedStatement(buffer.toString());
        preparedStatement.setInt(1,((Integer) u-1)*15);
        preparedStatement.setInt(2,15);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount =metaData.getColumnCount();
       int cont=0;
       int m= (Integer)u;
        List list = new ArrayList();
        String pag = null;
        while(resultSet.next()){
            cont++;
            for (int i=1;i<=columnCount;i++){
                if (15* m<cont){
                    System.out.println(-1);
                }else {
                    pag=resultSet.getString(i)+"\t";

                }
            }
            list.add(pag);
            System.out.println();
        }
        System.out.println("第"+m+"页"+ cont+" 条记录");
        dbUtil.closeAll();
        return list;
    }

    /**
     * 智能单表查询分页
     * @param t
     * @param pageNumber
     * @param pageSize
     * @param <T>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */

    @Override
    public <T> Pagelimit pageLimit(T t, Integer  pageNumber, Integer pageSize ) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = t.getClass();
        String simpleName = c.getSimpleName();
        //获取总的记录数
        StringBuffer pageRow = new StringBuffer("SELECT COUNT(*) FROM ");
        pageRow.append(simpleName);
        PreparedStatement preparedStatement1 = dbUtil.getPreparedStatement(pageRow.toString());
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        resultSet1.next();
        int pageCount = resultSet1.getInt(1);
        //分页的记录数
        StringBuffer buffer = new StringBuffer("select * from ");
        buffer.append(simpleName).append(" LIMIT ").append("?,?");
        PreparedStatement preparedStatement = dbUtil.getPreparedStatement(buffer.toString());
        preparedStatement.setInt(1,(pageNumber -1)* pageSize);
        preparedStatement.setInt(2,pageSize);
        ResultSet result = preparedStatement.executeQuery();
        List<T> list = new ArrayList();
        Method[] methods = c.getMethods();
        Object obj = null;
        while (result.next()) {
            obj = c.newInstance();
            for (Method method : methods) {
                String name = method.getName();
                if (name.startsWith("set")) {
                    String cname = name.substring(3);
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes[0] == String.class) {
                        method.invoke(obj, result.getString(cname));
                    }
                    if (parameterTypes[0] == int.class) {
                        method.invoke(obj, result.getInt(cname));
                    }
                }
            }
            list.add((T) obj);
        }
        dbUtil.closeAll();
       Pagelimit pageBean=new Pagelimit(pageCount,pageSize);
       pageBean.setList(list);
        return pageBean;
    }
}
