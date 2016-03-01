package me.yitar.webapp.model.products;

import me.yitar.webapp.dao.FeedDAO;

/**
 * Created by Yitar on 2016/3/1.
 */
public class BusinessFeed extends Feed {

    public BusinessFeed() {
        department = 1;
        fdao = new FeedDAO();
    }

    public BusinessFeed(int id) {
        this.id=id;
        department = 1;
        fdao = new FeedDAO();
    }

    public BusinessFeed(String headline) {
        department = 1;
        this.headline = headline;
        fdao = new FeedDAO();
    }

    public BusinessFeed(int id, String headline) {
        this.id=id;
        department = 1;
        this.headline = headline;
        fdao = new FeedDAO();
    }

}
