package com.kimzing.provider.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kimzing.provider.domain.dto.user.UserDTO;
import com.kimzing.provider.domain.po.user.User;
import com.kimzing.provider.domain.vo.user.UserVO;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * User接口.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
@Validated
public interface UserService extends IService<User> {

    /**
     * 保存User.
     *
     * @param userDTO
     * @return UserVO
     */
    UserVO save(@Valid UserDTO userDTO);

    /**
     * 更新User, 更新不为Null的字段.
     *
     * @param userDTO
     * @return UserVO
     */
    UserVO update(@Valid UserDTO userDTO);

    /**
     * 删除User.
     * <p>
     *     根据项目配置进行硬删除或者软删除
     * </p>
     * @param id
     */
    void remove(@NotNull Long id);

    /**
     * 通过ID查询User.
     *
     * @param id
     * @return UserVO
     */
    UserVO get(@NotNull Long id);

    /**
     * 根据分页和条件进行查询.
     * <p>
     *     条件为空时，查询全部
     * </p>
     * @param page
     * @param userDTO
     * @return IPage<UserVO>
     */
    IPage<UserVO> list(IPage page, UserDTO userDTO);

    /**
     * 使用xml进行分页查询.
     * <p>
     *     条件为空时，查询全部
     * </p>
     * @param page
     * @return IPage<UserVO>
     */
    IPage<UserVO> listWithXML(IPage page);

    /**
     * 使用注解进行分页查询.
     * <p>
     *     条件为空时，查询全部
     * </p>
     * @param page
     * @return IPage<UserVO>
     */
    IPage<UserVO> listWithAnnotation(IPage page);

    /**
     * 指定条件进行分页查询.
     * <p>
     *     条件为空时，查询全部
     * </p>
     * @param page
     * @param userDTO
     * @return IPage<UserVO>
     */
    IPage<UserVO> listByConditionWithWrapper(IPage page, UserDTO userDTO);
}
