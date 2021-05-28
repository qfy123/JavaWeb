package test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.Test;
import pojo.Book;
import pojo.Page;

/**
 * @author QFY
 * @Description
 * @create 2021-05-19 16:14
 */
public class BookDaoTest {
    private BookDao bookDao=new BookDaoImpl();

    @Test
    public void addBook() {
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(1));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookDao.queryBooks()) {
            System.out.println(book);
        }

    }

    @Test
    public void queryFroPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForItems() {
        for (Book book : bookDao.queryForItems(8, Page.PAGE_SIZE)) {
            System.out.println(book);
        }

    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 50));
    }

    @Test
    public void queryForItemsByPrice() {
        for (Book book : bookDao.queryForItemsByPrice(3, Page.PAGE_SIZE, 10, 50)) {
            System.out.println(book);
        }

    }
}