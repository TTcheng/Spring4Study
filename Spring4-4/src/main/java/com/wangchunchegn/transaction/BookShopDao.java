package com.wangchunchegn.transaction;

public interface BookShopDao {
    //根据书号获取书的单价
    public double findBookPriceByIsbn(String isbn);
    //更新书的库存，使书号对应的库存减一
    public void updateBookStock(String isbn);
    //更新用户的账号余额：使username的balance-price
    public void updateUserAcount(String username,double price);
}
