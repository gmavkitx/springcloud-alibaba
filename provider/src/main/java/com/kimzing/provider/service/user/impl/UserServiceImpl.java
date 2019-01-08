package com.kimzing.provider.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kimzing.provider.common.utils.exception.ExceptionManager;
import com.kimzing.provider.common.utils.page.PageConverter;
import com.kimzing.provider.domain.dto.user.UserDTO;
import com.kimzing.provider.domain.po.user.User;
import com.kimzing.provider.domain.vo.user.UserVO;
import com.kimzing.provider.mapper.user.UserMapper;
import com.kimzing.provider.service.user.UserService;
import com.kimzing.utils.mapper.MapperUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User接口实现.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    ExceptionManager exceptionManager;

    /**
     * 保存User.
     *
     * @param userDTO
     * @return UserVO
     */
    @Override
    public UserVO save(UserDTO userDTO) {
        User user = MapperUtils.mapperBean(userDTO, User.class);
        boolean success = this.save(user);
        if (!success) {
            throw exceptionManager.create("资源创建失败!");
        }
        return MapperUtils.mapperBean(user, UserVO.class);
    }

    /**
     * 更新User, 更新不为Null的字段.
     *
     * @param userDTO
     * @return UserVO
     */
    @Override
    public UserVO update(UserDTO userDTO) {
        if (userDTO.getId() == null) {
            throw exceptionManager.create("您所更新的资源ID不存在!");
        }
        User user = MapperUtils.mapperBean(userDTO, User.class);
        boolean success = this.updateById(user);
        if (!success) {
            throw exceptionManager.create("资源更新失败!");
        }
        return MapperUtils.mapperBean(user, UserVO.class);
    }

    /**
     * 删除User.
     * <p>
     *     根据项目配置进行硬删除或者软删除
     * </p>
     * @param id
     */
    @Override
    public void remove(Long id) {
        boolean success = this.removeById(id);
        if (!success) {
            throw exceptionManager.create("资源删除失败!");
        }
    }

    /**
     * 通过ID查询User.
     *
     * @param id
     * @return UserVO
     */
    @Override
    public UserVO get(Long id) {
        User user = this.getById(id);
        if (user == null) {
            throw exceptionManager.create("您所查询的资源不存在!");
        }
        UserVO userVO = MapperUtils.mapperBean(user, UserVO.class);
        return userVO;
    }

    /**
     * 根据分页和条件进行查询.
     * <p>
     *     条件为空时，查询全部
     * </p>
     * @param userDTO
     * @return IPage<UserVO>
     */
    @Override
    public IPage<UserVO> list(IPage page, UserDTO userDTO) {
        User user = MapperUtils.mapperBean(userDTO, User.class);
        IPage result = userMapper.selectPage(page, new QueryWrapper<User>().setEntity(user));
        PageConverter.convert(result, UserVO.class);
        return result;
    }

    /**
     * 通过xml进行分页查询.
     *
     * @param page
     * @return com.baomidou.mybatisplus.core.metadata.IPage<UserVO>
     */
    @Override
    public IPage<UserVO> listWithXML(IPage page) {
        page.setRecords(userMapper.listWithXML(page));
        PageConverter.convert(page, UserVO.class);
        return page;
    }

    /**
     * 通过注解的方式进行分页查询.
     *
     * @param page
     * @return com.baomidou.mybatisplus.core.metadata.IPage<UserVO>
     */
    @Override
    public IPage<UserVO> listWithAnnotation(IPage page) {
        page.setRecords(userMapper.listWithAnnotation(page));
        PageConverter.convert(page, UserVO.class);
        return page;
    }

    /**
     * 根据指定条件进行自定义查询.
     *
     * @param page
     * @param userDTO
     * @return com.baomidou.mybatisplus.core.metadata.IPage<UserVO>
     */
    @Override
    public IPage<UserVO> listByConditionWithWrapper(IPage page, UserDTO userDTO) {
        IPage result = this.page(page, new QueryWrapper<User>()
                .eq("gender", userDTO.getGender())
                .likeRight("name", userDTO.getName())
                .lt("age", userDTO.getAge())
                .orderByDesc("age")
        );
        PageConverter.convert(result, UserVO.class);
        return result;
    }


}
