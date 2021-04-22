package com.stocks.site.repository;

import com.stocks.site.model.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LedgerRepo extends JpaRepository<Ledger, Long> {
}
