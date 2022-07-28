package zw.co.pabuwe.polarbookshop.catalogservice.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import zw.co.pabuwe.polarbookshop.catalogservice.domain.BookNotFoundException;
import zw.co.pabuwe.polarbookshop.catalogservice.domain.BookService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void whenGetBookNotExistingThenReturn404() throws Exception {
        String isbn = "2233445566";
        given(bookService.viewBookDetails(isbn))
                .willThrow(BookNotFoundException.class);
        mockMvc
                .perform(get("/book/" + isbn))
                .andExpect(status().isNotFound());
    }

}
