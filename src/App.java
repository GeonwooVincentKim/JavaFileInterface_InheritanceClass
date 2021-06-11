import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class App {

    // randomRange 에서 getData 의 사용자 입력 값인 getValue 의 값을 가지고 와서 범위를 n1 ~ n2 만큼 지정한다.
    public static int randomRange(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }

    public static int arrayFrequency(List<Integer> randomList, int number) {
        int count = 0;

        for (int i = 0; i < randomList.size(); i++) {
            if (randomList.get(i) == number) {
                count++;
            }
        }
        return count;
    }

    public static boolean isContains(List<Integer> countArray, int temp) {
        boolean isContainValue = false;

        for (int i = 0; i < countArray.size(); i++) {
            if (countArray.get(i) == temp) {
                isContainValue = true;
                return isContainValue;
            }
        }

        return isContainValue;
    }

    public static String printArray(List<Integer> randArr, List<Integer> cntArr, int printCnt) {
        String setResult = "";

        // 랜덤 배열 출력
        // for (int i = 0; i < randArr.size(); i++) {
        // out.print(randArr.get(i) + " ");
        // setResult += randArr.get(i) + " ";
        // }
        // out.println();

        // for (int i = 0; i < cntArr.size(); i++) {
        // out.print(cntArr.get(i) + " - ");
        // }

        // out.println();
        // setResult += "\n";

        // 랜덤 배열 최빈도 수 내림차순 출력
        for (int i = 0; i < printCnt; i++) {
            out.print("#" + (i + 1) + " " + cntArr.get(i));
            out.println(" (" + arrayFrequency(randArr, cntArr.get(i)) + ")");
            setResult += "#" + (i + 1) + " " + cntArr.get(i) + "\n";
        }

        return setResult;
    }

    public static String printArray(int printT, List<Integer> sortCountList) {
        String getResult = "";

        for (int i = 0; i < printT; i++) {
            getResult += "#" + (i + 1) + " " + sortCountList.get(i) + "\n";
        }

        return getResult;
    }

    // getRandomArray 의 크기만큼 할당받은 randomList 의 값들은 main 으로부터 값을 넘겨받는다.
    // public static int[] getRandomList(int[] getRandomArray) {
    // int getRandomList[] = new int[getRandomArray.length];

    // for (int i = 0; i < getRandomList.length; i++) {
    // getRandomList[i] = (int) (Math.random() * (99 - 11 + 1)) + 11;
    // }

    // return getRandomList;
    // }

    // getRandomList 안에 있는 데이터들을 모두 List<Integer> 형의 randomList 에 삽입한다.
    // public static List<Integer> addRandomList(int[] getRandomArray) {
    // List<Integer> randomList = new ArrayList<Integer>();

    // getRandomList(getRandomArray, randomList);

    // return randomList;
    // }

    // countList 안에

    public static void main(String[] args) throws Exception {
        String result = ""; // 결과 값을 저장한다.
        int randomValue = 20; // 랜덤 길이는 20으로 설정한다.
        int printValue = 5; // 출력할 개수를 정한다.]

        String loopResult = ""; // RandomList 에서 뽑아온 값을 출력한다.
        // int countValue = 0; // 여러 번 나오는 수의 빈도 값을 저장한다.

        // int temp = 0;
        int[] temp = new int[randomValue]; // 랜덤 길이 만큼 숫자 범위 11 ~ 99의 랜덤 수(난수)들을 넘겨 받는다.
        List<Integer> randomList = new ArrayList<Integer>(); // temp 배열의 값을 저장한다.
        // List<Integer> randomList = Arrays.asList();
        // List<Integer> countList = new ArrayList<Integer>(); // 중복을 제거한 값들을 countArray
        // 에 저장한다.

        // 1. temp int[] 배열에 temp 하나씩 넘겨받은 값들을 temp 에 저장한다.
        temp = getTempData(temp);
        out.println();

        // 2. randomList 값을 getRandomList 로부터 넘겨받는다.
        randomList = getRandomList(temp);
        out.println(randomList);

        // 3. randomList 의 값을 printRandomList 로부터 넘겨받아 그 안에 있는 getRandomList 의 값들을 출력한다.
        loopResult = printRandomList(temp);
        out.println(loopResult);

        // 4. countList 의 값을 getCountList 로부터 넘겨받는다.
        List<Integer> countList = getCountList(temp);
        out.println(countList);

        // 5. sortCountList 의 List 값들을 불러온다.
        List<Integer> sortCountList = sortCountList(randomList, countList);
        out.println();

        // countList 출력
        result = loopResult + "\n" + printArray(printValue, sortCountList);
        out.println(result);
    }

    public static List<Integer> sortCountList(List<Integer> randomList, List<Integer> countList) {

        int currentValue = 0; // 반복되는 수의 빈도 수를 저장하는 countList 의 현재 값
        int currentCount = 0; // countList 의 빈도 수
        int nextValue = 0; // countList 의 다음 값
        int nextCount = 0; // countList 의 다음 빈도 수

        // countList 의 이전 값과 countList 의 다음 값을 각각 currentValue(currentCount),
        // nextValue(nextCount) 에 저장한 후, currentCount 의 값과 nextCount 을 비교해서 정렬한다.
        for (int i = 0; i < countList.size(); i++) {
            // for (int i = 0; i < temp.length; i++) {
            for (int j = i + 1; j < countList.size(); j++) {
                // out.print(temp[j] + " ");
                currentValue = countList.get(i);
                nextValue = countList.get(j);

                currentCount = arrayFrequency(randomList, currentValue);
                nextCount = arrayFrequency(randomList, nextValue);

                if (currentCount < nextCount) {
                    bubbleSort(countList, currentValue, nextValue, i, j);
                } else if (currentCount == nextCount && currentValue < nextValue) {
                    bubbleSort(countList, currentValue, nextValue, i, j);
                }
            }
        }

        return countList;
    }

    public static List<Integer> getCountList(int[] temp) {
        List<Integer> countList = new ArrayList<Integer>();
        out.print(countList);

        for (int i = 0; i < temp.length; i++) {
            if (!(isContains(countList, temp[i]))) {
                countList.add(temp[i]);
            }
        }

        return countList;
    }

    public static String printRandomList(int[] randomList) {
        String loopResult = "";

        for (int i = 0; i < randomList.length; i++) {
            loopResult += randomList[i] + " ";
        }

        return loopResult;
    }

    public static List<Integer> getRandomList(int[] temp) {
        List<Integer> randomList = new ArrayList<Integer>();
        out.println(randomList.toString());

        for (int i = 0; i < temp.length; i++) {
            randomList.add(temp[i]);
            out.print(randomList.get(i) + " ");
        }

        return randomList;
    }

    public static int[] getTempData(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            temp[i] = randomRange(11, 99);
            out.print(temp[i] + " ");
        }

        return temp;
    }

    public static void bubbleSort(List<Integer> countList, int currentValue, int nextValue, int i, int j) {
        int tempValue;
        tempValue = currentValue;
        countList.set(i, nextValue);
        countList.set(j, tempValue);
    }
}
