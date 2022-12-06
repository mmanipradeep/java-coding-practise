package com.program.generics;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        Parrent p = new Parrent();
        SecondChild sc = new SecondChild();
        FirstChild fc = new FirstChild();

        List<? extends Parrent> list = new ArrayList<>();
//        list.add(p); //- should not work
//        list.add(sc); //= work
//        list.add(fc); //= work
    }
}
