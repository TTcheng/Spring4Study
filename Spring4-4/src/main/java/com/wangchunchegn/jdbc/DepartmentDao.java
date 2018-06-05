package com.wangchunchegn.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DepartmentDao extends JdbcDaoSupport {
    @Autowired
    public void setDataSource2(DataSource dataSource) {
        setDataSource(dataSource);
    }
    public Department get(int i) {
        String sql = "SELECT id,name FROM public.\"Department\" WHERE id=?";
        RowMapper<Department> rowMapper = new BeanPropertyRowMapper<Department>(Department.class);
        Department department = getJdbcTemplate().queryForObject(sql, rowMapper, i);
        return department;
    }
}
