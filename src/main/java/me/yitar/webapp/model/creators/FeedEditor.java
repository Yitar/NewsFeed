package me.yitar.webapp.model.creators;

import me.yitar.webapp.model.User;
import me.yitar.webapp.model.products.Feed;

/**
 * Created by Yitar on 2016/3/1.
 */
public abstract class FeedEditor {
    User editor;

    public abstract Feed createFeed(String headline);

    public abstract Feed prepareDeleteFeed(int id);

    public abstract Feed prepareEditFeed(int id, String headline);

    public void publishFeed(int id, String headline) {
        Feed feed = createFeed(headline);
        feed.addFeed();
    }

}
