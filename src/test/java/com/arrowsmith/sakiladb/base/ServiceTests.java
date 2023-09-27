package com.arrowsmith.sakiladb.base;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

//
//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
public abstract class ServiceTests<T> {

    @Autowired
    protected MockMvc mockMvc;

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
