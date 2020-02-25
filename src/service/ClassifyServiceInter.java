package service;
import java.util.List;

import domain.Classify;
public interface ClassifyServiceInter {
	public int getClassifyNumber(int uid);
	public List<Classify> getClassify(int uid);
}
