package com.wangchunchegn.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements BookShopDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public double findBookPriceByIsbn(String isbn) {
        String sql = "SELECT price FROM public.book WHERE isbn=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    public void updateBookStock(String isbn) {
        String sql = "UPDATE book_stock SET stock = stock - 1 WHERE isbn=?";
        jdbcTemplate.update(sql,isbn);
    }

    public void updateUserAcount(String username, double price) {
        String sql = "UPDATE account SET balance = balance - ? WHERE username=?";
        jdbcTemplate.update(sql,price,username);
    }
}
