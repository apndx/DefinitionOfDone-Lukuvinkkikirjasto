/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReadMe.dao;

import ReadMe.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author bisi
 */
public class InMemoryDao implements DaoManager {

    private List<ReadingTip> videos;
    private List<ReadingTip> books;
    private List<ReadingTip> news;
    private List<ReadingTip> articles;
    private List<ReadingTip> blogs;

    /**
     * In memory 'database' that can be used for testing. Creates new lists of
     * bookmark objects, and adds new objects in them.
     *
     */
    public InMemoryDao() {
        this.videos = new ArrayList<>();
        this.books = new ArrayList<>();
        this.news = new ArrayList<>();
        this.articles = new ArrayList<>();
        this.blogs = new ArrayList<>();
        setInMemoryObjects();
    }

    /**
     * Empty constructor for "not found" testing
     * @param empty if the InMemoryDao is created as an empty one
     */
    public InMemoryDao(boolean empty) {
        this.videos = new ArrayList<>();
        this.books = new ArrayList<>();
        this.news = new ArrayList<>();
        this.articles = new ArrayList<>();
        this.blogs = new ArrayList<>();
    }

    private void setInMemoryObjects() {

        Date date = new Date(2018, 9, 13);

        // Create entries 
        videos.add(new Video("hackerdashery", "P vs. NP and the Computational Complexity Zoo",
                "https://www.youtube.com/watch?v=YX40hbAHx3s&frags=pl%2Cwn", "P js NP erot", 2014));
        books.add(new Book("hackerdashery1", "P vs. NP and the Computational Complexity Zoo1", "1234", "P js NP erot", 2014));
        news.add(new News("hackerdashery2", "P vs. NP and the Computational Complexity Zoo2", "https://www.youtube.com/watch?v=YX40hbAHx3s&frags=pl%2Cwn", "P js NP erot", "hmm", 2014));
        articles.add(new Article("hackerdashery3", "P vs. NP and the Computational Complexity Zoo3", "https://www.youtube.com/watch?v=YX40hbAHx3s&frags=pl%2Cwn", "P js NP erot", "hmm", 2014));
        blogs.add(new Blog("hackerdashery4", "P vs. NP and the Computational Complexity Zoo4", "https://www.youtube.com/watch?v=YX40hbAHx3s&frags=pl%2Cwn", "P js NP erot", 2014));

    }

    /**
     * Returns all wanted bookmarks as a List.
     *
     * Inputs = "all", "video", "book", "news", "article", "blog".
     * @param type of the objects listed
     * @return List<ReadingTip>
     */
    @Override
    public List<ReadingTip> listByType(String type) {
        ArrayList<ReadingTip> list = new ArrayList<>();
        switch (type) {
            case "all":
                videos.forEach(a -> list.add(a));
                books.forEach(a -> list.add(a));
                news.forEach(a -> list.add(a));
                articles.forEach(a -> list.add(a));
                blogs.forEach(a -> list.add(a));
                return list;
            case "video":
                return videos;
            case "book":
                return books;
            case "news":
                return news;
            case "article":
                return articles;
            case "blog":
                return blogs;
            default:
                return null;
        }
    }

    /**
     * Returns all ReadingTips matching keyword as a List.
     *
     * @param keyword substring of author, title or year
     * @return
     */
    @Override
    public List<ReadingTip> listByKeyword(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        List<ReadingTip> all = listByType("all");
        return all.stream()
                .filter(t -> {
                    String tipAsString = t.toString().toLowerCase();
                    return tipAsString.contains(lowerKeyword);
                })
                .collect(Collectors.toList());
    }

    public List<ReadingTip> getVideos() {
        return videos;
    }

    public List<ReadingTip> getBooks() {
        return books;
    }

    public List<ReadingTip> getNews() {
        return news;
    }

    public List<ReadingTip> getArticles() {
        return articles;
    }

    public List<ReadingTip> getBlogs() {
        return blogs;
    }

    @Override
    public void addVideo(Video video) {
        this.videos.add(video);
    }

    @Override
    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public void addNews(News news) {
        this.news.add(news);
    }

    @Override
    public void addArticle(Article article) {
        this.articles.add(article);
    }

    @Override
    public void addBlog(Blog blog) {
        this.blogs.add(blog);
    }

    @Override
    public boolean markAsRead(ReadingTip tip) {
        if (tip == null) {
            return false;
        }
        ReadingTip toBeMarked = findFromList(tip);
        if (toBeMarked == null) {
            return false;
        }

        toBeMarked.setChecked(true);
        toBeMarked.setDate_checked(new Date());
        return true;
    }

    private ReadingTip findFromList(ReadingTip tip) {
        switch (tip.getClass().getName().replace("ReadMe.domain.", "")) {
            case "Video":
                for (ReadingTip item : videos) {
                    if (item.equals(tip)) return item;
                }
            case "Book":
                for (ReadingTip item : books) {
                    if (item.equals(tip)) return item;
                }
            case "News":
                for (ReadingTip item : news) {
                    if (item.equals(tip)) return item;
                }
            case "Article":
                for (ReadingTip item : articles) {
                    if (item.equals(tip)) return item;
                }
            case "Blog":
                for (ReadingTip item : blogs) {
                    if (item.equals(tip)) return item;
                }
        }
        return null;
    }
}
