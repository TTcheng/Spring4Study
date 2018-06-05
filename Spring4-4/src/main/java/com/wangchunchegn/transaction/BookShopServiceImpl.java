package com.wangchunchegn.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookShopDao bookShopDao;
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,rollbackFor = {IOException.class,SQLException.class},
            noRollbackFor = ArithmeticException.class,
            readOnly = true, timeout = 30)
    public void purchase(String username, String isbn) {
        //1、获取书的单价
        double price = bookShopDao.findBookPriceByIsbn(isbn);
        //2、更新书的库存
        bookShopDao.updateBookStock(isbn);
        //3、更新用户余额
        bookShopDao.updateUserAcount(username,price);
    }
}
