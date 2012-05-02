package MyGCC;

import java.util.*;

public class LogicalBlock extends Instruction  {
  
  public Block block;
  
  public LogicalBlock(Expression r, InstructionType op) {
    super(r, op);
    this.block = new Block();
  }
  
  public LogicalBlock(Expression r, InstructionType op, Block b) {
    super(r, op);
    this.block = b;
  }
  
  public static String instructionToAssembly(LogicalBlock instruct, Context context) throws Exception {
		StringBuffer sb = new StringBuffer();
    String label1 = LabelManager.getLabel();
    String label2 = LabelManager.getLabel();
    
    if(instruct != null){
      if(instruct.rexpr == null){
        System.out.println("rexpr is null");
        // do nothing: already handled in epilogue()
        return sb.toString();
      }
      System.out.println("LogicalBlock");
      sb.append('.'); sb.append(label1); sb.append(":\n");
      System.out.println("Context: " + context);
      sb.append('\t'); sb.append(instruct.rexpr.handleExpression(null, context)); sb.append('\n');
      sb.append('\t'); sb.append(instruct.rexpr.op.getName()); sb.append('\t'); sb.append(label2); sb.append('\n');
      sb.append(instruct.block.toString());
      sb.append("\tjmp "); sb.append(label1); sb.append('\n');
      sb.append('.'); sb.append(label2); sb.append(":\n");
      System.out.println("Finished assembling LogicalBlock");
      return sb.toString();
    }
    
    System.err.println("The instruction is null");
    return null;
  }

  
}
