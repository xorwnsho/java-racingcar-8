package racingcar.domain;

public class Car {
    private static final int MAX_MOVE_LENGTH = 5;
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name){
        String trimmedName = name.trim();
        validateName(trimmedName);
        this.name = trimmedName;
    }

    // 3번 기능을 Car 클래스로 리펙토링
    private void validateName(String name) {
        if(name.isEmpty() || name.length() > MAX_MOVE_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    // ----- 5번 기능: 전진 또는 멈춤 ------
    public void move(int randomNumber){
        if(randomNumber >= MOVE_CONDITION){
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
