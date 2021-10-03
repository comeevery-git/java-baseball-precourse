package baseball;

import baseball.model.Baseball;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        System.out.println("게임시작!");

        gameStart();

        System.out.println("게임종료!");
    }

    public static void gameStart() {
        int maxSize = 3;
        HashSet<Integer> goldNumber = getRandomNumber(maxSize);

        Baseball baseball = new Baseball();
        baseball.setGoldNumber(goldNumber);
        baseball.setComplete(false);

        // 게임 완료되기 전까지 실행
        while(!baseball.isComplete()) {
            System.out.println("숫자를 입력해주세요 : ");

            String answer = Console.readLine();

            // 1-9 숫자만 입력했는 지 확인
            if(!numberCheck(answer)) {
                System.out.println("[ERROR] 1에서 9까지의 숫자만 입력하실 수 있습니다.");
                continue;
            }

            // 사용자 번호 확인
            char[] number = answer.trim().toCharArray();
            ArrayList<Integer> userNumber = new ArrayList<>();
            for(int i=0; maxSize>i; i++) {
                userNumber.add(Integer.parseInt(String.valueOf(number[i])));
            }
            baseball.setUserNumber(userNumber);

            // 컴퓨터 번호 확인
            ArrayList<Integer> computerNumber = new ArrayList<>();
            for(int i=0; maxSize>i; i++) {
                computerNumber.add(Randoms.pickNumberInRange(1, 9));
            }
            baseball.setComputerNumber(computerNumber);

            // 유효 번호 확인
            baseball = getCount(baseball);
            System.out.println(String.format("%d스트라이크 %d볼", baseball.getStrike(), baseball.getBall()));

            // 모든 숫자 일치 시
            if(baseball.isComplete()) {
                System.out.println("숫자야구의 지배자 "+baseball.getWinner()+"님!");
                System.out.println(maxSize +"개의 숫자를 모두 맞히셨습니다! 게임 끝");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                // TODO : 게임 플래그 구현(새 게임 시작 1, 게임종료 2)
                break;
            }

        }
    }

    // 무작위 숫자 생성
    private static HashSet<Integer> getRandomNumber(int maxSize){
        HashSet<Integer> result = new HashSet<>();
        while(maxSize > result.size()) {
            result.add(Randoms.pickNumberInRange(1, 9));
        }
        System.out.println("###result : "+result);
        return result;
    }

    // 숫자 체크
    private static boolean numberCheck(String answer){
        if(answer.trim().length() == 3) {
            String regex = "^[1-9]*$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(answer);

            return matcher.find();
        }
        System.out.println("###numberCheck 실패");

        return false;
    }

    // 스트라이크 또는 볼 체크
    private static Baseball getCount(Baseball baseball){
        int strikeCount = 0;
        int ballCount = 0;
        for(int i=0; baseball.getGoldNumber().size()>=i; i++){
            // TODO : 스트라이크 & 볼 숫자 체크(사용자, 컴퓨터)
        }

        System.out.println("###getCount ok : "+baseball.getGoldNumber());
        System.out.println("###getCount user : "+baseball.getUserNumber());
        System.out.println("###getCount computer : "+baseball.getComputerNumber());

        return baseball;
    }

}
