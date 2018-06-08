package com.techlabs.singleton.enums.test;
import com.techlabs.singleton.enums.*;

public class SingletonEnumTest {

	public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.INSTANCE;
        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());
    }
}
