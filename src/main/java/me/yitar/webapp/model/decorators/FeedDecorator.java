package me.yitar.webapp.model.decorators;

import me.yitar.webapp.model.IFeed;
import me.yitar.webapp.model.products.Feed;

import java.util.ArrayList;

/**
 * Created by Yitar on 2016/3/1.
 */
public abstract class FeedDecorator implements IFeed {

    /* (non-Javadoc)
     * @see com.se.newspaperapp.model.IFeed#getFeed()
     */
    @Override
    public abstract ArrayList<Feed> getFeeds(int channel);
}