public class Student {
    
	private String name;
	

    private float CGPA;
    
 
    private boolean isPlaced;
    

    private long offerCTC;
    

    private String offerCategory;
    

    private int oopsSkill;
    

    private int osSkill;
    

    private int dbmsSkill;
    

    private int dsaSkill;
    

    public Student(String name, float CGPA, int oopsSkill, int osSkill, int dbmsSkill, int dsaSkill) {
    	this.name = name;
    	this.CGPA = CGPA;
    	this.oopsSkill = oopsSkill;
    	this.osSkill = osSkill;
    	this.dbmsSkill = dbmsSkill;
    	this.dsaSkill = dsaSkill;
    	this.offerCategory = "";
        
    }
    
    
    public boolean isStudentInterested(long newCTC) {
    	if(newCTC > offerCTC)
    		return true;
    	return false;
    }
    

    public void setIsPlaced(boolean isPlaced) {
    	this.isPlaced = isPlaced;
        
    }
    

    public void setOfferCTC(long offerCTC) {
    	this.offerCTC = offerCTC;
        
    }
    

    public void setOfferCategory(String offerCategory) {
    	this.offerCategory = offerCategory;
      
    }
    

    public String getName() {
       return name;
    }
    
    
    public float getCGPA() {
        return this.CGPA;
    }
    

    public boolean getIsPlaced() {
        return this.isPlaced;
    }
    

    public long getOfferCTC() {
        return this.offerCTC;
    }
    

    public String getOfferCategory() {
        return this.offerCategory;
    }
    

    public int getOopsSkill() {
       return this.oopsSkill;
    }
    

    public int getOsSkills() {
       return this.osSkill;
    }
    

    public int getDbmsSkills() {
       return this.dbmsSkill;
    }
    
    
    public int getDsaSkill() {
       return this.dsaSkill;
    }
}
