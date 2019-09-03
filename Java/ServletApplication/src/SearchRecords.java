
public class SearchRecords {
	private String name;
	private String college;

	public SearchRecords(String name, String college) {
		super();
		this.name = name;
		this.college = college;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		SearchRecords rec = (SearchRecords) obj;
		return (rec.name == this.name && rec.college == this.college);
	}
	 @Override
	    public int hashCode() 
	    { 
	        return this.name.hashCode()+this.college.hashCode();
	    } 

}
