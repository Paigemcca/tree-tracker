package com.example.tree.tracker.Dao;

import com.example.tree.tracker.model.Tree;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class JdbcTreeDao implements TreeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTreeDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}
    @Override
    public List<Tree> getAllTrees() {
        List<Tree> results = new ArrayList<Tree>();
        String sql = "SELECT * from tree";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while(rowSet.next()){
            Tree tree = mapRowToTree(rowSet);
            results.add(tree);
        }
        return results;
    }

    private Tree mapRowToTree(SqlRowSet rowSet) {
        Tree result = new Tree();

        result.setTreeTag(rowSet.getInt("tree_tag"));
        result.setTreeDesc(rowSet.getString("tree_desc"));
        result.setTreeHealth(rowSet.getString("tree_health"));
        result.setTreePoem(rowSet.getString("tree_poem"));
        //this might be the issue if it isnt working.
        result.setTreeImage(rowSet.getString("tree_image"));

        return result;
    }

    @Override
    public Tree getOneTree(int treeTag) {
        Tree result = new Tree();

        String sql = "SELECT * FROM tree WHERE tree_tag = ?";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, treeTag);

        while (rowSet.next()) {
            Tree tree = mapRowToTree(rowSet);
            result = tree;
        }
        return result;
    }

    @Override
    public void createTree(Tree newTree) {

        String sql = "INSERT INTO tree (tree_tag, tree_desc, tree_health, tree_poem, tree_image) VALUES(?,?,?,?,?);";

        try{
            jdbcTemplate.update(sql, newTree.getTreeTag(), newTree.getTreeDesc(), newTree.getTreeHealth(), newTree.getTreePoem(), newTree.getTreeImage());
        }
        catch (Error e){
            System.out.println("New tree not created");
        }
    }


//    @Override
//    public void uploadImage(int treeTag) {
//
//        String sql = "INSERT INTO tree (tree_image) VALUES(?) WHERE tree_tag = ?";
//
//        try {
//            jdbcTemplate.update(sql, Tree.getTreeTag())
//        }
//    }


}
