package com.devskiller.httpclientcrud.model;

import java.util.Objects;

public class Character {

    private String name;
    private String race;
    private Details details;

    public Character() {
    }

    public Character(String name, String race) {
        this(name, race, null);
    }

    public Character(String name, String race, Details details) {
        this.name = name;
        this.race = race;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public Details getDetails() {
        return details;
    }

    public static class Details {

        private int level;
        private String server;
        private int gearLevel;

        public Details(int level, String server, int gearLevel) {
            this.level = level;
            this.server = server;
            this.gearLevel = gearLevel;
        }

        public Details() {
        }

        public int getLevel() {
            return level;
        }

        public String getServer() {
            return server;
        }

        public int getGearLevel() {
            return gearLevel;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Details details = (Details) o;
            return level == details.level &&
                    gearLevel == details.gearLevel &&
                    server.equals(details.server);
        }

        @Override
        public int hashCode() {
            return Objects.hash(level, server, gearLevel);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Character character = (Character) o;
        return name.equals(character.name) &&
                race.equals(character.race) &&
                Objects.equals(details, character.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, race, details);
    }
}