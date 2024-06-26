package view;

import org.kokodak.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static view.InputValidate.isDuplicateCarName;
import static view.InputValidate.isValidCarName;

public class InputView {

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return splitCarNames(Console.readLine());
    }

    public static List<String> splitCarNames(String carNames) {
        List<String> list;
        list = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toList();
        isValidCarName(list);
        isDuplicateCarName(list);
        return list;
    }
//
//    private static void isValidCarName(List<String> carList) {
//        for (String s : carList) {
//            isValidCarNameLength(s);
//        }
//    }
//
//    private static void isValidCarNameLength(String carName) {
//        if (carName.length() < 1 || carName.length() > 5) {
//            ExceptionMessage.isInvalidNameLength();
//            throw new IllegalArgumentException();
//        }
//    }
//
//    private static void isDuplicateCarName(List<String> carList) {
//        HashSet<String> names = new HashSet<>(carList);
//        System.out.println("set size = " + names.size());
//        System.out.println("list size = " + carList.size());
//        System.out.println();
//        if (names.size() != carList.size()) {
//            ExceptionMessage.isDuplicateCarName();
//            throw new IllegalArgumentException();
//        }
//    }


    public static int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String str = Console.readLine();
        int tryCount = Integer.parseInt(str);
        isValidTryCount(tryCount);
        return tryCount;
    }

    private static void isValidTryCount(int tryCount) {
        if (tryCount < 1) {
            ExceptionMessage.isInvalidTryCount();
            throw new IllegalArgumentException();
        }
    }

}
