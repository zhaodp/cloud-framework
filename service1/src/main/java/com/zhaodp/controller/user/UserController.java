package com.zhaodp.controller.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaodp.base.result.R;
import com.zhaodp.entity.user.UserEntity;
import com.zhaodp.req.AddUserReq;
import com.zhaodp.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

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
    public R<List<UserEntity>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize, BindingResult bindingResult) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<UserEntity> aPage = userService.page(new Page<>(current, pageSize));
        return R.success(aPage.getRecords());
    }

    @ApiOperation(value = "根据id查询用户信息", notes = "根据id查询用户信息")
    @GetMapping(value = "/{id}")
    public R<UserEntity> getById(@RequestParam("id") String id, BindingResult bindingResult) {
        return R.success(userService.getById(id));
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @PostMapping(value = "/create")
    public R create(@Valid AddUserReq req, BindingResult bindingResult) {
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
    public R delete(@PathVariable("id") String id, BindingResult bindingResult) {
        return R.result(userService.removeById(id));
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @PostMapping(value = "/update")
    public R delete(@RequestBody UserEntity params, BindingResult bindingResult) {
        return R.result(userService.updateById(params));
    }
}
