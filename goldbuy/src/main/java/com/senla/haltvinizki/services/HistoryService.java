package com.senla.haltvinizki.services;

import com.senla.haltvinizki.entity.history.History;

import java.util.List;

public interface HistoryService {
    History delete(History history);

    History create(History history);

    History update(History history);

    List<History> read();
}