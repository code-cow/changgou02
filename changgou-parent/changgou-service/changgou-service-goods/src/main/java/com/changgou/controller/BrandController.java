package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
/**
 *
 */
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 条件加分页
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand,
                                            @PathVariable(value = "page")Integer page,
                                            @PathVariable(value = "size")Integer size){
        PageInfo<Brand> pageInfo = brandService.findPage(brand,page, size);
        return  new Result<PageInfo<Brand>>(true,StatusCode.Ok,"pageinfo ok",pageInfo);
    }

    /**
     *分页
     * @param
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "page")Integer page,
                                 @PathVariable(value = "size")Integer size){
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return  new Result<PageInfo<Brand>>(true,StatusCode.Ok,"pageinfo ok",pageInfo);
    }

    /**
     * 根据品牌信息多条件搜索
     * @param brand
     * @return
     */
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        List<Brand> brands = brandService.findList(brand);
        return new Result<List<Brand>>(true,StatusCode.Ok,"search ok",brands);
    }

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id")Integer id){

        brandService.delete(id);
        return new Result(true,StatusCode.Ok,"delete ok");
    }

    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id")Integer id ,@RequestBody Brand brand){
        brand.setId(id);
        System.out.println(id);
        System.out.println(brand);
        brandService.update(brand);
        return new Result(true,StatusCode.Ok,"update ok");
    }

    /**
     * 增加品牌
     */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.Ok,"add ok");
    }

    /**
     * 根据id查询品牌
     */
    @GetMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable(value = "id")Integer id){
        System.out.println(id);
        Brand brand = brandService.findById(id);
        System.out.println(brand);
        return new Result<Brand>(true,StatusCode.Ok,"根据id查询所有品牌ok",brand);
    }

    /**
     * 查询所有品牌
     * @return
     */
    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> brands = brandService.findAll();
        System.out.println(brands);
        return new Result<List<Brand>>(true, StatusCode.Ok,"成功",brands);

    }

}
