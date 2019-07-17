package com.liling.smartband.dao;

import com.liling.smartband.beans.TDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TDeviceDao extends JpaRepository<TDevice,Long> {

}
