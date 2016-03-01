package me.yitar.webapp.model;

import me.yitar.webapp.model.products.Feed;

import java.util.ArrayList;

/**
 * Created by Yitar on 2016/3/1.
 */
public interface IFeed {

    public ArrayList<Feed> getFeeds(int channel);
}
