package service;

import java.util.List;

import domain.Classify;
import dao.ClassifyDao;
public class ClassifyService implements ClassifyServiceInter {

	@Override
	public int getClassifyNumber(int uid) {
		// TODO Auto-generated method stub
		ClassifyDao dao=new ClassifyDao();
		return dao.getClassifyNumber(uid);
	}

	@Override
	public List<Classify> getClassify(int uid) {
		// TODO Auto-generated method stub
		ClassifyDao dao=new ClassifyDao();
		return dao.getClassify(uid);
	}

	@Override
	public List<Classify> getClassifyLimit(int uid,int locpage) {
		ClassifyDao dao=new ClassifyDao();
		return dao.getClassifyLimit(uid, locpage);
	}
}
