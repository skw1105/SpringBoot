package com.utopia.springboot.dao;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class HelloResponseDaoTest {

    @Test
    public void lombokTest() {
        String name = "test";
        int amount = 1000;

        HelloResponseDao dto = new HelloResponseDao(name, amount);

        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
