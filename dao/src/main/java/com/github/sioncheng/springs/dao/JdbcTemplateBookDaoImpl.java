package com.github.sioncheng.springs.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.github.sioncheng.springs.dao.Constants.INSERT_BOOK_SQL;

@Repository("jdbcTemplateBookDao")
public class JdbcTemplateBookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addBook(Book book) {
        return jdbcTemplate.update(INSERT_BOOK_SQL, book.getName(),
                book.getISBN(),
                book.getPublication(),
                book.getPrice(),
                book.getAuthor());
    }
}
