package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.HistoryDao;
import com.senla.haltvinizki.dao.impl.HistoryDaoImpl;
import com.senla.haltvinizki.entity.history.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class HistoryServiceImpl implements com.senla.haltvinizki.services.HistoryService {

    @Autowired
   private HistoryDao historyDao;


    public HistoryServiceImpl(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }

    @Override
    public History delete(History history) {
        return historyDao.delete(history);
    }

    @Override
    public History create(History history) {
        return historyDao.create(history);
    }

    @Override
    public History update(History history) {
        return historyDao.update(history);
    }

    @Override
    public List<History> read() {
        return historyDao.read();
    }
}