package org.example;

// Product Class
class Burger {
    private final String bread;
    private final String patty;
    private final boolean cheese;
    private final boolean lettuce;

    // Private constructor
    private Burger(Builder builder) {
        this.bread = builder.bread;
        this.patty = builder.patty;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
    }

    public String toString() {
        return "Burger with " + bread + ", " + patty +
                (cheese ? ", Cheese" : "") +
                (lettuce ? ", Lettuce" : "");
    }

    // Builder Class
    static class Builder {
        private String bread;
        private String patty;
        private boolean cheese;
        private boolean lettuce;

        public Builder setBread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder setPatty(String patty) {
            this.patty = patty;
            return this;
        }

        public Builder setCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder setLettuce(boolean lettuce) {
            this.lettuce = lettuce;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }
}
