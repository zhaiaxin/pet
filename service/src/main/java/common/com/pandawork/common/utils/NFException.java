package com.pandawork.common.utils;

import com.pandawork.core.common.exception.IBizExceptionMes;

/**
 * NFException
 *
 * @author: zhangteng
 * @time: 2015/3/24 16:55
 */
public enum  NFException implements IBizExceptionMes {
    SystemException("系统内部异常", 1),

    UserNameNotNull("用户名不能为空", 10001),
    PasswordNotNull("密码不能为空", 10002),
    ListStudentAll("获取学生列表失败",10003),
    CountAll("获取学生信息数目失败",10004 ),
    StudentNameNotNull("获取学生姓名为空",10005 ),
    StudentNumLessOrEqualZero("学生学号小于零",10006 ),
    SexNotNull( "获取学生性别为空",10007),
    GradeLessOrEqualZero("获取学生年级小于零",10008),
    ClassNumLessOrEqualZero("获取学生年级小于零",10009),
    CollegeNotNull("获取学生学院为空",10010),
    BirthdayNotNull("获取学生生日为空",10011),
    GoodStudentNotNull("获取是否为好学生为空",10012),
    DelStudentNull("删除学生信息失败",10013),
    UpdateStudentFailed("更新学生信息失败",10014),
    UpdateStudentByIdFailed("按照id查询学生信息失败",10016),
    queryStudentByIdFailed("按照id查找学生信息失败",10017),

    QueryByNameFailed("按照名称查询动漫信息失败",10018 ),
    ListCartoonAll("获取动漫列表失败",10019),
    queryCartoonByIdFailed("按照id查找动漫信息失败",10020),
    CountCartoonAll("获取动漫信息数目失败",10021 ),
    DelCartoonNull("删除动漫信息失败",10022),
    UpdateCartoonFailed("更新动漫信息失败",10014),


    queryUserByIdFailed("按照id查找用户信息失败",10023),
    PasswordNotTrue("密码不正确",10024),
    ListUserAll("获取用户列表失败",10025),


    queryCommentByIdFailed("通过Id查找评论失败",10026),
    listFailed("通过CartoonId查找评论列表失败",10027),

    /*``````````````````````````````````````````````````````````````````````````````````````````````````*/

    NewPetFailed("添加宠物失败",20000),
    UpdatePetFailed("更新宠物失败",20001),
    delPetFailed("删除宠物失败",20002),
    queryPetByIdFailed("通过Id查询宠物失败",20003),
    queryByClassificationIdFailed("通过ClassificationId查询宠物失败",20004),
    queryByClassificationPIdFailed("通过ClassificationPId查询宠物失败",20004),


    ;

    private String msg;

    private Integer code;

    NFException(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }


    @Override
    public String getMes() {
        return null;
    }

    @Override
    public int getCode() {
        return 0;
    }
}
