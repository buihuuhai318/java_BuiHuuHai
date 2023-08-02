package com.example.team1.repository.hot;

import com.example.team1.model.DTO.HotCustomer;
import com.example.team1.model.DTO.HotItems;

import java.util.List;

public interface IStatisticalBoardRepository {
    List<HotCustomer> selectAllCustomer();

    List<HotItems> selectAllItem();

    int totalByDay();

    int totalByMonth();

    int totalByYear();
}
