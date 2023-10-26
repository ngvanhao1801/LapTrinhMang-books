package hunre.it.books.repository;

import hunre.it.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

	List<Book> findByTenDanhMucAndGiaSachLessThanEqual(String tenDanhMuc, float giaSach);

}
