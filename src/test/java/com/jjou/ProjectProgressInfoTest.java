package com.jjou;

import com.jjou.domain.ProjectInfoEntity;
import com.jjou.domain.ProjectProgress;
import com.jjou.domain.ProjectProgressInfo;
import com.jjou.mapper.ProjectInfoMapper;
import com.jjou.mapper.ProjectProgressInfoMapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Description:
 *
 * @Author ojj
 * @Date 2025-03-18 15:45
 * @Version 1.0
 */
@SpringBootTest
public class ProjectProgressInfoTest {

    @Autowired
    private ProjectProgressInfoMapper projectProgressInfoMapper;

    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    /**
     * 根据原工程进度信息 映射到新表
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    @Rollback(false)
    public void test1() {
        int count = projectProgressInfoMapper.selectCount();
        List<ProjectProgress> projectProgresses = projectProgressInfoMapper.selectList();
        int add = 0;
        int update = 0;
        for (ProjectProgress projectProgress : projectProgresses) {
            String projectId = projectProgress.getProjectId();
            String afterStatus = projectProgress.getAfterStatus();
            if (StringUtils.isNotBlank(projectId)) {
                ProjectProgressInfo projectProgressInfo = projectProgressInfoMapper.selectById(projectId);
                if (projectProgressInfo == null) {
                    ProjectProgressInfo projectProgressInfoNew = new ProjectProgressInfo();
                    projectProgressInfoNew.setId(UUID.randomUUID().toString());  // 生成 UUID
                    projectProgressInfoNew.setProjectId(projectId);
                    if (StringUtils.isNotBlank(afterStatus)) {
                        switch (afterStatus) {
                            case "1":
                                projectProgressInfoNew.setBeginDate(projectProgress.getNextDate());
                                break;
                            case "2":
                                projectProgressInfoNew.setEndDate(projectProgress.getNextDate());
                                break;
                            case "3":
                                projectProgressInfoNew.setBeginCheckDate(projectProgress.getNextDate());
                                break;
                            case "4":
                                projectProgressInfoNew.setEndCheckDate(projectProgress.getNextDate());
                                break;
                            case "7":
                                projectProgressInfoNew.setPlanDate(projectProgress.getNextDate());
                                break;
                            case "8":
                                projectProgressInfoNew.setCompleteDate(projectProgress.getNextDate());
                                break;
                            case "5":
                                projectProgressInfoNew.setSettlementDate(projectProgress.getNextDate());
                                break;
                            default:
                                break;
                        }
                    }
                    projectProgressInfoNew.setRemark(projectProgress.getRemark());
                    projectProgressInfoNew.setCreator(projectProgress.getCreator());
                    projectProgressInfoNew.setCreatorName(projectProgress.getCreatorName());
                    projectProgressInfoNew.setCreateTime(projectProgress.getCreateTime());
                    add += projectProgressInfoMapper.insert(projectProgressInfoNew);
                } else {
                    if (StringUtils.isNotBlank(afterStatus)) {
                        switch (afterStatus) {
                            case "1":
                                projectProgressInfo.setBeginDate(projectProgress.getNextDate());
                                break;
                            case "2":
                                projectProgressInfo.setEndDate(projectProgress.getNextDate());
                                break;
                            case "3":
                                projectProgressInfo.setBeginCheckDate(projectProgress.getNextDate());
                                break;
                            case "4":
                                projectProgressInfo.setEndCheckDate(projectProgress.getNextDate());
                                break;
                            case "7":
                                projectProgressInfo.setPlanDate(projectProgress.getNextDate());
                                break;
                            case "8":
                                projectProgressInfo.setCompleteDate(projectProgress.getNextDate());
                                break;
                            case "5":
                                projectProgressInfo.setSettlementDate(projectProgress.getNextDate());
                                break;
                            default:
                                break;
                        }
                        if (
                                projectProgressInfo.getBeginDate() != null
                                        || projectProgressInfo.getEndDate() != null
                                        || projectProgressInfo.getBeginCheckDate() != null
                                        || projectProgressInfo.getEndCheckDate() != null
                                        || projectProgressInfo.getPlanDate() != null
                                        || projectProgressInfo.getCompleteDate() != null
                                        || projectProgressInfo.getSettlementDate() != null
                        ){
                            update += projectProgressInfoMapper.update(projectProgressInfo);
                        }
                    }
                }
            }
        }
        System.out.println("progressInfo表总记录数：" + count);
        System.out.println("成功插入数：" + add);
        System.out.println("成功更新数：" + update);
    }

    /**
     * 根据原工程进度信息 映射到工程信息表
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    @Rollback(false)
    public void test2() {
        List<ProjectProgress> projectProgresses = projectProgressInfoMapper.selectList();
        int update = 0;
        for (ProjectProgress projectProgress : projectProgresses) {
            String projectId = projectProgress.getProjectId();
            String afterStatus = projectProgress.getAfterStatus();
            ProjectInfoEntity projectInfo = new ProjectInfoEntity();
            projectInfo.setId(projectId);
            if (StringUtils.isNotBlank(afterStatus)) {
                switch (afterStatus) {
                    case "1":
                        projectInfo.setBeginDate(projectProgress.getCreateTime());
                        break;
                    case "2":
                        projectInfo.setEndDate(projectProgress.getCreateTime());
                        break;
                    case "3":
                        projectInfo.setBeginCheckDate(projectProgress.getCreateTime());
                        break;
                    case "4":
                        projectInfo.setEndCheckDate(projectProgress.getCreateTime());
                        break;
                    case "7":
                        projectInfo.setPlanDate(projectProgress.getCreateTime());
                        break;
                    case "8":
                        projectInfo.setCompleteDate(projectProgress.getCreateTime());
                        break;
                    case "5":
                        projectInfo.setSettlementDate(projectProgress.getCreateTime());
                        break;
                    default:
                        break;
                }
                if (
                        projectInfo.getBeginDate() != null
                        || projectInfo.getEndDate() != null
                        || projectInfo.getBeginCheckDate() != null
                        || projectInfo.getEndCheckDate() != null
                        || projectInfo.getPlanDate() != null
                        || projectInfo.getCompleteDate() != null
                        || projectInfo.getSettlementDate() != null
                ){
                    update += projectInfoMapper.updateById(projectInfo);
                }

            }
        }
        System.out.println("成功更新数：" + update);
    }
}
