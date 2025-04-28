package com.jjou.mapper;

import com.jjou.domain.ProjectInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 *
 * @Author ojj
 * @Date 2025-03-25 08:43
 * @Version 1.0
 */
@Mapper
public interface ProjectInfoMapper {
    int updateById(ProjectInfoEntity projectInfo);
}
