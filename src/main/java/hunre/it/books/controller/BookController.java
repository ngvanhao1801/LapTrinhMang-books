package hunre.it.books.controller;

import hunre.it.books.entity.Book;
import hunre.it.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class BookController {

  @Autowired
  private BookService service;

  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/book_register")
  public String bookRegister() {
    return "book-register";
  }

  @GetMapping("/available_books")
  public ModelAndView getAllBook() {
    List<Book> list = service.getAllBook();

    Collections.sort(list, Comparator.comparing(Book::getGiaSach));

    // Bổ sung cột tình trạng
    for (Book book : list) {
      if (book.getGiaSach() >= 1000) {
        book.setTinhTrang("Cao");
      } else {
        book.setTinhTrang("Thấp");
      }
    }

    return new ModelAndView("book-list", "book", list);
  }

  @PostMapping("/save")
  public String addBook(@ModelAttribute Book l) {
    service.save(l);
    return "redirect:/available_books";
  }

  @RequestMapping("/editBook/{id}")
  public String editBook(@PathVariable("id") int id, Model model) {
    Book l = service.getBookById(id);
    model.addAttribute("book", l);
    return "book-edit";
  }

  @RequestMapping("/deleteBook/{id}")
  public String deleteBook(@PathVariable("id") int id) {
    service.deleteById(id);
    return "redirect:/available_books";
  }

  @GetMapping("/search")
  public String searchBook(@RequestParam("tenDanhMuc") String tenDanhMuc,
                               @RequestParam("giaSach") float giaSach,
                               Model theModel) {
    List<Book> books = service.searchBook(tenDanhMuc, giaSach);
    theModel.addAttribute("book", books);
    return "search-book";
  }

}
