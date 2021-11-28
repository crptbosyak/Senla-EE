package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.configuration.DatabaseConfig;
import com.senla.haltvinizki.dao.HistoryDao;
import com.senla.haltvinizki.entity.History;
import com.senla.haltvinizki.entity.Product;
import com.senla.haltvinizki.entity.User;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {DatabaseConfig.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class HistoryDaoImplTest extends TestCase {
    private final Date date = new Date();
    private final float price = 400;
    @Resource
    private HistoryDao historyDao;

    @Before
    public void fillingTable() {
        History history = History.builder().sellingPrice(400).sellingDate(date)
                .product(Product.builder().id(1L).name("iphone").build())
                .customer(User.builder().id(1L).name("oleg").build()).build();
        History history2 = History.builder().sellingPrice(5454).sellingDate(date)
                .product(Product.builder().id(2L).build())
                .customer(User.builder().id(2L).build()).build();
        History history3 = History.builder().sellingPrice(6565).sellingDate(date)
                .product(Product.builder().id(2L).build())
                .customer(User.builder().id(2L).build()).build();
        historyDao.create(history);
        historyDao.create(history2);
        historyDao.create(history3);
    }

    @Test
    public void create() {
        History history = History.builder().sellingPrice(400).sellingDate(date).product(Product.builder().id(2L).build()).build();
        historyDao.create(history);
        History history1 = historyDao.getById(4L);
        assertEquals(4L, history1.getId());
        assertEquals(history.getSellingPrice(), history1.getSellingPrice());
        assertEquals(history.getSellingDate(), history1.getSellingDate());
        assertEquals(history.getCustomer(), history1.getCustomer());
        assertEquals(history.getProduct(), history1.getProduct());
    }

    @Test
    public void getById() {
        History history = historyDao.getById(1L);
        assertEquals(1L, history.getId());
        assertEquals(price, history.getSellingPrice());
        assertEquals(date, history.getSellingDate());
    }

    @Test
    public void update() {
        History history = historyDao.getById(2L);
        history.setSellingPrice(400);
        historyDao.update(history);
        History history1 = historyDao.getById(2L);
        assertEquals(2L, history1.getId());
        assertEquals(history.getSellingPrice(), history1.getSellingPrice());
    }

    @Test
    public void delete() {
        historyDao.delete(2L);
        assertNull(historyDao.getById(2L));
    }

    @Test
    public void getHistoryWithCustomer() {
        History history = historyDao.getHistoryWithCustomer(1L);
        assertEquals(1L, history.getId());
        assertEquals(price, history.getSellingPrice());
        assertEquals(date, history.getSellingDate());
        assertEquals("oleg", history.getCustomer().getName());
        assertEquals(1L, history.getCustomer().getId());
    }

    @Test
    public void getHistoryWithProduct() {
        History history = historyDao.getHistoryWithProduct(1L);
        assertEquals(1L, history.getId());
        assertEquals(price, history.getSellingPrice());
        assertEquals(date, history.getSellingDate());
        assertEquals("iphone", history.getProduct().getName());
        assertEquals(1L, history.getProduct().getId());
    }


}