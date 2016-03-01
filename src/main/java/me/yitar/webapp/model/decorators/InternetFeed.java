package me.yitar.webapp.model.decorators;

import me.yitar.webapp.model.products.Feed;

import java.util.ArrayList;

/**
 * Created by Yitar on 2016/3/1.
 */
public class InternetFeed extends FeedDecorator {

    ArrayList<Feed> feeds = null;

    public InternetFeed(ArrayList<Feed> feedslist) {
        feeds = feedslist;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.se.newspaperapp.model.FeedDecorator#getFeed()
     */
    @Override
    public ArrayList<Feed> getFeeds(int channel) {
        for (Feed f : feeds) {
            f.setHeadline("Internet Feed:" + f.getHeadline());
        }
        return feeds;
    }

}
