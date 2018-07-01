package service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import database.dao.SkillsDAO;
import model.Skills;
import service.SkillsService;

@Service
public class SkillsServiceImpl implements SkillsService {
	private SkillsDAO skillDAO;

	public void setSkillsDAO(SkillsDAO skillDAO) {
		this.skillDAO = skillDAO;
	}
	
	@Override
	@Transactional
	public List<Skills> listSkills() {
		return this.skillDAO.listSkills();
	}

}
