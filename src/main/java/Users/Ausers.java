package Users;
public class Ausers {
	private String AmemberId;
	private String name;
	private String mail;
	private String library;
	private String pass;
        private String address;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAmemberId() {
		return AmemberId;
	}
	public void setAmemberId(String amemberId) {
		AmemberId = amemberId;
	}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
	public Ausers(String amemberId, String name, String mail, String library, String pass,String address) {
		super();
		this.AmemberId = amemberId;
		this.name = name;
		this.mail = mail;
		this.library = library;
		this.pass = pass;
                this.address=address;
	}
	@Override
	public String toString() {
		return "Ausers [AmemberId=" + AmemberId + ", name=" + name + ", mail=" + mail + ", library=" + library
				+ ", pass=" + pass + "]";
	}


}
