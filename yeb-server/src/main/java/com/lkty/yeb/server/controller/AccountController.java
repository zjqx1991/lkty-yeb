package com.lkty.yeb.server.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.lkty.yeb.api.admin.IAccountAPI;
import com.lkty.yeb.common.code.RavenCodeEnum;
import com.lkty.yeb.common.constant.server.AccountConstant;
import com.lkty.yeb.common.handler.RavenException;
import com.lkty.yeb.common.pojo.account.AccountEntity;
import com.lkty.yeb.common.result.R;
import com.lkty.yeb.server.service.IAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;


@RestController
public class AccountController implements IAccountAPI {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    private HttpServletRequest request;

    @Override
    public R code(HttpServletRequest request, HttpServletResponse response) {
        // 定义response输出类型为 image/jpeg 类型
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidaate");
        // Set IE extended HTTP/1.1 no-cache headers（use addHeader）
        response.addHeader("Cache-Control", "post-check=-0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        //********* 生成验证码 begin ***********
        // 获取验证码文本内容
        String text = this.defaultKaptcha.createText();
        // 将验证码文本内容放入session
        request.getSession().setAttribute(AccountConstant.ACCOUNT_CODE_KEY, text);
        // 根据文本验证码内容创建图形验证码
        BufferedImage image = this.defaultKaptcha.createImage(text);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            // 输出流输出图片，格式为jpg
            ImageIO.write(image, "jpg", outputStream);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {

        }

        //********* 生成验证码  end  ***********
        return null;
    }

    @Override
    public R login(@RequestBody AccountEntity accountEntity) {
        if (StringUtils.isBlank(accountEntity.getUsername()) || StringUtils.isBlank(accountEntity.getPassword()) || StringUtils.isBlank(accountEntity.getCode())) {
            throw new RavenException(RavenCodeEnum.PHONE_PASSWORD_FAIL);
        }
        Object code = this.request.getSession().getAttribute(AccountConstant.ACCOUNT_CODE_KEY);
        if (null == code || !code.equals(accountEntity.getCode())) {
            throw new RavenException(RavenCodeEnum.ACCOUNT_CODE_USED_FAIL);
        }
        return this.accountService.login(accountEntity.getUsername(), accountEntity.getPassword());
    }

    @Override
    public R logout() {
        return R.ok();
    }

    @Override
    public R getUserInfo() {
        return this.accountService.getUserInfo();
    }
}
