package com.jjou.dao;

import com.jjou.domain.Assets;
import com.jjou.domain.InspectEquipment;

/**
 * Description:
 *
 * @Author ojj
 * @Date 2024-08-22 09:56
 * @Version 1.0
 */
public interface AssetsDao {

    int insert(Assets assets);

    int insertIns(InspectEquipment inspectEquipment);

    InspectEquipment selectInsCountById(String equipmentName);

    int update(Assets assets);
}
