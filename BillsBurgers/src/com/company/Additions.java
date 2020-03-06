package com.company;

public abstract class Additions {
    private String name;
    private double price;

    public Additions(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Lettuce extends Additions {
    public Lettuce() {
        super("lettuce", 1.0);
    }
}

class Tomato extends Additions {
    public Tomato() {
        super("tomato", 1.5);
    }
}


class Carrot extends Additions {
    public Carrot() {
        super("carrot", 2.0);
    }
}

class Cucumber extends Additions {
    public Cucumber() {
        super("cucumber", 2.5);
    }
}

class Avocado extends Additions {
    public Avocado() {
        super("avocado", 3.0);
    }
}

class Eggs extends Additions {
    public Eggs() {
        super("eggs", 2.0);
    }
}

class Chips extends Additions {
    public Chips() {
        super("chips", 0);
    }
}

class Drinks extends Additions {
    public Drinks() {
        super("drinks", 0);
    }
}


