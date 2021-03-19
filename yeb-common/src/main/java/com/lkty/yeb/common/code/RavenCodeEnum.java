package com.lkty.yeb.common.code;

import lombok.Getter;


@Getter
public enum RavenCodeEnum {

    SUCCESS(true, 0, "成功"),
    TOO_MANY_REQUEST(false, 1000, "请求流量过大"),
    FAIL(false, 1001, "系统错误"),
    PARAM_FAIL(false, 1002, "参数错误"),
    LOGIN_NOT(false, 401, "未登录"),
    FORBIDDEN(false, 403, "权限不足，请联系管理员"),

    /**
     * 登录&注册
     */
    ACCOUNT_DISENABLED(false, 30100, "账号被禁用"),
    USERNAME_INVALID(false, 30101, "用户不存在"),
    PHONE_PASSWORD_FAIL(false, 30102, "手机号或密码错误"),
    ACCOUNT_CODE_USED_FAIL(false, 30103, "验证码已过期"),


    REGISTERED_FAIL(false, 30104, "用户已注册"),

    // 职位
    POSITION_SAVE_FAIL(false, 40100, "职位保存失败"),
    POSITION_UPDATE_FAIL(false, 40101, "职位更新失败"),

    // 菜单
    MENU_SAVE_FAIL(false, 50100, "菜单保存失败"),
    MENU_UPDATE_FAIL(false, 50101, "菜单更新失败"),
    MENU_DELETE_FAIL(false, 50102, "菜单删除失败"),

    // 角色
    ROLE_EXIST(false, 60200, "角色名称已经存在"),
    ROLE_SAVE_FAIL(false, 60201, "角色保存失败"),
    ROLE_UPDATE_FAIL(false, 60202, "角色更新失败"),
    ROLE_DELETE_FAIL(false, 60203, "角色更新失败"),

    PRODUCT_BRAND_EXIST(false, 40201, "品牌名称已经存在"),
    PRODUCT_BRAND_UPDATE_FAIL(false, 40202, "品牌更新失败"),

    // 仓库
    PRODUCT_STORE_EXIST(false, 40300, "仓库名称已经存在"),
    PRODUCT_STORE_SAVE_FAIL(false, 40301, "仓库保存失败"),
    PRODUCT_STORE_UPDATE_FAIL(false, 40302, "仓库更新失败"),

    // 供应商
    PRODUCT_SUPPLIER_EXIST(false, 40400, "供应商名称已经存在"),
    PRODUCT_SUPPLIER_SAVE_FAIL(false, 40401, "供应商保存失败"),
    PRODUCT_SUPPLIER_UPDATE_FAIL(false, 40402, "供应商更新失败"),

    // 客户
    PRODUCT_CLIENT_EXIST(false, 40500, "客户商名称已经存在"),
    PRODUCT_CLIENT_SAVE_FAIL(false, 40501, "客户商保存失败"),
    PRODUCT_CLIENT_UPDATE_FAIL(false, 40502, "客户商更新失败"),

    // 商品
    PRODUCT_EXIST(false, 40400, "商品已经存在"),
    PRODUCT_SAVE_FAIL(false, 40401, "商品保存失败"),
    PRODUCT_UPDATE_FAIL(false, 40402, "商品更新失败"),

    // 商品参数
    PRODUCT_PARAM_EXIST(false, 40700, "商品参数名称已经存在"),
    PRODUCT_PARAM_SAVE_FAIL(false, 40701, "商品参数保存失败"),
    PRODUCT_PARAM_UPDATE_FAIL(false, 40702, "商品参数更新失败"),

    // 采购订单
    PRODUCT_PURCHASE_ORDER_BILL_EXIST(false, 40801, "采购订单已经存在"),
    PRODUCT_PURCHASE_ORDER_BILL_SAVE_FAIL(false, 40802, "采购订单保存失败"),
    PRODUCT_PURCHASE_ORDER_BILL_UPDATE_FAIL(false, 40803, "采购订单更新失败"),

