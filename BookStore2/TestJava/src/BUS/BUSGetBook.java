/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.ConnectionUnit;
import DTO.Book;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 *
 * @author Tik
 */
public class BUSGetBook {
    ConnectionUnit connect;

    public BUSGetBook() {
        connect = DAO.DAO.getDAO();
    }

    public ArrayList<Book> getBook(String condition, String orderBy) throws Exception {
        ResultSet result = connect.Select("book", condition, orderBy);
        ArrayList<Book> bookList = new ArrayList<>();
        while (result.next()) {
            Book book = new Book();
            book.setBook_id(result.getInt("book_id"));
            book.setAuthor_id(result.getInt("author_id"));
            book.setGenre_id(result.getInt("genre_id"));
            book.setTitle(result.getString("title"));
            book.setIsbn(result.getString("isbn"));
            book.setPublication_date(result.getString("publication_date"));
            book.setPrice(result.getInt("price"));
            book.setAvailable_quantity(result.getInt("available_quantity"));
            book.setImage(result.getString("ten_anh"));
            bookList.add(book);
        }
        return bookList;
    }

    public ArrayList<Book> getBook(String condition) throws Exception {
        return this.getBook(condition, null);
    }

    public ArrayList<Book> getBook() throws Exception {
        return this.getBook(null);
    }
    public ResultSet getTopBookSelled(int top, String startDate, String endDate) throws Exception{
        String query = "SELECT order_item.book_id as book_id, book.title as title, SUM(order_item.quantity) as quantity "
                + "FROM book, book_order, order_item "
                + "WHERE order_item.book_id = book.book_id AND order_item.order_id = book_order.order_id AND book_order.order_date BETWEEN '"+ startDate+"' AND '"+endDate+"' GROUP BY order_item.book_id ORDER BY SUM(order_item.quantity) DESC LIMIT 0,"+top;
        ResultSet result = this.connect.execute(query);
        return result;
    }
    public Book getBookById(int bookId) throws Exception{
        ArrayList<Book> bookList = this.getBook("book_id="+bookId);
        return bookList.get(0);
    }
    public String getBookTitleById(int bookId) throws Exception{
        return this.getBookById(bookId).getTitle();
    }
    public void updates(Book book) throws Exception{
        HashMap<String,Object> map = new HashMap<>();
        map.put("book_id", book.getBook_id());
        map.put("author_id", book.getAuthor_id());
        map.put("genre_id", book.getGenre_id());
        map.put("title", book.getTitle());
        map.put("isbn",book.getIsbn());
        map.put("publication_date", book.getPublication_date());
        map.put("price",book.getPrice());
        map.put("available_quantity", book.getAvailable_quantity());
        this.connect.Update("book", map, "book_id="+book.getBook_id());
        
    }
    public ArrayList<Book> getBookBySearchLikeIdName(String nameOrId) throws Exception{
        return this.getBook(" book_id LIKE '%"+nameOrId+"%' OR title LIKE '%"+nameOrId+"%'");
    }
}
