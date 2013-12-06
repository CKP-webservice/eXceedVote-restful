package exceedvote.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="criteria")
@Entity
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

}
