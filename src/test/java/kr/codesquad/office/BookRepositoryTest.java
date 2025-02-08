package kr.codesquad.office;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("책 엔터티가 잘 생성되는지 테스트")
    void createBook() {
        Book book = Book.builder().title("오브젝트").build();
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

}