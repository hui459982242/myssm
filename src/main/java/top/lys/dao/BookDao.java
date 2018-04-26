package top.lys.dao;

import org.apache.ibatis.annotations.Param;
import top.lys.entity.Book;

import java.util.List;

public interface BookDao {
    Book queryById(long id);
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);
    int addBook(Book book);
    int updateBook(Book book);
    int deleteBookById(long id);
}
