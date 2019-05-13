package com.example.main.repository;

import com.example.main.model.Coupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CouponRepository extends BaseRepository<Coupon> {
    /**
     * 根据userId,获取所有关联的优惠券类别
     */
    @Query(value = "select * from strategy_coupon c where c.coupon_id in " +
            "(select m.coupon_id from mapper_user_coupon m where m.user_id = :uid)", nativeQuery = true)
    List<Coupon> findCouponsByUserId(@Param(value = "uid") String uid);

}
