package com.example.team1.service.customer;

import com.example.team1.model.customers.Types;

import java.util.Map;

public interface ITypeService {
    Types selectType(int id);

    Map<Integer, Types> selectAllType();
}
