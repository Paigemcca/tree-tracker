package com.techelevator.model;

public class Tree {

    private int treeId;
    private int treeTag;
    private String treeDesc;
    private String treeHealth;
    private String treePoem;
    private String treeImage;

    public Tree(){

    }

    public Tree(int treeId, int treeTag, String treeDesc, String treeHealth, String treePoem, String treeImage) {
        this.treeId = treeId;
        this.treeTag = treeTag;
        this.treeDesc = treeDesc;
        this.treeHealth = treeHealth;
        this.treePoem = treePoem;
        this.treeImage = treeImage;
    }

    public int getTreeId() {
        return treeId;
    }

    public void setTreeId(int treeId) {
        this.treeId = treeId;
    }

    public int getTreeTag() {
        return treeTag;
    }

    public void setTreeTag(int treeTag) {
        this.treeTag = treeTag;
    }

    public String getTreeDesc() {
        return treeDesc;
    }

    public void setTreeDesc(String treeDesc) {
        this.treeDesc = treeDesc;
    }

    public String getTreeHealth() {
        return treeHealth;
    }

    public void setTreeHealth(String treeHealth) {
        this.treeHealth = treeHealth;
    }

    public String getTreePoem() {
        return treePoem;
    }

    public void setTreePoem(String treePoem) {
        this.treePoem = treePoem;
    }

    public String getTreeImage() {
        return treeImage;
    }

    public void setTreeImage(String treeImage) {
        this.treeImage = treeImage;
    }
}
