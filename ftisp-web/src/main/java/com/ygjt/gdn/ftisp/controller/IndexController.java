package com.ygjt.gdn.ftisp.controller;


import com.ygjt.gdn.ftisp.auth.tools.VelocitySecurityUtil;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.enums.EmailCodeEnum;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.EntInfoDo;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.po.ValidEmailPO;
import com.ygjt.gdn.ftisp.service.EntInfoService;
import com.ygjt.gdn.ftisp.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    UserService userService;
    @Autowired
    EntInfoService entInfoService;

    @RequestMapping("/")
    public String rootIndex(Model model) {
        return "/page/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        return "/page/index";
    }

    @RequestMapping("/manage/")
    public String manageRootIndex(Model model) {
        return "/velocity";
    }

    @RequestMapping("/manage/enterprise")
    public String manageIndex(Model model) {
        return "/page/backstage/back-enterprise/back-enterprise";
    }
    @RequestMapping("/back-enterprise")
    public String backnterprise(Model model) {
        return "/page/backstage/back-enterprise/back-enterprise";
    }

    @RequestMapping("/back-enterprise-detail")
    public String backnterpriseDatail(Model model) {
        return "/page/backstage/back-enterprise/back-enterprise-detail";
    }

    @RequestMapping("/velocity")
    public String velocity() {
        return "velocity";
    }

    @RequestMapping("/jsp")
    public String jsp() {
        return "jsp";
    }

    @RequestMapping("/article")
    public String article() {
        return "/page/article/article";
    }

    @RequestMapping("/article-detail")
    public String articleDetail() {
        return "/page/article/article-detail";
    }

    @RequestMapping("/about-us")
    public String aboutUs() {
        return "/page/about-us/about-us";
    }

    @RequestMapping("/service")
    public String service() {
        return "/page/service/service";
    }

    @RequestMapping("/register")
    public String register() {
        return "/page/start/register";
    }

    @RequestMapping("/forget-password")
    public String forgetPassword() {
        return "/page/start/forget-password";
    }


    /**
     * 激活码校验
     *
     * @param po
     * @param model
     * @param result
     * @return
     */
    @RequestMapping("/validEmail")
    public String validEmail(@Valid ValidEmailPO po, Model model, BindingResult result) {
        List<String> errorList = new ArrayList<String>();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        if (errorList.size() > 0) {
            model.addAttribute("message", errorList.get(0));
            model.addAttribute("validStatus", Constants.RESULT_CODE_FAIL);
            //邮箱验证第二步
            model.addAttribute("step", "2");
        } else {
            try {
                userService.validEmail(po.getCode());
                model.addAttribute("code", po.getCode());
                model.addAttribute("message", "邮箱已验证成功");
                model.addAttribute("validStatus", Constants.RESULT_CODE_SUCCESS);
                //邮箱验证第三步
                model.addAttribute("step", "3");
            } catch (ServiceException e) {
                logger.error("激活码校验异常ServiceException：", e);
                model.addAttribute("message", e.getMessage());
                model.addAttribute("validStatus", Constants.RESULT_CODE_FAIL);
                //邮箱验证第二步
                model.addAttribute("step", "2");
            } catch (Exception e) {
                logger.error("激活码校验异常：", e);
                model.addAttribute("message", "激活码校验异常");
                model.addAttribute("validStatus", Constants.RESULT_CODE_FAIL);
                //邮箱验证第二步
                model.addAttribute("step", "2");
            }
        }

        if (StringUtils.equals(po.getMailType(), EmailCodeEnum.TYPE.EMAIL_TYPE_REGISTER.getFront_value())) {
            return "/page/start/register";
        } else {
            return "/page/start/forget-password";
        }

    }


    @RequestMapping("/enterprise")
    public String company(Model model) {
        //获取用户信息
        UserDo userDo = VelocitySecurityUtil.getUserDo();
        if(userDo.getSystemId()==null){
            return "/page/backstage/back-enterprise/back-enterprise";
        }else{

            //根据用户id获取对应的企业ID
            EntInfoDo entInfoDo = entInfoService.getEntByUserId(userDo.getId());
            if (null != entInfoDo) {
                model.addAttribute("id", entInfoDo.getId());
            }
            return "/page/user-center/info/enterprise/enterprise";
        }
    }

    @RequestMapping("/enterprise-update")
    public String enterpriseUpdate(Model model) {
        return "/page/user-center/info/enterprise/enterprise-update";
    }

    @RequestMapping("/commodity")
    public String commodity$() {
        return "/page/user-center/info/commodity/commodity";
    }

    @RequestMapping("/commodity-add")
    public String commodityAdd() {
        return "/page/user-center/info/commodity/commodity-add";
    }

    @RequestMapping("/commodity-update")
    public String commodityUpdate() {
        return "/page/user-center/info/commodity/commodity-add";
    }

    @RequestMapping("/commodity-detail")
    public String commodityDetail() {
        return "/page/user-center/info/commodity/commodity-detail";
    }

    @RequestMapping("/in-order")
    public String inOrder() {
        return "/page/user-center/domestic/in-order/in-order";
    }

    @RequestMapping("/in-order-detail")
    public String orderDetail() {
        return "/page/user-center/domestic/in-order/in-order-detail";
    }

    @RequestMapping("/in-order-add")
    public String inOrderAdd() {
        return "/page/user-center/domestic/in-order/in-order-add";
    }

    @RequestMapping("/address")
    public String address() {
        return "/page/user-center/info/address/address";
    }

    @RequestMapping("/address-add")
    public String addressAdd() {
        return "/page/user-center/info/address/address-add";
    }

    @RequestMapping("/address-update")
    public String addressUpdate() {
        return "/page/user-center/info/address/address-add";
    }

    @RequestMapping("/address-detail")
    public String addressDetail() {
        return "/page/user-center/info/address/address-detail";
    }

    @RequestMapping("/deliver-order")
    public String deliverOrder() {
        return "/page/user-center/overseas/deliver-order/deliver-order";
    }

    @RequestMapping("/deliver-order-add")
    public String deliverOrderAdd() {
        return "/page/user-center/overseas/deliver-order/deliver-order-add";
    }

    @RequestMapping("/stock")
    public String stock() {
        return "/page/user-center/overseas/stock/stock";
    }

    @RequestMapping("/deliver-order-update")
    public String deliverOrderUpdate() {
        return "/page/user-center/overseas/deliver-order/deliver-order-update";
    }

    @RequestMapping("/deliver-order-detail")
    public String deliverOrderDetail() {
        return "/page/user-center/overseas/deliver-order/deliver-order-detail";
    }

    @RequestMapping("/back-article")
    public String backArticle(){ return "/page/backstage/back-article/back-article"; }

    @RequestMapping("/back-article-add")
    public String backArticleAdd(){ return "/page/backstage/back-article/back-article-add"; }

    @RequestMapping("/back-article-detail")
    public String backArticleDetail(){ return "/page/backstage/back-article/back-article-detail"; }
}
