package com.example.team1.service.customer;

import com.example.team1.model.customers.Types;
import com.example.team1.repository.customer.ITypeRepository;
import com.example.team1.repository.customer.TypeRepository;

import java.util.Map;

public class TypeService implements ITypeService {

    ITypeRepository typeRepository = new TypeRepository();

    @Override
    public Types selectType(int id) {
        return typeRepository.selectType(id);
    }

    @Override
    public Map<Integer, Types> selectAllType() {
        return typeRepository.selectAllType();
    }
}
