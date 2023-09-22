package com.arrowsmith.sakiladb.base;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class EntityTest<T> {
    @Test
    public abstract void canCreate();
    @Test
    public abstract void canDelete();
    @Test
    public abstract void canUpdate();
    @Test
    public abstract void canRead();

    public abstract T getBasic();

    protected abstract void addAdditional(T entity);
}
