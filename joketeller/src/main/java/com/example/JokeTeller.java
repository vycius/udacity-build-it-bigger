package com.example;

import java.util.Random;

public class JokeTeller {

    private static String[] jokes = new String[]{
            "A SQL query goes into a bar, walks up to two tables and asks, \"Can I join you?\"",
            "When your hammer is C++, everything begins to look like a thumb.",
            "Programming is like sex:\n" +
                    "One mistake and you have to support it for the rest of your life."
    };

    public static String getRandomJoke() {
        int selectedJokeIndex = new Random().nextInt(jokes.length);

        return jokes[selectedJokeIndex];
    }

}
