package com.aht.NhanSu.service;

import com.aht.NhanSu.model.Aht_Contract;
import com.aht.NhanSu.model.Aht_Parts;

import java.util.List;
import java.util.Optional;

public interface PartsService {
    List<Aht_Parts> findAllParts();

    Optional<Aht_Parts> findPartsById(int idParts);

    Aht_Parts createParts(Aht_Parts ahtParts);

    Aht_Parts updateParts(Aht_Parts ahtParts);

    void deleteParts(int idParts);
}
