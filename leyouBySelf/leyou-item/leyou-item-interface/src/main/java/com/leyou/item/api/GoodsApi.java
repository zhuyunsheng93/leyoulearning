package com.leyou.item.api;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.SeckillGoods;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.SpuDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("goods")
public interface GoodsApi {
    /**
     * 分页查询
     *
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @param saleable
     * @return
     */
    @GetMapping("/spu/page")
     PageResult<SpuBo> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "saleable", defaultValue = "true") Boolean saleable);

    /**
     * 根据id查询商品
     *
     * @param id
     * @return
     */
    @GetMapping("/spu/{id}")
     SpuBo queryGoodsById(@PathVariable("id") Long id);

    /**
     * 根据Spu的id查询其下所有的sku
     *
     * @param id
     * @return
     */
    @GetMapping("sku/list/{id}")
     List<Sku> querySkuBySpuId(@PathVariable("id") Long id);

    /**
     * 根据spu商品id查询详情
     *
     * @param id
     * @return
     */
    @GetMapping("/spu/detail/{id}")
     SpuDetail querySpuDetailBySpuId(@PathVariable("id") Long id);

    /**
     * 根据id查询sku
     *
     * @param id
     * @return
     */
    @GetMapping("/sku/{id}")
     Sku querySkuById(@PathVariable("id") Long id);

    /**
     * 查询秒杀商品
     *
     * @return
     */
    @GetMapping("/seckill/list")
    ResponseEntity<List<SeckillGoods>>  querySeckillGoods();

}