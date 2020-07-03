package com.wiktorkowalczyk.bookrest.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    public DatabaseSeeder() {
    }

    @Override
    public void run(String... args) {
    }


}
