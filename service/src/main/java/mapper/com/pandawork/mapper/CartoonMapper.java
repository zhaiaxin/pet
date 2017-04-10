package com.pandawork.mapper;

import com.pandawork.common.entity.Cartoon;


import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 动漫管理mapper层
 * Created by ${阿鑫} on 2016/11/4.
 */
public interface CartoonMapper {



    /**
     * 增加动漫信息
     * @param cartoon
     * @throws Exception
     */

    public void insert(@Param("cartoon") Cartoon cartoon) throws Exception;

    /**
     * 修改动漫信息
     * @param cartoon
     * @return
     * @throws Exception
     */

    public void update(@Param("cartoon") Cartoon cartoon) throws Exception;

    /**
     *删除动漫信息
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deleteById(@Param("id") int id) throws Exception;

    /**
     * 全部动漫信息条数
     * @return
     * @throws Exception
     */

    public int countAll() throws Exception;

    /**
     * 通过id查询动漫
     * @param id
     * @return
     * @throws Exception
     */

    public Cartoon queryById(@Param("id") int id) throws Exception;

    /**
     * 通过动漫类别查询动漫
     * @param name
     * @return
     * @throws Exception
     */



    public List<Cartoon> queryByName(@Param("name") String name) throws Exception;
    /**
     * 通过动漫名称查询动漫
     * @param pName
     * @return
     * @throws Exception
     */

    public Cartoon queryByPName(@Param("pName") String pName) throws Exception;


    /**
     * 查询所有动漫列表
     * @return
     * @throws Exception
     */
    public List<Cartoon> listAll( ) throws Exception;


    /**
     * 动态查询
     * @param name
     * @param pName
     * @param author
     * @return
     * @throws Exception
     */
    public List<Cartoon> queryByCondition(@Param("name") String name, @Param("pName") String pName,
                                          @Param("author") String author) throws Exception;
}
