package me.yitar.webapp.model.creators;

import me.yitar.webapp.model.products.EntertainmentFeed;
import me.yitar.webapp.model.products.Feed;

/**
 * Created by Yitar on 2016/3/1.
 */
public class EntertainmentFeedEditor extends FeedEditor {

    @Override
    public Feed createFeed(String headline) {
        Feed feed = new EntertainmentFeed(headline);
        return feed;
    }

    @Override
    public Feed prepareDeleteFeed(int id) {
        Feed feed = new EntertainmentFeed(id);
        return feed;
    }

    @Override
    public Feed prepareEditFeed(int id, String headline) {
        Feed feed = new EntertainmentFeed(id, headline);
        return feed;
    }

}
