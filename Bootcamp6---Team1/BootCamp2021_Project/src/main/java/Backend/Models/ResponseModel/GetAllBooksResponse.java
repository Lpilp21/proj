package Backend.Models.ResponseModel;

import java.util.List;

public class GetAllBooksResponse{
	private List<GetBookResponse> books;

	public void setBooks(List<GetBookResponse> books){
		this.books = books;
	}

	public List<GetBookResponse> getBooks(){
		return books;
	}
}