package services;

import java.util.ArrayList;
import java.util.List;

import dao.IDao;
import entities.Rayon;

public class RayonService implements IDao<Rayon>{
	private List<Rayon> rayons;

	public RayonService() {
		rayons = new ArrayList<Rayon>();
	}


	@Override
	public boolean create(Rayon o) {
		
		return rayons.add(o);
	}

	@Override
	public boolean delete(Rayon o) {
		
		return rayons.remove(o);
	}

	@Override
	public boolean update(Rayon newRayon) {
		Rayon oldRayon = findById(newRayon.getId());
		oldRayon.setId(newRayon.getId());
		oldRayon.setCode(newRayon.getCode());
			return true;
	}

	@Override
	public Rayon findById(int id) {
		for (Rayon r  : rayons)
			if (r.getId() == id)
				return r;
		return null;
	}

	@Override
	public List<Rayon> findAll() {
		return rayons;
	}

}
