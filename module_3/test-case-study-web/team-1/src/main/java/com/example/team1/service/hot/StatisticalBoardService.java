package com.example.team1.service.hot;

import com.example.team1.model.DTO.HotCustomer;
import com.example.team1.model.DTO.HotItems;
import com.example.team1.repository.hot.IStatisticalBoardRepository;
import com.example.team1.repository.hot.StatisticalBoardRepository;

import java.util.List;

public class StatisticalBoardService implements IStatisticalBoardService {

    private static final IStatisticalBoardRepository boardRepository = new StatisticalBoardRepository();

    @Override
    public List<HotCustomer> selectAllCustomer() {
        return boardRepository.selectAllCustomer();
    }

    @Override
    public List<HotItems> selectAllItem() {
        return boardRepository.selectAllItem();
    }

    @Override
    public int totalByDay() {
        return boardRepository.totalByDay();
    }

    @Override
    public int totalByMonth() {
        return boardRepository.totalByMonth();
    }

    @Override
    public int totalByYear() {
        return boardRepository.totalByYear();
    }
}
