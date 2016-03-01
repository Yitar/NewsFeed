package me.yitar.webapp.model.products;

import me.yitar.webapp.dao.FeedDAO;

/**
 * Created by Yitar on 2016/3/1.
 */
public class EntertainmentFeed extends Feed {

    public EntertainmentFeed() {
        department = 2;
        fdao = new FeedDAO();
    }

    public EntertainmentFeed(int id) {
        this.id=id;
        department = 2;
        fdao = new FeedDAO();
    }

    public EntertainmentFeed(String headline) {
        department = 2;
        this.headline = headline;
        fdao = new FeedDAO();
    }

    public EntertainmentFeed(int id, String headline) {
        this.id = id;
        department = 2;
        this.headline = headline;
        fdao = new FeedDAO();
    }

}