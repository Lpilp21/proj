package Backend.Models.ResponseModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBookResponse{
	private String website;
	private int pages;
	private String subTitle;
	private String author;
	private String publishDate;

	private String isbn;
	private String publisher;
	private String description;
	private String title;

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setPages(int pages){
		this.pages = pages;
	}

	public int getPages(){
		return pages;
	}

	public void setSubTitle(String subTitle){
		this.subTitle = subTitle;
	}

	public String getSubTitle(){
		return subTitle;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}
	public void setPublishDate(String publishDate){
		this.publishDate = publishDate;
	}
	public String getPublishDate(){
		return publishDate;
	}

	public void setIsbn(String isbn){
		this.isbn = isbn;
	}

	public String getIsbn(){
		return isbn;
	}

	public void setPublisher(String publisher){
		this.publisher = publisher;
	}

	public String getPublisher(){
		return publisher;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

}
