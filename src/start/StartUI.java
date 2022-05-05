package start;

import input.Input;
import model.Item;
import tracker.Tracker;
import java.util.List;

public class StartUI {
    public void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Added item: " + item);
    }

    public void showItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        List<Item> items = tracker.findAll();
        if (items.isEmpty()) {
            System.out.println("The store does not contain items yet!");
        } else {
            items.forEach(System.out::println);
        }
    }

    public void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Replace item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(item, id)) {
            System.out.println("Item changed successfully!");
        } else {
            System.out.println("Item replacement error!");
        }
    }

    public void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("The item deleted!");
        } else {
            System.out.println("Item deletion error!");
        }
    }

    public void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item with this id does not exist");
        }
    }

    public void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (!items.isEmpty()) {
            items.forEach(System.out::println);
        } else {
            System.out.println("Items with name " + name + " does not exist!");
        }
    }

    void showMenu() {
        String[] menu = {
                "Add new item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find item by name",
                "Exit"
        };
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int option = input.askInt("Enter an option please: ");
            switch (option) {
                case 0 -> createItem(input, tracker);
                case 1 -> showItems(tracker);
                case 2 -> replaceItem(input, tracker);
                case 3 -> deleteItem(input, tracker);
                case 4 -> findById(input, tracker);
                case 5 -> findByName(input, tracker);
                case 6 -> {
                    run = false;
                    System.out.println("Have a nice day!");
                }
                default -> System.out.println("This option does not exist! Try again!");
            }
        }
    }
}
