package me.yitar.webapp.model.decorators;

import me.yitar.webapp.model.products.Feed;

import java.util.ArrayList;

/**
 * Created by Yitar on 2016/3/1.
 */
public class NewsFeed extends FeedDecorator {

    ArrayList<Feed> feeds = null;

    public NewsFeed(ArrayList<Feed> feedslist) {
        feeds = feedslist;
    }

    @Override
    public ArrayList<Feed> getFeeds(int channel) {
        for (Feed f : feeds) {
            f.setHeadline("Newspaper Feed:" + f.getHeadline());
        }
        return feeds;
    }

}