package com.pandawork.service.impl;

import com.pandawork.common.entity.Pet;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.mapper.PetMapper;
import com.pandawork.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 职责
 *
 * @author zhaiaxin
 * @time: 2017/4/9 19:31.
 */

@Service("petService")
public class PetServiceImpl implements PetService {

    @Autowired
    PetMapper petMapper;

    public void newPet(Pet pet) throws SSException {
        if (Assert.isNull(pet)) {
            return;
        }
        try {
            petMapper.newPet(pet);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.NewPetFailed, e);
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})//只要对数据库有改动，就得写
    public void updatePet(Pet pet) throws SSException {

        try {
            petMapper.updatePet(pet);
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdatePetFailed, e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})//只要对数据库有改动，就得写
    public void delPetById(int id) throws SSException {

        try {
            petMapper.delPetById(id);
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.delPetFailed, e);
        }
    }


    public Pet queryPetById(int id) throws SSException {

        try {
            return petMapper.queryPetById(id);
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.queryPetByIdFailed, e);
        }
    }

    public List<Pet> queryByClassificationId(int classificationId) throws SSException{
        try {
            return petMapper.queryByClassificationId(classificationId);
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.queryByClassificationIdFailed, e);
        }

    }

    public List<Pet> queryByClassificationPId(int classificationPId) throws SSException{
        try {
            return petMapper.queryByClassificationId(classificationPId);
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.queryByClassificationPIdFailed, e);
        }

    }





}
