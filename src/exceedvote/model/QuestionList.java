package exceedvote.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionList {
	@XmlElement
	List<Question> questions;
	
	public QuestionList() {
		questions = new ArrayList<Question>();
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<Question> Questions) {
		this.questions = questions;
	}
	
	public boolean addQuestion(Question question) {
		if(questions.contains(question)) return false;
		return this.questions.add(question);		
	}
}
