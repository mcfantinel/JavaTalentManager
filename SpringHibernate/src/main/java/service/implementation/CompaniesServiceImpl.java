package service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.dao.CompaniesDAO;
import model.Companies;
import service.CompaniesService;

@Service
public class CompaniesServiceImpl implements CompaniesService {
	private CompaniesDAO companyDAO;

	public void setCompaniesDAO(CompaniesDAO companyDAO) {
		this.companyDAO = companyDAO;
	}
	
	@Override
	@Transactional
	public List<Companies> listCompanies() {
		return this.companyDAO.listCompanies();
	}

}
