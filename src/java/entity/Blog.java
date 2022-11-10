/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author admin
 */
public class Blog {

    private int BlogID;
    private String BlogName;
    private String BlogDescription;
    private String BlogLink;
    private String BlogImage;

    public Blog() {
    }

    public Blog(int BlogID, String BlogName, String BlogDescription, String BlogLink, String BlogImage) {
        this.BlogID = BlogID;
        this.BlogName = BlogName;
        this.BlogDescription = BlogDescription;
        this.BlogLink = BlogLink;
        this.BlogImage = BlogImage;
    }

    public Blog(String BlogName, String BlogDescription, String BlogLink, String BlogImage) {
        this.BlogName = BlogName;
        this.BlogDescription = BlogDescription;
        this.BlogLink = BlogLink;
        this.BlogImage = BlogImage;
    }

    public int getBlogID() {
        return BlogID;
    }

    public void setBlogID(int BlogID) {
        this.BlogID = BlogID;
    }

    public String getBlogName() {
        return BlogName;
    }

    public void setBlogName(String BlogName) {
        this.BlogName = BlogName;
    }

    public String getBlogDescription() {
        return BlogDescription;
    }

    public void setBlogDescription(String BlogDescription) {
        this.BlogDescription = BlogDescription;
    }

    public String getBlogLink() {
        return BlogLink;
    }

    public void setBlogLink(String BlogLink) {
        this.BlogLink = BlogLink;
    }

    public String getBlogImage() {
        return BlogImage;
    }

    public void setBlogImage(String BlogImage) {
        this.BlogImage = BlogImage;
    }

    @Override
    public String toString() {
        return "Blog{" + "BlogID=" + BlogID + ", BlogName=" + BlogName + ", BlogDescription=" + BlogDescription + ", BlogLink=" + BlogLink + ", BlogImage=" + BlogImage + '}';
    }
    
}
