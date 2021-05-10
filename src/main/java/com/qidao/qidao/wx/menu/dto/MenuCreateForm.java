package com.qidao.qidao.wx.menu.dto;

import com.qidao.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuCreateForm extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String FirstColumnMenuName;
    private String FirstColumnMenuType;
    private String FirstColumnMenuContent;
    private String FirstColumnSubMenus;


    private String SecondColumnMenuName;
    private String SecondColumnMenuType;
    private String SecondColumnMenuContent;
    private String SecondColumnSubMenus;

    private String ThirdColumnMenuName;
    private String ThirdColumnMenuType;
    private String ThirdColumnMenuContent;
    private String ThirdColumnSubMenus;





}
