package com.example.borgerkong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

    public class ItemDatabase {
        public static Item getItemById(int itemID) {
            return items.get(itemID);
        }

        /***
         * Return an ArrayList containing all the articles in the database.
         */
        public static ArrayList<Item> getAllItems() {
            return new ArrayList<Item>((List) Arrays.asList(items.values().toArray()));
        }


        // You can ignore everything below this for now.
        private static final HashMap<Integer, Item> items = new HashMap<>();

        static {
            items.put(1, new Item(
                    1,
                    "Whopper",
                    "Juicy meat paddy, with fresh buns and lettuce",
                    9.50,
                    R.drawable.whopper));
            items.put(2, new Item(
                    2,
                    "Double Whopper",
                    "Two juicy meat paddies, with fresh buns and lettuce",
                    11.50,
                    R.drawable.doublewhopper));
            items.put(3, new Item(
                    3,
                    "Cheeseburger",
                    "Juicy meat paddy, with a slice cheese, with fresh buns",
                    6.50,
                    R.drawable.cheese));
            items.put(4, new Item(
                    4,
                    "Double Cheeseburger",
                    "Two juicy meat paddies, with two slices of cheese, with fresh buns",
                    8.50,
                    R.drawable.doublecheese));
            items.put(5, new Item(
                    5,
                    "Regular Fries",
                    "Fresh fried thin crunchy fries",
                    4.50,
                    R.drawable.fries));
            items.put(6, new Item(
                    6,
                    "Family Meal",
                    "Four burgers, two fries, four drinks and nuggets",
                    32.50,
                    R.drawable.familymeal));
            items.put(7, new Item(
                    7,
                    "Freeze",
                    "Frozen Coca Cola",
                    1.00,
                    R.drawable.freeze));
            items.put(8, new Item(
                    8,
                    "Regular Drink",
                    "Soft drink, water, or juice",
                    3.50,
                    R.drawable.drink));
            items.put(9, new Item(
                    9,
                    "Large Drink",
                    "Soft drink, water, or juice",
                    5.00,
                    R.drawable.drink));
            items.put(10, new Item(
                    10,
                    "Chicken Royale",
                    "Crunchy fried chicken, with lettuce and mayo on fresh buns",
                    8.00,
                    R.drawable.chickenroyale));
            items.put(11, new Item(
                    11,
                    "Grilled Chicken",
                    "Succulent grilled chicken, with lettuce and mayo on fresh buns",
                    9.00,
                    R.drawable.chickengrilled));
            items.put(12, new Item(
                    12,
                    "Hash Brown",
                    "Fresh, crunchy hash brown",
                    2.00,
                    R.drawable.hashbrown));
            items.put(13, new Item(
                    13,
                    "Onion Rings",
                    "Fresh, fried, tasty onion rings",
                    4.00,
                    R.drawable.onionrings));
            items.put(14, new Item(
                    14,
                    "Aussie Burger",
                    "Juicy meat paddy, pineapple, onion rings, lettuce and cheese on a fresh bun",
                    13.50,
                    R.drawable.aussieburger));
            items.put(15, new Item(
                    15,
                    "Large Fries",
                    "Fresh fried thin crunchy fries",
                    5.50,
                    R.drawable.fries));

        }
    }

