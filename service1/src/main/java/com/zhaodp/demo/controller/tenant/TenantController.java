package com.zhaodp.demo.controller.tenant;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.zhaodp.demo.service.tenant.TenantService;
import com.zhaodp.demo.entity.tenant.Tenant;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhaodp
 * @since 2020-08-19
 */
@Controller
@RequestMapping("/tenant")
public class TenantController {


    @Autowired
    private TenantService tenantService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<Tenant>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<Tenant> aPage = tenantService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tenant> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(tenantService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody Tenant params) {
        tenantService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        tenantService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> delete(@RequestBody Tenant params) {
        tenantService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
