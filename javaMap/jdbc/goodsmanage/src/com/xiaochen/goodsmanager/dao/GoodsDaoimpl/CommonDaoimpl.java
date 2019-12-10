package com.xiaochen.goodsmanager.dao.GoodsDaoimpl;

import com.xiaochen.goodsmanager.dao.CommonDao;
import com.xiaochen.goodsmanager.util.DBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommonDaoimpl implements CommonDao {
    private DBUtil dbUtil = new DBUtil();

    /**
     * 增加通用
     *
     * @param t
     * @param <T>
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    @Override
    public <T> boolean insert(T t) throws SQLException, IllegalAccessException, ClassNotFoundException {
        StringBuffer buffer = new StringBuffer("insert into ");
        Class c = t.getClass();
        buffer.append(c.getSimpleName());
        buffer.append("(");
        Field[] declaredFields = c.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            buffer.append(declaredField.getName()).append(",");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append(") values(null");
        for (int i = 0; i < declaredFields.length - 1; i++) {
            buffer.append(",?");
        }
        buffer.append(")");
        PreparedStatement preparedStatement = dbUtil.getPreparedStatement(buffer.toString());
        for (int i = 1; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            preparedStatement.setObject(i, declaredFields[i].get(t));
        }
        int i = preparedStatement.executeUpdate();
        dbUtil.closeAll();
        return i > 0 ? true : false;
    }

    /**
     * 删除通用
     *
     * @param t
     * @param u
     * @param <T>
     * @param <U>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */


    @Override
    public <T, U> boolean delete(T t, U u) throws SQLException, ClassNotFoundException, IllegalAccessException {
        // delete from 表名 where 表达式
        StringBuffer buffer = new StringBuffer("delete from ");
        Class c = t.getClass();
        buffer.append(c.getSimpleName());
        buffer.append(" where ");
        Field[] declaredFields = c.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
        }
        buffer.append(declaredFields[0].getName());
        buffer.append("=?");
        PreparedStatement preparedStatement = dbUtil.getPreparedStatement(buffer.toString());
        /*if(e instanceof Integer) {
            ps.setInt(1,(Integer) e);
        } else if(e instanceof String) {
            ps.setString(1,e.toString());
        }*/
        preparedStatement.setObject(1, u);
        int i = preparedStatement.executeUpdate();
        dbUtil.closeAll();
        return i > 0 ? true : false;
    }

    /**
     * 修改通用
     *
     * @param t
     * @param u
     * @param <T>
     * @param <U>
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    @Override
    public <T, U> boolean update(T t, U u) throws SQLException, IllegalAccessException, ClassNotFoundException {
        //update 表名 set 字段名 = 新内容
        StringBuffer buffer = new StringBuffer("update ");
        Class c = t.getClass();
        String simpleName = c.getSimpleName();
        buffer.append(simpleName);
        buffer.append(" set ");
        Field[] declaredFields = c.getDeclaredFields();
        for (int i = 1; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[0];
            declaredFields[i].setAccessible(true);
            buffer.append(declaredFields[i].getName());
            buffer.append("=?").append(",");

        }
        buffer.append(" where ");
        buffer.append(declaredFields[0].getName());
        buffer.append("=?");
        int lastIndexOf = buffer.lastIndexOf(",");
        buffer.deleteCharAt(lastIndexOf);
        PreparedStatement preparedStatement = dbUtil.getPreparedStatement(buffer.toString());
        for (int i = 1; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            preparedStatement.setObject(i, declaredFields[i].get(t));
        }
        preparedStatement.setObject(declaredFields.length, u.toString());
        int i = preparedStatement.executeUpdate();
        dbUtil.closeAll();
        return i > 0 ? true : false;
    }

    /**
     * 查询通用
     *
     * @param t
     * @param <T>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    @Override
    public <T> List selects(T t) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        List list = new ArrayList();
        StringBuffer buffer = new StringBuffer("select * from ");
        Class c = t.getClass();
        String simpleName = c.getSimpleName();
        buffer.append(simpleName);
        PreparedStatement preparedStatement = dbUtil.getPreparedStatement(buffer.toString());
        ResultSet result = preparedStatement.executeQuery();
        Field[] declaredFields = c.getDeclaredFields();
        Method[] methods = c.getMethods();
        int count = 0;
        Object obj = null;
        while (result.next()) {
            obj = c.newInstance();
            for (Method method : methods) {
                String name = method.getName();
                if (name.startsWith("set")) {
                    String cname = name.substring(3, name.length());
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes[0] == String.class) {
                        method.invoke(obj, result.getString(cname));
                    }
                    if (parameterTypes[0] == int.class) {
                        method.invoke(obj, result.getInt(cname));
                    }

                }

            }
            list.add(obj);
        }

        dbUtil.closeAll();
        return list;
    }

    /**
     * 查询单个
     *
     * @param <T>
     * @param <U>
     * @param t
     * @param u
     * @return
     */
    public <T, U> List select(T t, U u) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        StringBuffer buffer = new StringBuffer("select * from ");
        Class c = t.getClass();
        List list = new ArrayList();
        String simpleName = c.getSimpleName();
        buffer.append(simpleName).append(" where ");
        Field[] declaredFields = c.getDeclaredFields();
        buffer.append(declaredFields[0].getName()).append(" =?");
        PreparedStatement preparedStatement = dbUtil.getPreparedStatement(buffer.toString());
        preparedStatement.setObject(1,u);
        ResultSet result = preparedStatement.executeQuery();
        Method[] methods = c.getMethods();
        Object obj = null;
        while (result.next()) {
            obj = c.newInstance();
            for (Method method : methods) {
                String name = method.getName();
                if (name.startsWith("set")) {
                    String cname = name.substring(3, name.length());
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes[0] == String.class) {
                        method.invoke(obj, result.getString(cname));
                    }
                    if (parameterTypes[0] == int.class) {
                        method.invoke(obj, result.getInt(cname));
                    }
                }
            }
            list.add(obj);
        }
        dbUtil.closeAll();
        return  list;
    }
}