package com.github.sioncheng.springs.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.github.sioncheng.springs.dao.Constants.INSERT_BOOK_SQL;

public class BookDaoImpl implements BookDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addBook(Book book) {
        int rows = 0;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL);

            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getISBN());
            preparedStatement.setString(3, book.getPublication());
            preparedStatement.setInt(4, book.getPrice());
            preparedStatement.setString(5, book.getAuthor());

            rows = preparedStatement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (null != connection) {
                try {
                    connection.close();
                } catch (Exception ex2) {
                    ex2.printStackTrace();
                }
            }
        }

        return rows;
    }
}