    // 采购订单详情
    PRODUCT_PURCHASE_ORDER_BILL_ITEM_EXIST(false, 40901, "采购订单详情已经存在"),
    PRODUCT_PURCHASE_ORDER_BILL_ITEM_SAVE_FAIL(false, 40902, "采购订单详情保存失败"),
    PRODUCT_PURCHASE_ORDER_BILL_ITEM_UPDATE_FAIL(false, 40903, "采购订单详情更新失败"),

    // 入库订单
    STORE_IN_COME_BILL_EXIST(false, 41001, "入库订单已经存在"),
    STORE_IN_COME_BILL_SAVE_FAIL(false, 41002, "入库订单保存失败"),
    STORE_IN_COME_BILL_UPDATE_FAIL(false, 41003, "入库订单更新失败"),

    // 入库订单详情
    STORE_IN_COME_BILL_ITEM_EXIST(false, 41101, "入库订单详情已经存在"),
    STORE_IN_COME_BILL_ITEM_SAVE_FAIL(false, 41102, "入库订单详情保存失败"),
    STORE_IN_COME_BILL_ITEM_UPDATE_FAIL(false, 41103, "入库订单详情更新失败"),

    // 出库订单
    STORE_OUT_COME_BILL_EXIST(false, 41201, "出库订单已经存在"),
    STORE_OUT_COME_BILL_SAVE_FAIL(false, 41202, "出库订单保存失败"),
    STORE_OUT_COME_BILL_UPDATE_FAIL(false, 41203, "出库订单更新失败"),

    // 出库订单详情
    STORE_OUT_COME_BILL_ITEM_EXIST(false, 41301, "出库订单详情已经存在"),
    STORE_OUT_COME_BILL_ITEM_SAVE_FAIL(false, 41302, "出库订单详情保存失败"),
    STORE_OUT_COME_BILL_ITEM_UPDATE_FAIL(false, 41303, "出库订单详情更新失败"),

    // 商品库存
    REPERTORY_EXIST(false, 41401, "库存已经存在"),
    REPERTORY_SAVE_FAIL(false, 41402, "库存保存失败"),
    REPERTORY_UPDATE_FAIL(false, 41403, "库存更新失败"),
    REPERTORY_PRODUCT_NOT_EXIST(false, 41404, "商品在库存中不存在"),
    REPERTORY_PRODUCT_NOT_MORE(false, 41405, "商品库存不足"),
    REPERTORY_DETAIL_SAVE_FAIL(false, 41406, "库存明细保存失败"),
    REPERTORY_DETAIL_UPDATE_FAIL(false, 41407, "库存明细更新失败"),

    // 公司
    COMPANY_EXIST(false, 50100, "公司名称已经存在"),
    COMPANY_SAVE_FAIL(false, 50101, "公司保存失败"),
    COMPANY_UPDATE_FAIL(false, 50102, "公司更新失败"),

    // 部门
    DEPARTMENT_EXIST(false, 60100, "部门名称已经存在"),
    DEPARTMENT_SAVE_FAIL(false, 60101, "部门保存失败"),
    DEPARTMENT_UPDATE_FAIL(false, 60102, "部门更新失败"),

    // 员工
    EMPLOYEE_EXIST(false, 60300, "员工已经存在"),
    EMPLOYEE_SAVE_FAIL(false, 60301, "员工保存失败"),
    EMPLOYEE_UPDATE_FAIL(false, 60302, "员工更新失败"),
    EMPLOYEE_PASSWORD_FAIL(false, 60303, "密码错误"),
    EMPLOYEE_DELETE_FAIL(false, 60304, "删除员工失败"),
    EMPLOYEE_COUNT_UP_FAIL(false, 60305, "添加员工已达上线"),

    // 员工
    PERMISSION_EMPTY(false, 1, "权限为空"),


    // 支付订单
    ORDER_EXIST(false, 90100, "订单已经存在"),
    ORDER_NOT_EXIST(false, 90101, "订单不存在"),
    PAYMENT_FAIL(false, 90200, "支付失败"),
    PAYMENT_ORDER_FAIL(false, 90201, "支付订单不存在"),
    PAYMENT_CHECK_FAIL(false, 90202, "支付验证失败"),

    // 上传
    UPLOAD_FAIL(false, 1, "上传失败"),

    ;


    private Boolean success;
    private Integer code;
    private String message;

    RavenCodeEnum() {
    }

    RavenCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
