package com.zhaodp.demo.entity.tenant;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author zhaodp
 * @since 2020-08-19
 */
@TableName("t_tenant")
public class Tenant implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 租户名字
     */
    private String tenantName;

    /**
     * 国家
     */
    private String county;

    /**
     * 省份
     */
    private String provice;

    /**
     * 城市code
     */
    private Integer cityId;

    /**
     * 城市
     */
    private String cityName;

    /**
     * 编号类型，1：营业执照注册号 2:统一社会信用代码
     */
    private Integer businessLicenseNoType;

    /**
     * 营业执照号
     */
    private String businessLicenseNo;

    /**
     * 开户行全称名字
     */
    private String bankName;

    /**
     * 银行开户行账号名字
     */
    private String bankAccountName;

    /**
     * 开户行账号
     */
    private String bankAccountNo;

    /**
     * 公司营业照
     */
    private String companyLicenseUrl;

    /**
     * 开户许可证
     */
    private String companyLicensePermitUrl;

    /**
     * 法人身份证正面
     */
    private String companyLegalFrontCardUrl;

    /**
     * 法人身份证反面
     */
    private String companyLegalBackCardUrl;

    /**
     * 0待审核 1已审核 2审核失败
     */
    private Integer status;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 审核人
     */
    private String auditor;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getBusinessLicenseNoType() {
        return businessLicenseNoType;
    }

    public void setBusinessLicenseNoType(Integer businessLicenseNoType) {
        this.businessLicenseNoType = businessLicenseNoType;
    }

    public String getBusinessLicenseNo() {
        return businessLicenseNo;
    }

    public void setBusinessLicenseNo(String businessLicenseNo) {
        this.businessLicenseNo = businessLicenseNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getCompanyLicenseUrl() {
        return companyLicenseUrl;
    }

    public void setCompanyLicenseUrl(String companyLicenseUrl) {
        this.companyLicenseUrl = companyLicenseUrl;
    }

    public String getCompanyLicensePermitUrl() {
        return companyLicensePermitUrl;
    }

    public void setCompanyLicensePermitUrl(String companyLicensePermitUrl) {
        this.companyLicensePermitUrl = companyLicensePermitUrl;
    }

    public String getCompanyLegalFrontCardUrl() {
        return companyLegalFrontCardUrl;
    }

    public void setCompanyLegalFrontCardUrl(String companyLegalFrontCardUrl) {
        this.companyLegalFrontCardUrl = companyLegalFrontCardUrl;
    }

    public String getCompanyLegalBackCardUrl() {
        return companyLegalBackCardUrl;
    }

    public void setCompanyLegalBackCardUrl(String companyLegalBackCardUrl) {
        this.companyLegalBackCardUrl = companyLegalBackCardUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Tenant{" +
        ", id=" + id +
        ", tenantId=" + tenantId +
        ", tenantName=" + tenantName +
        ", county=" + county +
        ", provice=" + provice +
        ", cityId=" + cityId +
        ", cityName=" + cityName +
        ", businessLicenseNoType=" + businessLicenseNoType +
        ", businessLicenseNo=" + businessLicenseNo +
        ", bankName=" + bankName +
        ", bankAccountName=" + bankAccountName +
        ", bankAccountNo=" + bankAccountNo +
        ", companyLicenseUrl=" + companyLicenseUrl +
        ", companyLicensePermitUrl=" + companyLicensePermitUrl +
        ", companyLegalFrontCardUrl=" + companyLegalFrontCardUrl +
        ", companyLegalBackCardUrl=" + companyLegalBackCardUrl +
        ", status=" + status +
        ", auditTime=" + auditTime +
        ", auditor=" + auditor +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
