package domain;

import exceptions.IllegalCarNameException;

public class CarName {
    
    private final String name;
    
    public CarName(String name) {
        assertLengthUnder5(name);
        this.name = name;
    }
    
    public CarName(CarName other) {
        this.name = other.name;
    }
    
    private void assertLengthUnder5(String name) {
        if (name.length() > 5) {
            throw new IllegalCarNameException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }
    
    public int length() {
        return name.length();
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj) {
        assert obj instanceof CarName;
        CarName other = (CarName) obj;
        return this.name.equals(other.name);
    }
}
