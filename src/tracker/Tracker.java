package tracker;

import java.util.List;
import java.util.ArrayList;

import model.Item;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 0;
    private String name;

    public void add(Item item) {
        item.setId(ids++);
        items.add(item);
    }

    public Item findById(int id) {
        return getItemById(id);
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                list.add(item);
            }
        }
        return list;
    }

    public boolean replace(Item item, int id) {
        int rsl = indexOf(id);
        if (rsl == -1) {
            return false;
        }
        item.setId(id);
        items.set(rsl, item);
        return true;
    }

    public boolean delete(int id) {
        Item item = getItemById(id);
        if (item == null) {
            return false;
        }
        items.remove(item);
        return true;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    private Item getItemById(int id) {
        Item rsl = null;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}
