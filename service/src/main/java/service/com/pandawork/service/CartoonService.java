package com.pandawork.service;
import com.pandawork.common.entity.Cartoon;
import com.pandawork.core.common.exception.SSException;
import java.util.List;

/**
 * 动漫管理系统
 * CartoonService层
 * Created by ${阿鑫} on 2016/11/4.
 */
public interface CartoonService {

    /**
     * 增加动漫信息
     * @param cartoon
     * @throws SSException
     */

    public void insert(Cartoon cartoon) throws SSException;//SSException什么意思

    /**
     * 修改动漫信息
     * @param cartoon
     * @throws SSException
     */

    public void update(Cartoon cartoon) throws SSException;

    /**
     * 删除动漫信息
     * @param id
     * @return
     * @throws SSException
     */

    public boolean deleteById(int id) throws SSException;

    /**
     * 全部动漫信息条数
     * @return
     * @throws SSException
     */

    public int countAll() throws SSException;

    /**
     * 根据id查询动漫的数目
     * @param id
     * @return
     * @throws SSException
     */

    public Cartoon queryById(int id) throws SSException;

    /**
     * 通过动漫类别查询动漫
     * @param name
     * @return
     * @throws SSException
     */

    public List<Cartoon> queryByName(String name) throws SSException;
    /**
     * 搜素Name中的字符
     * @param pName
     * @return
     * @throws SSException
     */

    public Cartoon queryByPName(String pName) throws SSException;

    /**
     * 动漫信息列表
     * @return
     * @throws SSException
     */

    public List<Cartoon> listAll( ) throws SSException;


    /**
     * 动态查询
     * @param name
     * @param pName
     * @param author
     * @return
     * @throws SSException
     */
    public List<Cartoon> queryByCondition(String name,String pName, String author) throws SSException;
}
