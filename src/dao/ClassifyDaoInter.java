package dao;

import java.util.List;
import domain.Classify;
public interface ClassifyDaoInter {
	public int getClassifyNumber(int uid);
	public List<Classify> getClassify(int uid);
	public List<Classify> getClassifyLimit(int uid,int locpage);
	public int createClassify(String c,int uid);
	public Classify getClassifyByCname(String cname);
	public int delClassify(int cid);
}
