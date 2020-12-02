package lotto;

import lotto.domain.Generator;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorTest {

    private Generator generator;

    @BeforeEach
    public void setUp() {
        generator = new Generator();
    }

    @Test
    @DisplayName("수량만큼 로또를 생성한다")
    public void generate_lotto_ticket_list() {
        List<LottoTicket> lottoTickets = generator.generateLottoTickets(3);
        assertThat(lottoTickets.size()).isEqualTo(3);
    }
}
