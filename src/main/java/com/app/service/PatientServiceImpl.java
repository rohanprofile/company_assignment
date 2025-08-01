//package com.app.service;
//
//import java.sql.SQLIntegrityConstraintViolationException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.regex.Pattern;
//
//import javax.transaction.Transactional;
//import javax.validation.ConstraintViolationException;
//
//import org.hibernate.Transaction;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//
//import com.app.dao.IPatientDao;
//import com.app.dto.PatientDto;
//import com.app.pojos.Patient;
//
//
//@Service
//@Transactional
//public class PatientServiceImpl implements IPatientService {
//
//	@Autowired
//	ModelMapper mapper;
//
//	@Autowired
//	IPatientDao patDao;
//	
//    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";  
//	@Override
//	public String savepatientDetails(PatientDto pat) {
//		// TODO Auto-generated method stub
//		
//		
//		System.out.println("save patient details " +pat);
//		
//		if(pat.getDob().isBefore(LocalDate.parse("1990-01-01",DateTimeFormatter.ofPattern("yyyy-MM-dd")))) {//isBefore("1990-01-01")
//			
//			return "invalid date";
//		}
//		//if does not matches with the following
//		if ( ! (Pattern.matches(regex, pat.getEmail()) && pat.getEmail().endsWith(".com")  || pat.getEmail().endsWith(".co.in") ) ){
//			
//			return "invalid email";
//			
//		}
//		
//		
//		
//		//if above all vaidations are ok than save details into database
//		//Patient patPers=mapper.map(pat,Patient.class);
//		
//		
//		Patient patPers=new Patient();
//		patPers.setAddress(pat.getAddress());
//		patPers.setBloodGroup(pat.getBloodGroup());
//		patPers.setContactNo(pat.getContactNo());
//		patPers.setDob(pat.getDob());
//		patPers.setEmail(pat.getEmail());
//		patPers.setName(pat.getName());
//		
//		System.out.println("pat dao "+patDao);
//		
////		try {
//		patDao.save(patPers);
//		System.out.println("pat persi in service "+patPers); 
//		 
//		return "patient reg successfull";
////		}
////		catch(RuntimeException e) {
////			
////			System.err.println(" error in constraint voilation "+e.getMessage());
////			return "Some constraint violation has been made";
////			
////		}
//	
//		
//	}
//
//
//	@Override
//	public long deletePatientByEmail(String email) {
//		
//		return patDao.deleteByEmail(email);
//	}
//	
//
//
//}
