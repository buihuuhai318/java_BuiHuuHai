package com.example.team1.service.statistical_board;

import com.example.team1.model.dto.HotCustomer;
import com.example.team1.model.dto.HotItems;
import com.example.team1.repository.statistical_board.IStatisticalBoardRepository;
import com.example.team1.repository.statistical_board.StatisticalBoardRepository;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<Integer> revenueList() {
        return boardRepository.revenueList();
    }

    @Override
    public Map<String, Integer> quantityTotalByType() {
        return boardRepository.quantityTotalByType();
    }
}
