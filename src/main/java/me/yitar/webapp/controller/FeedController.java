package me.yitar.webapp.controller;


import me.yitar.webapp.model.User;
import me.yitar.webapp.model.creators.BusinessFeedEditor;
import me.yitar.webapp.model.creators.EntertainmentFeedEditor;
import me.yitar.webapp.model.creators.FeedEditor;
import me.yitar.webapp.model.creators.SportsFeedEditor;
import me.yitar.webapp.model.products.Feed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by Yitar on 2016/3/1.
 */
public class FeedController implements IFeedController  {

    private static final Logger logger = LoggerFactory
            .getLogger(FeedController.class);

    /**
     * Display addfeed page to the editor.
     */
    public String addfeed(Locale locale, Model model, HttpSession session) {
        model.addAttribute("sessionUser",session.getAttribute("sessionUser"));
        return "addfeed";
    }

    /**
     * Add the feed given by the user.
     */
    public String addfeed(String headline, Model model, HttpSession session) {
        User u = (User) session.getAttribute("sessionUser");
        if (null == u) {
            return "login";
        } else {
            int dept = u.getDepartment();
            FeedEditor feedEditor = null;
            Feed feed = null;
            switch (dept) {
                case 1:
                    feedEditor = new BusinessFeedEditor();
                    feed = feedEditor.createFeed(headline);
                    break;
                case 2:
                    feedEditor = new EntertainmentFeedEditor();
                    feed = feedEditor.createFeed(headline);
                    break;
                case 3:
                    feedEditor = new SportsFeedEditor();
                    feed = feedEditor.createFeed(headline);
                    break;
                default:
                    return "login";
            }
            feed.addFeed();
            return "redirect:home";
        }
    }

    /**
     * delete the feed selected by the user.
     */
    public String deletefeed(int id, Model model, HttpSession session) {
        User u = (User) session.getAttribute("sessionUser");
        if (null == u) {
            return "login";
        } else {
            int dept = u.getDepartment();
            FeedEditor feedEditor = null;
            Feed feed = null;
            switch (dept) {
                case 1:
                    feedEditor = new BusinessFeedEditor();
                    break;
                case 2:
                    feedEditor = new EntertainmentFeedEditor();
                    break;
                case 3:
                    feedEditor = new SportsFeedEditor();
                    break;
                default:
                    return "login";
            }
            feed = feedEditor.prepareDeleteFeed(id);
            feed.deleteFeed();
            return "redirect:home";
        }
    }


    /**
     * display edit feed page to hte editor.
     */
    public String editfeed(int id, Model model, HttpSession session) {
        User u = (User) session.getAttribute("sessionUser");
        if (null == u) {
            return "login";
        } else {
            int dept = u.getDepartment();
            FeedEditor feedEditor = null;
            Feed feed = null;
            switch (dept) {
                case 1:
                    feedEditor = new BusinessFeedEditor();
                    break;
                case 2:
                    feedEditor = new EntertainmentFeedEditor();
                    break;
                case 3:
                    feedEditor = new SportsFeedEditor();
                    break;
                default:
                    return "login";
            }
            feed = feedEditor.prepareDeleteFeed(id);
            feed = feed.getFeed();
            model.addAttribute("feed",feed);
            model.addAttribute("sessionUser",session.getAttribute("sessionUser"));
            return "editfeed";
        }

    }

    /**
     * update the feed based on the input given by the editor.
     */
    public String editFeed(int id, String headline, Model model,
                           HttpSession session) {
        User u = (User) session.getAttribute("sessionUser");
        if (null == u) {
            return "login";
        } else {
            int dept = u.getDepartment();
            FeedEditor feedEditor = null;
            Feed feed = null;
            switch (dept) {
                case 1:
                    feedEditor = new BusinessFeedEditor();
                    break;
                case 2:
                    feedEditor = new EntertainmentFeedEditor();
                    break;
                case 3:
                    feedEditor = new SportsFeedEditor();
                    break;
                default:
                    return "login";
            }
            feed = feedEditor.prepareEditFeed(id, headline);
            feed.editFeed();
            return "redirect:home";
        }
    }

}
