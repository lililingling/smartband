package com.liling.smartband.dao;

import com.liling.smartband.beans.TGpsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TGpsHistoryDao extends JpaRepository<TGpsHistory,Long> {
}
