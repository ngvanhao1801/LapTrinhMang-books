package hunre.it.books.service;

import hunre.it.books.entity.Book;
import hunre.it.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

	@Autowired
	private BookRepository bRepo;

	public void save(Book l) {
		bRepo.save(l);
	}

	public List<Book> getAllBook() {
		return bRepo.findAll();
	}

	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}

	public void deleteById(int id) {
		bRepo.deleteById(id);
	}

	public List<Book> searchBook(String tenDanhMuc, float giaSach) {
		return bRepo.findByTenDanhMucAndGiaSachLessThanEqual(tenDanhMuc, giaSach);
	}

}
