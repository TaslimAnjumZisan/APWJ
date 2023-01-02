package com.repository;

import com.domain.Amount;

import java.util.List;

public interface AmountRepository {
    public List<Amount> getAll();

    public Amount create(Amount taxVariables);

    public Amount get(Long id);

    public Amount update(Amount taxVariables);
}
