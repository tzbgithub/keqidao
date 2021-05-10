package com.qidao.qidao.product.product.mapper;

import com.qidao.qidao.product.product.domain.Product;
import com.qidao.qidao.product.product.domain.ProductReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomProductMapper {

    List<Product> getProduct(ProductReq req);

    int shelves(Long id , Long updateId);

    int stockFromSale(Long id , Long updateId);

}
