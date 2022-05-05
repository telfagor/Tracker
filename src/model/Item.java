package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private final LocalDateTime created = LocalDateTime.now();
    private int id;
    private String name;

    public Item() {}

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this(name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id = " + id
                + ", name = " + name + '\''
                + ", created = " + created.format(FORMATTER)
                + '}';
    }
}
