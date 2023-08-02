package com.example.team1.repository.customer;

import com.example.team1.model.customers.Types;

import java.util.Map;

public interface ITypeRepository {
    Types selectType(int id);

    Map<Integer, Types> selectAllType();
}
