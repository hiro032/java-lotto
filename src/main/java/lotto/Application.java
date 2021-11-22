package lotto;

import lotto.domain.*;
import lotto.domain.numbergenerator.RandomLottoNumbersGenerator;
import lotto.exception.LottoNumberException;
import lotto.exception.LottoNumbersCountException;
import lotto.exception.MinimumAmountException;
import lotto.view.Input;
import lotto.view.Output;

import static lotto.utils.StringUtil.split;
import static lotto.view.Input.askBonusBall;

public class Application {
    public static void main(String[] args) {
        Money purchaseAmount = getPurchaseAount();

        Lottos lottos = LottosFactory.from(purchaseAmount, new RandomLottoNumbersGenerator());

        Output.printLottosCount(lottos);
        Output.printLottos(lottos);

        LottoNumber bonusBall = getBonusBall();
        WinningLotto winningLotto = getWinningNumber(bonusBall);

        WinningStatistics statistics = WinningStatistics.from(lottos, winningLotto);
        Output.printWinningStatistics(statistics);
    }

    private static LottoNumber getBonusBall() {
        int bonusBall = askBonusBall();
        try {
            return LottoNumber.from(bonusBall);
        } catch (LottoNumberException e) {
            Output.LottoNumberError();
            return getBonusBall();
        }
    }

    private static Money getPurchaseAount() {
        int purchaseAmount = Input.askPurchaseAmount();
        try {
            return Money.from(purchaseAmount);
        } catch (MinimumAmountException e) {
            Output.printMoneyError();
            return getPurchaseAount();
        }
    }

    private static WinningLotto getWinningNumber(LottoNumber bonusBall) {
        try {
            String winningNumber = Input.askWinningNumber();
            String[] split = split(winningNumber);
            return WinningLotto.from(split, bonusBall);
        } catch (LottoNumberException e) {
            Output.LottoNumberError();
            return getWinningNumber(bonusBall);
        } catch (LottoNumbersCountException e) {
            Output.WinningNumberCountError();
            return getWinningNumber(bonusBall);
        }
    }
}
