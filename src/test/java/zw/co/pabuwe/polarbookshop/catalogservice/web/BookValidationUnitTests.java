package zw.co.pabuwe.polarbookshop.catalogservice.web;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import zw.co.pabuwe.polarbookshop.catalogservice.domain.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BookValidationUnitTests {

    private static Validator validator;

    @BeforeAll
    static void setup() {
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            validator = validatorFactory.getValidator();
        }
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var book = Book.of("1234567890", "Title", "Author", 9.99);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).isEmpty();
    }

    @Test
    void whenIsbnDefinedButIncorrectThenValidationFails() {
        var book = Book.of("a234567890", "Title", "Author", 9.99);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("The ISBN format must be valid.");
    }

}
