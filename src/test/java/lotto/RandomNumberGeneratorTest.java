package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.NumberGenerator;
import lotto.domain.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    private NumberGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new RandomNumberGenerator();
    }

    @Test
    @DisplayName("서로 다른 랜덤값이 6개 생성 된다.")
    void generateCountTest() {
        List<LottoNumber> numbers = generator.generate();

        assertThat(numbers.size()).isEqualTo(6);
    }

}