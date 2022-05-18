package com.ctse_assignment3.supplier_it19107356.controller;

import com.ctse_assignment3.supplier_it19107356.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ctse_assignment3.supplier_it19107356.repository.supplierRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctse_assignment3.supplier_it19107356.model.supplier;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class supplierController {

    @Autowired
    private supplierRepository supplierRepository;

    /*
     * @Autowired
     * private supplierService supplierService;
     */

    @GetMapping("/supplier/all")
    public List<supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @GetMapping("/supplier/{id}")
    public ResponseEntity<supplier> getSupplierById(@PathVariable(value = "id") Long supplierId)
            throws ResourceNotFoundException {
        supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + supplierId));

        return ResponseEntity.ok().body(supplier);
    }

    @PostMapping("/supplier")
    public supplier createSupplier(@RequestBody supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @PutMapping("/supplier/edit/{id}")
    public ResponseEntity<supplier> updateSupplier(@PathVariable(value = "id") Long supplierId,
            @RequestBody supplier supplierDetails) throws ResourceNotFoundException {
        supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + supplierId));

        supplier.setSupplier_name(supplierDetails.getSupplier_name());
        supplier.setCompany_name(supplierDetails.getCompany_name());
        supplier.setAddress(supplierDetails.getAddress());
        supplier.setEmail(supplierDetails.getEmail());
        supplier.setPhone(supplierDetails.getPhone());
        supplier.setItem_category(supplierDetails.getItem_category());
        final supplier updatedSupplier = supplierRepository.save(supplier);
        return ResponseEntity.ok(updatedSupplier);

    }

    @DeleteMapping("/supplier/delete/{id}")
    public Map<String, Boolean> deleteSupplier(@PathVariable(value = "id") Long supplierId)
            throws ResourceNotFoundException {

        supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + supplierId));
        supplierRepository.delete(supplier);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}