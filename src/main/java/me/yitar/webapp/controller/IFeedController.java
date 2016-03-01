package me.yitar.webapp.controller;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Created by Yitar on 2016/3/1.
 */
public interface IFeedController {

    /**
     * Display addfeed page to the editor.
     */
    public String addfeed(Locale locale, Model model, HttpSession session);

    /**
     * Add the feed given by the user.
     */
    public String addfeed(String headline, Model model, HttpSession session);

    /**
     * delete the feed selected by the user.
     */
    public String deletefeed(int id, Model model, HttpSession session);

    /**
     * diaplay edit feed page to hte editor.
     */
    public String editfeed(int id, Model model, HttpSession session);

    /**
     * update the feed based on the input given by the editor.
     */
    public String editFeed(int id, String headline, Model model,
                           HttpSession session);

}
