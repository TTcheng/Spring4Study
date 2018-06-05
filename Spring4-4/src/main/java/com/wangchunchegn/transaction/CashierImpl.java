package com.wangchunchegn.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CashierImpl implements Cashier {
    @Autowired
    private BookShopService bookShopService;
    @Transactional
    public void checkout(String username, List<String> isbns) {
        for (String isbn : isbns) {
            //bookShopService.purchase也是一个事务
            bookShopService.purchase(username, isbn);
        }
    }
}
