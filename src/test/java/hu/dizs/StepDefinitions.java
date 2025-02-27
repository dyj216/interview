package hu.dizs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class StepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(StepDefinitions.class);

    private List<Item> list1 = new ArrayList<>();
    private List<Item> list2 = new ArrayList<>();

    private Set<Item> set1;
    private Set<Item> set2;

    private final Map<String, HashSet<Item>> map = new HashMap<>();

    @Given("I have the following items in the first list:")
    public void i_have_the_following_items_in_the_first_list(List<Item> items) {
        list1 = items;
    }

    @And("I have the following items in the second list:")
    public void i_have_the_following_items_in_the_second_list(List<Item> items) {
        list2 = items;
    }

    @When("I compare both lists")
    public void i_compare_both_lists() {
        addListToItemMap(list1);
        addListToItemMap(list2);

        set1 = new HashSet<>(list1);
        set2 = new HashSet<>(list2);
    }

    @Then("the lists should contain the same items with name, price, and category, regardless of order")
    public void the_lists_should_contain_the_same_items_with_name_price_and_category_regardless_of_order() {
        for (String key : map.keySet()) {
            List<Item> itemList = map.get(key).stream().toList();
            Item item = itemList.getFirst();
            if (itemList.size() > 1) {
                logger.error("Item '{}' differs: [{}]", key, compareItems(itemList));
            } else {
                if (
                    !set1.contains(item)) {
                    logger.error("The first list does not contain: {}", item);
                }
                if (!set2.contains(item)) {
                    logger.error("The second list does not contain: {}", item);
                }

            }
        }
        Assertions.assertEquals(set1, set2);
    }

    private String compareItems(List<Item> items) {
        List<String> result = new ArrayList<>();
        double price1 = items.get(0).getPrice();
        double price2 = items.get(1).getPrice();
        String category1 = items.get(0).getCategory();
        String category2 = items.get(1).getCategory();

        if (price1 != price2) {
            result.add(String.format("price: %s != %s", price1, price2));
        }
        if (!Objects.equals(category1, category2)) {
            result.add(String.format("category: %s != %s", category1, category2));
        }

        return String.join(", ", result);
    }

    private void addListToItemMap(List<Item> list) {
        for (Item i : list) {
            String name = i.getName();
            if (map.containsKey(i.getName())) {
                map.get(name).add(i);
            } else {
                HashSet<Item> set = new HashSet<>();
                set.add(i);
                map.put(name, set);
            }
        }
    }
}
