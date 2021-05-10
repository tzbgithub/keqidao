package com.qidao.qidao.product.product.service.impl;

import com.github.pagehelper.Page;
import com.qidao.common.utils.StringUtils;
import com.qidao.common.utils.bean.BeanUtils;
import com.qidao.common.utils.security.ShiroUtils;
import com.qidao.framework.util.SnowflakeIdWorker53;
import com.qidao.project.system.user.domain.User;
import com.qidao.project.system.user.mapper.UserMapper;
import com.qidao.qidao.product.product.domain.*;
import com.qidao.qidao.product.product.mapper.CustomProductMapper;
import com.qidao.qidao.product.product.mapper.ProductSkuMapper;
import com.qidao.qidao.product.product.service.CustomProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("customProductService")
public class CustomProductServiceImpl implements CustomProductService {

    @Resource
    private CustomProductMapper customProductMapper;

    @Resource
    private ProductSkuMapper productSkuMapper;

    @Resource
    private SnowflakeIdWorker53 snowflakeIdWorker;

    @Resource
    private UserMapper userMapper;

    @Override
    public List<ProductRes> getProduct(ProductReq req) {
        List<Product> products = customProductMapper.getProduct(req);
        List<User> verifyUser = userMapper.getVerifyUser();
        Map<Long, String> userMap = verifyUser.stream().collect(Collectors.toMap(User::getUserId, User::getUserName, (oldV, newV) -> newV));
        Page<ProductRes> res = new Page<>();
        products.forEach(product -> {
            ProductRes productRes = new ProductRes();
            BeanUtils.copyProperties(product , productRes);
            productRes.setUpdateName(userMap.get(product.getUpdateBy()));
            res.add(productRes);
        });
        if(products instanceof Page) {
            res.setTotal(((Page<Product>) products).getTotal());
        }
        return res;
    }

    @Override
    public int shelves(Long id) {
        return customProductMapper.shelves(id , ShiroUtils.getUserId());
    }

    @Override
    public int stockFromSale(Long id) {
        return customProductMapper.stockFromSale(id, ShiroUtils.getUserId());
    }

    @Override
    public int create(ProductInsertReq req) {
        ProductSku productSku = new ProductSku();
        BeanUtils.copyProperties(req , productSku);
        productSku.setServerVal(Integer.valueOf(req.getServerVal().toString()));
        productSku.setCreateBy(ShiroUtils.getUserId());
        productSku.setId(snowflakeIdWorker.nextId());
        return productSkuMapper.insertSelective(productSku);
    }

    @Override
    public int updateProduct(ProductUpdateReq req) {
        ProductSku sku = new ProductSku();
        BeanUtils.copyProperties(req , sku);
        if (StringUtils.isNotEmpty(req.getExtra())){
            sku.setExtra(req.getExtra().replace("1","hot").replace("2","sale"));
        }
        sku.setUpdateBy(ShiroUtils.getUserId());
        return productSkuMapper.updateByPrimaryKeySelective(sku);
    }
}
