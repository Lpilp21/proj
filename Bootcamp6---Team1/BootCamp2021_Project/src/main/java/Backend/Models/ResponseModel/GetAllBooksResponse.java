package Backend.Models.ResponseModel;

import java.util.List;

public class GetAllBooksResponse{
	private List<BooksItem> books;

	public void setBooks(List<BooksItem> books){
		this.books = books;
	}

	public List<BooksItem> getBooks(){
		return books;
	}
}