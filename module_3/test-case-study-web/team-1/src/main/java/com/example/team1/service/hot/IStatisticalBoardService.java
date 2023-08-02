package com.example.team1.service.hot;

import com.example.team1.model.DTO.HotCustomer;
import com.example.team1.model.DTO.HotItems;

import java.util.List;

public interface IStatisticalBoardService {
    List<HotCustomer> selectAllCustomer();

    List<HotItems> selectAllItem();

    int totalByDay();

    int totalByMonth();

    int totalByYear();
}
