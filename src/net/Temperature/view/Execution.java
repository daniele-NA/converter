package net.Temperature.view;


import net.Temperature.controller.ActionManagement;

import java.io.IOException;

public class Execution {

    public static void main(String[] args) throws IOException {
        final ActionManagement ac=new ActionManagement();
        ac.start();
    }


}
