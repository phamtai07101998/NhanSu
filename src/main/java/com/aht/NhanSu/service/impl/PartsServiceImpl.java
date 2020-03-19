package com.aht.NhanSu.service.impl;

import com.aht.NhanSu.dao.PartsDAO;
import com.aht.NhanSu.model.Aht_Parts;
import com.aht.NhanSu.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartsServiceImpl implements PartsService {

    @Autowired
    private PartsDAO partsDAO;

    @Override
    public List<Aht_Parts> findAllParts() {
        return partsDAO.findAll();
    }

    @Override
    public Optional<Aht_Parts> findPartsById(int idParts) {
        return partsDAO.findById(idParts);
    }

    @Override
    public Aht_Parts createParts(Aht_Parts ahtParts) {
        return partsDAO.save(ahtParts);
    }

    @Override
    public Aht_Parts updateParts(Aht_Parts ahtParts) {
        Optional<Aht_Parts> findParts = partsDAO.findById(ahtParts.getPartsId());
        if (findParts.isPresent()){
            Aht_Parts updateParts = findParts.get();
            updateParts.setPartsId(ahtParts.getPartsId());
            updateParts.setDepartmentList(ahtParts.getDepartmentList());
            updateParts.setPartsName(ahtParts.getPartsName());
            return partsDAO.save(updateParts);
        }
        return null;
    }

    @Override
    public void deleteParts(int idParts) {
        partsDAO.deleteById(idParts);
    }
}
