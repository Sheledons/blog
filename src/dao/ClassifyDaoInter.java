package dao;

import java.util.List;
import domain.Classify;
public interface ClassifyDaoInter {
	public int getClassifyNumber(int uid);
	public List<Classify> getClassify(int uid);
	public List<Classify> getClassifyLimit(int uid,int locpage);
}
