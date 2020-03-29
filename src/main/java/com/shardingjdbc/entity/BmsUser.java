package com.shardingjdbc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 管理员信息表(BmsUser)实体类
 *
 * @author makejava
 * @since 2020-03-29 10:54:46
 */
public class BmsUser implements Serializable {
    private static final long serialVersionUID = 279400442096418089L;
    /**
    * 用户ID
    */
    private String userId;
    /**
    * 用户名称
    */
    private String userName;
    /**
    * 用户密码
    */
    private String userPwd;
    /**
    * 真实姓名
    */
    private String realName;
    /**
    * 加密盐
    */
    private String salt;
    /**
    * 描述
    */
    private String description;
    /**
    * 是否停用/锁定
    */
    private String isBlock;
    /**
    * 是否职员
    */
    private String isStaff;
    /**
    * 员工id,对应员工信息表
    */
    private String empId;
    /**
    * 最后更新时间
    */
    private Date updateTime;
    /**
    * 最后更新人名称
    */
    private String updateUser;
    /**
    * 最后更新人ID
    */
    private String updateUserId;
    /**
    * 创建人
    */
    private String createUserId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 创建人名称
    */
    private String createUser;
    /**
    * 所属模块1:BMS 2:网报
    */
    private String module;
    /**
    * 是否删除：1是，0否
    */
    private String isDelete;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsBlock() {
        return isBlock;
    }

    public void setIsBlock(String isBlock) {
        this.isBlock = isBlock;
    }

    public String getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(String isStaff) {
        this.isStaff = isStaff;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

}