package baseball.system.util;

import baseball.console.Interactive;
import baseball.message.Message;
import baseball.system.enums.UserAction;
import baseball.validation.Condition;
import baseball.system.condition.IsOperationCodeCond;
import baseball.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class SystemUtil implements Interactive {

    private static final SystemUtil instance = new SystemUtil();
    private static final Validator validator = Validator.getInstance();

    private SystemUtil() {
    }

    public static SystemUtil getInstance() {
        return instance;
    }

    public void print(Message message) {
        System.out.println(message.getMessage());
    }

    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public UserAction getUserInput() {
        Integer input = Integer.parseInt(Console.readLine());

        List<Condition> conditions = List.of(
                IsOperationCodeCond.getInstance()
        );

        if (validator.isAnyConditionsFalse(input, conditions)) {
            throw new IllegalArgumentException();
        }

        return UserAction.getEnumByValue(input);
    }
}
