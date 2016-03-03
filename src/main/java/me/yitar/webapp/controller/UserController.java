package me.yitar.webapp.controller;

import me.yitar.webapp.dao.DatabaseHandlerSingleton;
import me.yitar.webapp.model.User;
import me.yitar.webapp.model.decorators.InternetFeed;
import me.yitar.webapp.model.decorators.NewsFeed;
import me.yitar.webapp.model.decorators.TwitterFeed;
import me.yitar.webapp.model.products.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Yitar on 2016/3/1.
 * Handles requests for the users handling.
 */
public class UserController implements IUserController {

    private static final Logger logger = LoggerFactory
            .getLogger(UserController.class);
    private User uh = new User();

    /**
     * Show the login page
     */
    public String login(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        return "login";
    }

    /**
     * Perform login by taking the username and password
     */
    public String login(String email, String password, Model model,
                        HttpSession session) {

        User u = new User();
        u = u.getRegisteredUser(email, password);
        if (null == u) {
            model.addAttribute("message", "Login Unsuccessful");
            return "login";
        } else {
            model.addAttribute("sessionUser", u);
            return "redirect:home";
        }
    }

    /**
     * Perform logout and redirect to login
     */
    public String logout(Model model, HttpSession session) {
        session.invalidate();
        model.asMap().clear();
        DatabaseHandlerSingleton.close();
        return "redirect:login";
    }

    /**
     * Show User registration page
     */
    public String register(Locale locale, Model model, HttpSession session) {
        logger.info("Welcome home! The client locale is {}.", locale);

        return "register";
    }

    /**
     * Register user by taking the inputs
     */
    public String registerUser(String firstName, String lastName,
                               String contactNumber, String email, String password, Model model,
                               HttpSession session) {
        User u = new User();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        u.setPassword(password);
        u.setContactNumber(contactNumber);
        u.setRole(0);
        int res = u.addUser(u);
        if (res != -1)
            model.addAttribute("message", "User Successfully Created");
        else
            model.addAttribute("message", "Failure in user creation");
        return "login";
    }

    /**
     * Show home view as per the user role
     */
    public String homeview(Locale locale, Model model, HttpSession session) {
        User u = (User) session.getAttribute("sessionUser");
        Feed feed =null;
        ArrayList<Feed> feeds =null;
        String department=null;
        switch (u.getRole()) {
            case 0:	//Role is User
                feed = new GenericFeed();
                feeds = feed.getFeeds(1);
                InternetFeed internetFeeds = new InternetFeed(feeds);
                feeds = internetFeeds.getFeeds(1);
                model.addAttribute("internetfeeds", feeds);

                feed = new GenericFeed();
                feeds= feed.getFeeds(1);
                NewsFeed newspaperFeeds = new NewsFeed(feeds);
                feeds = newspaperFeeds.getFeeds(1);
                model.addAttribute("newspaperfeeds", feeds);

                feed = new GenericFeed();
                feeds = feed.getFeeds(1);
                TwitterFeed twitterFeeds = new TwitterFeed(feeds);
                feeds = twitterFeeds.getFeeds(1);
                model.addAttribute("twitterfeeds", feeds);
                return "userview";
            case 1:  //Role is editor
                int dept = u.getDepartment();
                switch(dept){
                    case 1: 	//Department is Business
                        feed = new BusinessFeed();
                        department="Business";
                        break;
                    case 2: 	//Department is Entertainment
                        feed = new EntertainmentFeed();
                        department="Entertainment";
                        break;
                    case 3: 	//Department is Sports
                        feed = new SportsFeed();
                        department="Sports";
                        break;
                }
                feeds = feed.getFeeds(1);
                model.addAttribute("feeds", feeds);
                model.addAttribute("department",department);
                return "editorview";
            case 2:
                ArrayList<User> usersList = uh.getAllEditors();
                model.addAttribute("users", usersList);
                return "superuserview";
            default:
                model.addAttribute("message", "User Unauthorized");
        }
        return "login";
    }

    /**
     * Show add user form
     */
    public String addUser(Locale locale, Model model, HttpSession session) {
        logger.info("Welcome home! The client locale is {}.", locale);

        return "adduser";
    }

    /**
     * Add the user as per the given inputs
     */
    public String addUser(String firstName, String lastName,
                          String contactNumber, String email, String password,
                          int department, Model model, HttpSession session) {
        User u = new User();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        u.setPassword(password);
        u.setContactNumber(contactNumber);
        u.setRole(1);
        u.setDepartment(department);
        int res = u.addUser(u);
        if (res != -1)
            model.addAttribute("message", "User Successfully Created");
        else
            model.addAttribute("message", "Failure in user creation");

        return "redirect:home";
    }

    /**
     * Delete the specified user
     */
    public String deleteUser(int userId, Model model, HttpSession session) {

        int res = uh.deleteUser(userId);
        if (res != -1)
            model.addAttribute("message", "User Successfully deleted");
        else
            model.addAttribute("message", "Failure in user delete");

        return "redirect:home";
    }


}
