package com.zhaodp.service.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaodp.base.page.PageDTO;
import com.zhaodp.dao.user.UserMapper;
import com.zhaodp.dto.user.UserDTO;
import com.zhaodp.entity.user.UserEntity;
import com.zhaodp.req.user.UserSearchReq;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhaodp
 * @since 2020-08-20
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {

    private UserDTO convertEntityToDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public PageDTO<UserDTO> findByPage(UserSearchReq req) {
        int pageNo = req.getPageNo();
        int pageSize = req.getPageSize();
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageSize < 10) {
            pageSize = 10;
        } else if (pageSize > 1000) {
            pageSize = 1000;
        }
        Page<UserEntity> page = page(new Page<>(pageNo, pageSize));
        PageDTO<UserDTO> pageDTO = new PageDTO<>();
        pageDTO.setPageNo(page.getCurrent());
        pageDTO.setPageSize(page.getSize());
        pageDTO.setTotalSize(page.getTotal());
        pageDTO.setPages(page.getPages());
        List<UserEntity> records = page.getRecords();
        if (!CollectionUtils.isEmpty(records)) {
            List<UserDTO> userList = records.stream().map(entity -> convertEntityToDTO(entity)).collect(Collectors.toList());
            pageDTO.setList(userList);
        }
        return pageDTO;
    }

    public UserDTO findById(Serializable id) {
        UserEntity entity = getById(id);
        if (entity == null) {
            return null;
        } else {
            return convertEntityToDTO(entity);
        }
    }

}
