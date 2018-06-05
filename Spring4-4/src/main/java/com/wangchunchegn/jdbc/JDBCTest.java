package com.wangchunchegn.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    public ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
    }
    @Test
    public void testNamedParameterJdbcTemplate(){
        String sql = "INSERT INTO \"Student\"(id,name,age,department) VALUES (:id,:name,:age,:deptid)";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("id","12");
        paraMap.put("name","Jack");
        paraMap.put("age",35);
        paraMap.put("deptid",1);
        namedParameterJdbcTemplate.update(sql,paraMap);
    }

    /**
     * 注意，调用queryForList方法不能得到实体类的集合，而需要调用带rowMapper参数的query方法
     */
    @Test
    public void testQueryForList() {
        //query list1
        String sql1 = "SELECT * FROM public.\"Student\" WHERE age > ?";
        List result = jdbcTemplate.queryForList(sql1, 21);
        System.out.println(result);
        //Object list
        String sql2 = "SELECT * FROM public.\"Student\" WHERE age > ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        List<Student> students = jdbcTemplate.query(sql2, rowMapper,21);
        System.out.println(students);
    }

    /**
     * 从数据库中获取一条记录，实际得到对应的一个对象
     */
    @Test
    public void testQueryForObject() {
        String sql = "SELECT id,name,age,department FROM public.\"Student\" WHERE id=?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        Student student = jdbcTemplate.queryForObject(sql, rowMapper, "1");
        System.out.println(student);
    }

    /**
     * 执行Insert ，Update， Delete
     */
    @Test
    public void testUpdate() {
        String sql = "UPDATE \"Student\" SET age=? WHERE id=?";
        jdbcTemplate.update(sql, 15, "1");
    }

    /**
     * 批量更新
     */
    @Test
    public void testBatchUpdate() {
        //插入多条记录
        String sql = "INSERT INTO \"Student\"(id,name,age) VALUES (?,?,?)";
        List<Object[]> sqlArgsList = new ArrayList<Object[]>();
        sqlArgsList.add(new Object[]{"4", "AA", 31});
        sqlArgsList.add(new Object[]{"5", "BB", 32});
        sqlArgsList.add(new Object[]{"6", "CC", 33});
        sqlArgsList.add(new Object[]{"7", "DD", 34});
        jdbcTemplate.batchUpdate(sql, sqlArgsList);
    }
    //test Dao
    @Test
    public void  testStudentDao() throws InterruptedException {
        StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");
        Student student = studentDao.get("1");
        System.out.println(student);
    }
    @Test
    public void testDepartmentDao(){
        DepartmentDao departmentDao = (DepartmentDao) ctx.getBean("departmentDao");
        Department department = departmentDao.get(1);
        System.out.println(department);
    }
    //datasource
    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

}
