package com.qidao.qidao.salesman.salesman.domain;

import com.qidao.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 销售员对象 salesmanDO
 *
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2020/12/30 3:46 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesmanDO extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 销售员id集合
     */
    private String[] ids;
    /**
     * 销售员密码
     */
    private String password;
}
