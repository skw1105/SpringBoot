package com.utopia.springboot.dao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDao {
    private final String name;
    private final int amount;
}
