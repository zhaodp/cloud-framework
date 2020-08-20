package com.zhaodp.demo.service.impl.tenant;

import com.zhaodp.demo.entity.tenant.Tenant;
import com.zhaodp.demo.mapper.tenant.TenantMapper;
import com.zhaodp.demo.service.tenant.TenantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaodp
 * @since 2020-08-19
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements TenantService {

}
