package vn.jv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import vn.jv.persist.domain.Skill;
import vn.jv.persist.repositories.SkillRepo;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
@Service("skillService")
public class SkillService extends BaseService implements ISkillService {
	@Autowired
	SkillRepo skillRepo;
	
	@Cacheable("SkillService.findAll")
	public List<Skill> findAll() {
		return skillRepo.findAll();
	}

	
	public List<Skill> findByIds(List<Integer> skillIds) {
		List<Skill> skills = new ArrayList<Skill>();
		if (skillIds != null) {
			for (Integer skillId : skillIds) {
				Skill skill = findById(skillId);
				skills.add(skill);
			}
		}
		return skills;
	}

	@Cacheable(value = {"SkillService.findById"}, key = "skillId")
	public Skill findById(Integer skillId) {
		return skillRepo.findOne(skillId);
	}

}
