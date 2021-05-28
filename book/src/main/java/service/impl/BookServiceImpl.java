package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import pojo.Book;
import pojo.Page;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();


        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=bookDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal=pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();


        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=bookDao.queryForPageTotalCountByPrice(min,max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal=pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);
        return page;
    }
}
