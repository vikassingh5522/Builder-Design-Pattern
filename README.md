# Builder-Design-Pattern

The Builder Design Pattern is a creational design pattern used to construct complex objects step-by-step. It separates the construction of a complex object from its representation, so the same construction process can create different types of objects.

🔧 Why Use Builder Pattern?
When an object has:

Too many parameters (some optional),

Multiple combinations of parameters,

Or when object creation is complex and should be controlled step-by-step

Absolutely! Let's break down the **real-life analogy** of the **Builder Design Pattern** using your **burger example at a restaurant** 🍔:

---

## 🧱 Real-Life Analogy: Ordering a Burger at a Restaurant

### 🧑‍🍳 The Situation:

Imagine you're at a **burger counter** where the cook (or the system) makes burgers **based on your choices**.

Different customers want:

* Different types of bread 🍞
* Veggie or meat patty 🥕🍖
* Cheese or no cheese 🧀❌
* Lettuce or no lettuce 🥬❌

### ⚙️ What's the Problem?

If the cook had to prepare every possible combination using separate recipes (like having 50 constructors in code), it would be chaotic and hard to maintain.

---

## 🛠️ The Solution: Builder Design Pattern

Instead of preparing **fixed burger types**, the cook asks:

> "Tell me step-by-step what you want."

So, the customer says:

> ✅ Whole wheat bread
> ✅ Veggie patty
> ✅ Add cheese
> ❌ No lettuce

The **Builder** collects these choices **step by step** and finally makes **exactly the burger you want** — **without modifying the kitchen rules** (core class stays the same).

---

### 🧱 Mapping Real Life to Code

| Real Life 🍔        | Builder Pattern Code                |
| ------------------- | ----------------------------------- |
| Burger              | `Burger` class                      |
| Order Form          | `Burger.Builder` class              |
| Customer choices    | `.setBread()`, `.setCheese()`, etc. |
| Cook builds burger  | `.build()` method                   |
| Final Burger served | `Burger` object returned            |

---

### ✅ Key Benefits:

* You don't need to create 100 types of burgers (constructors) for every combination.
* You can **customize easily**.
* The core "Burger class" never changes — just the options you choose.

---

### 🔁 Example:

```java
Burger myBurger = new Burger.Builder()
                   .setBread("Wheat")
                   .setPatty("Veggie")
                   .setCheese(true)
                   .build();
```

➡️ This is just like telling the cook:

> “Give me a wheat burger, veggie patty, and cheese.”

// Product Class
class Burger {
    private String bread;
    private String patty;
    private boolean cheese;
    private boolean lettuce;

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
public class Main {
    public static void main(String[] args) {
        Burger myBurger = new Burger.Builder()
                            .setBread("Whole Wheat")
                            .setPatty("Veg")
                            .setCheese(true)
                            .setLettuce(true)
                            .build();

        System.out.println(myBurger);
    }
}

Burger with Whole Wheat, Veg, Cheese, Lettuce



