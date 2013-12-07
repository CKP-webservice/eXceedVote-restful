package exceedvote.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="criteria")
public class CriterionList {

	private List<Criterion> criterionList;

	public CriterionList() {
		criterionList = new ArrayList<Criterion>();
	}
	
	public void setCriterionList(List<Criterion> criterionList) {
		if(criterionList != null)
			this.criterionList = criterionList;
	}
	
	public List<Criterion> getCriterionList() {
		return criterionList;
	}
	
	public void add(Criterion criterion) {
		this.criterionList.add(criterion);
	}

}
