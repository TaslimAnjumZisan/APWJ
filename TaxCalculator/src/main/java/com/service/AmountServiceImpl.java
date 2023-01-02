package com.service;

import com.domain.Amount;
import com.repository.AmountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class AmountServiceImpl implements AmountService {
    private AmountRepository amountRepository;
    public AmountServiceImpl(AmountRepository amountRepository) {
        this.amountRepository = amountRepository;
    }
    @Transactional
    public Amount insert(Amount taxVariables) {
        return amountRepository.create(taxVariables);
    }
    @Transactional(readOnly = true)
    public Amount get(Long id) {
        return amountRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Amount> getAll() {
        return amountRepository.getAll();
    }

    @Transactional
    public Amount update(Amount amount) {
        return amountRepository.update(amount);
    }
}
