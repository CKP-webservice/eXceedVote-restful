package exceedvote.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="criteria")
@XmlAccessorType(XmlAccessType.FIELD)
public class CriterionList {

	@XmlElement(name="criterion")
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
