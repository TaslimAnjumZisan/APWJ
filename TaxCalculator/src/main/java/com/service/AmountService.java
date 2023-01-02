package com.service;

import com.domain.Amount;

import java.util.List;

public interface AmountService {
    public Amount insert(Amount taxVariables);

    public Amount get(Long id);

    public List<Amount> getAll();

    public Amount update(Amount taxVariables);
}
