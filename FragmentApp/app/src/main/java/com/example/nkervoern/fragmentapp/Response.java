package com.example.nkervoern.fragmentapp;

/**
 * Created by nkervoern on 19/02/15.
 */
public class Response {

    class Sys {
        public String country;
    }

    class Main {
        public double temp;
    }

    class Wind {
        public double speed;
    }

    class Clouds {
        public String name;
        public int cod;
    }
}
