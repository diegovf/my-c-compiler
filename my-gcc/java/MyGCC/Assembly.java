package MyGCC;


public enum Assembly{
	
	MOV("movl", "movq"),
	PUSH("pushl", "pushq"),
	CONVERT("cdq", "cqto");
	
	private String name32;
  private String name64;
  
  private Assembly (String name32, String name64) {
		this.name32 = name32;
    this.name64 = name64;
  }
  
  public String toString(){
		if(CodeGenerator.mode64)
			return this.name64;
		return this.name32;
	}
	
}