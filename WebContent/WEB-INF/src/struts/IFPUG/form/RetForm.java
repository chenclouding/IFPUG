/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.IFPUG.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 04-29-2010
 * 
 * XDoclet definition:
 * @struts.form name="retForm"
 */
public class RetForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** typeId property */
	private String type;

	/** rRetName property */
	private String retName;

	/** retDesp property */
	private String retDesp;

	/** id property */
	private String id;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/** 
	 * Returns the ilfRetName.
	 * @return String
	 */
	public String getRetName() {
		return retName;
	}

	/** 
	 * Set the ilfRetName.
	 * @param ilfRetName The ilfRetName to set
	 */
	public void setRetName(String retName) {
		this.retName = retName;
	}

	/** 
	 * Returns the ilfRetDesp.
	 * @return String
	 */
	public String getRetDesp() {
		return retDesp;
	}

	/** 
	 * Set the ilfRetDesp.
	 * @param ilfRetDesp The ilfRetDesp to set
	 */
	public void setRetDesp(String retDesp) {
		this.retDesp = retDesp;
	}

	/** 
	 * Returns the id.
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/** 
	 * Set the id.
	 * @param id The id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}