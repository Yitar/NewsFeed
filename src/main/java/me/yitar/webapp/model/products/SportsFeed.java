package me.yitar.webapp.model.products;

import me.yitar.webapp.dao.FeedDAO;

/**
 * Created by Yitar on 2016/3/1.
 */
public class SportsFeed extends Feed {

    public SportsFeed() {
        department = 3;
        fdao = new FeedDAO();
    }

    public SportsFeed(int id) {
        this.id=id;
        department = 3;
        fdao = new FeedDAO();
    }

    public SportsFeed(String headline) {
        department = 3;
        this.headline = headline;
        fdao = new FeedDAO();
    }

    public SportsFeed(int id,String headline) {
        this.id=id;
        department = 3;
        this.headline = headline;
        fdao = new FeedDAO();
    }

}
