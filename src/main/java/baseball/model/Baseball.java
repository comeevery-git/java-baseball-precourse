package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;

public class Baseball {
    HashSet<Integer> goldNumber;
    ArrayList<Integer> userNumber;
    ArrayList<Integer> computerNumber;
    int strike = 0;
    int ball = 0;
    boolean complete = false;
    String winner = "";

    public HashSet<Integer> getGoldNumber() {
        return goldNumber;
    }

    public void setGoldNumber(HashSet<Integer> goldNumber) {
        this.goldNumber = goldNumber;
    }

    public ArrayList<Integer> getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(ArrayList<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    public ArrayList<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(ArrayList<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}