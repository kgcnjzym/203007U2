package com.xt.functions;

import com.xt.entity.Book;
import com.xt.service.BookService;
import com.xt.service.impl.BookServiceImpl;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/20 11:07
 * @since V1.00
 */
public class BookFunction {
    private static BookService service=new BookServiceImpl();
    public static Book getBook(Integer id){
        return service.getById(id);
    }
}
