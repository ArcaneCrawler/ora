package com.math.epidemic.Entities;

import java.awt.print.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.math.epidemic.Entities.Virus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class VirDAO {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<Virus> rowMapper = new RowMapper<Virus>() {

        @Override
        public Virus mapRow(ResultSet rs, int rowNum) throws SQLException {
            Virus virus = new Virus();
            virus.setId(rs.getLong("id"));
            virus.setName(rs.getString("name"));
            virus.setStrain(rs.getString("strain"));
            virus.setLethal(rs.getFloat("lethal"));
            virus.setInfluence(rs.getFloat("influence"));
            virus.setChance(rs.getFloat("chance"));
            virus.setEvol_rate(rs.getFloat("evol_rate"));
            virus.setCure_rate(rs.getFloat("cure_rate"));
            virus.setEndurance(rs.getFloat("endurance"));
            return virus;
        }

    };

/*
    public void insert(Virus virus) {
        String sql = "INSERT INTO book(title, comment, date_release, author_id, id) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, getPreparedStatementSetter(virus));
    }


    public void update(Book book) {
        String sql = "UPDATE book SET title=?, comment=?, date_release=?, author_id=? WHERE id=?";
        jdbcTemplate.update(sql, getPreparedStatementSetter(book));
    }


    public void delete(Book book) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", book.getId());
    }


    public Book getById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM book WHERE id=?", rowMapper, id);
    }

*/
    public List<Virus> getAll() {
        System.out.println("Вызвал ГетАлл");
        return jdbcTemplate.query("SELECT * FROM virus", rowMapper);

    }

/*
    public List<Book> findByCriteria(BookSearchCriteria criteria) {
        if (criteria.isEmpty()) {
            return getAll();
        }
        String sql = "SELECT * FROM book WHERE true";
        if (criteria.getComment() != null) {
            sql += " AND comment=:comment";
        }
        if (criteria.getTitle() != null) {
            sql += " AND title=:title";
        }
        if (criteria.getMaxDateRelease() != null) {
            sql += " AND date_release<:maxDateRelease";
        }
        if (criteria.getMinDateRelease() != null) {
            sql += " AND date_release>:minDateRelease";
        }
        if (criteria.getAuthorId() != null) {
            sql += " AND author_id=:authorId";
        }
        BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(criteria);
        return namedTemplate.query(sql, namedParameters, rowMapper);
    }

    private PreparedStatementSetter getPreparedStatementSetter(final Virus virus) {
        return new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                int i = 0;
                ps.setString(++i, virus.getTitle());
                ps.setString(++i, virus.getComment());
                ps.setDate(++i, new java.sql.Date(virus.getDateRelease().getTime()));
                ps.setInt(++i, virus.getAuthorId());
                ps.setInt(++i, virus.getId());
            }
        };
    }*/

}