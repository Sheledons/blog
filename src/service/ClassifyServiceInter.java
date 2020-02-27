package service;
import java.util.List;

import domain.Classify;
public interface ClassifyServiceInter {
	public int getClassifyNumber(int uid);
	public List<Classify> getClassify(int uid);
	public List<Classify> getClassifyLimit(int uid,int locpage);
	public Classify createClassify(String cname,int uid);
	public boolean delClassify(int cid);
}
