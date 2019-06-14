package com.example.main.repository;

import com.example.main.model.VIPRechargeHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VIPRechargeHistoryRepository extends BaseRepository<VIPRechargeHistory> {
    @Query(value = "select * from vip_recharge_history h where h.vip_id in " +
            "(select v.id from vip v where v.user_id = :uid)", nativeQuery = true)
    List<VIPRechargeHistory> findAllByUserId(@Param(value = "uid") String uid);

    List<VIPRechargeHistory> findAllByVipId(String vid);
}
