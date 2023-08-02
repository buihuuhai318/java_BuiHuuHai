package com.example.team1.repository.statistical_board;

import com.example.team1.model.dto.BillDto;
import com.example.team1.model.dto.HotCustomer;
import com.example.team1.model.dto.HotItems;

import java.util.List;

public interface IStatisticalBoardRepository {
    List<HotCustomer> selectAllCustomer();

    List<HotItems> selectAllItem();

    List<BillDto> selectAllBillByAccount(int idAccount);

    int totalByDay();

    int totalByMonth();

    int totalByYear();
}
