public class PlacementUnit {
    
    private Company companies[];

    
    private int maxNumberOfCompanies;

    
    private int numberOfCompanies;

    
    private Student students[];

    
    private int numberOfStudents;

    
    public PlacementUnit(int maxNumberOfCompanies, int numberOfStudents, Student[] students) {
        this.maxNumberOfCompanies = maxNumberOfCompanies;
        this.numberOfStudents = numberOfStudents;
        this.students = students;
        this.companies = new Company[this.maxNumberOfCompanies];
    }
    
    
    public boolean addCompany(Company company) {
        if (this.numberOfCompanies >= this.maxNumberOfCompanies)
        	return false;
        this.companies[numberOfCompanies] = company;
        this.numberOfCompanies++;
        return true;
    }
    
    
    public boolean removeCompany(Company company) {
        for(int i=0; i<numberOfCompanies;i++) {
        	if (this.companies[i] == company) {
        		for(int j = i;j<numberOfCompanies-1;j++) {
        			this.companies[j] = this.companies[j+1];
        		}
        		this.numberOfCompanies--;
        		return true;
        	}
        }
        return false;
    }
    
    
    public boolean isStudentEligible(Company company, Student student) {
        if (student.getCGPA() < company.getCGPACutoff()) {
        	return false;
        }
        if (!student.getIsPlaced())
        	return  true;
        if (student.getOfferCategory().equals("Dream") && company.getCategory().equals("Fantasy"))
        	return true;
        return false;
    }
    
    
    public void startPlacementProcess() {
        for( int i = 0; i<numberOfCompanies; i++) {
        	int Offers= 0;
        	for(int j = 0; j<numberOfStudents;j++) {
        		if (!students[j].isStudentInterested(companies[i].getCTC()) || !isStudentEligible(companies[i],students[j])) {
        			continue;
        		}
        		if (!companies[i].evaluateStudent(students[j]))
        			continue;
        		if (Offers >= companies[i].getMaxOffers() ) {
        			break;
        		}
        		students[j].setIsPlaced(true);
        		students[j].setOfferCategory(companies[i].getCategory());
        		students[j].setOfferCTC(companies[i].getCTC());
        		Offers++;
        	}

        }
    }
    
    
    public float findAverageCTC() {
    	float avgCTC = 0.0f;
    	long total = 0;
    	int placedStudents = 0;
    	 for(int i=0; i<numberOfStudents;i++) {
    		 long offeredCTC = this.students[i].getOfferCTC();
    		 if (students[i].getIsPlaced()) {
    			 total += offeredCTC;
    			 placedStudents++;
    		 } 
    	 }
    	 avgCTC = (float)total/placedStudents;
    	 return avgCTC;
        
    }
    
    
    public int getNumberOfCompanies() {
        return this.numberOfCompanies;
    }

    
    public int getNumberOfStudents() {
        return this.numberOfStudents;
    }

    
    public Company[] getCompanies() {
        return this.companies;
    }

    
    public Student[] getStudents() {
        return this.students;
    }
    
    public int maxNumberOfCompanies() {
    	return this.maxNumberOfCompanies;
        
    }
}
