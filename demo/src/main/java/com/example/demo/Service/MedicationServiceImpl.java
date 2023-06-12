package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Medication;

import com.example.demo.Exception.ResourceNotFoundException;

import com.example.demo.Payloads.MedicationDto;

import com.example.demo.Repository.MedicationRepo;

@Service
public class MedicationServiceImpl implements MedicationServices {
	
	@Autowired
	private MedicationRepo medicationRepo;
   @Autowired
	private ModelMapper modelMapper;

	@Override
	public MedicationDto saveMedication(MedicationDto medicationDto) {
		Medication medication =this.dtoToMedication(medicationDto);
		medication.setDosage(medicationDto.getDosage());
		medication.setFrequency(medicationDto.getFrequency());
		medication.setName(medicationDto.getName());
		medication.setInstructions(medicationDto.getInstructions());
		
		Medication savedMedication = this.medicationRepo.save(medication);
		return this.medicationToDto(savedMedication);
		//return null;
	}

	@Override
	public List<MedicationDto> getAllMedications() {
		List<Medication>medications =this.medicationRepo.findAll();
		
		List<MedicationDto> medicationDtos=medications.stream().map(medication->this.medicationToDto(medication)).collect(Collectors.toList());
		return medicationDtos;
		//return null;
	}

	@Override
	public MedicationDto getMedicationById(int id) {
		Medication medication=this.medicationRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Medication", "id", id));
		return this.medicationToDto(medication);
	}

	@Override
	public MedicationDto updateMedication(MedicationDto medicationDto, int id) {
		Medication medication=this.medicationRepo.findById(id).orElseThrow();
		medication.setDosage(medicationDto.getDosage());
		medication.setFrequency(medicationDto.getFrequency());
		medication.setInstructions(medicationDto.getInstructions());
		medication.setName(medicationDto.getName());
		Medication upadateMedication =this.medicationRepo.save(medication);
		MedicationDto medicationDto1 =this.medicationToDto(upadateMedication);
		
		return medicationDto1;
	}

	@Override
	public void deleteMedication(int id) {
		Medication medication=this.medicationRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));	
		this.medicationRepo.delete(medication);
		
	}
	
	public Medication dtoToMedication(MedicationDto medicationDto) {
		Medication medication = this.modelMapper.map(medicationDto, Medication.class);
		return medication;
	}
	public MedicationDto medicationToDto(Medication medication) {
		MedicationDto medicationDto =this.modelMapper.map(medication, MedicationDto.class);
		return medicationDto;
	}

}
