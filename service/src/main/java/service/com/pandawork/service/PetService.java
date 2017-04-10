package com.pandawork.service;

import com.pandawork.common.entity.Pet;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * petService层
 *
 * @author zhaiaxin
 * @time: 2017/4/9 19:26.
 */

public interface PetService {

    /**
     * 添加宠物
     * @param pet
     * @throws SSException
     */
    public void newPet(Pet pet) throws SSException;

    /**
     * 修改宠物
     * @param pet
     * @throws SSException
     */
    public void updatePet(Pet pet) throws SSException;

    /**
     * 删除宠物
     * @param id
     * @throws SSException
     */
    public void delPetById(int id) throws SSException;

    /**
     * 通过Id查询
     * @param id
     * @throws SSException
     */
    public Pet queryPetById(int id) throws SSException;

    /**
     * 通过classificationId查询
     * @param classificationId
     * @throws SSException
     */
    public List<Pet> queryByClassificationId(int classificationId) throws SSException;

    /**
     * 通过classificationPId查询
     * @param classificationPId
     * @throws SSException
     */
    public List<Pet> queryByClassificationPId(int classificationPId) throws SSException;

}
