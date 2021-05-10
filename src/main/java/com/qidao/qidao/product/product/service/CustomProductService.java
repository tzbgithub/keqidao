package com.qidao.qidao.product.product.service;

import com.qidao.qidao.product.product.domain.ProductInsertReq;
import com.qidao.qidao.product.product.domain.ProductReq;
import com.qidao.qidao.product.product.domain.ProductRes;
import com.qidao.qidao.product.product.domain.ProductUpdateReq;

import java.util.List;

public interface CustomProductService {

    List<ProductRes> getProduct(ProductReq req);

    int shelves(Long id);

    int stockFromSale(Long id);

    int create(ProductInsertReq req);

    int updateProduct(ProductUpdateReq req);
}
