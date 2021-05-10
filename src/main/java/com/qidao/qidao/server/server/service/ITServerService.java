package com.qidao.qidao.server.server.service;

import com.qidao.qidao.server.server.domain.TServer;
import java.util.List;

/**
 * 服务(需求)Service接口
 * 
 * @author yqj
 * @date 2021-02-18
 */
public interface ITServerService {
    /**
     * 查询服务(需求)
     * 
     * @param id 服务(需求)ID
     * @return 服务(需求)
     */
    TServer selectTServerById(Long id);

    /**
     * 查询服务(需求)列表
     * 
     * @param tServer 服务(需求)
     * @return 服务(需求)集合
     */
    List<TServer> selectTServerList(TServer tServer);

    /**
     * 新增服务(需求)
     * 
     * @param tServer 服务(需求)
     * @return 结果
     */
    int insertTServer(TServer tServer);

    /**
     * 修改服务(需求)
     * 
     * @param tServer 服务(需求)
     * @return 结果
     */
    int updateTServer(TServer tServer);

    /**
     * 批量删除服务(需求)
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTServerByIds(String ids);

    /**
     * 删除服务(需求)信息
     * 
     * @param id 服务(需求)ID
     * @return 结果
     */
    int deleteTServerById(Long id);

                                                                                                                                                                                                                                    int logicDelByIds(String ids);
                                                                        }
