package com.zhaodp.controller.user;

import com.zhaodp.base.page.PageDTO;
import com.zhaodp.base.result.R;
import com.zhaodp.dto.user.UserDTO;
import com.zhaodp.entity.user.UserEntity;
import com.zhaodp.req.user.UserCreateReq;
import com.zhaodp.req.user.UserIdReq;
import com.zhaodp.req.user.UserSearchReq;
import com.zhaodp.req.user.UserUpdateReq;
import com.zhaodp.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * <p>
 * 用户管理Controller
 * </p>
 *
 * @author zhaodp
 * @since 2020-08-20
 */
@Api(value = "User", tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户列表", notes = "分页查询用户列表")
    @GetMapping(value = "/")
    public R<PageDTO<UserDTO>> list(UserSearchReq req, BindingResult bindingResult) {
        return R.success(userService.findByPage(req));
    }

    @ApiOperation(value = "根据id查询用户信息", notes = "根据id查询用户信息")
    @GetMapping(value = "/{id}")
    public R<UserDTO> getById(@Valid UserIdReq req, BindingResult bindingResult) {
        UserDTO userDTO = userService.findById(req.getId());
        return R.success(userDTO);
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @PostMapping(value = "/create")
    public R create(@Valid UserCreateReq req, BindingResult bindingResult) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(req.getName());
        userEntity.setAge(req.getAge());
        Date now = new Date();
        userEntity.setCreateTime(now);
        userEntity.setUpdateTime(now);
        return R.result(userService.save(userEntity));
    }

    @ApiOperation(value = "根据id删除用户", notes = "根据id删除用户")
    @PostMapping(value = "/delete/{id}")
    public R delete(@Valid UserIdReq req, BindingResult bindingResult) {
        return R.result(userService.removeById(req.getId()));
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @PostMapping(value = "/update")
    public R delete(UserUpdateReq req, BindingResult bindingResult) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(req.getId());
        userEntity.setName(req.getName());
        userEntity.setAge(req.getAge());
        Date now = new Date();
        userEntity.setCreateTime(now);
        userEntity.setUpdateTime(now);
        return R.result(userService.updateById(userEntity));
    }
}
