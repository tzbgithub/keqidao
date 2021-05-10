package com.qidao.qidao.channel.channel.service;

import com.qidao.qidao.channel.channel.domain.ChannelListRes;

import java.util.List;

public interface CustomChannelService {

    List<ChannelListRes> getChannelList();

    /**
     * 下架
     * @param id
     * @return
     */
    int stockFromSale(Long id);

    /**
     * 上架
     * @param id
     * @return
     */
    int shelves(Long id);
}
