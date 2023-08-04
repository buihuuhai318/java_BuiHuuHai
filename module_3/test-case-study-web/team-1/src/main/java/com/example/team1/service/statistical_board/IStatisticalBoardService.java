package com.example.team1.service.statistical_board;

import com.example.team1.model.dto.HotCustomer;
import com.example.team1.model.dto.HotItems;

import java.util.List;
import java.util.Map;

public interface IStatisticalBoardService {
    List<HotCustomer> selectAllCustomer();

    List<HotItems> selectAllItem();

    int totalByDay();

    int totalByMonth();

    int totalByYear();
}