public class Company {
    
    private int companyID;

    
    private float CGPACutoff;

    
    private long CTC;

   
    private String category;

    
    private float skillCutoff;

    
    private int maxOffers;

    
    public Company(int companyID, float CGPACutoff, long CTC, String category, float skillCutoff, int maxOffers) {
       this.companyID = companyID;
       this.CGPACutoff = CGPACutoff;
       this.CTC = CTC;
       this.category = category;
       this.skillCutoff = skillCutoff;
       this.maxOffers = maxOffers;
       
    }

    
    public boolean evaluateStudent(Student student) {
        double avgSkill = (student.getDbmsSkills() + student.getDsaSkill() + student.getOopsSkill() + student.getOsSkills())/4.0;
        if (skillCutoff < avgSkill)
        	return true;
        return false;
    }

    
    public int getCompanyID() {
        return this.companyID;
    }

    
    public float getCGPACutoff() {
    	return this.CGPACutoff;
    }

    
    public long getCTC() {
    	return this.CTC;
    }

    
    public float getSkillCutoff() {
        return this.skillCutoff;
    }

    
    public int getMaxOffers() {
        return this.maxOffers;
    }

    
    public String getCategory() {
        return this.category;
    }
}