package com.jjou.mapper;

import com.jjou.domain.ProjectProgress;
import com.jjou.domain.ProjectProgressInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description:
 *
 * @Author ojj
 * @Date 2025-03-18 15:24
 * @Version 1.0
 */
@Mapper
public interface ProjectProgressInfoMapper {

    List<ProjectProgress> selectList();

    ProjectProgressInfo selectById(String projectId);

    int insert(ProjectProgressInfo projectProgressInfo);

    int update(ProjectProgressInfo projectProgressInfo);

    int selectCount();

}
