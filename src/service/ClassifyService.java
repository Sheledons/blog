package service;

import java.util.List;

import domain.Classify;
import dao.ClassifyDao;
public class ClassifyService implements ClassifyServiceInter {
	private ClassifyDao dao=new ClassifyDao();
	@Override
	public int getClassifyNumber(int uid) {
		// TODO Auto-generated method stub
		
		return this.dao.getClassifyNumber(uid);
	}

	@Override
	public List<Classify> getClassify(int uid) {
		// TODO Auto-generated method stub
		
		return this.dao.getClassify(uid);
	}

	@Override
	public List<Classify> getClassifyLimit(int uid,int locpage) {
		
		return this.dao.getClassifyLimit(uid, locpage);
	}

	@Override
	public Classify createClassify(String cname,int uid) {
		
		Classify classify=null;
		int flag=this.dao.createClassify(cname, uid);
		if(flag!=0){
			classify=this.dao.getClassifyByCname(cname);
		}
		return classify;
	}

	@Override
	public boolean delClassify(int cid) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int num=this.dao.delClassify(cid);
		if(num!=0){
			flag=true;
		}
		return flag;
	}
}
