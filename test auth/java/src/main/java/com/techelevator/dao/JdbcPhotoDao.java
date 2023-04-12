package com.techelevator.dao;

import com.techelevator.model.Photo;
import com.techelevator.model.Tree;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPhotoDao implements PhotoDao{
    private static final String INSERT_PHOTO_SQL = "INSERT INTO photos (name, data) VALUES (?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public JdbcPhotoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertPhoto(String name, byte[] data) {
        jdbcTemplate.update(INSERT_PHOTO_SQL, new Object[] {name, data});
    }

    @Override
    public List<Photo> getAllPhotos(int treeTag) {
        List<Photo> results = new ArrayList<>();
        String sql = "SELECT * FROM photo WHERE tree_tag = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while(rowSet.next()){
            Photo photo = mapRowToPhoto(rowSet);
            results.add(photo);
        }
        return results;
    }

    @Override
    public Photo getOnePhoto(int treeTag) {
        Photo result = new Photo();
        String sql = "SELECT * FROM photo WHERE tree_tag = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, treeTag);

        while(rowSet.next()){
            Photo photo = mapRowToPhoto(rowSet);
            result = photo;
        }
        return result;
    }



    private Photo mapRowToPhoto(SqlRowSet rowSet) {
        Photo result = new Photo();

        result.setName(rowSet.getString("name"));
        result.setData((byte[]) rowSet.getObject("data"));
        return result;
    }
}
