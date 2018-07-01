package service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.dao.AcademicDegreesDAO;
import model.AcademicDegrees;
import service.AcademicDegreesService;

@Service
public class AcademicDegreesServiceImpl implements AcademicDegreesService {
	
	private AcademicDegreesDAO academicDegreeDAO;

	public void setAcademicDegreesDAO(AcademicDegreesDAO academicDegreeDAO) {
		this.academicDegreeDAO = academicDegreeDAO;
	}
	
	@Override
	@Transactional
	public List<AcademicDegrees> listAcademicDegrees() {
		return this.academicDegreeDAO.listAcademicDegrees();
	}

}
