package com.pandawork.mapper;

import com.pandawork.common.entity.Pet;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * pet管理mapper层
 *
 * @author zhaiaxin
 * @time: 2017/4/9 19:08.
 */
public interface PetMapper {

    /**
     * 添加宠物
     * @param pet
     * @throws Exception
     */
    public void newPet(@Param("pet")Pet pet) throws Exception;

    /**
     * 修改宠物
     * @param pet
     * @throws Exception
     */
    public void updatePet(@Param("pet")Pet pet) throws Exception;

    /**
     * 删除宠物
     * @param id
     * @throws Exception
     */
    public void delPetById(@Param("id")int id) throws Exception;

    /**
     * 通过Id查询
     * @param id
     * @throws Exception
     */
    public Pet queryPetById(@Param("id")int id) throws Exception;

    /**
     * 通过classificationId查询
     * @param classificationId
     * @throws Exception
     */
    public List<Pet> queryByClassificationId(@Param("classificationId")int classificationId) throws Exception;

    /**
     * 通过classificationPId查询
     * @param classificationPId
     * @throws Exception
     */
    public List<Pet> queryByClassificationPId(@Param("classificationPId")int classificationPId) throws Exception;
}
