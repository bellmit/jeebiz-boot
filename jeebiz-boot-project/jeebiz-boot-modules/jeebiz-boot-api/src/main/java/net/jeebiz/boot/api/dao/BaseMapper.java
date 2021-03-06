/** 
 * Copyright (C) 2018 Jeebiz (http://jeebiz.net).
 * All Rights Reserved. 
 */
package net.jeebiz.boot.api.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import net.jeebiz.boot.api.dao.entities.PaginationEntity;
import net.jeebiz.boot.api.dao.entities.PairModel;

/**
 * 通用Dao接口
 * @author <a href="https://github.com/wandl">wandl</a>
 * @param <T> 持有的实体对象
 */
public interface BaseMapper<T extends Model<?>> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T>  {
	
	/**
	 * 更新数据状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int setStatus(@Param("id") String id, @Param("status") String status);
	
	/**
	 * 分页查询
	 * @param t
	 * @return
	 */
	public List<T> getPagedList(Page<T> page, @Param("model") PaginationEntity<T> model);
	
	/**
	 * 无分页查询
	 * @param t
	 * @return
	 */
	public List<T> getEntityList(T t);
	
	
	/**
	 * 无分页查询
	 * @param key
	 * @return
	 */
	public List<T> getEntityList(@Param("key") String key);
	
	/**
	 * 根据唯一ID编码获取记录数
	 * @param name
	 * @return
	 */
	public int getCountByUid(@Param("uid") String uid);
	
	/**
	 * 根据编码获取记录数
	 * @param code
	 * @param origin
	 * @return
	 */
	public int getCountByCode(@Param("code") String code, @Param("origin") String origin);
	
	/**
	 * 根据名称获取记录数
	 * @param name
	 * @param origin
	 * @return
	 */
	public int getCountByName(@Param("name") String name, @Param("origin") String origin);
	
	public int getCountByParent(@Param("parent") String parent);
	
	/**
	 * 通过指定key查询多个值
	 * @param key
	 * @return
	 */
	public Map<String, String> getValues(@Param("key") String key);
	
	/**
	 * 根据key查询该分组下的基础数据
	 * @param key
	 * @return
	 */
	public List<PairModel> getPairValues(@Param("key") String key);
	
	/**
	 *  查询一组键值对数据
	 * @param key
	 * @return
	 */
	public List<PairModel> getPairList();
	
}
