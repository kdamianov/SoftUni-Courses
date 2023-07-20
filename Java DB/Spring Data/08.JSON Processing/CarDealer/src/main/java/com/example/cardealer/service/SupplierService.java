package com.example.cardealer.service;

import com.example.cardealer.model.dto.suppliersDto.SupplierNotImportersDto;
import com.example.cardealer.model.entities.Supplier;

import java.io.IOException;
import java.util.List;

public interface SupplierService {
  void seedSuppliers() throws IOException;

  Supplier findRandomSupplier();

    List<SupplierNotImportersDto> getAllSuplliersNotImporting();
}
