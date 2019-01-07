package com.kimzing.provider.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kimzing.provider.domain.po.user.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User存储层.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 使用xml进行分页查询.
     *
     * @param page
     * @return java.util.List<User>
     */
    List<User> listWithXML(IPage page);

    /**
     * 根据注解进行分页查询.
     *
     * @param page
     * @return java.util.List<User>
     */
    @Select("SELECT id,name,age,balance,birth,gender FROM `user`")
    List<User> listWithAnnotation(IPage page);

}
