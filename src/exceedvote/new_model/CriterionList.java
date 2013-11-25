package exceedvote.new_model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="criterions")
@Entity
public class CriterionList {
	List<Criterion> criterionList;
	
	public CriterionList() {
		criterionList = new ArrayList<Criterion>();
	}
}
