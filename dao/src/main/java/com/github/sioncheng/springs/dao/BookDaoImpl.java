package com.github.sioncheng.springs.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDaoImpl implements BookDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addBook(Book book) {
        int rows = 0;

        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("insert into book(name,isbn,publication,price,author) values (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getISBN());
            preparedStatement.setString(3, book.getPublication());
            preparedStatement.setInt(4, book.getPrice());
            preparedStatement.setString(5, book.getAuthor());

            rows = preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rows;
    }
}
