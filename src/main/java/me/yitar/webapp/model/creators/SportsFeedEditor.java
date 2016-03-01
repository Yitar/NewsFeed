package me.yitar.webapp.model.creators;

import me.yitar.webapp.model.products.Feed;
import me.yitar.webapp.model.products.SportsFeed;

/**
 * Created by Yitar on 2016/3/1.
 */
public class SportsFeedEditor extends FeedEditor {

    @Override
    public Feed createFeed(String headline) {
        Feed feed = new SportsFeed(headline);
        return feed;
    }

    @Override
    public Feed prepareDeleteFeed(int id) {
        Feed feed = new SportsFeed(id);
        return feed;
    }

    @Override
    public Feed prepareEditFeed(int id, String headline) {
        Feed feed = new SportsFeed(id,headline);
        return feed;
    }

}
