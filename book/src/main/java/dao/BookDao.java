package dao;

import pojo.Book;

import java.util.List;

public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForItems(Integer begin,Integer size);

    Integer queryForPageTotalCountByPrice(int min,int max);

    List<Book> queryForItemsByPrice(int begin, int pageSize, int min, int max);
}
