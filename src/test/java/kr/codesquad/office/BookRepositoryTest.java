package kr.codesquad.office;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("오브젝트 제목의 책 엔터티가 잘 생성되는지 테스트")
    @Transactional
    void createBook() {
        var title = "오브젝트";
        Book book = Book.builder().title(title).build();
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
        assertThat(book.getTitle()).isEqualTo(title);
    }

    @Test
    @DisplayName("타이틀 검색으로 관련 도서를 검색할 수 있어야 한다.")
    @Transactional
    void findBookByTitle() {
        String[] titles = {"오브젝트의 이해", "오브젝트", "드래곤볼"};
        for (var title : titles) {
            var book = Book.builder().title(title).build();
            bookRepository.save(book);
        }
        var findBooks = bookRepository.findBooksByTitleLike("%오브젝트%");
        assertThat(findBooks).isNotNull();
        assertThat(findBooks.size()).isEqualTo(2);
        assertThat(findBooks.get(0).getTitle()).isEqualTo(titles[0]);
        assertThat(findBooks.get(1).getTitle()).isEqualTo(titles[1]);
    }

}