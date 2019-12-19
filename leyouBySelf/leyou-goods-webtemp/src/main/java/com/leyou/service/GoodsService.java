package com.leyou.service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface GoodsService {
    /**
     * 商品详细信息
     * @param spuId
     * @return
     */
    Map<String,Object> loadModel(Long spuId) throws InterruptedException, ExecutionException;
}
