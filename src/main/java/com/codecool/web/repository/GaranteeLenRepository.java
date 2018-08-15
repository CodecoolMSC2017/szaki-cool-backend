package com.codecool.web.repository;

import com.codecool.web.model.Currency;
import com.codecool.web.model.GuaranteeLength;
import org.springframework.data.repository.CrudRepository;

public interface GaranteeLenRepository extends CrudRepository<GuaranteeLength, Integer> {
}
