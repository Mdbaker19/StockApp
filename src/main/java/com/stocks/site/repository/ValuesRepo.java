package com.stocks.site.repository;

import com.stocks.site.model.Values;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValuesRepo extends JpaRepository<Values, Long> {
}
