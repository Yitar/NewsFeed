package me.yitar.webapp.model.creators;

import me.yitar.webapp.model.products.BusinessFeed;
import me.yitar.webapp.model.products.Feed;

/**
 * Created by Yitar on 2016/3/1.
 */
public class BusinessFeedEditor extends FeedEditor {


    @Override
    public Feed createFeed(String headline) {
        Feed feed = new BusinessFeed(headline);
        return feed;
    }

    @Override
    public Feed prepareDeleteFeed(int id) {
        Feed feed = new BusinessFeed(id);
        return feed;
    }

    @Override
    public Feed prepareEditFeed(int id, String headline) {
        Feed feed = new BusinessFeed(id, headline);
        return feed;
    }
}
