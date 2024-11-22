package ru.job4j.pojo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ShopTest {
    @Test
    public void whenHasNotNull() {
        Product[] products = new Product[1];
        products[0] = new Product("Milk", 10);
        int result = Shop.indexOfNull(products);
        int expected = -1;
        assertThat(result).isEqualTo(expected);
    }
}