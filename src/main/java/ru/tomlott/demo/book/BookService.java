package ru.tomlott.demo.book;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> opt = bookRepository.findBookByName(book.getName());

        if (opt.isPresent()){
            throw new IllegalStateException("name is used");
        }

        bookRepository.save(book);
        System.out.println(book);
    }

    public void deleteBook(Long id) {
        if (bookRepository.existsById(id))
            bookRepository.deleteById(id);
        else
            throw new IllegalStateException("there is no such book");
    }

    @Transactional
    public void updateBook(Long id, Book book) {
        Book oldBook;
        if ((oldBook = bookRepository.findById(id).orElse(null)) == null){
            throw new IllegalStateException("There is no such book to update");
        }
        if (oldBook.getName().compareTo(book.getName()) == 0 && oldBook.getAuthor().compareTo(book.getAuthor()) == 0 )
            throw new IllegalStateException("This book is exist already");
        oldBook.setName(book.getName());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setPublisher(book.getPublisher());
        oldBook.setYear(book.getYear());
        oldBook.setPlot(book.getPlot());
    }
}
