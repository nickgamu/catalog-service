package zw.co.pabuwe.polarbookshop.catalogservice.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import zw.co.pabuwe.polarbookshop.catalogservice.domain.Book;
import zw.co.pabuwe.polarbookshop.catalogservice.domain.BookRepository;

import java.util.List;

@Component
//@RequiredArgsConstructor
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        bookRepository.deleteAll();
        var book1 = Book.of("1234567891", "Quantic EMBA Guide", "Quantic", 60.00, "Quantic Pub");
        var book2 = Book.of("1234567892", "Cloud Native Spring in Action", "Thomas Vitale", 23.00, "Manning Press");
        bookRepository.saveAll(List.of(book1, book2));
    }

}
