package com.example.demo.Service;

import java.util.List;

import com.example.demo.Payloads.MedicationDto;


public interface MedicationServices {
	
	
	MedicationDto saveMedication(MedicationDto medicationDto);
	
	List<MedicationDto> getAllMedications();
	
	MedicationDto getMedicationById(int id);
	
	MedicationDto updateMedication(MedicationDto medicationDto,int id);
     
    void deleteMedication(int id);

}
