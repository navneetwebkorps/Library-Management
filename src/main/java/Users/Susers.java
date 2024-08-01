package Users;

public class Susers {
	private String SmemberId;
	private String Sname;
	private String Smail;
	private String Spass;
	@Override
	public String toString() {
		return "Susers [SmemberId=" + SmemberId + ", Sname=" + Sname + ", Smail=" + Smail + ", Spass=" + Spass + "]";
	}
	public String getSmemberId() {
		return SmemberId;
	}
	public void setSmemberId(String smemberId) {
		SmemberId = smemberId;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSmail() {
		return Smail;
	}
	public void setSmail(String smail) {
		Smail = smail;
	}
	public String getSpass() {
		return Spass;
	}
	public void setSpass(String spass) {
		Spass = spass;
	}
	public Susers(String smemberId, String sname, String smail, String spass) {
		super();
		SmemberId = smemberId;
		Sname = sname;
		Smail = smail;
		Spass = spass;
	}

}
