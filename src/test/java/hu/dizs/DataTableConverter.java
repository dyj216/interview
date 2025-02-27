package hu.dizs;

import io.cucumber.java.DataTableType;
import java.util.Map;

public class DataTableConverter {

    @DataTableType
    public Item convert(Map<String, String> row) {
        return new Item(
                row.get("name"),
                Double.parseDouble(row.get("price")),
                row.get("category")
        );
    }
}
