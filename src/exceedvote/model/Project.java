package exceedvote.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * @author Kanin Sirisith
 * Model from project
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {
	private String projectName;
	private String projectDetail;
	private String imgURL1;
	private String imgURL2;
	private String imgURL3;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String shortProjectDetail;
	
	/*
	 * Constructor for Project class
	 * @param string project name, project detail, image URL, and project number
	 */
	public Project()
	{
		
	}
	public Project(String projectName, String projectDetail,String shortProjectDetail, String imgURL1,String imgURL2,String imgURL3)
	{
		this.projectName = projectName;
		this.projectDetail = projectDetail;
		this.shortProjectDetail = shortProjectDetail;
		this.setImgURL1(imgURL1);
		this.setImgURL2(imgURL2);
		this.setImgURL3(imgURL3);
	}
	
	/*
	 * @return project name
	 */
	public String getProjectName() {
		return projectName;
	}
	
	/*
	 * @param string project name
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	/*
	 * @return project details
	 */
	public String getProjectDetail() {
		return projectDetail;
	}
	
	/*
	 * @param string project details
	 */
	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}
	
	public String getShortProjectDetail() {
		return shortProjectDetail;
	}
	
	/*
	 * @param string project details
	 */
	public void setShortProjectDetail(String shortProjectDetail) {
		this.shortProjectDetail = shortProjectDetail;
	}
	
	public String getImgURL1() {
		return imgURL1;
	}
	public void setImgURL1(String imgURL1) {
		this.imgURL1 = imgURL1;
	}
	public String getImgURL2() {
		return imgURL2;
	}
	public void setImgURL2(String imgURL2) {
		this.imgURL2 = imgURL2;
	}
	public String getImgURL3() {
		return imgURL3;
	}
	public void setImgURL3(String imgURL3) {
		this.imgURL3 = imgURL3;
	}
	public int getId() {
		return id;
	}
}
