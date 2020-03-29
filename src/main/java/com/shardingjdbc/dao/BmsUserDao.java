package com.shardingjdbc.dao;

import com.shardingjdbc.entity.BmsUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员信息表(BmsUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-29 10:54:47
 */
public interface BmsUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    BmsUser queryById(String userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BmsUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bmsUser 实例对象
     * @return 对象列表
     */
    List<BmsUser> queryAll(BmsUser bmsUser);

    /**
     * 新增数据
     *
     * @param bmsUser 实例对象
     * @return 影响行数
     */
    int insert(BmsUser bmsUser);

    /**
     * 修改数据
     *
     * @param bmsUser 实例对象
     * @return 影响行数
     */
    int update(BmsUser bmsUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(String userId);

}