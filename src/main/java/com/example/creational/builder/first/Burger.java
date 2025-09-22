package com.example.creational.builder.first;

public class Burger {
    private final int size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean lettuce;
    private final boolean tomato;

    public Burger(BurgerBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "size=" + size +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", lettuce=" + lettuce +
                ", tomato=" + tomato +
                '}';
    }

    public static class BurgerBuilder {
        private final int size;
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean lettuce = false;
        private boolean tomato = false;

        public BurgerBuilder(int size) {
            this.size = size;
        }

        public BurgerBuilder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public BurgerBuilder addLettuce() {
            this.lettuce = true;
            return this;
        }

        public BurgerBuilder addCheese() {
            this.cheese = true;
            return this;
        }

        public BurgerBuilder addTomato() {
            this.tomato = true;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }
}
